// import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FiltroVermelhoMagico implements FiltroImagem {

    @Override
    public void aplicarFiltro(String caminhoEntrada, String caminhoSaida) {

        BufferedImage img = null;
        File f = null;
        
        try {
            f = new File("D:/Apollo/Downloads/ruido.bmp");
            img = ImageIO.read(f);
        }
        catch (IOException e) {
            System.out.println(e);
        }

        int width = img.getWidth();
        int height = img.getHeight();

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int p = img.getRGB(col, row);

                // get alpha
                int a = (p >> 24) & 0xff;

                // get red
                int r = (p >> 16) & 0xff;

                // get green
                int g = (p >> 8) & 0xff;

                // get blue
                int b = p & 0xff;

                // Color.RGBtoHSB(r, g, b, null);

                if (p % 2 == 0) { // BRANCO
                    a = 0;
                    r = 255;
                    g = 255;
                    b = 255;

                } else { // PRETO
                    a = 255;
                    r = 0;
                    g = 0;
                    b = 0;                    
                }
            
                p = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(col, row, p);
            }
        }

        try {
            f = new File("D:/Apollo/Downloads/ruidoFiltrado.png");
            ImageIO.write(img, "png", f);
        }
        catch (IOException e) {
            System.out.println(e);
        }

    }
    
    // fontes: 
    // https://www.baeldung.com/java-getting-pixel-array-from-image
    // https://www.geeksforgeeks.org/java/image-processing-in-java-get-and-set-pixels/

}

import java.util.Base64;

public class DecodificadorBase64 implements Decodificador {

    @Override
    public String decodificar(String texto) {
        byte[] decodedBytes = Base64.getDecoder().decode(texto);

        String decodedString = new String(decodedBytes);
        
        return decodedString;
    }
    
    // fonte: https://www.baeldung.com/java-base64-encode-and-decode
}

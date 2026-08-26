public class DecodificadorCesar implements Decodificador {
    private int chave;
    private static final String ALFABETO = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String decodificar(String texto) {
        String mensagemEncriptada = texto.toLowerCase();
        StringBuilder mensagemDecriptada = new StringBuilder();

        int chaveCesar = 26 - chave;

        for (int i = 0; i < mensagemEncriptada.length(); i++) {
            char charEncriptado = mensagemEncriptada.charAt(i);

            int posicao = ALFABETO.indexOf(charEncriptado);

            if (posicao != -1) {
                int novaPosicao = (posicao + chaveCesar) % 26;
                char charDecriptado = ALFABETO.charAt(novaPosicao);
                mensagemDecriptada.append(charDecriptado);
            } else {
                mensagemDecriptada.append(charEncriptado);
            }
        }

        return mensagemDecriptada.toString();
    }
    // fonte: https://medium.com/@carlosguilherme.schneider/exerc%C3%ADcios-em-java-cifra-de-c%C3%A9sar-724e9ec497eb
    
    //-----------------------------------------------------------------------------

    public DecodificadorCesar(int chave) {
        this.chave = chave;
    }

}

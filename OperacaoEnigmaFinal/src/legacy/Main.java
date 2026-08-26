public class Main {
    public static void main(String[] args) {
        

        DecodificadorBase64 decodificadorBase64 = new DecodificadorBase64();
        String resultado64;

        resultado64 = decodificadorBase64.decodificar("Q2hhdmVfQ2VzYXI6IDcgfCBBbHZvOiBtZW5zYWdlbS50eHQ");

        System.out.println("RESULTADO 64: " + resultado64);


        DecodificadorCesar decodificadorCesar = new DecodificadorCesar(7);
        String resultadoCesar = decodificadorCesar.decodificar("Mpsayl v jhuhs CLYTLSOV kh pthnlt ybpkv.itw. Ptwhy = Wylav, Why = Iyhujv");
        System.out.println("RESULTADO CESAR: " + resultadoCesar);

        FiltroVermelhoMagico filtroVermelhoMagico = new FiltroVermelhoMagico();

        filtroVermelhoMagico.aplicarFiltro("asd", "asd");


    }
}

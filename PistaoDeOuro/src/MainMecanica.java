public class MainMecanica {
    public static void main(String[] args) throws Exception {
        
        Peca peca = new Peca("VELA-NGK", "vela", 10);
        NegocioEstoque estoque = new NegocioEstoque();

        //● Dar entrada de 5 unidades do SKU "VELA-NGK".
        estoque.darEntrada("VELA-NGK", 5);

        //● Dar entrada de mais 5 unidades do mesmo SKU "VELA-NGK".
        estoque.darEntrada("VELA-NGK", 5);

        //● Executar baixa com sucesso de 3 unidades.
        estoque.darBaixa("VELA-NGK", 3);

        //● Tentar dar baixa de 20 unidades (o sistema deve recusar e retornar false).
        estoque.darBaixa("VELA-NGK", 20);

        //● Imprimir no console o saldo final consultado (Resultado esperado: 7 unidades).
        estoque.consultarQuantidade("VELA-NGK");
    }
}
import java.util.HashMap;
import java.util.Map;

public class NegocioEstoque {
    private Map<String, Integer> itens = new HashMap<>();

    void darEntrada(String sku, int quantidade){

        if (itens.containsKey(sku)) {
            int qtdAtual = itens.get(sku);
            itens.put(sku, qtdAtual + quantidade);
            System.out.println("Estoque (quantidade: " + itens.get(sku) + ") adicionado com sucesso!");
        } else {
            itens.put(sku, quantidade);
            System.out.println("Peça nova (quantidade: " + itens.get(sku) + ") adicionada com sucesso!");
        }


    }
//-------------------------------------------------------------------------------

    boolean darBaixa(String sku, int quantidade){

        if (itens.containsKey(sku)) {
            int qtdAtual = itens.get(sku);
            if (quantidade <= qtdAtual) {
                qtdAtual = qtdAtual - quantidade;
                itens.put(sku, qtdAtual);
                System.out.println(quantidade + " peças removidas! (Estoque: " + itens.get(sku) + ") ");
                return true;
            } else {
                System.out.println("Erro, não há estoque o suficiente!");
                return false;
            }

        } else {
            System.out.println("Peça inexistente na loja.");
            return false;
        }
    }
//--------------------------------------------------------------------------------

    int consultarQuantidade(String sku){
        
        if (itens.containsKey(sku)) {
            System.out.println(itens.get(sku) + " no estoque!");
        } else {
            System.out.println("Peça não encontrada no sistema.");
        }
   
        return 0;
    }
}
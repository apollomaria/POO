public class Peca {
    private String codigoSku;
    private String nome;
    private double preco;

    public Peca(String codigoSku, String nome, double preco) {
        this.codigoSku = codigoSku;
        this.nome = nome;
        this.preco = preco;
    }
//-------------------------------------------------------------------------------
    public String getCodigoSku() {
        return codigoSku;
    }

    public void setCodigoSku(String codigoSku) {
        this.codigoSku = codigoSku;
    }
//-------------------------------------------------------------------------------
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
//-------------------------------------------------------------------------------
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
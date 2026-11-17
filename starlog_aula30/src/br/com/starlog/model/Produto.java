package br.com.starlog.model;

public class Produto {
    private Long id;
    private String nome;
    private double preco;
    private int estoque;
    
    public Produto(Long id, String nome, double preco, int estoque) {
        if (nome.trim().isEmpty() || nome.trim().length() < 3) {
            throw new IllegalArgumentException("Erro: nome invalido.");
        }

        if (preco <= 0) {
            throw new NumberFormatException("Erro: preco invalido.");
        }

        if (estoque < 0) {
            throw new NumberFormatException("Erro: estoque nao pode ser negativo.");
        }
        
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return "\n ------------- \nPRODUTO " + id  + " \nNome: " + nome + " \nPreco: R$" + preco + " \nEstoque: " + estoque;
    }

}

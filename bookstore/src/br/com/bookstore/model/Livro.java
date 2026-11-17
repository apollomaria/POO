package br.com.bookstore.model;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private double preco;
    
    public Livro(Long id, String titulo, String autor, double preco) {
        if (titulo.trim().isEmpty() || titulo.trim().length() < 0) {
            throw new IllegalArgumentException("Titulo invalido.");
        }

        if (autor.trim().isEmpty() || autor.trim().length() < 0) {
            throw new IllegalArgumentException("Autor invalido.");
        } 

        if (preco <= 0) {
            throw new NumberFormatException("O preco de venda deve ser estritamente positivo.");
        }
        
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n ------------- \nLIVRO " + id  + " \nTítulo: " + titulo + " \nAutor: " + autor + " \nValor: R$" + preco;
    }
}

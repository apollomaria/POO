package br.com.streaming.model;

public class Video {
    private String titulo;
    private int duracaoEmMinutos;
    private Categoria categoria;
    // é possível utilizar Categoria categoria pois Video e Categoria pertencem a um mesmo pacote

    public Video(String titulo, int duracaoEmMinutos) {
        this.titulo = titulo;
        this.duracaoEmMinutos = duracaoEmMinutos;
        Categoria categoria;
    }

}

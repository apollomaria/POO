package br.com.technexus.main;

import br.com.technexus.model.Loja;
import br.com.technexus.model.Produto;

public class Main {
    public static void main(String[] args) {
        
        Loja loja = new Loja();
        Produto p1 = new Produto();
        Produto p2 = new Produto();
        Produto p3 = new Produto();
        Produto p4 = new Produto();
        Produto p5 = new Produto();

        p1.setCategoria("GAMES");
        p1.setNome("The Witcher");
        p1.setPreco(150);

        p2.setCategoria("GAMES");
        p2.setNome("FIFA");
        p2.setPreco(200);

        p3.setCategoria("LIVROS");
        p3.setNome("Java for Dummies");
        p3.setPreco(100);

        p4.setCategoria("LIVROS");
        p4.setNome("Clean Code");
        p4.setPreco(80);
        
        p5.setCategoria("HARDWARE");
        p5.setNome("Mouse");
        p5.setPreco(50);

        loja.cadastrar(p1);
        loja.cadastrar(p2);
        loja.cadastrar(p3);
        loja.cadastrar(p4);
        loja.cadastrar(p5);
        
        System.out.println(loja.buscarPorCategoria("GAMES"));
        System.out.println(loja.calcularPatrimonioTotal());
        System.out.println(loja.calcularTotalPorCategoria("LIVROS"));
    }
}

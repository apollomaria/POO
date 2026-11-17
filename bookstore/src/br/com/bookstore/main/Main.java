package br.com.bookstore.main;

import br.com.bookstore.dao.LivroDAO;
import br.com.bookstore.dao.LivroDAOSqlite;
import br.com.bookstore.model.Livro;

public class Main {
    public static void main(String[] args) {
        LivroDAO dao = new LivroDAOSqlite();

        Livro livro1 = new Livro("Clean Code", "Autor 1", 50.5);
        Livro livro2 = new Livro("Design Patterns", "Autor 2", 60.5);
        Livro livro3 = new Livro("Refactoring", "Autor 3", 40.5);


        dao.criarTabelaSeNaoExistir();
    
        dao.salvar(livro1);
        dao.salvar(livro2);
        dao.salvar(livro3);

        dao.buscarPorId(2L).ifPresentOrElse(
            livro -> System.out.println("Encontrado: " + livro.getTitulo()), 
            () -> System.out.println("Livro não encontrado."));


        dao.buscarPorId(999L).ifPresentOrElse(
            livro -> System.out.println("Encontrado: " + livro.getTitulo()), 
            () -> System.out.println("Livro não encontrado."));

        System.out.println(dao.listarTodos());
    } 
}

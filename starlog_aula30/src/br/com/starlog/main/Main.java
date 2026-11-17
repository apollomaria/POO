package br.com.starlog.main;

import br.com.starlog.dao.ProdutoDAO;
import br.com.starlog.dao.ProdutoDAOSqlite;
import br.com.starlog.model.Produto;

public class Main {
    public static void main(String[] args) {
     
        ProdutoDAO dao = new ProdutoDAOSqlite();

        Produto p1 = new Produto("Teclado Mecânico RGB", 70, 50);
        Produto p2 = new Produto("Mousepad Speed XL", 90, 150);

        // dao.salvar(p1);
        // dao.salvar(p2);
        
        System.out.println(dao.listarTodos());
        p1.setId(1L);
        p1.setEstoque(15);
        p1.setPreco(289.90);
        boolean resultado = dao.atualizar(p1);

        if (resultado) {
            System.out.println("Produto atualizado!");
        } else {
            System.out.println("Falha na atualização do produto.");
        }

        dao.excluir(1L);
        dao.excluir(888L);
        System.out.println(dao.listarTodos());
    }
}

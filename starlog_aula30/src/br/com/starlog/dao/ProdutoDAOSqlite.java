package br.com.starlog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.starlog.factory.ConexaoFactory;
import br.com.starlog.model.Produto;

public class ProdutoDAOSqlite implements ProdutoDAO {

    public ProdutoDAOSqlite() {
        String sql = """
            CREATE TABLE IF NOT EXISTS produtos (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT NOT NULL,
                preco REAL NOT NULL,
                estoque INTEGER NOT NULL
            );
        """;

        try (Connection conn = ConexaoFactory.obterConexao();
            Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela 'produtos' criada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }

/*  private Long id;
    private String nome;
    private double preco;
    private int estoque; */

    @Override 
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produtos (nome, preco, estoque) VALUES (?, ?, ?);";

        try (Connection conn = ConexaoFactory.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getEstoque());

            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                try (ResultSet chaves = stmt.getGeneratedKeys()) {
                    if (chaves.next()) {
                        produto.setId(chaves.getLong(1));
                        System.out.println("Produto salvo!");
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    
    }



    private Produto mapearLinha(ResultSet rs) throws SQLException {
        Long id = rs.getLong("id");
        String nome = rs.getString("nome");
        double preco = rs.getDouble("preco");
        int estoque = rs.getInt("estoque");
        return new Produto(id, nome, preco, estoque);
    }


/*  private Long id;
    private String nome;
    private double preco;
    private int estoque; */


    @Override
    public Optional<Produto> buscarPorId(Long id) {
        String sql = "SELECT id, nome, preco, estoque FROM produtos WHERE id = ?;";

        try (Connection conn = ConexaoFactory.obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setLong(1, id);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return Optional.of(mapearLinha(rs));
                    }
                    return Optional.empty();
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao buscar produto por id: " + e.getMessage(), e);
            }
        
    }




/*  private Long id;
    private String nome;
    private double preco;
    private int estoque; */


    public List<Produto> listarTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT id, nome, preco, estoque FROM produtos ORDER BY id"; 

        try (Connection conn = ConexaoFactory.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto p = new Produto(
                    rs.getLong("id"),
                    rs.getString("nome"),              
                    rs.getDouble("preco"),
                    rs.getInt("estoque")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Erro: " + e.getMessage());
        }
        

        return lista;
    }



    @Override
    public boolean atualizar(Produto produto) {
        if (produto == null || produto.getId() == null) {
            throw new IllegalArgumentException("O ID do produto não pode ser nulo para atualização.");
        }

        String sql = "UPDATE produtos SET nome = ?, preco = ?, estoque = ? WHERE id = ?;";
        try (Connection conn = ConexaoFactory.obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, produto.getNome());
                stmt.setDouble(2, produto.getPreco());
                stmt.setInt(3, produto.getEstoque());
                stmt.setLong(4, produto.getId());

                int linhasAfetadas = stmt.executeUpdate();

                return linhasAfetadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage(), e);
        }
    }



    @Override
    public boolean excluir(Long id) {
        String sql = "DELETE FROM produtos WHERE id = ?;";
        try (Connection conn = ConexaoFactory.obterConexao();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
                stmt.setLong(1, id);

                int linhasAfetadas = stmt.executeUpdate();
                return linhasAfetadas > 0; // True se excluiu; False se o ID não existia
        
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir produto: " + e.getMessage(), e);
        }
    }





}

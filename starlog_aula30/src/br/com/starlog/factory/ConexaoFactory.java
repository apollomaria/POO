package br.com.starlog.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConexaoFactory {

    private static final String URL = "jdbc:sqlite:starlog.db";

    private ConexaoFactory() {
        throw new UnsupportedOperationException("ConexaoFactory e utilitaria!");
    }

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}

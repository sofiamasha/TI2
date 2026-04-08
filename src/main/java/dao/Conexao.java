package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection getConexao() throws Exception {
        return DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/produtosdb",
            "postgres",
            "1234"
        );
    }
}
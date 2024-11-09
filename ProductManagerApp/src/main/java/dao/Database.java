/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

/**
 *
 * @author Jean
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/product_manager?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MySQL não encontrado!", e);
        }
    }
    
    // Testando a conexão com o banco de dados (execute esse arquivo para teste)
    public static void main(String[] args) {
    try (Connection connection = Database.getConnection()) {
        System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
    } catch (SQLException e) {
        System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
    }
    }

}



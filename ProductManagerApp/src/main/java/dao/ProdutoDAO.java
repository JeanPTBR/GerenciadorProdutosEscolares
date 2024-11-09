/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

/**
 *
 * @author Jean
 */

import model.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    // Método para adicionar um novo produto ao banco de dados
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO products (name, description, price, quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getName());
            stmt.setString(2, produto.getDescription());
            stmt.setDouble(3, produto.getPrice());
            stmt.setInt(4, produto.getQuantity());

            stmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    // Método para obter todos os produtos do banco de dados
    public List<Produto> listarProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setDescription(rs.getString("description"));
                produto.setPrice(rs.getDouble("price"));
                produto.setQuantity(rs.getInt("quantity"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
        return produtos;
    }

    // Método para atualizar um produto no banco de dados
    public void atualizarProduto(Produto produto) {
        String sql = "UPDATE products SET name = ?, description = ?, price = ?, quantity = ? WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getName());
            stmt.setString(2, produto.getDescription());
            stmt.setDouble(3, produto.getPrice());
            stmt.setInt(4, produto.getQuantity());
            stmt.setInt(5, produto.getId());

            stmt.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // Método para excluir um produto pelo ID
    public void deletarProduto(int id) {
        String sql = "DELETE FROM products WHERE id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
            System.out.println("Produto deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar produto: " + e.getMessage());
        }
    }
    
    // Método para buscar produto pelo ID para edição
    public Produto buscarProdutoPorId(int id) {
    Produto produto = null;
    String sql = "SELECT * FROM products WHERE id = ?";
    
    try (Connection conn = Database.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setName(rs.getString("name"));
                produto.setDescription(rs.getString("description"));
                produto.setPrice(rs.getDouble("price"));
                produto.setQuantity(rs.getInt("quantity"));
            }
        }
    } catch (SQLException e) {
        System.err.println("Erro ao buscar produto: " + e.getMessage());
    }
    return produto;
}

}


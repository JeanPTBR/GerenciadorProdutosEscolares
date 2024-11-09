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

public class ProdutoDAOTest {
    public static void main(String[] args) {
        ProdutoDAO dao = new ProdutoDAO();

        // Teste de Adição
        Produto novoProduto = new Produto(0, "Produto Teste", "Descrição do Produto Teste", 10.99, 100);
        dao.adicionarProduto(novoProduto);

        // Teste de Listagem
        System.out.println("Lista de Produtos:");
        for (Produto p : dao.listarProdutos()) {
            System.out.println(p.getName() + " - " + p.getDescription());
        }

        // Teste de Atualização
        novoProduto.setName("Produto Atualizado");
        dao.atualizarProduto(novoProduto);

        // Teste de Exclusão
        dao.deletarProduto(novoProduto.getId());
    }
}

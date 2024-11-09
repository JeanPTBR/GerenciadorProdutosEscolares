<%-- 
    Document   : index
    Created on : Nov 8, 2024, 10:32:11 AM
    Author     : Jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model.Produto" %>
<%@ page import="dao.ProdutoDAO" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Lista de Produtos</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>Gerenciador de Produtos</h1>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Preço</th>
            <th>Quantidade</th>
            <th>Ações</th>
        </tr>
        <%
            ProdutoDAO dao = new ProdutoDAO();
            List<Produto> produtos = dao.listarProdutos();
            for (Produto produto : produtos) {
        %>
        <tr>
            <td><%= produto.getId() %></td>
            <td><%= produto.getName() %></td>
            <td><%= produto.getDescription() %></td>
            <td><%= produto.getPrice() %></td>
            <td><%= produto.getQuantity() %></td>
            <td>
                <a href="editar.jsp?id=<%= produto.getId() %>">Editar</a> |
                <a href="excluir.jsp?id=<%= produto.getId() %>">Excluir</a>
            </td>
        </tr>
        <% } %>
    </table>

    <br>
    <center><a href="adicionar.jsp">Adicionar Novo Produto</a></center>
    <br><br><br>
</body>
</html>


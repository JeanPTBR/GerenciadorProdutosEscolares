<%-- 
    Document   : editar
    Created on : Nov 8, 2024, 10:40:21 AM
    Author     : Jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="dao.ProdutoDAO" %>
<%@ page import="model.Produto" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ProdutoDAO dao = new ProdutoDAO();
    Produto produto = dao.buscarProdutoPorId(id); // Método adicionado no ProdutoDAO
%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Editar Produto</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>Editar Produto</h1>
    <form action="atualizarProduto.jsp" method="post">
        <input type="hidden" name="id" value="<%= produto.getId() %>">
        Nome: <input type="text" name="name" value="<%= produto.getName() %>" required><br>
        Descrição: <input type="text" name="description" value="<%= produto.getDescription() %>" required><br>
        Preço: <input type="number" name="price" step="0.01" value="<%= produto.getPrice() %>" required><br>
        Quantidade: <input type="number" name="quantity" value="<%= produto.getQuantity() %>" required><br>
        <input type="submit" value="Atualizar">
    </form>
    <br>
    <center><a href="index.jsp">Voltar à Lista de Produtos</a></center>
</body>
</html>


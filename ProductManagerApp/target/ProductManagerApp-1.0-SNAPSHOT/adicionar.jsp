<%-- 
    Document   : adicionar
    Created on : Nov 8, 2024, 10:33:44 AM
    Author     : Jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="dao.ProdutoDAO" %>
<%@ page import="model.Produto" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <title>Adicionar Produto</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>Adicionar Produto</h1>
    <form action="salvarProduto.jsp" method="post">
        Nome: <input type="text" name="name" required><br>
        Descrição: <input type="text" name="description" required><br>
        Preço: <input type="number" name="price" step="0.01" required><br>
        Quantidade: <input type="number" name="quantity" required><br>
        <input type="submit" value="Salvar">
    </form>
    <br>
    <center><a href="index.jsp">Voltar à Lista de Produtos</a></center>
</body>
</html>

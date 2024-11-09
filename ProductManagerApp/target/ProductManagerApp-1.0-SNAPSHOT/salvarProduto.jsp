<%-- 
    Document   : salvarProduto
    Created on : Nov 8, 2024, 10:34:20 AM
    Author     : Jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="dao.ProdutoDAO" %>
<%@ page import="model.Produto" %>
<%
    String nome = request.getParameter("name");
    String descricao = request.getParameter("description");
    double preco = Double.parseDouble(request.getParameter("price"));
    int quantidade = Integer.parseInt(request.getParameter("quantity"));

    Produto novoProduto = new Produto(0, nome, descricao, preco, quantidade);
    ProdutoDAO dao = new ProdutoDAO();
    dao.adicionarProduto(novoProduto);

    response.sendRedirect("index.jsp");
%>


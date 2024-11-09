<%-- 
    Document   : atualizarProduto
    Created on : Nov 8, 2024, 10:43:37 AM
    Author     : Jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="dao.ProdutoDAO" %>
<%@ page import="model.Produto" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String nome = request.getParameter("name");
    String descricao = request.getParameter("description");
    double preco = Double.parseDouble(request.getParameter("price"));
    int quantidade = Integer.parseInt(request.getParameter("quantity"));

    Produto produto = new Produto(id, nome, descricao, preco, quantidade);
    ProdutoDAO dao = new ProdutoDAO();
    dao.atualizarProduto(produto);

    response.sendRedirect("index.jsp");
%>

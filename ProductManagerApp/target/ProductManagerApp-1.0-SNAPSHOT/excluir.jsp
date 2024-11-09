<%-- 
    Document   : excluir
    Created on : Nov 8, 2024, 10:44:38 AM
    Author     : Jean
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="dao.ProdutoDAO" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    ProdutoDAO dao = new ProdutoDAO();
    dao.deletarProduto(id);

    response.sendRedirect("index.jsp");
%>

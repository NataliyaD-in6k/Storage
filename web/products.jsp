<%@ page import="natasha.store.dao.ProductDao" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="natasha.store.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="natasha.store.dao.CategoryDao" %><%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 3/15/16
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="WEB-INF/resouses/style.css">
</head>
<body>
<div class="container">
    <h1 class="text-primary">Catalogue</h1>
<%
    CategoryDao categoryDao = new CategoryDao(getConnectToDataBase());
    ProductDao productDao = new ProductDao(getConnectToDataBase(), categoryDao);
    int id = Integer.parseInt(request.getParameter("category_id"));
    List<Product> allProducts = productDao.getProductsByCategoryId(id);

    for (Product p : allProducts) {
%>
<div class="product col-sm-3 well"><% String name = p.getName(); %><%=name%></div>
<%}%>
</div>
</body>
</html>
<%!
    private Connection getConnectToDataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "root");
    }
%>

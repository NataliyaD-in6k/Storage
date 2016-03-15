<%@ page import="natasha.store.dao.CategoryDao" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="natasha.store.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 3/15/16
  Time: 9:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>%=application.getServerInfo()%</title>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="WEB-INF/resouses/style.css" type="text/css">
</head>
<body>
<div class="container">
    <h1 class="text-primary">Welcome to Store!</h1>
    <p>Choose category:</p>
    <%
        CategoryDao categoryDao = new CategoryDao(getConnectToDataBase());
        List<Category> allCategories = categoryDao.getAll();

        for (Category c : allCategories) {
            int id = c.getId();
    %>
    <a href="products.jsp?category_id=<%=id%>"><div class="category col-sm-3 well"><% String name = c.getName(); %><%=name%>
    </div></a>
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
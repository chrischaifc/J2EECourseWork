<%--
  Created by IntelliJ IDEA.
  User: fuchunchai
  Date: 2019-03-27
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>CRUD Application</title>
</head>
<body>
<div align="center">
    <h1>Clothes Management</h1>
    <h2>
        <a href="new">Add New Cloth</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Clothes</a>
    </h2>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Clothes</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Color</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach var="cloth" items="${listCloth}">
            <tr>
                <td><c:out value="${cloth.id}" /></td>
                <td><c:out value="${cloth.name}" /></td>
                <td><c:out value="${cloth.type}" /></td>
                <td><c:out value="${cloth.color}" /></td>
                <td><c:out value="${cloth.price}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${cloth.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${cloth.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>


<%@ page import="com.fuchun.Type" %><%--
  Created by IntelliJ IDEA.
  User: fuchunchai
  Date: 2019-03-28
  Time: 15:15
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
    <h1 style="text-align: center">Cloths Management</h1>
    <h2>
        <a href="new">Add New Cloth</a>
        &nbsp;&nbsp;&nbsp;
        <a style="text-align: center" href="list">List All Clothes</a>
    </h2>
</div>
<div align="center">
    <c:if test="${cloth != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${cloth == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${cloth != null}">
                            Edit Cloth
                        </c:if>
                        <c:if test="${cloth == null}">
                            Add New Cloth
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${cloth != null}">
                    <input type="hidden" name="id" value="<c:out value='${cloth.id}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${cloth.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Type: </th>
                    <td>
                        <select name="type" value="<c:out value='${cloth.type}' />">
                            <% for (Type type :
                                    Type.values()) { %>
                            <option><%out.print(type);%></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Color: </th>
                    <td>
                        <input type="text" name="color" size="5"
                               value="<c:out value='${cloth.color}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price: </th>
                    <td>
                        <input type="text" name="price" size="5"
                               value="<c:out value='${cloth.price}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>


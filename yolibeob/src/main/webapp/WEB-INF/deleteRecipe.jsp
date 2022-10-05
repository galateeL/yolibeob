<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>

<p>Do you really want to remove the recipe ${recipeId} ?</p>

<form action="${pageContext.request.contextPath}/deliteRecipe" method="post">
    <input hidden value="${recipe.id}" name="recipeId">
    <button type="submit">YES</button>
</form>

<form action="${pageContext.request.contextPath}/recipes" method="get">
    <button type="submit">NO</button>
</form>


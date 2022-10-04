<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add ingredients</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>

<form action="${pageContext.request.contextPath}/addIngredientToRecipe" method="POST">

  <input hidden name="idRecipe" value="${recipe.id}">
  <h5>Recipe title : "${recipe.title}"</h5>

  <label for="quantity">Quantity : </label>
  <input id="quantity" type="number" name="quantity">

  <label for="unity">Unity : </label>
  <input id="unity" type="text" name="unity">

  <label for="ingredientName">Ingredient : </label>
  <input id="ingredientName" type="text" name="ingredientName">

  <button type="submit">Add ingredient</button>

</form>

<ul>
<c:forEach items="${ingredientsRecipe}" var="ingredientRecipe">
  <li><c:out value="${ingredientRecipe.ingredient.title}"/></li>
  <li><c:out value="${ingredientRecipe.quantity}"/></li>
  <li><c:out value="${ingredientRecipe.unity}"/></li>
</c:forEach>
</ul>





</body>
</html>

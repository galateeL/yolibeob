<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add ingredients</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <link rel="stylesheet" href="<c:url value='/style/addIngredientToRecipe.css'/>"/>
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Pacifico&family=Ubuntu:wght@300&display=swap');
  </style>

</head>
<body>

<div class="container mb-5">

  <div class="row d-flex justify-content-center" >
    <img class="col-9" id="addIngredient-banner" src="https://images.unsplash.com/photo-1582138079863-ec3e671f59d7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1035&q=80" alt="">

  <div class="col-9" id="addIngredient-bg">
    <h1 style="font-family: 'Ubuntu', sans-serif; color: #ff5630" class="m-5">Add ingredients</h1>

<form action="${pageContext.request.contextPath}/addIngredientToRecipe" method="POST" class="m-5">

  <div class="mb-3">
    <input hidden name="idRecipe" value="${recipe.id}">
    <h5 style="color: #03ad6e; font-family: 'Pacifico', cursive; font-size: 40px" class="mb-5 text-center">${recipe.title}</h5>
  </div>

  <div class="mb-3">
  <label for="quantity" class="form-label">Quantity : </label>
  <input id="quantity" type="number" name="quantity" class="form-control">
  </div>

  <div class="mb-3">
  <label for="unity" class="form-label">Unity : </label>
  <input id="unity" type="text" name="unity" class="form-control">
  </div>

  <div class="mb-3">
  <label for="ingredientName" class="form-label">Ingredient : </label>
  <input id="ingredientName" type="text" name="ingredientName" class="form-control">
  </div>

  <button type="submit" class="btn" style="background: #03ad6e; color: white">Add this ingredient</button>

  <ul class="list-group list-group-horizontal m-3">
  <c:forEach items="${ingredientsRecipe}" var="ingredientRecipe">
    <li style="color: #ff5630; background-color: #ffffff" class="list-group-item m-3"><c:out value="${ingredientRecipe.quantity}"/> <c:out value="${ingredientRecipe.unity}"/> <c:out value="${ingredientRecipe.ingredient.title}"/></li>
  </c:forEach>
  </ul>

    <div class="row justify-content-center">
  <a class="btn mb-3 text-center" style="background: #ff5630; color: #f6f6f6; width: 35%" href="${pageContext.request.contextPath}/recipe-details?id=${recipe.id}">Validate and publish my recipe</a>
    </div>
    </form>

  </div>
</div>
</div>

</body>
</html>

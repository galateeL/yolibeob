<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>

  <title>${recipe.title}</title>
</head>
<body>
<div class="container">

  <div class="row row-cols-1">

    <c:if test="${error_format_id}">
      <p>L'id est inconnu</p>
    </c:if>

    <div class="col">
      <div class=class="card-body">
        <img src="${recipe.pictureUrl}" width="80%" height="80%">
        <h1 class="card-title">${recipe.title}</h1>
        <h3>Recipe by : ${recipe.user.firstName}</h3>
        <p>It will take you : ${recipe.time} minutes</p>
        <div>

          <p>For : ${recipe.person} persons</p>
          <p>Budget : ${recipe.budget}</p>
          <p>Category : ${recipe.criteria}</p>
          <p>Difficulty : ${recipe.difficulty}</p>

          <h2>Ingredients :</h2>
          <ul>
            <c:forEach items="${ingredientsRecipe}" var="ingredientRecipe">
              <li><c:out value="${ingredientRecipe.quantity}"/> <c:out value="${ingredientRecipe.unity}"/> <c:out value="${ingredientRecipe.ingredient.title}"/></li>
            </c:forEach>
          </ul>







          <article>
            <h2> Steps :</h2>
            <c:out value="${recipe.steps}"></c:out>
          </article>

        </div>

      </div>
    </div>

  </div>
</div>
</body>
</html>

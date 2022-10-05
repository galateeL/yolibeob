<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

  <title>Yolibeob | ${recipe.title}</title>
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
        <p>It will take you : ${recipe.time}</p>
        <div>

          <p>For : ${recipe.person} persons</p>

          <h2>Ingredients :</h2>
          <c:forEach items="${recipes}" var="recipe">

            <c:out value="${recipe.ingredientList}"></c:out>

          </c:forEach>

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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yolibeob | Edit recip</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</head>
<body>

<div class="container">

  <a href="${pageContext.request.contextPath}/addIngredient">Add Ingredient</a>

  <div class="row">
    <fieldset>
      <legend>Choose your ingredients :</legend>
      <c:forEach items="${ingredients}" var="ingredient">
      <div>
        <input type="checkbox" id="scales" name="scales">
        <label for="scales">${ingredient.title}</label>
      </div>

      </c:forEach>

    </fieldset>

  </div>

</div>

</body>
</html>

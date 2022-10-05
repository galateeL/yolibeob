<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Yolibeob | Edit recipe</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</head>
<body>


<div class="container">

  <h1>Edit Recipe</h1>

  <div class="row">

    <c:choose>
      <c:when test="${recipe_not_found}">

      </c:when>

      <c:otherwise>
        <form action="${pageContext.request.contextPath}/editRecipe" method="POST">

          <input hidden name="idRecipe" value="${recipe.id}">
          <label for="title">Recipe </label>
          <input id="title" type="text" name="title" value="${recipe.title}">

          <input hidden name="person" value="${recipe.person}">
          <label for="person">NB Persons </label>
          <input id="person" type="number" name="title" value="${recipe.person}" convive(s)>

          <input hidden name="steps" value="${recipe.steps}">
          <label for="steps">Steps </label>
          <input id="steps" type="text" name="steps" value="${recipe.steps}">


          <input hidden name="stime" value="${recipe.time}">
          <label for="time">Time </label>
          <input id="time" type="text" name="time" value="${recipe.time}">


//FOR EACH SUR ENUM A IMPLEMENTER - DIFFCULTY
          <label for="difficulty-select">Difficulty</label>
          <select name="difficulty" id="difficulty-select">
            <c:forEach items="${requestScope.countries}" var="country">
              <option value="${country.id}">${country.name}</option>
            </c:forEach>
          </select>

 //FOR EACH SUR ENUM A IMPLEMENTER - BUDGET
          <label for="budget-select">Budget</label>
          <select name="country" id="budget-select">
            <c:forEach items="${requestScope.countries}" var="country">
              <option value="${country.id}">${country.name}</option>
            </c:forEach>
          </select>


//FOR EACH SUR ENUM A IMPLEMENTER - CRITERIA
          <label for="criteria-select">Criteria</label>
          <select name="country" id="criteria-select">
            <c:forEach items="${requestScope.countries}" var="country">
              <option value="${country.id}">${country.name}</option>
            </c:forEach>
          </select>


          <input hidden name="pictureUrl" value="${recipe.pictureUrl}">
          <label for="pictureUrl">Photo </label>
          <input id="pictureUrl" type="text" name="pictureUrl" required value="${recipe.pictureUrl}">


          <button type="submit">Edit</button>

        </form>

      </c:otherwise>
    </c:choose>

  </div>

</div>

</body>
</html>

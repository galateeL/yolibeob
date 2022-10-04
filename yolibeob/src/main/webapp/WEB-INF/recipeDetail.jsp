<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Yolibeob | <c:out value="${recipe.title}"></c:out></title>
</head>
<body>
<div class="container">

  <div>

    <c:if test="${error_format_id}">
      <p>L'id est inconnu</p>
    </c:if>

    <div>
      <div>
        <h1><c:out value="${recipe.title}"></c:out></h1>
        <h3>Recipe by : <c:out value="${recipe.user.firstName}"></c:out></h3>
        <p>Posted : <c:out value="${recipe.time}"></c:out></p>
        <div>
          <img src="${recipe.pictureUrl}" width="100%" height="100%">

          <c:out value="${recipe.person}"></c:out>

          <c:forEach items="${recipes}" var="recipe">

            <c:out value="${recipe.ingredientList}"></c:out>

          </c:forEach>


          <article>
            <c:out value="${recipe.steps}"></c:out>
          </article>


        </div>

      </div>
    </div>

  </div>
</div>
</body>
</html>

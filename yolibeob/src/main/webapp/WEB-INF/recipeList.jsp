<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

    <title>Recipe List</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">

    <h1>Recipes :</h1>

    <a href="${pageContext.request.contextPath}/addRecipe">Add Recipe</a>

    <div class="row">
        <c:forEach items="${recipes}" var="recipe">

            <div class="col-lg-4 mb-3 d-flex align-items-stretch">
                <div class="card">
                    <img src="${recipe.pictureUrl}"alt="${recipe.title}">
                    <div class="card-body d-flex flex-column">
                        <h2 class="card-title">${recipe.title}</h2>
                    </div>
                    <div class="card-footer">
                        <a href="${pageContext.request.contextPath}/edit?id=${recipe.id}" class="btn btn-primary">Edit</a>

                        <form action="${pageContext.request.contextPath}/deleteRecipe?idRecipe=${recipe.id}" method="post">
                            <input hidden name="idRecipe" value="${recipe.id}">
                            <c:out value="${recipe.id}"/>

                            <button class="btn btn-secondary" type="submit">Delete</button>
                            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/recipe-details?id=${recipe.id}">Details</a>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


</div>

</body>
</html>

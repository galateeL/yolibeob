<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <link rel="stylesheet" href="<c:url value='/style/recipes.css'/>"/>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Pacifico&family=Ubuntu:wght@300&display=swap');
    </style>
    <title>Yolibeob | Recipes</title>

</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">

   <!-- <a href="${pageContext.request.contextPath}/addRecipe">Add Recipe</a>-->

    <div class="container" id="recipes-container">

        <img class="col-12" src="https://images.unsplash.com/photo-1657299156538-e08595d224ca?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80" alt="" id="recipes-banner">
        <div class="col-12" style="background-color: #03ad6e; height: 20px"></div>

        <div class="d-flex justify-between flex-row align-items-center m-2">
            <img src="https://i0.wp.com/www.ux-republic.com/wp-content/uploads/2021/03/01-notes.png?ssl=1" alt="" style="width: 100px"/>
            <h1 class="m-5" style="font-family: 'Ubuntu', sans-serif;">Recipes</h1>
        </div>


    <div class="row">
        <c:forEach items="${recipes}" var="recipe">

            <div class="col-lg-4 mb-3 d-flex align-items-stretch">
                <div class="card" style="width: 300px">
                    <img src="${recipe.pictureUrl}"alt="${recipe.title}" class="card-img-top embed-responsive-item" style="height: 200px; object-fit: cover">
                    <div class="card-body d-flex flex-column">
                        <h2 class="card-title text-center" style="font-family: 'Pacifico', cursive; color: #1c1b1b">${recipe.title}</h2>
                    </div>
                    <div class="card-footer d-flex justify-content-center">
                       <!-- <a href="${pageContext.request.contextPath}/edit?id=${recipe.id}" class="btn btn-primary">Edit</a>-->

                        <form action="${pageContext.request.contextPath}/deleteRecipe?idRecipe=${recipe.id}" method="post" class="mb-3">
                            <input hidden name="idRecipe" value="${recipe.id}">

                            <button class="btn" style="background-color: #FF5630FF; color: white" type="submit">Delete</button>
                            <a class="btn" style="color: white; background-color: #03AD6EFF" href="${pageContext.request.contextPath}/recipe-details?id=${recipe.id}">Details</a>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    </div>

</div>

</body>
</html>

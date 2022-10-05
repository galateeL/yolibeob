<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
            crossorigin="anonymous"></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Pacifico&family=Ubuntu:wght@300&display=swap');
    </style>

    <title>${recipe.title}</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<div class="container">

    <c:if test="${error_format_id}">
        <p>L'id est inconnu</p>
    </c:if>
    <div class="row">

        <div class="col-6">

            <div class="card mb-3">
                <h1 class="card-title m-3" style="font-family: 'Pacifico', cursive; color: #03ad6e">${recipe.title}</h1>

                <img src="${recipe.pictureUrl}" class="card-img-top" alt="" style="object-fit: cover; height: 300px">
                <div class="card-body">


                    <p class="card-text"><span style="color:#03AD6EFF">Recipe by : </span>${recipe.user.firstName}</p>
                    <p class="card-text"><span style="color:#03AD6EFF">It will take you : </span>${recipe.time} minutes
                    </p>
                    <p class="card-text"><span style="color:#03AD6EFF">For : </span>${recipe.person} persons</p>
                    <p class="card-text"><span style="color:#03AD6EFF">Budget : </span>${recipe.budget}</p>
                    <p class="card-text"><span style="color:#03AD6EFF">Category : </span>${recipe.criteria}</p>
                    <p class="card-text"><span style="color:#03AD6EFF">Difficulty : </span>${recipe.difficulty}</p>

                    <h5 style="color: #03ad6e">Ingredients</h5>
                    <hr style="color:#03ad6e;"/>
                    <ul>
                        <c:forEach items="${ingredientsRecipe}" var="ingredientRecipe">
                            <li><c:out value="${ingredientRecipe.quantity}"/> <c:out value="${ingredientRecipe.unity}"/>
                                <c:out value="${ingredientRecipe.ingredient.title}"/></li>
                        </c:forEach>
                    </ul>

                    <h5 style="color: #03ad6e">Steps</h5>
                    <hr style="color:#03ad6e;"/>
                    <p><c:out value="${recipe.steps}"></c:out></p>

                </div>


            </div>
        </div>

    </div>


</div>
</body>
</html>

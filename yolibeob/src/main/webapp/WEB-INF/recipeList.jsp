<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yolibeob | Recipe List</title>
</head>
<body>

<div class="container">

    <h1>Recipes :</h1>

    <a href="${pageContext.request.contextPath}/addRecipe">Add Recipe</a>

    <div>
        <c:forEach items="${RequestScope.recipes}" var="recipe">

            <div>
                <div class>
                    <img src="${recipe.pictureUrl}"alt="${recipe.title}">
                    <div>
                        <h5>${recipe.title}</h5>
                    </div>
                    <div >
                        <a href="${pageContext.request.contextPath}/edit?id=${recipe.id}">Edit</a>

                        <form action="${pageContext.request.contextPath}/delete-recipe" method="post">
                            <input hidden name="idRecipes" value="${recipe.id}">
                            <button type="submit">Delete</button>
                            <a href="${pageContext.request.contextPath}/recipe-details?id=${recipe.id}">Details</a>
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>


</div>

</body>
</html>

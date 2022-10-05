<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
            crossorigin="anonymous"></script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<!--<p>Do you really want to remove the recipe ${recipeId} ?</p>

<form action="${pageContext.request.contextPath}/deleteRecipe?recipeId=${idRecipe}" method="post">
    <input hidden value="${idRecipe}" name="idRecipe">
    <button type="submit">YES</button>
</form>

<form action="${pageContext.request.contextPath}/recipes" method="get">
    <button type="submit">NO</button>
</form>-->
<div class="container"
     style="background:transparent url('https://sauvageboris.fr/training/javaee/carEE/resources/img/blur.jpg')">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card border-0 rounded-3 my-5">
                <div class="card-body p-4 p-sm-5">
                    <h3 class="card-title text-align-center mb-5">Do you really want to remove the recipe ${recipeId}
                        ?</h3>
                    <form action="${pageContext.request.contextPath}/deleteRecipe?recipeId=${idRecipe}" method="post"
                          class="d-flex">
                        <input hidden value="${idRecipe}" name="idRecipe">
                        <button class="col-3 btn btn-success btn-login text-uppercase fw-bold" type="submit">YES
                        </button>
                    </form>
                    <form action="${pageContext.request.contextPath}/recipes" method="get">
                        <button type="submit" class=" col-3 btn btn-danger btn-login text-uppercase fw-bold">NO</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="./footer.jsp" %>
</body>




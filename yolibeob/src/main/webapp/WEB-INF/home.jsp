
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yolibeob | Home</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<c:url value='/style/home.css'/>"/>
  <style>
    @import url('https://fonts.googleapis.com/css2?family=Pacifico&family=Ubuntu:wght@300&display=swap');
  </style>
</head>

<body>

  <%@ include file="./header.jsp" %>

<div class="container" id="home-container">

  <img class="col-12" src="https://images.unsplash.com/photo-1657299156538-e08595d224ca?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80" alt="" id="home-banner">
  <div class="col-12" style="background-color: #ff5630; height: 20px"></div>
    <div class="d-flex justify-between flex-row align-items-center m-5">
        <img src="https://preview.redd.it/nr44vhxhjif71.jpg?auto=webp&s=08dc15fce9e1d54cc288c79c069afde74db53863" alt="" style="width: 100px"/>
        <h1 style="font-family: 'Ubuntu', sans-serif;">What are we having for lunch ? </h1>
  </div>

  <div class="row">
    <c:forEach items="${recipes}" var="recipe">

      <div class="col-lg-4 mb-3 d-flex align-items-stretch">
        <div class="card" style="width: 300px">
          <img src="${recipe.pictureUrl}" alt="${recipe.title}" class="card-img-top embed-responsive-item" style="height: 200px; object-fit: cover">
          <div class="card-body d-flex flex-column">
            <h5 class="card-title text-center" style="font-family: 'Pacifico', cursive; color: #1c1b1b">${recipe.title}</h5>
          </div>

          <div class="card-footer d-flex justify-content-center">

              <!--<a href="${pageContext.request.contextPath}/edit?id=${recipe.id}" class="btn btn-primary me-2" style="height:38px ">Edit</a>-->

           <!-- <form action="${pageContext.request.contextPath}/deleteRecipe?idRecipe=${recipe.id}" method="post" class="mt-3">
              <input hidden name="idRecipe" value="${recipe.id}">
              <button class="btn" type="submit" style="background-color: #FF5630FF; color: white">Delete</button>-->

            </form>

            <a class="btn" style="color: white; background-color: #03AD6EFF" href="${pageContext.request.contextPath}/recipe-details?id=${recipe.id}">Details</a>

          </div>

        </div>
      </div>
    </c:forEach>
  </div>

</div>




</body>
</html>

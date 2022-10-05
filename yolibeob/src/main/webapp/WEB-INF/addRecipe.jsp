<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yolibeob | Add recipe</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<c:url value='/style/addRecipe.css'/>"/>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Ubuntu:wght@300&display=swap');
    </style>

</head>
<body>

<div class="container mb-5">

    <div class="row d-flex justify-content-center" >
        <img class="col-9" id="addRecipe-banner" src="https://images.unsplash.com/photo-1543352634-a1c51d9f1fa7?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80" alt="">

        <div class="col-9" id="addRecipe-bg">
            <h1 style="font-family: 'Ubuntu', sans-serif; color: #ff5630" class="m-5">Add Recipe</h1>

        <form action="${pageContext.request.contextPath}/addRecipe" method="POST" class="m-5">
            <div class="mb-3">
                <label for="title" class="form-label">Title</label>
                <input id="title" type="text" name="title" class="form-control">
            </div>

            <div class="mb-3">
            <label for="pictureUrl" class="form-label">Picture Url</label>
            <input id="pictureUrl" type="text" name="pictureUrl" class="form-control">
            </div>

            <div class="mb-3">
            <label for="time" class="form-label">Time (minutes)</label>
            <input id="time" type="text" name="time" class="form-control">
            </div>

            <div class="mb-3">
            <label for="steps" class="form-label">Steps</label>
                <textarea class="form-control" rows="4" id="steps" type="text" name="steps"></textarea>
            </div>

            <div class="mb-3">
            <label for="person" class="form-label">Nb persons</label>
            <input id="person" type="text" name="person" class="form-control">
            </div>

            <div class="mb-3">
            <label for="difficulty-list" class="form-label">Difficulty</label>
            <select name="difficulty" id="difficulty-list">
                <option value="difficulty" disabled selected> -- Please choose a difficulty level-- </option>
                <option value="Very easy">Very easy</option>
                <option value="Easy">Easy</option>
                <option value="DQuite difficult">Quite difficult</option>
                <option value="Difficult">Difficult</option>
            </select>
            </div>

            <div class="mb-3">
            <label for="budget-list" class="form-label">Budget</label>
            <select name="budget" id="budget-list">
                <option value="budget" disabled selected> -- Please choose a budget-- </option>
                <option value="Low budget">Low budget</option>
                <option value="Medium">Medium</option>
                <option value="Quite expensive">Quite expensive</option>
                <option value="Expensive">Expensive</option>
            </select>
            </div>

            <div class="mb-3">
            <label for="criteria-list" class="form-label">Category</label>
            <select name="criteria" id="criteria-list">
                <option value="criteria" disabled selected> -- Please choose a category-- </option>
                <option value="Starter">Starter</option>
                <option value="Main course">Main course</option>
                <option value="Dessert">Dessert</option>
                <option value="Drink">Drink</option>
            </select>
            </div>

            <button type="submit" class="btn" style="background: #ff5630; color: white">Continue and add ingredients</button>

        </form>
        </div>

    </div>

</div>

</body>
</html>

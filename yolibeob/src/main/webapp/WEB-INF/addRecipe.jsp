<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yolibeob | Add recipe</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>

<div class="container">

    <h1>Add Recipe</h1>

    <div class="row">

        <form action="${pageContext.request.contextPath}/addRecipe" method="POST">

            <label for="title">Title</label>
            <input id="title" type="text" name="title">

            <label for="pictureUrl">Picture Url</label>
            <input id="pictureUrl" type="text" name="pictureUrl">

            <label for="time">Time (minutes)</label>
            <input id="time" type="text" name="time">

            <label for="steps">Steps</label>
            <input id="steps" type="text" name="steps">

            <label for="person">Nb persons</label>
            <input id="person" type="text" name="person">

            <label for="difficulty-list">Difficulty</label>
            <select name="difficulty" id="difficulty-list">
                <option value="difficulty" disabled selected> -- Please choose a difficulty level-- </option>
                <option value="Very easy">Very easy</option>
                <option value="Easy">Easy</option>
                <option value="DQuite difficult">Quite difficult</option>
                <option value="Difficult">Difficult</option>
            </select>


            <label for="budget-list">Budget</label>
            <select name="budget" id="budget-list">
                <option value="budget" disabled selected> -- Please choose a budget-- </option>
                <option value="Low budget">Low budget</option>
                <option value="Medium">Medium</option>
                <option value="Quite expensive">Quite expensive</option>
                <option value="Expensive">Expensive</option>
            </select>


            <label for="criteria-list">Category</label>
            <select name="criteria" id="criteria-list">
                <option value="criteria" disabled selected> -- Please choose a category-- </option>
                <option value="Starter">Starter</option>
                <option value="Main course">Main course</option>
                <option value="Dessert">Dessert</option>
                <option value="Drink">Drink</option>
            </select>


            <button type="submit">Create</button>
        </form>


    </div>

</div>

</body>
</html>

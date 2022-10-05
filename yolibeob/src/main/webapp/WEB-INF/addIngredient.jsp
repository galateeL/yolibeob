<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<body>
<div class="container">

    <h1>Add ingredient</h1>

    <div class="row">

        <form action="${pageContext.request.contextPath}/addIngredient" method="POST">

            <div class="mb-2">
                <label for="title" class="form-label">Name</label>
                <input type="text" class="form-control" id="title" name="title">
            </div>

            <button type="submit">Create</button>
        </form>

    </div>

</div>


</body>
</html>

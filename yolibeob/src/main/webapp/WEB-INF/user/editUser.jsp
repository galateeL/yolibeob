<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
</head>
<body>

<header>
    <%@ include file="../header.jsp" %>
</header>
<div class="container" style="background:transparent url('https://sauvageboris.fr/training/javaee/carEE/resources/img/blur.jpg')">
    <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
            <div class="card border-0 rounded-3 my-5">
                <div class="card-body p-4 p-sm-5">
                    <h3 class="card-title text-center mb-5">Edit User</h3>
                    <form action="${pageContext.request.contextPath}/auth/editUser" method="post">
                        <div class="form-floating mb-3">
                            <input id="lastName" class="form-control" type="text" name="lastName">
                            <label for="lastName">Last Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input id="firstName" class="form-control" type="text" name="firstName">
                            <label for="firstName">First Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input id="avatarUrl" class="form-control" type="text" name="avatarUrl">
                            <label for="avatarUrl">Picture</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input id="password" class="form-control" type="password" name="password">
                            <label for="password">Password</label>
                        </div>
                        <div class="d-grid">
                            <button class="btn btn-success btn-login text-uppercase fw-bold" type="submit">Edit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Island Project | Details</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
  <body>
  <header>
    <%@ include file="../header.jsp" %>
  </header>
    <div class="container mt-4">
      <div class="row">
        <div class="col-8 offset-2">
          <div class="card">
            <img src="${user.avatarUrl}" class="card-img-top h-50" alt="${user.lastName}">
            <div class="card-body">
              <ul class="list-group list-group-flush">
                <li class="list-group-item">Last name : ${user.lastName}</li>
                <li class="list-group-item">First name : ${user.firstName}</li>
                <li class="list-group-item">Email : ${user.email}</li>
                <li class="list-group-item">Password : ${user.password}</li>
              </ul>
            </div>
              <div class="card-footer d-flex justify-content-end">
                                <a href="${pageContext.request.contextPath}/auth/editUser?id=${user.id}"
                                   class="btn btn-success btn mx-2">Edit</a>

                                <form action="${pageContext.request.contextPath}/auth/deleteUser" method="post"
                                      class="m-0">
                                    <input hidden type="text" value="${user.id}" name="idUser">
                                    <button type="submit" class="btn btn-secondary btn">Delete</button>
                                </form>
              </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>

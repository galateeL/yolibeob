<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
  <title>Login</title>
</head>
<body>
<header>
  <%@ include file="../header.jsp" %>
</header>
<div class="container" style="background:transparent url('https://sauvageboris.fr/training/javaee/carEE/resources/img/blur.jpg')">
  <div class="row vh-100 justify-content-space-between align-items-center ">
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
      <div class="card border-0 rounded-3 my-5">
        <div class="card-body p-4 p-sm-5">
          <h3 class="card-title text-center mb-5">LOGIN PAGE</h3>
          <form action="login" method="post">
            <div class="form-floating mb-3">
              <input type="text" class="form-control" id="email" name="email">
              <label for="email">Email</label>
            </div>
            <div class="form-floating mb-3">
              <input type="password" class="form-control" id="password" name="password">
              <label for="password">Password</label>
            </div>
            <% if(request.getAttribute("error") != null) {%>
            <div class="error"><%=request.getAttribute("error")%></div>
            <%}%>
            <p></p>
            <div class="d-grid">
              <button class="btn btn-success btn-login text-uppercase fw-bold" type="submit">LOGIN</button>
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

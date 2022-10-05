<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
<nav class="navbar navbar-expand-lg  static-top">
  <div class="container">
    <a class="navbar-brand" href="#">
      <img class="float-start" src="https://sauvageboris.fr/training/javaee/recipeEE/resources/logo/60.png" alt="Car">
    </a>
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav ms-auto">
        <li class="nav-item">
          <a  style="color: #1ed3a6" class="nav-link" href="">Recipe</a>
        </li>
        <c:if test = "${sessionScope.user == null}">
          <li class="nav-item ms-2">
            <a style="color: #1ed3a6" class="nav-link" href="${pageContext.request.contextPath}/addUser">Register</a>
          </li>
        </c:if>
        <c:if test = "${sessionScope.user != null}" var="condition">
          <li class="nav-item dropdown">
            <a  style="color: #1ed3a6" class="nav-link dropdown-toggle" href="#" id="btAdmin" role="button"
                data-bs-toggle="dropdown">Profil</a>
            <ul class="dropdown-menu" aria-labelledby="btAdmin">
              <li><a class="dropdown-item"  style="color: #1ed3a6"
                     href="${pageContext.request.contextPath}/auth/editUser?id=${user.id}">Edit User</a></li>
              <li><a class="dropdown-item"  style="color: #1ed3a6"
                     href="${pageContext.request.contextPath}/auth/detailUser?id=${user.id}">Detail User</a></li>
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link" style="color: #1ed3a6" href="${pageContext.request.contextPath}/logout">Logout</a>
          </li>
        </c:if>
        <c:if test="${!condition}">
          <li class="nav-item">
            <a class="nav-link" style="color: #1ed3a6" href="${pageContext.request.contextPath}/login">Login</a>
          </li>
        </c:if>
      </ul>
    </div>
  </div>
</nav>
</body>

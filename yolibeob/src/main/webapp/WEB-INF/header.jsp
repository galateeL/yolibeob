<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="mb-5">
    <nav class="navbar navbar-expand-lg fixed-top bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/home">
                <img src="https://sauvageboris.fr/training/javaee/recipeEE/resources/logo/60.png" alt="Logo" width="30"
                     height="24" class="d-inline-block align-text-top">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarNavDropdown,#navbarNavDropdown2"
                    aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/home">
                            Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/recipes">Recipes</a>
                    </li>
                    <c:if test="${sessionScope.user != null}" var="condition">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/auth/addRecipe">Add Recipe</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                               aria-expanded="false">
                                Recipes by categories
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/category/starter">
                                    Starters</a></li>
                                <li><a class="dropdown-item"
                                       href="${pageContext.request.contextPath}/category/main-course">Dishes</a>
                                </li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/category/dessert">Desserts</a>
                                </li>
                                <li><a class="dropdown-item"
                                       href="${pageContext.request.contextPath}/category/drink">Drinks</a></li>
                            </ul>
                        </li>
                    </c:if>
                </ul>
            </div>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown2">
                <ul class="navbar-nav">
                    <c:if test="${sessionScope.user == null}">
                    <li class="nav-item ms-2">
                        <a class="nav-link" href="${pageContext.request.contextPath}/addUser">Register</a>
                        </c:if>
                        <c:if test="${condition}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle me-1" href="#" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">Profil</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/auth/editUser?id=${user.id}">Edit User</a>
                            </li>
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/auth/detailUser?id=${user.id}">Detail
                                User</a></li>
                        </ul>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                    </li>
                    </c:if>
                    <c:if test="${!condition}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                        </li>
                    </c:if>
                </ul>
            </div>
        </div>
    </nav>
</header>



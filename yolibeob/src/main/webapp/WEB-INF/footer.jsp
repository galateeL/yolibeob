<%--
  Created by IntelliJ IDEA.
  User: Kevin
  Date: 05/10/2022
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<footer class="py-3 my-4 container mb-0" style="background-color: #ff5630;">
    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
        <li class="nav-item"><a href="${pageContext.request.contextPath}/home" class="nav-link px-2 text-muted" style="color: #ffffff!important;">Home</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath}/recipes" class="nav-link px-2 text-muted" style="color: #ffffff!important;">Recipes</a></li>
        <li class="nav-item"><a href="${pageContext.request.contextPath}/auth/detailUser?id=${user.id}" class="nav-link px-2 text-muted" style="color: #ffffff!important;">Profile</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-muted" style="color: #ffffff!important;">FAQs</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-muted" style="color: #ffffff!important;">About</a></li>
    </ul>
    <p class="text-center text-muted" style="color: #ffffff!important;">© 2022 Company, Inc</p>
</footer>




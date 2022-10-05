<header>
  <nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">
        <img src="https://sauvageboris.fr/training/javaee/recipeEE/resources/logo/60.png" alt="Logo" width="30" height="24" class="d-inline-block align-text-top">
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Features</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Pricing</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Recettes par categories
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/category/starter">Entrees</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/category/main-course">Plats</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/category/dessert">Desserts</a></li>
              <li><a class="dropdown-item" href="${pageContext.request.contextPath}/category/drink">Boissons</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</header>

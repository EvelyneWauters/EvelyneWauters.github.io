<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All recipes</title>

  <!-- Add Bootstrap! -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/css/mainstylesheet.css"/>

</head>
<body>
<div class="container undernavbar">

  <h1>all recipes</h1>
  <c:choose>
  <c:when test="${recipe == null or empty recipe}">
  <p>No recipes found :-(</p>
  </c:when>
  <c:otherwise>
  <table class="table table-hover">
    <tr>
      <th>name</th>
      <th><span class="glyphicon glyphicon-time"/></th>
      <th>edit</th>
      <th>delete</th>
    </tr>

    <c:forEach var="recipe" items="${recipe}">
      <tr>
        <td><a href="/recipe/id/${recipe.id}">${recipe.name}</a></td>
          <td>${recipe.durationInMinutes} min</td>
        <td><a href="/recipe/form?id=${recipe.id}"> <span class="glyphicon glyphicon-pencil"/> </a></td>
        <td><a href="/recipe/delete/id/${recipe.id}"> <span class="glyphicon glyphicon-erase"/> </a></td>
      </tr>
    </c:forEach>
  </table>
  </c:otherwise>
  </c:choose>

  <a href="/recipe/form" class="btn btn-primary">Add a recipe</a>
  <a href="/" class="btn btn-default">Take me home</a>
</div>
</body>
</html>
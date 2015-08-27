<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <link rel="stylesheet" type="text/css" href="/css/mainstylesheet.css"/>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <title>Recipe detail</title>
</head>


<body>
<div class="container">

  <jsp:include page="navbar.jsp"></jsp:include>

  <h1> ${recipe.name} </h1>
  <h5><span class="glyphicon glyphicon-time"/> ${recipe.durationInMinutes} min <span class="glyphicon glyphicon-cutlery"/> ${recipe.mealType.label}</h5>

  <div class="row">
    <div class="col-md-4">
      <img src="http://i.ytimg.com/vi/lrIRTs-K0Jg/maxresdefault.jpg" alt="cover img" class="img-responsive"/>

    </div>

    <div class="col-md-8">

      <%--The list of ingredients--%>
      <c:choose>
        <c:when test="${empty recipe.ingredientList}">
          <p>No ingredients found :-(</p>
        </c:when>
        <c:otherwise>
          <table class="table table-hover">
            <tr>
            <th>ingredients         <a href="recipeaddingredient"><span class="glyphicon glyphicon-pencil"/></a> "</th>
            </tr>

            <c:forEach var="ingredients" items="${recipe.ingredientList}">
              <tr>
                <td>${ingredients.quantity.quantityMetric} ${ingredients.quantity.baseUnit} ${ingredients.name}</td>
              </tr>
            </c:forEach>
          </table>
        </c:otherwise>
      </c:choose>

      <h2>Description</h2>
      <p>${recipe.description}</p>

      <h2>How to: </h2>

      <p>${recipe.howTo} </p>

    </div>

  </div>

  <div class="whitebackground">



  </div>


  <input type="hidden" name="recipeId" value="${param['recipeId']}"/>


  <%--<a href="/character/form?movieId=${movie.id}" class="btn btn-primary">Add a character</a>--%>
  <%--<a href="/comment/all?id=${movie.id}" class="btn btn-primary">Show the comments on this movie</a>--%>


</div>
</body>
</html>

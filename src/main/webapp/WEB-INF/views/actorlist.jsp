<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>All actors</title>

  <!-- Add Bootstrap! -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/css/mainstylesheet.css"/>

</head>


<body>
<div class="container">
  <jsp:include page="navbar.jsp"></jsp:include>


  <h1>Actors</h1>
  <c:choose>
    <c:when test="${actor == null or empty actor}">
      <p>No actors found :-(</p>
    </c:when>
    <c:otherwise>
      <table class="table table-hover">
        <tr>
          <th></th>
          <th>name</th>
          <th>country</th>
          <th>born</th>
          <th>edit</th>
          <th>edit</th>
        </tr>

        <c:forEach var="actor" items="${actor}">
          <tr>
            <td><a href="/actor/id/${actor.id}"><img src="${actor.imageUrl}" alt="image" height="30px"></a></td>
            <td><a href="/actor/id/${actor.id}">${actor.firstName} ${actor.lastName}</a></td>
            <td><a href="/actor/id/${actor.id}">${actor.countryBornIn}</a></td>
            <td><a href="/actor/id/${actor.id}">${actor.birthDate}</a></td>
            <td><a href="/actor/form?id=${actor.id}"> <span class="glyphicon glyphicon-pencil"/>  </a></td>
            <td><a href="/actor/delete/id/${actor.id}"> delete  </a></td>
          </tr>
        </c:forEach>
      </table>
    </c:otherwise>
  </c:choose>

  <a href="/actor/form" class="btn btn-primary">Add an actor</a>
  <a href="/" class="btn btn-default">Take me all the way home</a>



</body>
</html>
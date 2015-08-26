<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!-- Add Bootstrap! -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="/css/mainstylesheet.css"/>

    <title>See comments</title>
</head>


<body>
<div class="container">

  <jsp:include page="navbar.jsp"></jsp:include>

  <h1>a penny for your thoughts </h1>
  <c:choose>
    <c:when test="${comment == null or empty comment}">
      <p>No comments yet :-(</p>
    </c:when>
    <c:otherwise>
      <table class="table table-hover">
        <tr>
          <th>user</th>
          <th>content</th>
          <th>date</th>
        </tr>

        <c:forEach var="comment" items="${comment}">
          <tr>
            <td><a href="/user/id/${comment.user.id}">${comment.user.login}</a></td>
            <td>${comment.content}</td>
            <td>${comment.dateAdded}</td>
          </tr>
        </c:forEach>
      </table>
    </c:otherwise>
  </c:choose>



  <a href="/comment/form?movieid=${param['id']}" class="btn btn-primary">Add a comment</a>
  <a href="/" class="btn btn-default">Take me all the way home</a>


</div>


</body>
</html>

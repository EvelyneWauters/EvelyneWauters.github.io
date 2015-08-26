<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
  <link rel="stylesheet" type="text/css" href="/css/mainstylesheet.css"/>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  <style>
    .blueskies{ background-image: url("http://nhtheatreawards.org/Data/Sites/1/aaImages/graphics/Sky%20and%20Clouds/beautiful_sky-dsc01468-dws.jpg");
      background-position: center;
      background-repeat: no-repeat;}
  </style>
  <title>add comment</title>
</head>

<body class = "blueskies">
<div class="container">

  <jsp:include page="navbar.jsp"></jsp:include>


  <h1>thoughts?</h1>



  <h2>add a comment </h2>


  <sf:form commandName="comment" action="/comment/create">


    <div class="form-group">
      <label for="content">content</label>
      <sf:textarea class="form-control" rows="8" path="content" ></sf:textarea>
    </div>



    <div class="form-group">
      <label for="movie.rating">rating</label>
      <sf:input path="movie.rating" class="form-control" value=" " />
    </div>

    <div class="form-group">
      <label for="user.login">login</label>
      <sf:input path="user.login" class="form-control" />
    </div>

    <div class="form-group">
      <label for="user.password">password</label>
      <sf:password path="user.password" class="form-control"/>
    </div>

    <sf:hidden path="id"/>

    <input type="hidden" name="movieid" value="${param['movieid']}"/>


    <button type="submit" class="btn btn-success">submit</button>
  </sf:form>
</div>
</body>
</html>

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

  <title>Movie in Detail</title>
</head>


<body>
<div class="container">

  <jsp:include page="navbar.jsp"></jsp:include>

  <h1> This is the profile page of cinephiliac ${user.login}</h1>
  <h3> ${user.firstName} ${user.lastName} </h3>
  <h5>sing happy birthday on ${user.birthDate} </h5>

  <div class="row">
    <div class="col-md-4">
      <img src="${user.imageUrl}" alt="cover img" class="img-responsive"/>

    </div>

    <div class="col-md-8">

      <h2>Bio: </h2>

      <p>${user.bio} </p>


    </div>

  </div>






</div>
</body>
</html>

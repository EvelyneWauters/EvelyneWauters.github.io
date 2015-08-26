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
  <title>Register, it's free (for now)!</title>
</head>

<body class = "blueskies">
<div class="container">

  <jsp:include page="navbar.jsp"></jsp:include>


  <h1>Come join us!</h1>


  <sf:form commandName="user" action="/user/create">


    <div class="form-group">
      <label for="login">nickname</label>
      <sf:input path="login" class="form-control"/>
      <sf:errors path="login"/>
    </div>

    <div class="form-group">
      <label for="firstName">first name</label>
      <sf:input path="firstName" class="form-control"/>
    </div>

    <div class="form-group">
      <label for="lastName">last name</label>
      <sf:input path="lastName" class="form-control"/>
    </div>

    <div class="form-group">
      <label for="email">where can we send all the spam?</label>
      <sf:input path="email" class="form-control"/>
    </div>

    <%--TODO: make a password field--%>
    <div class="form-group">
      <label for="password">password</label>
      <sf:password path="password" class="form-control"/>
    </div>

    <div class="form-group">
      <label for="bio">tell us something about yourself:</label>
      <sf:textarea class="form-control" rows="5" path="bio" ></sf:textarea>
    </div>

    <div class="form-group">
      <label for="gender">gender</label>
      <sf:select path="gender" items="${genders}" cssClass="form-control"/>
    </div>

    <div class="form-group">
      <label for="birthDate">when do you blow out your birthdaycandles?</label>
      <sf:input path="birthDate" class="form-control" />
    </div>


    <div class="form-group">
      <label for="imageUrl">show yourself!</label>
      <sf:input path="imageUrl" class="form-control" />
    </div>


    <sf:hidden path="id"/>


    <button type="submit" class="btn btn-success">submit</button>
  </sf:form>
</div>
</body>
</html>

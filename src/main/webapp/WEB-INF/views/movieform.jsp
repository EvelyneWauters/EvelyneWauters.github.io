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
    <title>Create movie</title>
</head>

<body class = "blueskies">
<div class="container">

    <jsp:include page="navbar.jsp"></jsp:include>


    <h1>What have you been watching lately?</h1>



        <h2>add a movie <small>or edit an existing one</small></h2>


        <sf:form commandName="movie" action="/movie/create">


            <div class="form-group">
                <label for="title">title</label>
                <sf:input path="title" class="form-control"/>
                <sf:errors path="title"/>
            </div>

            <div class="form-group">
                <label for="yearReleased">released</label>
                <sf:input path="yearReleased" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="summary">summary</label>
                <sf:textarea class="form-control" rows="5" path="summary" ></sf:textarea>
            </div>

            <div class="form-group">
                <label for="genre">genre</label>
                <sf:select path="genre" items="${genres}" cssClass="form-control"/>
            </div>


            <div class="form-group">
                <label for="length">length</label>
                <sf:input path="length" class="form-control" value=" " />
            </div>

            <div class="form-group">
                <label for="director">director</label>
                <sf:input path="director" class="form-control" />
            </div>

            <div class="form-group">
                <label for="coverImageUrl">URL poster</label>
                <sf:input path="coverImageUrl" class="form-control"/>
            </div>

            <div class="form-group">
                <label for="movieTrailerUrl">URL trailer (embedded link)</label>
                <sf:input path="movieTrailerUrl" class="form-control"/>
            </div>


            <sf:hidden path="id"/>
            <sf:hidden path="rating"/>


            <button type="submit" class="btn btn-success">submit</button>
        </sf:form>
</div>
</body>
</html>

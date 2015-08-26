<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie list</title>

    <!-- Add Bootstrap! -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/mainstylesheet.css"/>


</head>


<body>
<div class="container">
    <jsp:include page="navbar.jsp"></jsp:include>

<div class="undernavbar">

    <h1>Movies</h1>
    <c:choose>
        <c:when test="${movie == null or empty movie}">
            <p>No movies found :-(</p>
        </c:when>
        <c:otherwise>
            <table class="table table-hover">
                <tr>
                    <th>id</th>
                    <th></th>
                    <th>rating</th>
                    <th>title</th>
                    <th>release year</th>
                    <th>genre</th>
                    <th>edit</th>
                    <th>delete</th>
                </tr>

                <c:forEach var="movie" items="${movie}">
                    <tr>
                        <td><a href="/movie/id/${movie.id}">${movie.id}</a></td>
                        <td><a href="/movie/id/${movie.id}"><img src="${movie.coverImageUrl}" alt="cover img"
                                                                 height="30px"></a></td>
                        <td><a href="/movie/id/${movie.id}">${movie.rating}</a></td>
                        <td><a href="/movie/id/${movie.id}">${movie.title}</a></td>
                        <td><a href="/movie/id/${movie.id}">${movie.yearReleased}</a></td>
                        <td><a href="/movie/id/${movie.id}">${movie.genre.label}</a></td>
                        <td><a href="/movie/form?id=${movie.id}"> <span class="glyphicon glyphicon-pencil"/> </a></td>
                        <td><a href="/movie/delete/id/${movie.id}"> <span class="glyphicon glyphicon-erase"/> </a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

    <a href="/movie/form" class="btn btn-primary">Add a movie</a>
    <a href="/" class="btn btn-default">Take me all the way home</a>
</div>
</div>
</body>
</html>
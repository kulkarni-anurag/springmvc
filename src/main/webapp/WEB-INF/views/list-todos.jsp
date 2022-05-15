<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Todos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container">
        <h2 class="text-center mt-3">Todo Page</h2>
        <br />
        <h4>Hi ${username}</h4>
        <br />
        <table class="table table-bordered table-striped">
            <caption>Your todos are</caption>
            <thead>
                <tr>
                    <td>Id</td>
                    <td>Description</td>
                    <td>User</td>
                    <td>Target Date</td>
                    <td>Is Completed</td>
                </tr>
            </thead>
            <tbody>
                <!-- for(Todo todo : todos) -->
                <c:forEach items="${todos}" var="todo">
                    <tr>
                        <td>${todo.id}</td>
                        <td>${todo.desc}</td>
                        <td>${todo.user}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br />
        <a href="/springmvc/addtodo" class="btn btn-info">Add Todo</a>
    </div>
</body>
</html>
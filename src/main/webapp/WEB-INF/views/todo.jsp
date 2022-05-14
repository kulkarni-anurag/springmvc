<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Todo Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
    <div class="container">
        <h2 class="text-center mt-3">Add a new Todo</h2>
        <br />
        <form method="post" action="/springmvc/addtodo">
            <div class="form-group">
                <label for="desc">Enter Todo Description</label>
                <input type="text" class="form-control" name="desc" id="desc" placeholder="Enter Todo Description" />
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-success">Add</button>
            </div>
        </form>
    </div>
</body>
</html>
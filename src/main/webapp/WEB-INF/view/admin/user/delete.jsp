<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Document</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            </head>

            <body>
                <div class="container mt-5">
                    <div class="d-flex justify-content-between align-items-center mt-4 mb-2">
                        <h3>Delete user = ${id}</h3>
                        <a href="/admin/user" class="btn btn-close"></a>
                    </div>
                    <hr>
                    <div class="alert alert-danger" role="alert">
                        Do you want to delete User ${id} ?
                    </div>
                    <form:form method="post" action="/admin/user/delete" modelAttribute="deleteUser">
                        <div class="mb-3 d-none">
                            <label class="form-label">id:</label>
                            <form:input type="id" class="form-control" path="id" />
                        </div>
                        <button type="submit" class="btn btn-danger">Yes</button>
                    </form:form>
            </body>

            </html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Create</title>
            <!-- Latest compiled and minified CSS -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

            <!-- Latest compiled JavaScript -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        </head>

        <body>
            <div class="container mt-5">
                <div class="row">
                    <div class="col-md-6 mx-auto">
                        <h3>Create a user</h3>
                        <hr>
                        <form action="">
                            <div class="mb-3">
                                <label class="form-label">Email:</label>
                                <input class="form-control" type="email">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Password:</label>
                                <input class="form-control" type="password">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Full Name:</label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Address:</label>
                                <input class="form-control" type="text">
                            </div>
                            <div class="mb-3">
                                <label class="form-label">Phone:</label>
                                <input class="form-control" type="number">
                            </div>
                            <button class="btn btn-primary" type="submit">Create</button>

                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>
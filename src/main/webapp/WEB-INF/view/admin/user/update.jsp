<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
                            <div class="d-flex justify-content-between">
                                <h3>Update user</h3>
                                <a href="/admin/user" class="btn btn-close"></a>
                            </div>
                            <hr>

                            <form:form method="post" action="/admin/user/update" modelAttribute="updateUser">
                                <!-- action la url tren server -->
                                <div class="mb-3" style="display: none;">
                                    <label class="form-label">Id:</label>
                                    <form:input class="form-control" type="id" path="id" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Email:</label>
                                    <form:input class="form-control" type="email" path="email" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Full Name:</label>
                                    <form:input class="form-control" type="text" path="fullName" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Address:</label>
                                    <form:input class="form-control" type="text" path="address" />
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Phone Number:</label>
                                    <form:input class="form-control" type="number" path="phone" />
                                </div>
                                <button class="btn btn-primary" type="submit">Update</button>

                            </form:form>
                        </div>
                    </div>
                </div>
            </body>

            </html>
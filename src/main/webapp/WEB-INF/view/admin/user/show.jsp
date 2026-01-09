<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>User Detail ${id}</title>
                <!-- Latest compiled and minified CSS -->
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

                <!-- Latest compiled JavaScript -->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
            </head>

            <body>
                <div class="container">
                    <div class="row">
                        <div class="d-flex justify-content-between align-items-center mt-4 mb-2">
                            <h3>User detail id = ${id}</h3>
                            <a href="/admin/user" class="btn btn-close"></a>
                        </div>
                        <hr>
                        <div class="card" style="width: 18rem;">
                            <div class="card-header">
                                User infor
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Email: ${user.email}</li>
                                <li class="list-group-item">Fullname: ${user.fullName}</li>
                                <li class="list-group-item">Address: ${user.address}</li>
                                <li class="list-group-item">Email: ${user.phone}</li>
                            </ul>
                        </div>
                        
                    </div>
                </div>
            </body>

            </html>
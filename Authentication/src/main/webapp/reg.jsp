<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>

<!-- Bootstrap 5 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card shadow">
                <div class="card-header text-center bg-primary text-white">
                    <h4>Registration Form</h4>
                </div>

                <div class="card-body">
                <span class="text-success">${msg }</span>
                <span class="text-danger">${err }</span>
                    <form action="reg" method="post">

                        <!-- Username -->
                        <div class="mb-3">
                            <label class="form-label">Username</label>
                            <input type="text" name="name" class="form-control" placeholder="Enter username">
                        </div>

                        <!-- Email -->
                        <div class="mb-3">
                            <label class="form-label">Email</label>
                            <input type="email" name="email" class="form-control" placeholder="Enter email">
                        </div>

                        <!-- Password -->
                        <div class="mb-3">
                            <label class="form-label">Password</label>
                            <input type="password" name="pass" class="form-control" placeholder="Enter password">
                        </div>

                        <!-- Gender -->
                        <div class="mb-3">
                            <label class="form-label d-block">Gender</label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" value="male">
                                <label class="form-check-label">Male</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="gender" value="female">
                                <label class="form-check-label">Female</label>
                            </div>
                        </div>

                        <!-- Language -->
                        <div class="mb-3">
                            <label class="form-label d-block">Language</label>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" name="lang" value="guj">
                                <label class="form-check-label">Gujarati</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" name="lang" value="hin">
                                <label class="form-check-label">Hindi</label>
                            </div>
                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="checkbox" name="lang" value="eng">
                                <label class="form-check-label">English</label>
                            </div>
                        </div>

                        <!-- Country -->
                        <div class="mb-3">
                            <label class="form-label">Country</label>
                            <select name="country" class="form-select">
                                <option value="0">--- Select country ---</option>
                                <option value="in">India</option>
                                <option value="usa">USA</option>
                                <option value="aus">Australia</option>
                            </select>
                        </div>

                        <!-- Address -->
                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <textarea class="form-control" rows="3" name="address"></textarea>
                        </div>

                        <!-- Buttons -->
                        <div class="d-flex justify-content-between">
                            <input type="submit" class="btn btn-primary" value="Register">
                            <input type="reset" class="btn btn-secondary" value="Reset">
                        </div>
                        <br>
						<a href="index.jsp">Already Registered? Login here</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

<!DOCTYPE html>
<html lang="en" >
<meta charset="UTF-8"/>
<head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <link href="https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="resources/Home/style2.css">
    <link rel="stylesheet" href="resources/Home/style.css">
    <link rel="stylesheet" href="/resources/To-Do%20List/To-Do%20List.css"data-role="def">


</head>

<div id = "ContentDiv" class="form">

    <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
    </ul>

    <div class="tab-content">
        <div id="signup">
            <form action="/Register" method="POST">
            <h1>Sign Up for Free</h1>

                <c:if test="${not empty error}">
                    <div class="error" style="color: red; font-size: 25px">${RegisterError}</div>
                </c:if>
                <c:if test="${not empty success}">
                    <div class="success" style="color: #edfc0b; font-size: 25px">${msg}</div>
                </c:if>
                <div class="top-row">
                    <div class="field-wrap">
                        <label>
                            First Name<span class="req">*</span>
                        </label>
                        <input type="text" name="firstName" required="" autocomplete="off">
                    </div>

                    <div class="field-wrap">
                        <label>
                            Last Name<span class="req">*</span>
                        </label>
                        <input type="text" name="lastName" required="" autocomplete="off">
                    </div>
                </div>

                <div class="field-wrap">
                    <label>
                        Email Address<span class="req">*</span>
                    </label>
                    <input type="email" name="newEmail" required="" autocomplete="off">
                </div>

                <div class="field-wrap">
                    <label>
                        Set A Password<span class="req">*</span>
                    </label>
                    <input type="password" name="newPassword" required="" autocomplete="off">
                </div>

                <button type="submit" class="button button-block">Get Started</button>
            </form>

        </div>

        <div id="login">
            <h1>Welcome Back!</h1>

                <div id="errorDiv" style="display: none;color: red; font-size: 25px;">Invalid Email or Password</div>
                <div class="field-wrap">
                    <label>
                        Email Address<span class="req">*</span>
                    </label>
                    <input type="email" id="email" required="" autocomplete="off">
                </div>

                <div class="field-wrap">
                    <label>
                        Password<span class="req">*</span>
                    </label>
                    <input type="password" id="password" required="" autocomplete="off">
                </div>

                <p class="forgot"><a href="#">Forgot Password?</a></p>

                <button class="button button-block" id="login-btn">Log In</button>


        </div>

    </div><!-- tab-content -->
</div> <!-- /Content -->

    <div id="myDIV" class="header" style="display: none;">
        <button type="button" class="Logout-btn" onclick="window.location.href='http://localhost:8080/index.jsp';">Log Out</button>
        <h2 style="margin:5px">To-Do List</h2>
        <input type="text" id="myInput" placeholder="Title...">
        <span onclick="newElement()" class="addBtn">Add</span>
    </div>

    <ul id="myUL" style="display: none;">
    </ul>


<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="/resources/Home/index.js"></script>
<script src="/resources/Home/login.js"></script>
<script src="/resources/To-Do%20List/To-Do%20List.js"></script>

</body>

</html>

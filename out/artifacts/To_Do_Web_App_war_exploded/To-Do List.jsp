<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/resources/To-Do%20List/To-Do%20List.css">
</head>
<body>

<div id="myDIV" class="header">
    <button class="Hi-btn">${firstName}</button>
    <button type="button" class="Logout-btn" onclick="window.location.href='http://localhost:8080/index.jsp';">Log Out</button>
    <h2 style="margin:5px">To-Do List</h2>
    <input type="text" id="myInput" placeholder="Title...">
    <span onclick="newElement()" class="addBtn">Add</span>
</div>

<ul id="myUL">
    <li>Hit the gym</li>
    <li class="checked">Pay bills</li>
    <li>Meet George</li>
    <li>Buy eggs</li>
    <li>Read a book</li>
    <li>Organize office</li>
</ul>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script type="text/javascript" src="/resources/To-Do%20List/To-Do%20List.js"></script>
</body>
</html>

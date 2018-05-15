
# To-Do-List-Web-App

To-Do-List-Web-App is a Java Spring MVC Web Application where the user can
login/logout and can create, view, edit and delete a To-Do list.

# UI

UI is designed using HTML5,Materialize.CSS,Javascript and jQuery.
It is a single page web application which uses ajax calls for Registration,
Login,Adding To Do's,Deleting them and Logout.
It also validates user and shows appropriate warnings and directions.

![Wrong Login](/images/Login.png)

# DB

MySQL is used as database for this application which is connected with 
backend using JDBC and MySQL connector JAR.Database contains one Users table
and other Tasks table.
Users table has userId,firstName,lastName,email,password as its columns
Tasks table has userId,task,action,taskId as its columns.

# Backend

Backend is made using Java Spring MVC framework(annotation based)
1.Registration:
User's entries are sent to controller using form action where first user 
is checked for making sure no duplicate user.Then user is registered and a view 
of same page is sent with message to Login as model.

2.Login:
Controller is called using AJAX and after validating email and password from DB
if user is valid his ToDo list's tasks along with taskId(Primary key in DB) is sent
as json response(using Google's GSON) else Error message which makes error div 
to appear with warning on Login page.

3.Add Todo's:
A button is provided with an input box to add tasks.On click of that button AJAX call
is made to ADD controller which then adds the task in DB using POJO class.

![ToDo List](/images/TodoList.png

4.Delete ToDo's:
On clicking cross button given for each task controller is called through AJAX and taskId is
sent to it.Controller interacts with DB and sets action of that taskId as delete,it is not 
deleted permanently.In future if any History is needed then it can be used again.

![ToDo Delete](/images/ToDoDelete.png)

5.Logout:
Logout controller is called using loaction.href on button for Logout.
It redirects user to Login/SignUP page.

![SignUp Page](/images/SignUp.png)



# Authors

Vishwanath Sharma


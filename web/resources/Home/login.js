$(document).ready(function () {

    $('#login-btn').click(function () {
        var loginUser = {
           "email": $('#email').val(),
           "password": $('#password').val()
       } ;
        $.ajax({
           type:'POST',
            contentType : 'application/json; charset=utf-8',
           dataType:'json',
            url:'http://localhost:8080/Login',
           data:JSON.stringify(loginUser),
           success:function (list) {
               var task = JSON.parse(list);
               console.log(list);
           }
        });

    });
});
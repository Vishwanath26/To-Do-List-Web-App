$(document).ready(function () {

    var x;
    var List = "";
    var task ={};
    var stylesheet = document.styleSheets[4];
    stylesheet.disabled = true;

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
           success:function (response) {
               if (response !== "Error") {
                   console.log(response);
                   x = response;

                   $('#ContentDiv').hide();
                   var stylesheet1 = document.styleSheets[0];
                   var stylesheet2 = document.styleSheets[1];
                   var stylesheet3 = document.styleSheets[2];
                   var stylesheet4 = document.styleSheets[3];
                   stylesheet1.disabled = true;
                   stylesheet2.disabled = true;
                   stylesheet3.disabled = true;
                   stylesheet4.disabled = true;
                   stylesheet.disabled = false;
                   $('#myDIV').show();
                   $('#myUL').show();
                   var y = Object.keys(x);
                   x[0] = " ";
                   x[1] = " ";
                   y.forEach(function (item) {
                       console.log(x[item]);
                       List += '<li class = "ToDo" id=' + item + '>';
                       List += x[item] + '</li>';
                   });
                   $('#myUL').html(List);
                   var myNodelist = document.getElementsByClassName("ToDo");
                   var i;
                   for (i = 0; i < myNodelist.length; i++) {
                       var span = document.createElement("SPAN");
                       var txt = document.createTextNode("\u00D7");
                       span.className = "close";
                       span.appendChild(txt);
                       myNodelist[i].appendChild(span);
                   }
                   var close = document.getElementsByClassName("close");
                   var i;
                   for (i = 0; i < close.length; i++) {
                       close[i].onclick = function () {
                           var div = this.parentElement;
                           var text = div.textContent;
                           task = {
                               "taskId": div.id,
                               "action": "delete"

                           };
                           document.getElementById("myInput").value = "";
                           $.ajax({
                               type: 'POST',
                               contentType: 'application/json; charset=utf-8',
                               dataType: 'json',
                               url: 'http://localhost:8080/Delete',
                               data: JSON.stringify(task)
                           });

                           console.log(text);
                           div.style.display = "none";
                       }
                   }

               }
               else {
                   $("#errorDiv").show();
               }
           }
        });

    });
    $('.addBtn').click(function () {

        task = {
            "task" : $('#myInput').val(),
            "action" : "insert"

        };
        document.getElementById("myInput").value = "";
        $.ajax({
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            url: 'http://localhost:8080/Add',
            data:JSON.stringify(task)
        });
    });
    $('')


});
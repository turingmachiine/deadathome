<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="js/jquery.min.js"></script>
    <title>Document</title>
</head>
<body>
<div>
    <p><input id="query" oninput="f()"/></p> <#-- строка, в которой пишешь, по введению
                                                        буквы происходит вызов функции-->
</div>
<div>
    <table id="res"> <#-- внутрь  этого тэга выводится результат-->
        <tr>
            <th>Имя</th>
            <th>email</th>
        </tr>
        <#list users as user>
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
            </tr>
        </#list>
    </table>
</div>
</body>
    <script type="application/javascript">
        function f() {
            if ($("#query").val().length >= 0) {
                $.ajax({
                    url: "/searchUsers",
                    data: {"name": $("#query").val()},
                    dataType: "json",
                    success: function (msg) {
                        if (msg.length >= 1) {
                            $("#res").html("");
                            $("#res").append("<tr>" + "\n")
                            $("#res").append("<th> Имя </th>" + "\n");
                            $("#res").append("<th> Email </th>" + "\n");
                            $("#res").append("</tr>" + "\n")
                            for (var i = 0; i < msg.length; i++) {
                                $("#res").append("<tr>" + "\n")
                                $("#res").append("<td>" + msg[i].name + "</td>" + "\n");
                                $("#res").append("<td>" + msg[i].email + "</td>" + "\n");
                                $("#res").append("</tr>" + "\n")
                            }
                        } else {
                            $("#res").html("No results..");
                        }
                    }
                })
            }
            else {
                $("#res").html("");
            }
        }
    </script>
</html>
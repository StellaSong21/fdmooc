function check() {
    let username = $("#username").val();
    let password = $("#password").val();
    if (username == undefined || username === "") {
        $("#us").html("<div class=\"glyphicon glyphicon-remove\"> invalid</div>");
        return;
    }
    if (password == undefined || password === "") {
        $("#ps").html("<div class=\"glyphicon glyphicon-remove\"> invalid</div>");
        return;
    }
    $.post("Servlet", {
        type: "login",
        username: username,
        password: password
    }, function (data) {
        console.log(data);
        if (data < 60000) {
            console.log("success");
            $.session.set("uid", data);
            $.session.set("username", username);
        } else {
            $("#us").html("<div class=\"glyphicon glyphicon-remove\"> maybe wrong</div>");
            $("#ps").html("<div class=\"glyphicon glyphicon-remove\"> maybe wrong</div>");
        }
    })
}
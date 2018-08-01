function mail() {
    if (!check())
        return;
    let email = $("#email").val();
    if (!checkEmail(email)) return;
    if (!check()) return;
    $.post("Servlet", {
        type: "mail",
        username: $("#username").val(),
        email: $("#email").val()
    }, function (data) {
        console.log("check email" + data);
        $("#send").html("SEND<div class=\"glyphicon glyphicon-ok\"></div>")
    })
}

function check() {
    let username = $("#username").val();
    if (username == undefined || username === "")
        return false;
    $.post("Servlet", {
        type: "hasUsername",
        username: username
    }, function (data) {
        console.log("check username" + data);
        if (data === false) {
            $("#us").html("exists.");
            return false;
        }
        $("#us").html("<div class=\"glyphicon glyphicon-ok\"></div>");
        return true;
    });
    return false;
}

function register() {
    let username = $("#username").val();
    if (!check()) return;
    let password = $("#password").val();
    if (!([a - z].test(password) && password.length > 5)) {
        $("#ps").html("<div class=\"glyphicon glyphicon-remove\">invalid</div>")
        return;
    }
    let confirm = $("#confirm").val();
    if (password !== confirm) {
        $("#cs").html("<div class=\"glyphicon glyphicon-remove\">invalid</div>")
        return;
    }
    let email = $("#email").val();
    if (!checkEmail(email)) return;
    let nickname = $("#nickname").val();
    if (nickname == undefined || nickname === "") {
        $("#ns").html("<div class=\"glyphicon glyphicon-remove\">not blank</div>")
        return;
    }
    let verify = $("#verify").val();
    if (verify == undefined || verify === "") {
        $("#ns").html("<div class=\"glyphicon glyphicon-remove\">not blank</div>")
        return;
    }
    $.post("Servlet", {
        type: "register",
        username: username,
        password: password,
        nickname: nickname,
        email: email,
        verify: verify
    }, function (data) {
        console.log("register" + data);
        if (data > 60000) {
            $("#vs").html("<div class=\"glyphicon glyphicon-remove\">invalid</div>");
        } else {
            $.session.set("username", username);
            $.session.set("uid", data);
        }
    });
}

function checkEmail(email) {
    const email_pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (email_pattern.test(email)) {
        $("#es").html("invalid");
        return false;
    }
    return true;
}
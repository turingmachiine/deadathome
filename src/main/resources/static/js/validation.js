function pass_check() {
    pass_str = $("#password").val();
    if (pass_str.length < 8) {
        $("#length_error").html("Пароль должен быть не короче 8 символов");

        document.getElementById("form_btn").disabled = true;
    } else {

        document.getElementById("form_btn").disabled = false;
        $("#length_error").html("");
    }
    if (pass_str.search(/.*[\d].*/) != -1) {
        $("#num_error").html("");
        document.getElementById("form_btn").disabled = false;
    } else {
        $("#num_error").html("Пароль должен содержать хотя бы одну цифру");
        document.getElementById("form_btn").disabled = true;
    }
    if (pass_str.search(/.*[A-ZА-Я].*/) != -1) {

        document.getElementById("form_btn").disabled = false;
        $("#letter_error").html("")
    } else {
        $("#letter_error").html("Пароль должен содержать хотя бы одну заглавную букву")

        document.getElementById("form_btn").disabled = true;
    }
}

function email_check() {
    email_str = $("#email").val();
    if ((email_str.search(/.*@.*/) != -1) ||
        (email_str.search(/^(\s*)?(\+)?([- _():=+]?\d[- _():=+]?){10,14}(\s*)?$/) != -1)) {
        $("#email_error").html("");
        document.getElementById("form_btn").disabled = false;
    } else {
        $("#email_error").html("Введите валидный email или номер телефона");
        document.getElementById("form_btn").disabled = true;
    }
}
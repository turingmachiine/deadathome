function pass_check() {
    pass_str = $("#password").val();
    if (pass_str.length < 8) {
        $("#length_error").html("Пароль должен быть не короче 8 символов")
    } else {
        $("#length_error").html("");
    }
    if (pass_str.search(/.*[\d].*/) != -1) {
        $("#num_error").html("")
    } else {
        $("#num_error").html("Пароль должен содержать хотя бы одну цифру")
    }
    if (pass_str.search(/.*[A-ZА-Я].*/) != -1) {
        $("#letter_error").html("")
    } else {
        $("#letter_error").html("Пароль должен содержать хотя бы одну заглавную букву")
    }
}
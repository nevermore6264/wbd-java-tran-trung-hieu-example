function check() {
    var idCard = document.getElementById("idCard");
    if (isNaN(idCard.value) == true) {
        document.getElementById("idCard_error").innerHTML = "Field must be number";
        idCard.style.border = "1px solid red";
        idCard.focus();
        return false;
    } else {
        document.getElementById("idCard_error").innerHTML = "";
        idCard.style.border = "";
    }

    var name = document.getElementById("name");
    if (name.value == "") {
        document.getElementById("name_error").innerHTML = "Field must not be empty";
        name.style.border = "1px solid red";
        name.focus();
        return false;
    } else {
        document.getElementById("name_error").innerHTML = "";
        name.style.border = "";
    }

    var birthday = document.getElementById("birthday");
    var pattern = /^([0-9]{2})-([0-9]{2})-([0-9]{4})$/;
    if (birthday.value == "" || !pattern.test(birthday.value)) {
        document.getElementById("birthday_error").innerHTML = "Input format dd/MM/yyyy";
        birthday.style.border = "1px solid red";
        birthday.focus();
        return false;
    } else {
        document.getElementById("birthday_error").innerHTML = "";
        birthday.style.border = "";
    }

    var phone = document.getElementById("phoneNumber");
    var check = /^\d{10,11}$/;
    if (check.test(phone.value)) {
        document.getElementById("phone_error").innerHTML = "Field must be number";
        phone.style.border = "1px solid red";
        phone.focus();
        return false;
    } else if (phone.value.length > 11 || phone.value.length < 10) {
        document.getElementById("phone_error").innerHTML = "Field length form 10 to 11";
        phone.style.border = "1px solid red";
        phone.focus();
        return false;
    } else {
        document.getElementById("phone_error").innerHTML = "";
        name.style.border = "";
    }

    var email = document.getElementById("email");
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (email.value == "" || !re.test(email.value)) {
        document.getElementById("email_error").innerHTML = "Please enter the email";
        email.style.border = "1px solid red";
        email.focus();
        return false;
    } else {
        document.getElementById("email_error").innerHTML = "";
        email.style.border = "";
    }

    var address = document.getElementById("address");
    if (address.value = "") {
        document.getElementById("address_error").innerHTML = "Field must not be empty";
        address.style.border = "1px solid red";
        address.focus();
        return false;
    } else {
        document.getElementById("address_error").innerHTML = "";
        address.style.border = "";
    }
}

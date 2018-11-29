function enviardados() {

    if (document.loginform.username.value == "" || document.loginform.username.value.length < 3)
    {
        alert("Preencha o login corretamente!");
        document.loginform.username.focus();
        return false;
    }


    if (document.loginform.userPass.value == "" || document.loginform.userPass.value.length < 3)
    {
        alert("Preencha a senha corretamente!");
        document.loginform.userPass.focus();
        return false;
    }

    return true;
}




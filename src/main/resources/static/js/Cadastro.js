function PasswordEqual() {
    if (document.forms["form"]["pass1"].value != document.forms["form"]["pass2"].value) {
        alert("Passwords are not matching");
        return false;
      }
    else {
        return true;
    }
}

var success;

function cadastrar() {
    const name = document.getElementById("name").value;
    const pass1 = document.getElementById("pass1").value;
    const pass2 = document.getElementById("pass2").value;

    const cadastrarCommand = {
        username: name,
        password: pass1,
        retype: pass2
    };


    fetch("/newuser",{
        method: 'POST',
        body: JSON.stringify(cadastrarCommand),
        headers: {
            'Content-Type': 'application/json',
            'access-control-allow-origin': '*'
        }
    })
    .then(response => response.text())
    .then(data => success = data)
    .then(callback);
}

function callback() {
    if (success === "true")
        document.location.href = "InitialPage.html";
    else
        window.alert("Não foi possível realizar essa operação");
}
function PasswordEqual() {
    if (document.forms["form"]["pass3"].value != document.forms["form"]["pass4"].value) {
        alert("Passwords are not matching");
        return false;
      }
    else {
        return true;
    }
}

var success;

function updatePassword() {
    const pass3 = document.getElementById("pass3").value;
    const pass4 = document.getElementById("pass4").value;

    const updatePasswordCommand = {
        password: pass3,
        retype: pass4
    };


    fetch("/updateUserPassword",{
        method: 'POST',
        body: JSON.stringify(updatePasswordCommand),
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
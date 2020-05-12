function PasswordEqual() {
    if (document.forms["form"]["pass1"].value != document.forms["form"]["pass2"].value) {
        alert("Passwords are not matching");
        return false;
      }
    else {
        return true;
    }
}
// (function ($) {
//    "use strict";
//
//
//    /*==================================================================
//    [ Validate ]*/
//    var input = $('.validate-input .input100');
//
//    $('.validate-form').on('submit',function(){
//        var check = true;
//
//        for(var i=0; i<input.length; i++) {
//            if(validate(input[i]) == false){
//                showValidate(input[i]);
//                check=false;
//            }
//        }
//
//        return check;
//    });
//
//
//    $('.validate-form .input100').each(function(){
//        $(this).focus(function(){
//           hideValidate(this);
//        });
//    });
//
//    function validate (input) {
//        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
//            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
//                return false;
//            }
//        }
//        else {
//            if($(input).val().trim() == ''){
//                return false;
//            }
//        }
//    }
//
//    function showValidate(input) {
//        var thisAlert = $(input).parent();
//
//        $(thisAlert).addClass('alert-validate');
//    }
//
//    function hideValidate(input) {
//        var thisAlert = $(input).parent();
//
//        $(thisAlert).removeClass('alert-validate');
//    }
    
    function login(){
    	sendLoginRequest();
    }
    
    function sendLoginRequest() {
        const username = document.getElementById("usuario").value;
        const password = document.getElementById("senha").value;

        const loginRequest = {
            username: username,
            password: password
        }

        console.log(loginRequest);

        fetch("/login",
            {
                method: 'POST',
                body: JSON.stringify(loginRequest),
                headers: {
                    'Content-Type': 'application/json',
                    'access-control-allow-origin': '*'
                }
            })
            .then(response => response.text())
            .then(data => logged = data)
            .then(validateLogin);
    }
    
    function validateLogin() {
        if (logged === "LOGGED")
            document.location.href = "InitialPage.html";
        else
            window.alert("Usuário ou senhha incorretos");
    }
    
    

//})(jQuery);
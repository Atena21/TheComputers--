    
	let logged;

	function login(){
    	sendLoginRequest();
    }
    
    function sendLoginRequest() {
        const username = document.getElementById("usuario").value;
        const password = document.getElementById("senha").value;

        const loginRequest = {
            username: username,
            password: password
        };


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
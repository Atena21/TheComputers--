/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
    if (!e.target.matches('.dropbtn')) {
    var myDropdown = document.getElementById("myDropdown");
        if (myDropdown.classList.contains('show')) {
        myDropdown.classList.remove('show');
        }
    }
}


function loadArray(array){

    var lastMessage = "última mensagem";

    array.forEach(function(item) {
    var buttonDiv = document.createElement("div");
    buttonDiv.classList.add("btnDiv");
    var button = document.createElement("a");
    // console.log(button);
    var name = document.createTextNode(item.name);
    var br = document.createElement("br");
  //  var lastMessage = document.createTextNode(item.lastMessage);
    button.href = "./chat.html";
    button.appendChild(name);
    button.appendChild(br);
    button.appendChild(lastMessage);
    button.classList.add("btn");
    buttonDiv.appendChild(button);
    buttonDiv.cli
    document.getElementById("chats").appendChild(buttonDiv);
    });

    function logout (){
        fetch("/logout",
                {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json',
                        'access-control-allow-origin': '*'
                    }
                })
                .then(response => response.text());
    };

    function getRoomsByUser () {
        fetch("/getRoomsByUser",
                {
                    method: 'GET',
                    headers: {
                        'access-control-allow-origin': '*'
                    }
                })
                .then(response => response.json())
                .then(data => loadArray(data));
    }
}
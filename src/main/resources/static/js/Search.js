/* When the user clicks on the button, 
toggle between hiding and showing the dropdown content */
var users;

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

let success;

function createRoom() {
    const roomName = document.getElementById("nomeSala").value;

    const createRoomCommand = {
        roomName: roomName
    }

    console.log(createRoomCommand);

    fetch("/createRoom",
        {
            method: 'POST',
            body: JSON.stringify(createRoomCommand),
            headers: {
                'Content-Type': 'application/json',
                'access-control-allow-origin': '*'
            }
        })
        .then(response => response.text())
        .then(getUsersCheckbox)
        .then(data => success = data)
        .then(callback);
}

function callback() {

    if (success === "true")
        document.location.href = "chat.html";
    else
        window.alert("Insira o nome da sala.");
}

function addUserToRoom(username){
	const roomName = document.getElementById("nomeSala").value;
	
	const addUserToRoomCommand = {
	        username: username,
	        roomName: roomName
	    }


	fetch("/addUserToRoom",
	    {
	    	method: 'POST',
	        body: JSON.stringify(addUserToRoomCommand),
	        headers: {
	            'Content-Type': 'application/json',
	                'access-control-allow-origin': '*'
	        }
	    })
	    .then(response => response.text())
}

function getUsersCheckbox() {
	
	var checkbox = document.getElementsByName('checkboxName');
	
	for (var i = 0; i < checkbox.length; i++){
		if ( checkbox[i].checked ) {
			const username = checkbox[i].value;
			addUserToRoom(username);
		}
	}
}

// Shows a initial suggestion to new chats
function loadUsers(){

    users.forEach(function(item) {
        var buttonDiv = document.createElement("div");
        buttonDiv.classList.add("btnDiv");
        var checkbox = document.createElement("input");
        checkbox.setAttribute("type","checkbox");
        checkbox.setAttribute("name","checkboxName");
        checkbox.classList.add("checkbox")
        buttonDiv.appendChild(checkbox);
        var button = document.createElement("a");
        button.classList.add("btn");
        var text = document.createElement("span");
        var name = document.createTextNode(item);
        text.appendChild(name);
        button.appendChild(text);
        buttonDiv.appendChild(button);
        document.getElementById("contacts").appendChild(buttonDiv);
    });
}

function getUsers()
{
    fetch("/getUsers",
            {
                method: 'GET',
                headers: {
                    'access-control-allow-origin': '*'
                }
            })
            .then(response => response.json())
            .then(data => users = data)
}

$("document").ready(getUsers);
var chatInfo;
var messages;
var stompClient = null;


function loadMessages(){
	
    messages.forEach(function(item) {
    var mdiv = document.createElement("div");
    var div = document.createElement("div")
    if(item.userId == chatInfo.userId){
        mdiv.classList.add("me");
    }
    else{
        mdiv.classList.add("other");
    }
    var text = document.createTextNode(item.message);
    div.appendChild(text);
    div.classList.add("div");
    mdiv.appendChild(div);
    mdiv.cli
    document.getElementById("chats").appendChild(mdiv);
   });

}

function loadText(){
	
    var text = document.getElementById("text").value;
    console.log(text);
    document.getElementById('text').value="";
    document.getElementById('text').placeholder= "New message...";
    
    var message = {
			content: text,
			username: chatInfo.username,
			userId: chatInfo.userId,
			roomId: chatInfo.roomId
	};
	stompClient.send("/app/message", {}, JSON.stringify(message));

}


function connect() {
    var socket = new SockJS('/mywebsockets');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/' + chatInfo.roomId, function (message) {
            addMessage(JSON.parse(message.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function getChatInfo()
{
    fetch("/chatInfo",
            {
                method: 'GET',
                headers: {
                    'access-control-allow-origin': '*'
                }
            })
            .then(response => response.json())
            .then(data => chatInfo = data)
            .then(getMessages)
            .then(connect);
}


function getMessages()
{
	fetch("/messages",
            {
                method: 'GET',
                headers: {
                    'access-control-allow-origin': '*'
                }
            })
            .then(response => response.json())
            .then(data => messages = data)
            .then(loadMessages);
}

$("document").ready(getChatInfo);
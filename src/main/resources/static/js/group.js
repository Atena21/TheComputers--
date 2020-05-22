var text1 = {user : "me", message: "oi"};
var text2 = {user : "Sarah", message: "ola2"};
var text3 = {user : "Ale", message: "ola3"};
var array_original = [text1, text2, text3, text1];
var array_novo=[];

function loadArray(array){

    array.forEach(function(item) {
    var mdiv = document.createElement("div");
    var div = document.createElement("div");
    if(item.user == "me"){
        mdiv.classList.add("me");
    }
    else{
        mdiv.classList.add("other");
        var user = document.createTextNode(item.user);
        var br = document.createElement("br");
        div.appendChild(user);
        div.appendChild(br);
    }
    var message = document.createTextNode(item.message);
    div.appendChild(message);
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
    var textme = {user: "me", message: text};
    array_novo=[textme]

    //tem que pegar daqui pra ir pro bd(array_novo)

    if(text != ""){
        loadArray(array_novo);
    }
}
function loadArray(){
    var text1 = {user : "me", message: "oi"};
    var text2 = {user : "user2", message: "ola2"};
    var text3 = {user : "user3", message: "ola3"};
    var array = [text1, text2, text3, text1];

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
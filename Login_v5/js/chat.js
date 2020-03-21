function loadArray(){
    var text1 = {user : "me", message: "oiiiiiiii"};
    var text2 = {user : "other", message: "olaaaaaaaaaaaaaaa"};
    var array = [text1, text2, text1, text2];

    array.forEach(function(item) {
    var mdiv = document.createElement("div");
    var div = document.createElement("div")
    if(item.user == "me"){
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
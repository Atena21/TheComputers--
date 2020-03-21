function loadArray(){
    var text1 = {user : "me", message: "oi"};
    var text2 = {user : "other", message: "olaaaaaaaaaaaaaaa"};
    var array = [text1, text2, text1, text2];

    array.forEach(function(item) {
    var div = document.createElement("div");
    if(item.user == "me"){
        div.classList.add("me");
    }
    else{
        div.classList.add("other");
    }
    var text = document.createTextNode(item.message);
    console.log(text);
    div.appendChild(text);
    console.log(div);
    document.getElementById("chats").appendChild(div);
   });
}
var text1 = {user : "me", message: "oiiiiiiii"};
var text2 = {user : "other", message: "Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola Ola "};
var array_original = [text1, text2, text1, text2];

//array_original são as mensagens do histórico
var array_novo=[];


function loadArray(array){
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
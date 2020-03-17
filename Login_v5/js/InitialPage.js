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


function loadArray(){
    var person1 = {name: "Sarah", lastMessage: "Oi"}
    var person2 = {name: "Ale", lastMessage: "Hey!"}
    var array = [person1, person2, "slide 3", "slide 4", "slide 5"];

    array.forEach(function(item) {
    var buttonDiv = document.createElement("div");
    buttonDiv.classList.add("btnDiv");
    var button = document.createElement("a");
    // console.log(button);
    var text = document.createTextNode(item.name);
    var br = document.createElement("br");
    var lastMessage = document.createTextNode(item.lastMessage);
    button.href = "./index.html";
    button.appendChild(text);
    button.appendChild(br);
    button.appendChild(lastMessage);
    button.classList.add("btn");
    buttonDiv.appendChild(button);
    document.getElementById("chats").appendChild(buttonDiv);
    // console.log("Banana");
    });
}
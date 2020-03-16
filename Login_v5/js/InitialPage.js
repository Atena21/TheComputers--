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

// var convArray = ["a", "b", "c", "d", "e", "f"];

function loadArray(){
    var person1 = {name: "Sarah", lastMessage: "Oi"}
    var array = [person1, "slide 2", "slide 3", "slide 4", "slide 5"];

    array.forEach(function(item) {
    var button = document.createElement("button");
    console.log(button);
    var text = document.createTextNode(item.name);
    var br = document.createElement("br");
    var lastMessage = document.createTextNode(item.lastMessage);
    button.onclick = "location.href='./Login.html'";
    button.appendChild(text);
    button.appendChild(br);
    button.appendChild(lastMessage);
    document.getElementById("chats").appendChild(button);
    console.log("Banana");
    });
}
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

// Shows a initial suggestion to new chats
function loadArray(){
    var person1 = "Sarah";
    var person2 = "Ale";
    var person3 = "Milena";
    var array = [person1, person2, person3];

    array.forEach(function(item) {
        var buttonDiv = document.createElement("div");
        buttonDiv.classList.add("btnDiv");
        var button = document.createElement("a");
        var name = document.createTextNode(item);
        button.appendChild(name);
        button.classList.add("btn")
        buttonDiv.appendChild(button)
        document.getElementById("contacts").appendChild(buttonDiv);
    });
}
class Text {
    constructor(senderId, receiverId, message, timeStamp){
        this.id;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    set id(id){
        this.id = id;
    }
}

class User {
    constructor(name, password){
        // this.id = id;
        this.name = name;
        this.password = password;
    }
}

class Conversation {
    constructor(){
        this.user1;
        this.user2;
        this.history;
    }

    getMessages(messages) {
        var history = [];
        this.history = history;
    }
}
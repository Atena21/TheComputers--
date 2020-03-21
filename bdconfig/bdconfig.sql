CREATE TABLE usuario(
	user_id int,
	name varchar (15),
	password varchar (20),
	PRIMARY KEY (user_id)
	);

CREATE TABLE message (
	message_id int,
	sender int references usuario (user_id),
	receiver int references usuario (user_id),
	message_text varchar (100),
	message_time timestamp,
	PRIMARY KEY (message_id)
	);


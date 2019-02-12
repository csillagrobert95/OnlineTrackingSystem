CREATE TABLE user (
	user_id INTEGER(4) PRIMARY KEY AUTO_INCREMENT,
	active INTEGER(1) NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	username VARCHAR(30) NOT NULL,
	password VARCHAR(100) NOT NULL,
	email VARCHAR(30) NOT NULL
);

CREATE TABLE role (
	role_id INTEGER(4) PRIMARY KEY,
	role VARCHAR(20) NOT NULL
);

CREATE TABLE user_role (
	user_id INTEGER(4) NOT NULL,
	role_id INTEGER(4) NOT NULL
);

CREATE TABLE package (
	awb INTEGER(11) PRIMARY KEY,
	sender_id INTEGER(4) NOT NULL,
	receiver_id INTEGER(4) NOT NULL,
	package_name VARCHAR(100) NOT NULL,
	package_description VARCHAR(100) NOT NULL,
	sender_city VARCHAR(100) NOT NULL,
	destination_city VARCHAR(100) NOT NULL,
	tracked INTEGER(1)
);

CREATE TABLE routes (
	awb INTEGER(11) NOT NULL REFERENCES package(awb),
	route_nr INTEGER(2) NOT NULL,
	city VARCHAR(100) NOT NULL,
	receive_time TIMESTAMP NOT NULL,
	PRIMARY KEY (awb, route_nr)
);



ALTER TABLE user_role
ADD CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES user(user_id);

ALTER TABLE user_role
ADD CONSTRAINT role_id_fk FOREIGN KEY (role_id) REFERENCES role(role_id);

ALTER TABLE user_role
ADD CONSTRAINT user_role_pk PRIMARY KEY(user_id, role_id);

ALTER TABLE package
ADD CONSTRAINT sender_id_user_fk FOREIGN KEY (sender_id) REFERENCES user(user_id);

ALTER TABLE package
ADD CONSTRAINT receiver_id_user_fk FOREIGN KEY (receiver_id) REFERENCES user(user_id);


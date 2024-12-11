create table IF NOT EXISTS reservations(

id CHAR(36) PRIMARY KEY,
room_id CHAR(36) NOT NULL,
user_id CHAR(36) NOT NULL,
user_email VARCHAR(50) UNIQUE NOT NULL,
checkin DATETIME NOT NULL,
checkout DATETIME NOT NULL,

CONSTRAINT fk_room FOREIGN KEY(room_id) REFERENCES rooms(id),
CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id)
);


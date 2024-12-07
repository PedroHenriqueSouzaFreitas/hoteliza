create table IF NOT EXISTS reservations(

id UUID PRIMARY KEY,
hotel_id UUID NOT NULL,
room_id UUID NOT NULL,
user_id UUID NOT NULL,
user_email VARCHAR(50) UNIQUE NOT NULL,
checkin DATETIME,
checkout DATETIME,

FOREIGN(hotel_id) REFERENCES hotels(id),
FOREIGN(room_id) REFERENCES rooms(id),
FOREIGN(user_id) REFERENCES users(id)
);


CREATE TABLE IF NOT EXISTS hotels (
id CHAR(36) PRIMARY KEY,
name VARCHAR(100) NOT NULL,
address VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS rooms (
id CHAR(36) PRIMARY KEY,
hotel_id CHAR(36) NOT NULL,
number VARCHAR(10),
type VARCHAR(50),
status boolean,
CONSTRAINT fk_hotel FOREIGN KEY (hotel_id) REFERENCES hotels(id)
);

CREATE TABLE IF NOT EXISTS hotel_rooms (
    hotel_id CHAR(36) NOT NULL,
    room_id CHAR(36) NOT NULL,
    CONSTRAINT fk_room FOREIGN KEY (room_id) REFERENCES rooms(id),
    CONSTRAINT fk_hotel_rooms FOREIGN KEY (hotel_id) REFERENCES hotels(id),
    PRIMARY KEY (hotel_id, room_id)
);


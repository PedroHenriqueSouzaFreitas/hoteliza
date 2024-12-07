-- Insira dados na tabela `hotels` com IDs fixos
INSERT INTO hotels (id, name, address) VALUES 
('1', 'Hotel Paradise', '123 Main Street'),
('2', 'Ocean View Resort', '456 Beach Avenue'),
('3', 'Mountain Retreat', '789 Hilltop Road');

-- Insira dados na tabela `rooms` usando os IDs fixos da tabela `hotels`
INSERT INTO rooms (id, hotel_id, number, type, status) VALUES
('1', '1', '101', 'SOLTEIRO', TRUE),
('2', '1', '102', 'CASAL', FALSE),
('3', '2', '201', 'SOLTEIRO', TRUE),
('4', '3', '301', 'CASAL', TRUE),
('5', '2', '302', 'CASAL', FALSE);

-- Insira dados na tabela `hotel_rooms` com IDs fixos
INSERT INTO hotel_rooms (hotel_id, room_id) VALUES
('1', '1'), -- Hotel Paradise, Room 101
('1', '2'), -- Hotel Paradise, Room 301
('2', '3'), -- Ocean View Resort, Room 102
('3', '4'), -- Mountain Retreat, Room 201
('2', '5'); -- Ocean View Resort, Room 302

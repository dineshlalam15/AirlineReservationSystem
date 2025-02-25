CREATE TABLE flights (
    flight_id INT AUTO_INCREMENT PRIMARY KEY,
    airline_id INT NOT NULL,
    flight_name VARCHAR(255) UNIQUE NOT NULL,
    source VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    arrival_time TIME NOT NULL,
    departure_time TIME NOT NULL,
    total_seats INT NOT NULL,
    booked_seats INT NOT NULL,
    remaining_seats INT AS (total_seats - booked_seats) STORED,
    FOREIGN KEY (airline_id) REFERENCES airlines(id) ON DELETE CASCADE
);

INSERT INTO flights (airline_id, flight_name, source, destination, arrival_time, departure_time, total_seats, booked_seats) 
VALUES 
    (1, 'IND45321', 'Delhi', 'Mumbai', '12:30:00', '10:00:00', 180, 50),
    (1, 'IND78654', 'Bangalore', 'Chennai', '16:45:00', '14:30:00', 150, 30),
    (1, 'IND12987', 'Kolkata', 'Hyderabad', '22:00:00', '19:15:00', 160, 40),

    (2, 'AIR98765', 'Mumbai', 'Kolkata', '08:20:00', '05:50:00', 250, 120),
    (2, 'AIR45632', 'Chennai', 'Delhi', '18:10:00', '15:45:00', 220, 100),
    (2, 'AIR12345', 'Pune', 'Bangalore', '20:30:00', '18:00:00', 200, 90),
    (2, 'AIR67890', 'Jaipur', 'Lucknow', '07:15:00', '05:00:00', 140, 60),

    (3, 'SPI34567', 'Delhi', 'Goa', '14:30:00', '12:00:00', 180, 70),
    (3, 'SPI78901', 'Hyderabad', 'Jaipur', '19:45:00', '17:20:00', 160, 55),

    (4, 'GOF23456', 'Mumbai', 'Lucknow', '10:40:00', '08:15:00', 140, 60),
    (4, 'GOF67891', 'Pune', 'Delhi', '20:30:00', '17:55:00', 200, 90),
    (4, 'GOF54321', 'Kolkata', 'Chennai', '23:00:00', '20:45:00', 160, 50),

    (5, 'VIS56789', 'Bangalore', 'Hyderabad', '21:15:00', '19:00:00', 180, 75),
    (5, 'VIS43210', 'Delhi', 'Chandigarh', '09:30:00', '07:05:00', 150, 50),
    (5, 'VIS89012', 'Goa', 'Kolkata', '13:50:00', '11:30:00', 170, 65);

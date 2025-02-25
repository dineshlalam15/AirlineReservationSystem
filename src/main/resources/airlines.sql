CREATE TABLE airlines (
    airline_id INT AUTO_INCREMENT PRIMARY KEY,
    airline_name VARCHAR(255) UNIQUE NOT NULL,
    no_of_flights INT NOT NULL
);

INSERT INTO airlines (name, no_of_flights) VALUES
    ('IndiGo', 3),
    ('Air India', 4),
    ('SpiceJet', 2),
    ('Go First', 3),
    ('Vistara', 3);

DROP DATABASE IF EXISTS ARS;
CREATE DATABASE ARS;
USE ARS;

CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50),
    age INT,
    gender VARCHAR(10),
    email VARCHAR(100) NOT NULL UNIQUE,
    phoneNo VARCHAR(20) UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO customers (first_name, last_name, age, gender, email, phoneNo, password) VALUES
('John', 'Doe', 30, 'Male', 'john.doe@example.com', '9876543210', 'password123'),
('Jane', 'Smith', 28, 'Female', 'jane.smith@example.com', '9876543211', 'securepass'),
('Alice', 'Johnson', 35, 'Female', 'alice.johnson@example.com', '9876543212', 'alicepass'),
('Bob', 'Brown', 40, 'Male', 'bob.brown@example.com', '9876543213', 'bobsecure'),
('Charlie', 'Davis', 27, 'Male', 'charlie.davis@example.com', '9876543214', 'charliepass'),
('David', 'Miller', 33, 'Male', 'david.miller@example.com', '9876543215', 'davidpass'),
('Emma', 'Wilson', 25, 'Female', 'emma.wilson@example.com', '9876543216', 'emmapass'),
('Frank', 'Moore', 45, 'Male', 'frank.moore@example.com', '9876543217', 'frankpass'),
('Grace', 'Taylor', 29, 'Female', 'grace.taylor@example.com', '9876543218', 'gracepass'),
('Hannah', 'Anderson', 32, 'Female', 'hannah.anderson@example.com', '9876543219', 'hannahpass');

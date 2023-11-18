-- init.sql

-- Create a new database
CREATE DATABASE mydatabase;

-- Connect to the new database
\c mydatabase;

-- Create a new user with global permissions
CREATE USER myuser WITH ENCRYPTED PASSWORD 'password';
ALTER USER myuser WITH SUPERUSER;

-- Create a table
CREATE TABLE users
(
    user_id    SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    surname    VARCHAR(50) NOT NULL
);

CREATE TABLE logs
(
    log_id        SERIAL PRIMARY KEY,
    user_id       INT REFERENCES users (user_id),
    log_message   TEXT NOT NULL,
    log_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE staff
(
    staff_id       SERIAL PRIMARY KEY,
    staff_username VARCHAR(50) NOT NULL,
    staff_password VARCHAR(50) NOT NULL
);

-- Grant permissions on the table to the user
GRANT ALL PRIVILEGES ON TABLE users, logs TO myuser;

-- user table
INSERT INTO users (first_name, surname)
VALUES ('Lemn', 'Sissay'),
       ('Malik', 'Doe');

-- staff table
INSERT INTO staff (staff_username, staff_password)
VALUES ('staffmember1', 'password1'),
       ('staffmember2', 'password2'),
       ('staffmember3', 'password3');



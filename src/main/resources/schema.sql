CREATE TABLE IF NOT EXISTS books
(
    id SERIAL PRIMARY KEY,
    book_name VARCHAR(255) NOT NULL,
    author_name VARCHAR(255) NOT NULL,
    qty INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS readers_log_pas
(
    login VARCHAR(50) NOT NULL PRIMARY KEY,
    reader_id INTEGER NOT NULL,
    pass VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS readers
(
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    second_name VARCHAR(255),
    last_name VARCHAR(255) NOT NULL,
    read_card VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS reservation
(
    id SERIAL PRIMARY KEY,
    reader_card VARCHAR(255) NOT NULL,
    book_id INTEGER NOT NULL,
    reserv_date VARCHAR(10) NOT NULL,
    reserv_time VARCHAR(5) NOT NULL
);


-- https://miro.com/app/board/uXjVMbgHa3E=/

--Створення таблиці worker 

CREATE TABLE IF NOT EXISTS worker (
    id INT PRIMARY KEY,
    name VARCHAR NOT NULL,
        CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 1000),
    birthday DATE,
        CHECK (YEAR(birthday) > 1900),
    level ENUM ('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    salary INT,
        CHECK (100 <= salary AND salary <= 100000)
);

-- Створення таблиці client

CREATE TABLE IF NOT EXISTS client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL
);

--Створення таблиці project

CREATE TABLE IF NOT EXISTS project (
    id IDENTITY PRIMARY KEY,
    client_id BIGINT NOT NULL,
    FOREIGN KEY(client_id) REFERENCES client(id),
    start_date DATE,
    finish_date DATE
);

--Створення таблиці project_worker

CREATE TABLE IF NOT EXISTS project_worker (
    project_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY(worker_id) REFERENCES worker(id),
    FOREIGN KEY(project_id) REFERENCES project(id)
);
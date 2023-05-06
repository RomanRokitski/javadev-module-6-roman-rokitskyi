CREATE TABLE worker (
    id IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL,
        CHECK (LENGTH(name) >= 2 AND LENGTH(name) <= 1000),
    birthday DATE,
        CHECK (YEAR(birthday) > 1900),
    level ENUM ('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
    salary INT,
        CHECK (100 <= salary AND salary <= 100000)
);

CREATE TABLE client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR(1000) NOT NULL
);

CREATE TABLE project (
    id IDENTITY PRIMARY KEY,
    client_id BIGINT NOT NULL,
    FOREIGN KEY(client_id) REFERENCES client(id),
    start_date DATE,
    finish_date DATE
);

CREATE TABLE project_worker (
    project_id BIGINT NOT NULL,
    worker_id BIGINT NOT NULL,
    PRIMARY KEY (project_id, worker_id),
    FOREIGN KEY(worker_id) REFERENCES worker(id),
    FOREIGN KEY(project_id) REFERENCES project(id)
);
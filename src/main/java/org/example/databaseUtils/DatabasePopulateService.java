package org.example.databaseUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    static final String WORKER_SQL = "INSERT INTO worker (id, name, birthday, level, salary) VALUES (?, ?, ?, ?, ?)";
    static final String CLIENT_SQL = "INSERT INTO client (id, name) VALUES (?, ?)";
    static final String PROJECT_SQL = "INSERT INTO project (id, client_id, start_date, finish_date) VALUES (?, ?, ?, ?)";
    static final String PROJECT_WORKER_SQL = "INSERT INTO project_worker (project_id, worker_id) VALUES (?, ?)";
    Connection conn = Database.getInstance().getConnection();

    public void insertWorker() {
        try {
            PreparedStatement prepareStatementWorkers = conn.prepareStatement(WORKER_SQL);

            int[] worker_ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            String[] worker_names = {"Bohdan", "Alex", "Inna", "Pavel", "Roman",
                    "Alex", "Max", "Sergey", "Gregor", "Angela"};
            Date[] worker_birthdays = {
                    Date.valueOf("1990-08-09"),
                    Date.valueOf("1980-03-01"),
                    Date.valueOf("1990-03-07"),
                    Date.valueOf("1995-12-17"),
                    Date.valueOf("1989-01-22"),
                    Date.valueOf("1995-01-04"),
                    Date.valueOf("1998-11-30"),
                    Date.valueOf("2000-11-28"),
                    Date.valueOf("2000-02-01"),
                    Date.valueOf("1999-07-03"),
            };
            String[] worker_levels = {"Senior", "Senior", "Senior", "Middle",
                    "Middle", "Middle", "Junior", "Junior", "Trainee", "Trainee"};
            int[] worker_salaries = {5500, 5000, 4500, 3000, 3000, 3300, 1800, 1500, 1000, 800};

            for (int i = 0; i < worker_ids.length; i++) {
                prepareStatementWorkers.setInt(1, worker_ids[i]);
                prepareStatementWorkers.setString(2, worker_names[i]);
                prepareStatementWorkers.setDate(3, Date.valueOf(String.valueOf(worker_birthdays[i])));
                prepareStatementWorkers.setString(4, worker_levels[i]);
                prepareStatementWorkers.setInt(5, worker_salaries[i]);
                prepareStatementWorkers.addBatch();
            }

            prepareStatementWorkers.executeBatch();

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertClients() {
        try {
            PreparedStatement preparedStatementClients = conn.prepareStatement(CLIENT_SQL);

            int[] client_ids = {1, 2, 3, 4, 5};
            String[] client_names = {"Alcatel", "MediaLux", "Netflix", "Foxtrot", "Moyo"};

            for (int i = 0; i < client_ids.length; i++) {
                preparedStatementClients.setInt(1, client_ids[i]);
                preparedStatementClients.setString(2, client_names[i]);
                preparedStatementClients.addBatch();
            }
            preparedStatementClients.executeBatch();

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertProjects() {
        try {
            PreparedStatement prepareStatementProject = conn.prepareStatement(PROJECT_SQL);

            int[] p_ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] p_client_ids = {1, 2, 2, 3, 3, 3, 4, 4, 5, 5};
            Date[] p_start_dates = {
                    Date.valueOf("2023-03-17"),
                    Date.valueOf("2023-04-10"),
                    Date.valueOf("2023-04-10"),
                    Date.valueOf("2023-01-01"),
                    Date.valueOf("2023-02-01"),
                    Date.valueOf("2023-02-01"),
                    Date.valueOf("2023-06-11"),
                    Date.valueOf("2023-07-01"),
                    Date.valueOf("2023-05-01"),
                    Date.valueOf("2023-05-01")
            };
            Date[] p_finish_dates = {
                    Date.valueOf("2023-05-30"),
                    Date.valueOf("2024-09-07"),
                    Date.valueOf("2025-11-01"),
                    Date.valueOf("2026-01-01"),
                    Date.valueOf("2025-08-09"),
                    Date.valueOf("2025-12-01"),
                    Date.valueOf("2027-06-11"),
                    Date.valueOf("2028-07-01"),
                    Date.valueOf("2024-05-01"),
                    Date.valueOf("2024-01-01"),
            };

            for (int i = 0; i < p_ids.length; i++) {
                prepareStatementProject.setInt(1, p_ids[i]);
                prepareStatementProject.setInt(2, p_client_ids[i]);
                prepareStatementProject.setDate(3, Date.valueOf(String.valueOf(p_start_dates[i])));
                prepareStatementProject.setDate(4, Date.valueOf(String.valueOf(p_finish_dates[i])));
                prepareStatementProject.addBatch();
            }

            prepareStatementProject.executeBatch();

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insertProjectWorker() {
        try {
            PreparedStatement preparedStatementProjectWorker = conn.prepareStatement(PROJECT_WORKER_SQL);

            int[] projects_id = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 7, 8, 8, 9, 9, 9, 10, 10};
            int[] workers_ids = {1, 4, 7, 2, 5, 3, 6, 9, 1, 8, 3, 8, 9, 2, 6, 9, 1, 5, 4, 3, 6, 10, 4, 10};

            for (int i = 0; i < projects_id.length; i++) {
                preparedStatementProjectWorker.setInt(1, projects_id[i]);
                preparedStatementProjectWorker.setInt(2, workers_ids[i]);
                preparedStatementProjectWorker.addBatch();
            }

            preparedStatementProjectWorker.executeBatch();

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
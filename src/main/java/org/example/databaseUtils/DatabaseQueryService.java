package org.example.databaseUtils;

import org.example.requestClasses.*;
import org.example.util.SQLReader;

import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<FindMaxSalaryWorker> findMaxSalaryWorkers() {
        List<FindMaxSalaryWorker> workers = new ArrayList<>();

        String sql = SQLReader.fileReader("src/main/java/org/example/sql/find_max_salary_worker.sql");

        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                workers.add(FindMaxSalaryWorker.builder()
                        .name(rs.getString("NAME"))
                        .salary(rs.getInt("SALARY"))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workers;
    }

    public List<FindLongestProject> findLongestProjects() {
        List<FindLongestProject> longest_project = new ArrayList<>();

        String sql = SQLReader.fileReader("src/main/java/org/example/sql/find_longest_project.sql");

        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                longest_project.add(FindLongestProject.builder()
                        .name(rs.getString("NAME"))
                        .month_count(rs.getInt("MONTH_COUNT"))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return longest_project;
    }

    public List<FindMaxProjectsClient> findMaxProjectsClients() {
        List<FindMaxProjectsClient> client_project = new ArrayList<>();

        String sql = SQLReader.fileReader("src/main/java/org/example/sql/find_max_projects_client.sql");
        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                client_project.add(FindMaxProjectsClient.builder()
                        .name(rs.getString("NAME"))
                        .count(rs.getInt("PROJECT_COUNT"))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client_project;
    }

    public List<FindYoungestEldestWorker> findYoungestEldestWorkers() {
        List<FindYoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();

        String sql = SQLReader.fileReader("src/main/java/org/example/sql/find_youngest_eldest_workers.sql");
        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                youngestEldestWorkers.add(FindYoungestEldestWorker.builder()
                        .type(rs.getString("TYPE"))
                        .name(rs.getString("NAME"))
                        .birthday(LocalDate.parse(rs.getString("BIRTHDAY")))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return youngestEldestWorkers;
    }

    public List<PrintProjectPrices> printProjectPrices() {
        List<PrintProjectPrices> project_price = new ArrayList<>();

        String sql = SQLReader.fileReader("src/main/java/org/example/sql/print_project_prices.sql");
        try (Statement statement = Database.getInstance().getConnection().createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                project_price.add(PrintProjectPrices.builder()
                        .id(rs.getString("NAME"))
                        .price(rs.getInt("PRICE"))
                        .build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return project_price;
    }
}

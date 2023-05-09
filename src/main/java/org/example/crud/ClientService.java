package org.example.crud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    public long create(String name) {
        long result = 0L;

        try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
            if (!(name.length() >= 2 && name.length() <= 1000) || name.trim().isEmpty()) {
                throw new RuntimeException("Wrong name!");
            }
            PreparedStatement ps = conn.prepareStatement("INSERT INTO client (name) VALUES (?)");
            ps.setString(1, name);
            ps.executeUpdate();

            ps = conn.prepareStatement("SELECT id, name FROM client WHERE name = ?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getLong("ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getById(long id) {
        String result = "";

        try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
            if (id == 0) {
                throw new RuntimeException("Wrong id!");
            }
            PreparedStatement ps = conn.prepareStatement("SELECT id, name FROM client WHERE id = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString("NAME");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setName(long id, String name) {
        if (!(name.length() >= 2 && name.length() <= 1000) || name.trim().isEmpty()) {
            throw new RuntimeException("Wrong name!");
        } else if (id == 0) {
            throw new RuntimeException("Wrong id");
        }

        try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("UPDATE client SET name = ? WHERE id = ?");
            pstmt.setString(1, name);
            pstmt.setLong(2, id);
            pstmt.addBatch();
            pstmt.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteByID(long id) {
        try (Connection conn = DatabaseConnection.getInstance().getConnection()) {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM PROJECT_WORKER WHERE PROJECT_ID IN (SELECT ID FROM PROJECT WHERE CLIENT_ID = ?)");
            pstmt.setLong(1, id);
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement("DELETE FROM PROJECT WHERE CLIENT_ID = ?");
            pstmt.setLong(1, id);
            pstmt.executeUpdate();

            pstmt = conn.prepareStatement("DELETE FROM client WHERE id = ?");
            pstmt.setLong(1, id);
            pstmt.executeUpdate();

            System.out.println("Client and related projects and workers deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error executing SQL: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Client> listAll() {
        List<Client> clients = new ArrayList<>();
        try (Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT id, name FROM client");
            while (rs.next()) {
                long id = rs.getInt("ID");
                String name = rs.getString("NAME");
                Client client = new Client(id, name);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}
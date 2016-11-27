package com.jetbrainslab.khayrullin.database;

import com.jetbrainslab.khayrullin.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.jetbrainslab.khayrullin.database.DBConnection.conn;

public class UserDAO {

    public boolean addUser(User user) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(name, surname, email, password, role, status) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSurname());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getRoleString());
        stmt.setString(6, user.getStatusString());
        stmt.execute();
        return true;
    }

    public void usersWithMostMessagesOnSeason(String season) throws SQLException {
        int from1 = 0;
        int to1 = 0;
        int december = 13;
        switch (season) {
            case "SUMMER":
                from1 = 6;
                to1 = 8;
                break;
            case "AUTUMN":
                from1 = 9;
                to1 = 11;
                break;
            case "SPRING":
                from1 = 3;
                to1 = 5;
                break;
            case "WINTER":
                from1 = 1;
                to1 = 2;
                december = 12;
                break;
            default:
                throw new SQLException("Invalid month added!");
        }
        PreparedStatement stml = conn.prepareStatement(
                "WITH user_msg AS (\n" +
                        "    SELECT\n" +
                        "      u.id,\n" +
                        "      u.name,\n" +
                        "      date_part('month' ,m_r.created_at) createdat_month,\n" +
                        "      count(m_r.id) msg_rec\n" +
                        "    FROM users u\n" +
                        "      LEFT JOIN message m_r ON u.id = m_r.recipient_id\n" +
                        "    GROUP BY u.id, createdat_month\n" +
                        ")\n" +
                        "SELECT\n" +
                        "    user_msg.id,\n" +
                        "  user_msg.name\n" +
                        "FROM user_msg\n" +
                        "WHERE user_msg.msg_rec = (SELECT max(user_msg.msg_rec) FROM user_msg) AND (createdat_month >=" + from1 + " AND createdat_month <= " + to1 + ") OR (createdat_month=" + december + ")\n" +
                        "ORDER BY id");
        ResultSet rs = stml.executeQuery();
        if (rs != null) {
            System.out.println("id   Name");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }
        }

    }

    public void usersWithMostAnswersWithAddressPart(String addressPart) throws SQLException {
        PreparedStatement stml = conn.prepareStatement("WITH user_req_count AS (SELECT u.id,\n" +
                "                          u.name,\n" +
                "                          count(r.id) req_count\n" +
                "                        FROM users u JOIN request r\n" +
                "                            ON u.id = r.volunteer_id AND r.address LIKE '%" + addressPart + "%'\n" +
                "                        GROUP BY u.id\n" +
                ")\n" +
                "SELECT user_req_count.id, user_req_count.name\n" +
                "FROM user_req_count WHERE req_count = (SELECT max(req_count) FROM user_req_count)\n" +
                "ORDER BY user_req_count.id");
        ResultSet rs = stml.executeQuery();
        if (rs != null) {
            System.out.println("id   Name");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }
        }
    }
}

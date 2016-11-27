package com.jetbrainslab.khayrullin.database;

import com.jetbrainslab.khayrullin.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.jetbrainslab.khayrullin.database.Connection.conn;

public class UserDAO {
    private final String ADD = "INSERT INTO users(name, surname, email, password, role, status) VALUES (?, ?, ?, ?, ?, ?)";
    private final String USERS_WITH_MOST_MESSAGES_ON_SEASON_PART1 = "WITH user_msg AS (\n" +
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
            "WHERE user_msg.msg_rec = (SELECT max(user_msg.msg_rec) FROM user_msg) AND (createdat_month >=";
    private final String USERS_WITH_MOST_MESSAGES_ON_SEASON_PART2 =" AND createdat_month <= ";
    private final String USERS_WITH_MOST_MESSAGES_ON_SEASON_PART3 =") OR (createdat_month=";
    private final String USERS_WITH_MOST_MESSAGES_ON_SEASON_PART4 = ")ORDER BY id";
    private final String USERS_WITH_MOST_ANSWERS_BY_ADDRESS_PART_PART1 ="WITH user_req_count AS (SELECT u.id,\n" +
                            "                          u.name,\n" +
                            "                          count(r.id) req_count\n" +
                            "                        FROM users u JOIN request r\n" +
                            "                            ON u.id = r.volunteer_id AND r.address LIKE '%";
    private final String USERS_WITH_MOST_ANSWERS_BY_ADDRESS_PART_PART2 = "%'\n" +
                            "                        GROUP BY u.id\n" +
                            ")\n" +
                            "SELECT user_req_count.id, user_req_count.name\n" +
                            "FROM user_req_count WHERE req_count = (SELECT max(req_count) FROM user_req_count)\n" +
                            "ORDER BY user_req_count.id";

    public boolean addUser(User user) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(ADD);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSurname());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getPassword());
        stmt.setString(5, user.getRoleString());
        stmt.setString(6, user.getStatusString());
        stmt.execute();
        return true;
    }

    public void getUsersWithMostMessagesOnSeason(String season) throws SQLException {
        int from = 0;
        int to = 0;
        int december = 13;
        switch (season) {
            case "SUMMER":
                from = 6;
                to = 8;
                break;
            case "AUTUMN":
                from = 9;
                to = 11;
                break;
            case "SPRING":
                from = 3;
                to = 5;
                break;
            case "WINTER":
                from = 1;
                to = 2;
                december = 12;
                break;
            default:
                throw new SQLException("Invalid month added!");
        }
        PreparedStatement stml = conn.prepareStatement(USERS_WITH_MOST_MESSAGES_ON_SEASON_PART1 + from + USERS_WITH_MOST_MESSAGES_ON_SEASON_PART2 + to + USERS_WITH_MOST_MESSAGES_ON_SEASON_PART3 + december + USERS_WITH_MOST_MESSAGES_ON_SEASON_PART4);
        ResultSet rs = stml.executeQuery();
        if (rs != null) {
            System.out.println("id   Name");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }
        }

    }

    public void getUsersWithMostAnswersByAddressPart(String addressPart) throws SQLException {
        PreparedStatement stml = conn.prepareStatement(USERS_WITH_MOST_ANSWERS_BY_ADDRESS_PART_PART1 + addressPart + USERS_WITH_MOST_ANSWERS_BY_ADDRESS_PART_PART2);
        ResultSet rs = stml.executeQuery();
        if (rs != null) {
            System.out.println("id   Name");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }
        }
    }
}

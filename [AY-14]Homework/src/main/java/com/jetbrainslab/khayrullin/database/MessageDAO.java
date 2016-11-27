package com.jetbrainslab.khayrullin.database;

import com.jetbrainslab.khayrullin.entity.Message;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.jetbrainslab.khayrullin.database.DBConnection.conn;

public class MessageDAO {

    public boolean addMessage(Message message) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO message(text, sender_id, recipient_id, created_at, status) VALUES (?, ?, ?, ?, ?)");
        stmt.setString(1, message.getText());
        stmt.setInt(2, message.getSenderId());
        stmt.setInt(3, message.getRecipientId());
        stmt.setTimestamp(4, message.getCreatedAt());
        stmt.setString(5, message.getStatusString());
        stmt.execute();
        return true;
    }
}

package com.jetbrainslab.khayrullin.database;

import com.jetbrainslab.khayrullin.entity.Request;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.jetbrainslab.khayrullin.database.Connection.conn;

public class RequestDAO {
    private final String ADD = "INSERT INTO request(needy_id, volunteer_id, address, latitude, longitude, created_at, service_type, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public boolean addRequest(Request request) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(ADD);
        stmt.setInt(1, request.getNeedyId());
        stmt.setInt(2, request.getVolonteerId());
        stmt.setString(3, request.getAddress());
        stmt.setInt(4, Math.toIntExact(request.getLatitude()));
        stmt.setInt(5, Math.toIntExact(request.getLongitude()));
        stmt.setTimestamp(6, request.getCreatedAt());
        stmt.setString(7, request.getServiceTypeString());
        stmt.setString(8, request.getRequestStatusString());
        stmt.execute();
        return true;
    }
}

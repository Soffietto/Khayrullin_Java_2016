package com.jetbrainslab.khayrullin.database;

import com.jetbrainslab.khayrullin.entity.Community;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.jetbrainslab.khayrullin.database.DBConnection.conn;

public class CommunityDAO {

    public boolean editCommunity(Community community, int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE community SET name=?, description=?, founder_id=?, created_at=? WHERE id=" + id);
        stmt.setString(1, community.getName());
        stmt.setString(2, community.getDescription());
        stmt.setInt(3, community.getFounderID());
        stmt.setTimestamp(4, community.getCreatedAt());
        stmt.execute();
        return true;
    }
}

package com.jetbrainslab.khayrullin.dao;

import com.jetbrainslab.khayrullin.entity.News;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.jetbrainslab.khayrullin.dao.Connection.conn;

public class NewsDAO {
    private final String EDIT = "UPDATE news SET text=?, community_id=?, author_id=?, created_at=? WHERE id=";
    private final String MESSAGE_COUNT = "SELECT count(news.id) FROM news WHERE author_id = ";

    public boolean editNews(News news, int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(EDIT + id);
        stmt.setString(1, news.getText());
        stmt.setInt(2, news.getCommunityId());
        stmt.setInt(3, news.getAuthorId());
        stmt.setTimestamp(4, news.getCreatedAt());
        stmt.execute();
        return true;
    }

    public int getMessageCountByUser(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(MESSAGE_COUNT + id);
        ResultSet rs = stmt.executeQuery();
        int n = 0;
        if (rs != null) {
            while (rs.next())
                n = rs.getInt("count");
        }
        return n;
    }
}

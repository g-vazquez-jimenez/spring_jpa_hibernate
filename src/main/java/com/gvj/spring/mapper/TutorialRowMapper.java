package com.gvj.spring.mapper;

import com.gvj.spring.model.Tutorial;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TutorialRowMapper implements RowMapper<Tutorial> {
    @Override
    public Tutorial mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tutorial tutorial = new Tutorial();
        tutorial.setTitle(rs.getString("title"));
        tutorial.setPublished(rs.getBoolean("published"));
        tutorial.setId(rs.getLong("id"));
        tutorial.setDescription(rs.getString("description"));
        return tutorial;
    }
}

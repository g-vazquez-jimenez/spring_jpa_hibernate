package com.gvj.spring.repository;

import com.gvj.spring.mapper.TutorialRowMapper;
import com.gvj.spring.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TutorialJdbcRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Tutorial findById(long id) {
        return jdbcTemplate.queryForObject("select * from TUTORIALS where id=?", new BeanPropertyRowMapper<>(Tutorial.class), id);
    }

    public List<Tutorial> findAll() {
        return jdbcTemplate.query("select * from TUTORIALS", new TutorialRowMapper());
    }

    public void deleteById(long id) {
        jdbcTemplate.update("delete from TUTORIALS where id=?", id);
    }

    public int save(Tutorial tutorial) {
        return jdbcTemplate.update("insert into TUTORIALS (title, published, description, id) " + "values(?, ?, ?, (select next value for tutorials_seq))",
                tutorial.getTitle(), tutorial.isPublished(), tutorial.getDescription());
    }

    public int update(Tutorial tutorial) {
        return jdbcTemplate.update("update TUTORIALS " + " set title = ?, published = ?, description = ?" + " where id = ?",
                tutorial.getTitle(), tutorial.isPublished(), tutorial.getDescription(), tutorial.getId());
    }
}

package com.jblab.khayrullin.services.DAO;

import com.jblab.khayrullin.model.enums.Subject;
import com.jblab.khayrullin.services.ScoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Qualifier("jdbc")
public class JdbcTemplateDAO implements ScoresService {

    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcTemplateDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long getTotalScore(long id) {
        return jdbcTemplate.queryForObject("select sum(score) from scores WHERE id_student=?", Long.class, id);
    }

    @Override
    public double getAverageScore(long id) {
        return jdbcTemplate.queryForObject("select avg(score) from scores WHERE id_student=?", Double.class, id);
    }

    @Override
    public int getScoreOnTheSubject(long id, Subject subject) {
        return jdbcTemplate.queryForObject("select score from scores WHERE id_student=? and subject=?",
                Integer.class, id, subject.toString());
    }
}

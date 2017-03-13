package com.jblab.khayrullin.repository;

import com.jblab.khayrullin.model.Score;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends CrudRepository<Score, Long> {
}

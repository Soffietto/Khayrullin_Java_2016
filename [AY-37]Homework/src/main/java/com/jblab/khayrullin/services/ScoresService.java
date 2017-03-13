package com.jblab.khayrullin.services;

import com.jblab.khayrullin.model.enums.Subject;

public interface ScoresService {
    long getTotalScore(long id);

    double getAverageScore(long id);

    int getScoreOnTheSubject(long id, Subject subject);
}

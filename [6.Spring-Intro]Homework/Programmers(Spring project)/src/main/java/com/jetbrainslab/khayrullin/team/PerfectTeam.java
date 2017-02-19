package com.jetbrainslab.khayrullin.team;

import com.jetbrainslab.khayrullin.Backender;
import com.jetbrainslab.khayrullin.Frontender;
import com.jetbrainslab.khayrullin.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PerfectTeam implements Team {

    private Backender backender;
    private Frontender frontender;

    @Autowired
    public PerfectTeam(@Qualifier("javaSenior") Backender backender, @Qualifier("htmlGuru") Frontender frontender) {
        this.backender = backender;
        this.frontender = frontender;
    }

    public Backender getBackender() {
        return backender;
    }

    public void setBackender(Backender backender) {
        this.backender = backender;
    }

    public Frontender getFrontender() {
        return frontender;
    }

    public void setFrontender(Frontender frontender) {
        this.frontender = frontender;
    }

    @PostConstruct
    public void printStatus() {
        System.out.println("Status is: Perfect");
    }

    @Override
    public void work() {
        System.out.print("Backend: ");
        backender.makeServer();
        System.out.print("Frontend: ");
        frontender.draw();
    }
}

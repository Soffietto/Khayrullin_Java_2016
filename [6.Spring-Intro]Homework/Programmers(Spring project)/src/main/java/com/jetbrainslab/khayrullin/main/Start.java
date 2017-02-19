package com.jetbrainslab.khayrullin.main;

import com.jetbrainslab.khayrullin.JavaConfig;
import com.jetbrainslab.khayrullin.Team;
import com.jetbrainslab.khayrullin.team.PerfectTeam;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        // ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        Object team = context.getBean("perfectTeam");
        if (team instanceof PerfectTeam) {
            Team perfectTeam = (PerfectTeam) team;
            perfectTeam.work();
        }
    }
}

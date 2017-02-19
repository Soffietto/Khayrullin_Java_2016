package com.jetbrainslab.khayrullin.backend;

import com.jetbrainslab.khayrullin.Backender;
import org.springframework.stereotype.Component;

@Component
public class JavaSenior implements Backender {
    @Override
    public void makeServer() {
        System.out.println("Perfectly done");
    }
}

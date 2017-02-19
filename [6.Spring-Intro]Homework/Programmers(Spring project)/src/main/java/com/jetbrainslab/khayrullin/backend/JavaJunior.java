package com.jetbrainslab.khayrullin.backend;

import com.jetbrainslab.khayrullin.Backender;
import org.springframework.stereotype.Component;

@Component
public class JavaJunior implements Backender {
    @Override
    public void makeServer() {
        System.out.println("Not so good.");
    }
}

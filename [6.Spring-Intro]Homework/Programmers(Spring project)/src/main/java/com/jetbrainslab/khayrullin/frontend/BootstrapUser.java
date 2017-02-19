package com.jetbrainslab.khayrullin.frontend;

import com.jetbrainslab.khayrullin.Frontender;
import org.springframework.stereotype.Component;

@Component
public class BootstrapUser implements Frontender {
    @Override
    public void draw() {
        System.out.println("Low-level pages");
    }
}

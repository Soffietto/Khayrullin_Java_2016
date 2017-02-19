package com.jetbrainslab.khayrullin.frontend;

import com.jetbrainslab.khayrullin.Frontender;
import org.springframework.stereotype.Component;

@Component
public class HtmlGuru implements Frontender {
    @Override
    public void draw() {
        System.out.println("High-level pages");
    }
}

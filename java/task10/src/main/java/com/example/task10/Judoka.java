package com.example.task10;

import org.springframework.stereotype.Component;

@Component("judoka")
public class Judoka implements Fighter {
    @Override
    public void doFight() {
        System.out.println("Judoka is fighting");
    }
}

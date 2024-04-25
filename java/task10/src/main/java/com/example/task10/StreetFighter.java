package com.example.task10;

import org.springframework.stereotype.Component;

@Component("streetFighter")
public class StreetFighter implements Fighter {
    @Override
    public void doFight() {
        System.out.println("StreetFighter is fighting");
    }
}

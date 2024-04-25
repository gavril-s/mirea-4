package com.example.task10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {
    private final ApplicationContext context;

    public Main(ApplicationContext context) {
        this.context = context;
    }

    public void execute(String beanName) {
        Fighter fighter = (Fighter) context.getBean(beanName);
        fighter.doFight();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        Main main = context.getBean(Main.class);
        main.execute(scanner.nextLine());
    }
}
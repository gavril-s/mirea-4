package task2.opt6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<Human>();
        humans.add(new Human(54, "Boris", "Medvedev", LocalDate.of(1970, 5, 3), 79));
        humans.add(new Human(13, "Oleg", "Sokolov", LocalDate.of(2014, 3, 3), 60));
        humans.add(new Human(25, "Ruslan", "Gitelman", LocalDate.of(1993, 12, 20), 111));
        humans.add(new Human(42, "Ilya", "Maddison", LocalDate.of(1986, 9, 29), 85));
        humans.add(new Human(96, "Elizabeth", "II", LocalDate.of(1926, 9, 8), 72));

        HumanManager manager = new HumanManager(humans);
        manager.processHumans();

        List<Human> resultHumans = manager.getHumans();
        String resultLastNames = manager.getLastNames();

        System.out.println("Humans:");
        for (Human human : resultHumans) {
            System.out.println(human.toString());
        }
        System.out.format("\nLast names: %s\n", resultLastNames);
    }
}

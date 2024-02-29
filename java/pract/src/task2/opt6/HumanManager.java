package task2.opt6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HumanManager {
    private List<Human> humans;
    private String lastNames;

    public HumanManager(List<Human> humans) {
        this.humans = new ArrayList<Human>(humans);
    }

    public void processHumans() {
        humans.stream().forEach(human -> human.weight -= 5);
        humans = humans.stream()
                .filter(human -> human.birthDate.isBefore(LocalDate.of(1993, 2, 3)))
                .collect(Collectors.toList());
        lastNames  = humans.stream().map(human -> human.lastName).reduce((lhs, rhs) -> lhs + rhs).orElse("");
    }

    public List<Human> getHumans() {
        return humans;
    }

    public String getLastNames() {
        return lastNames;
    }
}

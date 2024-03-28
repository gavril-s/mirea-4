package task7.opt6;
import java.util.HashMap;
import java.util.Map;

// Интерфейс, который представляет операции, которые можно выполнять с внешним состоянием
interface Flyweight {
    void doOperation(String outerState);
}

class ConcreteFlyweight implements Flyweight {
    private final String innerState;

    public ConcreteFlyweight(String innerState) {
        this.innerState = innerState;
    }

    @Override
    public void doOperation(String outerState) {
        System.out.println("Inner State = " + innerState + ", Outer State = " + outerState);
    }
}

// Фабрика для создания и управления флайвейт объектами
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    public Flyweight getFlyweight(String key) {
        if (!flyweights.containsKey(key)) {
            flyweights.put(key, new ConcreteFlyweight(key));
        }
        return flyweights.get(key);
    }
}

// Клиентский код, который использует Flyweight фабрику для создания и работы с флайвейт объектами
class FlyweightClient {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("A");
        Flyweight flyweight2 = factory.getFlyweight("B");
        Flyweight flyweight3 = factory.getFlyweight("A"); // Повторно использует существующий экземпляр с ключом "A" вместо создания нового

        flyweight1.doOperation("First call");
        flyweight2.doOperation("Second call");
        flyweight3.doOperation("Third call"); // Покажет такое же внутреннее состояние, как и flyweight1, потому что они идентичны
    }
}

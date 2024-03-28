package task6;

// Интерфейс продукта
interface FactoryProduct {
    void print();
}

// Конкретный продукт
class ConcreteProduct implements FactoryProduct {
    @Override
    public void print() {
        System.out.println("Concrete Product");
    }
}

// Интерфейс фабрики
interface Creator {
    FactoryProduct factoryMethod();
}

// Конкретная фабрика
class ConcreteCreator implements Creator {
    @Override
    public FactoryProduct factoryMethod() {
        return new ConcreteProduct();
    }
}

public class FactoryMethodExample {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        FactoryProduct product = creator.factoryMethod();
        product.print();
    }
}


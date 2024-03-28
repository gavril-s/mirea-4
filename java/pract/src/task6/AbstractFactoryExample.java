package task6;

// Интерфейс для продукта А
interface ProductA {
    void print();
}

// Интерфейс для продукта B
interface ProductB {
    void print();
}

// Интерфейс для абстрактной фабрики
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// Конкретная реализация продукта A
class ConcreteProductA implements ProductA {
    @Override
    public void print() {
        System.out.println("Concrete Product A");
    }
}

// Конкретная реализация продукта B
class ConcreteProductB implements ProductB {
    @Override
    public void print() {
        System.out.println("Concrete Product B");
    }
}

// Конкретная реализация абстрактной фабрики
class ConcreteFactory implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ConcreteProductA();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB();
    }
}

public class AbstractFactoryExample {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();

        productA.print();
        productB.print();
    }
}
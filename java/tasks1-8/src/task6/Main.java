package task6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Фабричный:");
        Creator creator = new ConcreteCreator();
        FactoryProduct factoryProduct = creator.factoryMethod();
        factoryProduct.print();

        System.out.println("\nПрототип:");
        try {
            Prototype original = new Prototype("Original data");
            Prototype clone = original.clone();
            clone.setData("Cloned data");

            System.out.println("Original data: " + original.getData());
            System.out.println("Cloned data: " + clone.getData());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("\nАбстрактная фабрика:");
        AbstractFactory factory = new ConcreteFactory();
        ProductA productA = factory.createProductA();
        ProductB productB = factory.createProductB();
        productA.print();
        productB.print();

        System.out.println("\nСтроитель:");
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        BuilderProduct builderProduct = director.construct(builder);
        System.out.println("Product built: " + builderProduct);
    }
}

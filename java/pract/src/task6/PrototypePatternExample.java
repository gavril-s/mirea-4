package task6;

// Прототип
class Prototype implements Cloneable {
    private String data;

    public Prototype(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}

// Пример использования
public class PrototypePatternExample {
    public static void main(String[] args) {
        try {
            Prototype original = new Prototype("Original data");
            Prototype clone = original.clone();
            clone.setData("Cloned data");
            System.out.println("Original data: " + original.getData());
            System.out.println("Cloned data: " + clone.getData());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}




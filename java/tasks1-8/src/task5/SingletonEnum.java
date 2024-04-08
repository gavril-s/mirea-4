package task5;

public enum SingletonEnum {
    INSTANCE;

    public static SingletonEnum getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        SingletonEnum singleton1 = SingletonEnum.getInstance();
        SingletonEnum singleton2 = SingletonEnum.getInstance();

        System.out.println(singleton1 == singleton2);
    }
}

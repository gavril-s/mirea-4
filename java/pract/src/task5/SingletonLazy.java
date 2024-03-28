package task5;

public class SingletonLazy {
    private static volatile SingletonLazy instance;

    private SingletonLazy() {}

    public static SingletonLazy getInstance() {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonLazy singleton1 = SingletonLazy.getInstance();
        SingletonLazy singleton2 = SingletonLazy.getInstance();

        System.out.println(singleton1 == singleton2);
    }
}
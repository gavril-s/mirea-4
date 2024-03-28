package task5;

public class SingletonWithHolder {
    private SingletonWithHolder() {}

    private static class SingletonHolder {
        private static final SingletonWithHolder INSTANCE = new SingletonWithHolder();
    }

    public static SingletonWithHolder getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        SingletonWithHolder singleton1 = SingletonWithHolder.getInstance();
        SingletonWithHolder singleton2 = SingletonWithHolder.getInstance();

        System.out.println(singleton1 == singleton2);
    }
}
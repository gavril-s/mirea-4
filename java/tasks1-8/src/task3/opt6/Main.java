package task3.opt6;

public class Main {
    public static void main(String[] args) throws Exception {
        LockSet<Integer> set = new LockSet<Integer>();
        SemaphoreMap<String, Integer> map = new SemaphoreMap<String, Integer>();

        Thread setOne = new Thread(()->{
            set.add(1);
            set.add(2);
            set.add(3);
        });
        Thread setTwo = new Thread(()-> {
            set.add(4);
            set.add(5);
            set.add(6);
        });

        Thread mapOne = new Thread(()->{
            map.put("a", 1);
            map.put("b", 2);
            map.put("c", 3);
        });
        Thread mapTwo = new Thread(()-> {
            map.put("a", 10);
            map.put("e", 4);
            map.put("f", 5);
        });

        setOne.start();
        setTwo.start();
        mapOne.start();
        mapTwo.start();
        Thread.sleep(1000);

        System.out.println(set);
        System.out.println(map);
    }
}

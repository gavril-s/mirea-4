package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final int THREADS = 3;
    private static final int TASKS = 10;
    private static final Lock tasksRunningLock = new ReentrantLock();
    private static int tasksRunning = 0;

    public static void main(String[] args) {
        ExecutorService service = new ExecutorService(THREADS);
        List<Runnable> tasks = makeTasks(TASKS);
        for (Runnable task : tasks) {
            service.submit(task);
        }
    }

    private static List<Runnable> makeTasks(int count) {
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            final int taskId = i + 1;
            tasks.add(() -> {
                System.out.format("Task %d started\n", taskId);
                changeTasksRunningBy(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.format("Task %d finished\n", taskId);
                changeTasksRunningBy(-1);
            });
        }
        return tasks;
    }

    private static void changeTasksRunningBy(int shift) {
        tasksRunningLock.lock();
        tasksRunning += shift;
        System.out.format("Number of tasks running: %d\n", tasksRunning);
        tasksRunningLock.unlock();
    }
}

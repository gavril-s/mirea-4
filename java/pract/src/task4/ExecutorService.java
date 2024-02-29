package task4;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

public class ExecutorService {
    private static Semaphore semaphore;

    public ExecutorService(int threads) {
        semaphore = new Semaphore(threads);
    }

    public Future submit(Callable task) {
        FutureTask future = new FutureTask(() -> {
            Object result = null;
            try {
                semaphore.acquire();
                result = task.call();
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        });

        Thread thread = new Thread(future);
        thread.start();

        return future;
    }

    public Future submit(Runnable task) {
        return submit(new Callable() {
            @Override
            public Object call() throws Exception {
                task.run();
                return null;
            }
        });
    }
}

package task3.opt6;

import java.util.HashMap;
import java.util.concurrent.Semaphore;
import java.util.Map;

public class SemaphoreMap<K, V> {
    private static final Semaphore semaphore = new Semaphore(1);
    private Map<K, V> map;

    public SemaphoreMap() {
        map = new HashMap<K, V>();
    }

    public Boolean containsKey(K k) {
        Boolean res = null;
        try {
            semaphore.acquire();
            res = map.containsKey(k);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }
    public Boolean containsValue(V v) {
        Boolean res = null;
        try {
            semaphore.acquire();
            res = map.containsValue(v);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }
    public V get(K k) {
        V res = null;
        try {
            semaphore.acquire();
            res = map.get(k);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }
    public V put(K k, V v) {
        V res = null;
        try {
            semaphore.acquire();
            res = map.put(k, v);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }
    public V remove(K k) {
        V res = null;
        try {
            semaphore.acquire();
            res = map.remove(k);
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public String toString() {
        String res = "";
        try {
            semaphore.acquire();
            res = map.toString();
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }
}

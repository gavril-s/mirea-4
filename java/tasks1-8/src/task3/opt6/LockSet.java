package task3.opt6;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSet<T> {
    private static final Lock lock = new ReentrantLock();
    private Set<T> set;

    public LockSet() {
        set = new HashSet<T>();
    }

    public boolean contains(T o) {
        lock.lock();
        boolean res = set.contains(o);
        lock.unlock();
        return res;
    }
    public boolean add(T o) {
        lock.lock();
        boolean res = set.add(o);
        lock.unlock();
        return res;
    }
    public boolean remove(T o) {
        lock.lock();
        boolean res = set.remove(o);
        lock.unlock();
        return res;
    }

    @Override
    public String toString() {
        lock.lock();
        String res = set.toString();
        lock.unlock();
        return res;
    }
}

package ru.ntr.preparing.hw03.counter;


import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private volatile long value;
    private final ReentrantLock locker = new ReentrantLock();

    public Counter() {
    }

    public Counter(long startValue) {
        this.value = startValue;
    }

    public long getAndIncrement() {
        locker.lock();
        long returnValue = value++;
        locker.unlock();
        return returnValue;
    }

    public long incrementAndGet() {
        locker.lock();
        long returnValue = ++value;
        locker.unlock();
        return returnValue;
    }

    public void increment() {
        locker.lock();
        value++;
        locker.unlock();
    }

    public long getAndDecrement() {
        locker.lock();
        long returnValue = value--;
        locker.unlock();
        return returnValue;
    }

    public long decrementAndGet() {
        locker.lock();
        long returnValue = --value;
        locker.unlock();
        return returnValue;
    }

    public void decrement() {
        locker.lock();
        value--;
        locker.unlock();
    }

    public long get() {
        return value;
    }
}

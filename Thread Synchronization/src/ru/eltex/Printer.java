package ru.eltex;

import java.util.concurrent.locks.ReentrantLock;

public class Printer {
    static private Integer a = 0;


    static private ReentrantLock lock = new ReentrantLock();
    static private volatile Integer b = 0;
    static private Integer c = 0;

    public static synchronized void ink() {
        a += 1;
        System.out.println("a = " + a);
    }

    public static void ink2() {
        b = b + 1;
        System.out.println(b);
    }

    public static void ink3() {
        lock.lock();
        c += 1;
        System.out.println("c = " + c);
        lock.unlock();
    }

    public static Integer getB() {
        return b;
    }
}

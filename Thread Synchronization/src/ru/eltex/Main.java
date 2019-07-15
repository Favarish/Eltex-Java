package ru.eltex;

public class Main {

    public static void main(String[] args) {
        //synchronization
        System.out.println("Synchronization:");
        for (int i = 0; i < 10; i++) {
            Runnable r = new MyThread();
            Thread t = new Thread(r);

            t.start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //volatile
        System.out.println("Volatile:");
        for (int i = 0; i < 10; i++) {
            Runnable r2 = new MyThread2();
            Thread t2 = new Thread(r2);

            t2.start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //ReentrantLock
        System.out.println("ReentrantLock:");
        for (int i = 0; i < 10; i++) {
            Runnable r3 = new MyThread3();
            Thread t3 = new Thread(r3);

            t3.start();
        }
    }
}

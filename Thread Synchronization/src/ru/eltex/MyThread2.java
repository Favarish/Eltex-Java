package ru.eltex;

public class MyThread2 implements Runnable{

    @Override
    public void run() {
        Printer.ink2();
    }
}

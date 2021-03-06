package com.practice.jai.java.threading;

public class MyThread1 extends Thread
{
    private final PrintCount printCount;

    public MyThread1(PrintCount printCount)
    {
        this.printCount = printCount;
    }
    @Override
    public void run()
    {
        synchronized (printCount)
        {
            //System.out.println(printCount.getCount());
            System.out.println("MyThread got Notification...");
            //printCount.incrementCount();
            System.out.println("Notifying to Main...");
            printCount.notify();
            /*printCount.notify();
            try {
                printCount.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

        }
    }
}

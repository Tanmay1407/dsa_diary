package core.multithreading;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is Thread: "+Thread.currentThread().getName()+" State: "+Thread.currentThread().getState());
        Thread1 th1 = new Thread1(); // NEW STATE
        System.out.println("Thread1 State: "+th1.getState());
        th1.start(); // RUNNABLE STATE
        System.out.println("Thread1 State: "+th1.getState());
        th1.join(); // Main Thread waits for the thread th1 to finish then only it executes further
        System.out.println("Thread1 State: "+th1.getState());

        //Executing a class implementing Runnable interface
        ThreadWithRunnable thRun = new ThreadWithRunnable(); //Create instance of class implementing Runnable
        Thread th = new Thread(thRun); // Create instance of Thread class by passing the thRun in the constructor
        th.start(); // Executing the thread using start() method

        //Thread Priorities:

        MinPrThread minThr = new MinPrThread("MinPriThread");
        MidPrThread midThr = new MidPrThread("MidPriThread");
        MaxPrThread maxThr = new MaxPrThread("MaxPriThread");
        minThr.setPriority(Thread.MIN_PRIORITY);
        midThr.setPriority(Thread.NORM_PRIORITY);
        maxThr.setPriority(Thread.MAX_PRIORITY);
        minThr.start();midThr.start();maxThr.start();

        //Demon Thread : JVM does NOT wait for a demon thread to finish, it only waits for the user threads
        DemonThread dTh = new DemonThread("Demon Thread");
        dTh.setDaemon(true); // Making this thread a demon thread
        dTh.start();
        System.out.println("Main Thread: Finished");
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        try{
            System.out.println("This is Thread1: Running");
            Thread.sleep(2000);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

class ThreadWithRunnable implements  Runnable {
    @Override
    public void run() {
        System.out.println("This thread is created by implementation of Runnable Interface");
    }
}

class MinPrThread extends  Thread {
    MinPrThread(String threadName){
        super(threadName);
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("This is MIN Priority Thread: Count: "+i);
        }
    }
}

class MidPrThread extends  Thread {
    MidPrThread(String threadName){
        super(threadName);
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("This is MID Priority Thread: Count: "+i);
        }
    }
}

class MaxPrThread extends  Thread {
    MaxPrThread(String threadName){
        super(threadName);
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("This is MAX Priority Thread: Count: "+i);
        }
    }
}

class DemonThread extends  Thread {
    DemonThread(String threadName){
        super(threadName);
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++) {
            System.out.println("This is DemonThread Thread: Count: "+i);
        }
    }
}



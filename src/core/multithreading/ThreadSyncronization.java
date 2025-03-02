package core.multithreading;

public class ThreadSyncronization {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ThreadSync thS1 = new ThreadSync(counter);
        ThreadSync thS2 = new ThreadSync(counter);
        thS1.start();thS2.start();
        try{
            thS1.join();
            thS2.join();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Counter Value: "+counter.getCount());

    }
}

class ThreadSync extends  Thread {
    private  Counter counter;
    ThreadSync(Counter counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        for(int i = 0; i < 1000; i++){
            counter.increment();
        }
    }
}

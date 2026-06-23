package thread_example;

import java.util.concurrent.*;

public class Housetasks {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);//to reuse the used threads

        Runnable cooking = () -> {
            System.out.println("Cooking breakfast by " + Thread.currentThread().getName());
            sleep(3000);
            System.out.println("Breakfast ready");
        };

        Runnable laundry = () -> {
            System.out.println("Washing clothes by " + Thread.currentThread().getName());
            sleep(1000);
            System.out.println("Clothes washed");
        };

        Runnable cleaning = () -> {
            System.out.println("Cleaning room by " + Thread.currentThread().getName());
            sleep(1500);
            System.out.println("Room cleaned");
        };

        executor.submit(cooking);
        executor.submit(laundry);
        executor.submit(cleaning);

        executor.shutdown();
    }

    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
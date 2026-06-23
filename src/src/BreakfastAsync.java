package src;

import java.util.concurrent.CompletableFuture;

public class BreakfastAsync {

    public static void main(String[] args) {

        CompletableFuture<Void> eggs = CompletableFuture.runAsync(() -> {
            cook("Boiling eggs", 3);
        });

        CompletableFuture<Void> toast = CompletableFuture.runAsync(() -> {
            cook("Toasting bread", 2);
        });

        CompletableFuture<Void> coffee = CompletableFuture.runAsync(() -> {
            cook("Brewing coffee", 4);
        });

        // Wait for ALL tasks to finish
        CompletableFuture<Void> breakfast =
                CompletableFuture.allOf(eggs, toast, coffee);

        breakfast.thenRun(() -> {
            System.out.println("🍽️ Breakfast is ready!");
        });

        // Important: keep main thread alive
        breakfast.join();
    }

    static void cook(String task, int seconds) {
        try {
            System.out.println(task + " started...");
            Thread.sleep(seconds * 1000);
            System.out.println(task + " done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
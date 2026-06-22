package src;

import java.util.concurrent.CompletableFuture;

public class TeaAsync {

    static CompletableFuture<String> boilWater() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Boiling water...");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Water ready");
            return "Water";
        });
    }

    static CompletableFuture<String> prepareCup() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Getting cup...");
                Thread.sleep(2000);

                System.out.println("Adding tea bag...");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Cup ready");
            return "Cup";
        });
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        CompletableFuture<String> water = boilWater();
        CompletableFuture<String> cup = prepareCup();

        CompletableFuture<Void> tea =
                water.thenCombine(cup, (w, c) -> {
                    System.out.println("Making tea...");
                    return "Tea";
                }).thenAccept(result -> {
                    System.out.println("Tea is ready!");
                });

        tea.join();

        long end = System.currentTimeMillis();

        System.out.println("Time: " + (end - start) / 1000.0 + " seconds");
    }
}
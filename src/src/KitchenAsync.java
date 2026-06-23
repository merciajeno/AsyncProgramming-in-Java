package src;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

public class KitchenAsync {

    public static void main(String[] args) {

        // 3 orders running in parallel
    	LocalDateTime start = LocalDateTime.now();
        CompletableFuture<Void> order1 = processOrder("Order 1");
        CompletableFuture<Void> order2 = processOrder("Order 2");
        CompletableFuture<Void> order3 = processOrder("Order 3");

        // wait for all orders
        CompletableFuture.allOf(order1, order2, order3).join();
        LocalDateTime end = LocalDateTime.now();
        System.out.println("Seconds took:"+(end.getSecond()-start.getSecond()));
        System.out.println("🏁 All orders completed!");
    }

    // One full order pipeline
    static CompletableFuture<Void> processOrder(String orderName) {

        return CompletableFuture
                .supplyAsync(() -> prep(orderName))
                .thenApply(dish -> cook(dish))
                .thenApply(dish -> pack(dish))
                .thenAccept(finalDish -> {
                    System.out.println("✅ " + finalDish + " is served!");
                });
    }

    // Step 1
    static String prep(String order) {
        sleep(1000);
        System.out.println(order + " -> Prepping sandwich 🥪");
        return order + " [Prepped]";
    }

    // Step 2
    static String cook(String dish) {
        sleep(2000);
        System.out.println(dish + " -> Cooking 🔥");
        return dish + " [Cooked]";
    }

    // Step 3
    static String pack(String dish) {
        sleep(1000);
        System.out.println(dish + " -> Packing 📦");
        return dish + " [Packed]";
    }

    static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
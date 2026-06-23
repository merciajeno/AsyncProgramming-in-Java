package coffee;

import java.util.concurrent.CompletableFuture;

public class CoffeeAsync {

	public static void main(String[] args) {
		
		  System.out.println("🥤 Making Espresso...");
	        makeCoffee(false);

	        System.out.println("\n🥛 Making Latte...");
	        makeCoffee(true).join();

	        System.out.println("\n🏁 All drinks ready!");
	}
	 static CompletableFuture<String> makeCoffee(boolean withMilk) {

	        return CompletableFuture
	                .supplyAsync(() -> grindBeans())
	                .thenApply(beans -> brewCoffee(beans))
	                .thenApply(coffee -> {
	                    if (withMilk) {
	                        return addMilk(coffee);
	                    }
	                    return coffee;
	                })
	                .thenApply(finalDrink -> {
	                    System.out.println("✅ Served: " + finalDrink);
	                    return finalDrink;
	                });
	    }

	    static String grindBeans() {
	        sleep(1000);
	        System.out.println("🫘 Grinding beans...");
	        return "Ground Beans";
	    }

	    static String brewCoffee(String input) {
	        sleep(2000);
	        System.out.println("☕ Brewing coffee...");
	        return input + " + Brewed Coffee";
	    }

	    static String addMilk(String coffee) {
	        sleep(1500);
	        System.out.println("🥛 Adding milk...");
	        return coffee + " + Milk";
	    }

	    static void sleep(int ms) {
	        try {
	            Thread.sleep(ms);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}

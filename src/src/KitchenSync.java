package src;

import java.time.LocalDateTime;

public class KitchenSync {
    public static void prepare() throws InterruptedException 
    {
    	Thread.sleep(1000);
    	System.out.println("Preparing items");
    	
    }
    public static void cook()throws InterruptedException
    {
    	Thread.sleep(1000);
    	System.out.println("Cooking items");
    }
    public static void pack() throws InterruptedException
    {
    	Thread.sleep(1000);
    	System.out.println("Packing items");
    }
	public static void main(String[] args) throws InterruptedException {
		int i;
		LocalDateTime start = LocalDateTime.now();
		for(i=1;i<=3;i++)
		{
			prepare();
			cook();
			pack();
			System.out.println("-------------------------------------");
		}
		LocalDateTime end = LocalDateTime.now();
		System.out.println(end.getSecond()-start.getSecond());
	}
}

package src;


public class TeaSync {

	 static void boilWater() throws InterruptedException {
	        System.out.println("Boiling water...");
	        Thread.sleep(5000);
	        System.out.println("Water ready");
	    }

	    static void getCup() throws InterruptedException {
	        System.out.println("Getting cup...");
	        Thread.sleep(2000);
	        System.out.println("Cup ready");
	    }

	    static void addTeaBag() throws InterruptedException {
	        System.out.println("Adding tea bag...");
	        Thread.sleep(1000);
	        System.out.println("Tea bag added");
	    }

	    public static void main(String[] args) throws Exception {

	        long start = System.currentTimeMillis();

	        boilWater();
	        getCup();
	        addTeaBag();

	        System.out.println("Tea is ready!");

	        long end = System.currentTimeMillis();

	        System.out.println("Time: " + (end - start) / 1000.0 + " seconds");
	    }
}

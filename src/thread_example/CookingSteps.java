package thread_example;

public class CookingSteps extends Thread {

	 public void run() {
	        System.out.println("Cooking started...");
	        try {
	            Thread.sleep(2000); // simulating boiling time
	        } catch (InterruptedException e) {
	            System.out.println("Cooking interrupted!");
	        }
	        System.out.println("Cooking finished!");
	    }
	public static void main(String[] args) {
		//to understand the lifecycle of thread
		CookingSteps c = new CookingSteps();
		System.out.println(c.getState());
		c.start();
		System.out.println(c.getState());
//		try {
//			c.join();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(c.getState());
	}
}

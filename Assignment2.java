//100 20 5
//Ct
public class Assignment2 {

	public static void main(String[] args) {
		int n = 0,k = 0,t = 0;
		
		try {
			n=Integer.parseInt(args[0]);
			k=Integer.parseInt(args[1]);
			t=Integer.parseInt(args[2]);
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Missing Command line argument(s)");
			System.exit(0);
		}
		catch(NumberFormatException e) {
			System.out.println("Improper command line argument(s)");
			System.exit(0);
		}
		
		int [] buffer = new int [n];
		Producer p = new Producer (buffer,k,t);
		p.setName("Producer Thread");
		Consumer c = new Consumer (buffer,k,t);
		c.setName("Consumer Thread");
		
		p.start();
		c.start();
		
		try {
			p.join();
			c.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}

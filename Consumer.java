
public class Consumer extends Thread {
	
	private int [] buffer;
	private int n;
	private int k;
	private int t;
	private int next_out=0;
	public Consumer(int[] buffer,  int k, int t) {
		super();
		this.buffer = buffer;
		this.n =buffer.length;
		this.k = k;
		this.t = t;
		
	}
	
	public void run() {
		while(true) {
			consume();
		}
	}
	public void consume() {
		int t2=(int)(t*Math.random());
		System.out.println(Thread.currentThread().getName()+"produced, will be going to sleep");
		try {
			Thread.currentThread().sleep(t2*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int k2=(int)(k*Math.random());
		for (int i=0;i<k2-1;i++) {
			int data=buffer[(next_out+i)%n];
			if(data >1) {
				System.out.println("Race Condition detect at Indx "+i);
				System.out.println(Thread.currentThread().getName());
			}
			buffer[(next_out+i) % n] = 0;
			}
		next_out = (next_out + k2) % n;
		
	}
	
	

	

}

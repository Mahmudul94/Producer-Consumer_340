
public class Producer extends Thread {
	
	private int [] buffer;
	private int n;
	private int k;
	private int t;
	private int next_in=0;
	public Producer(int[] buffer,  int k, int t) {
		super();
		this.buffer = buffer;
		this.n = buffer.length;
		this.k = k;
		this.t = t;
	}
	public void run() {
		while(true) {
			Produce();
		}
	}
	public void Produce() {
		int k1=(int)(k*Math.random());
		for (int i=0;i<k1-1;i++) {
			buffer[(next_in+i)%n]+=1;
		}
		next_in=(next_in+k1)%n;
		int random=(int)(t*Math.random());
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.currentThread().sleep(random*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}

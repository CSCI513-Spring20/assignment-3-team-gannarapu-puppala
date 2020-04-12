
public class main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

		WordCountMultiThread CPUSchedular = new WordCountMultiThread("xyz");

		CPUSchedular.start();
		
		Thread t1 = new Thread("Thread 1");

		t1.start();

		CpuSchedular.addThread(t1);
		
		new WordCountMultiThread ("One");
		new WordCountMultiThread ("Two");
	    //new WordCountMultiThread ("Three");
	}

}

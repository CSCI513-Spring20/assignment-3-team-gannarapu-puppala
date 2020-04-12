import java.util.LinkedList;

public class WordCountMultiThread extends Thread
	{
	
	String name;
	Thread t;
	
	LinkedList<Thread> que = new LinkedList<Thread>();


	
	WordCountMultiThread(String thread){
	    name = thread; 
	    t = new Thread(this, name);
	t.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i<5;i++) {
			System.out.println(name+"   "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(name + "Interrupted");
			}
		}
	}

	public void addThread(Thread t) {

		t.setPriority(2);

		}
	
	}
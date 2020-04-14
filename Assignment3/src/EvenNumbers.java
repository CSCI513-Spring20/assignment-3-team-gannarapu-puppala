import java.util.ArrayList;
import java.util.Arrays;

public class EvenNumbers extends Task {
	
	private ArrayList<Integer> evenNumbers;
	private int start;
	private int end;
	
	public EvenNumbers(int start, int end, int taskNumber) {
		super("Task"+taskNumber+", Even Numbers:" + start + "," + end);
		evenNumbers = new ArrayList<Integer>();
		this.start = start;
		this.end = end;
	}
	@Override
	public void run() {
		System.out.println(this.getName() + " running with " + Thread.currentThread().getName());
		for (int i = start; i <= end; ++i) {
			if(i%2==0) { evenNumbers.add(i);}
		}
		System.out.println(this.getName() + " genereated Even Numbers " + Arrays.toString(evenNumbers.toArray()) );
		System.out.println(this.getName() + " finished by " + Thread.currentThread().getName());
		try { 
            Thread.sleep(100); 
        } 
        catch (InterruptedException e) { 
            System.out.println("Caught:" + e); 
        }
		System.out.println(Thread.currentThread().getName() + " Stopped.");
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Printing Even Numbers between 1 and 1200");
		System.out.println("No of Threads used 10");
		System.out.println("No of Tasks 12");
		System.out.println("");
		System.out.println("");
		CustomThreadPool customThreadPool = new CustomThreadPool(10);
		ArrayList<EvenNumbers> tasks = new ArrayList<EvenNumbers>();
		int lowerLimit = 1;
		int upperLimit = 100;
		
		 for (int i = 1; i <= 12; i++) 
	        {
			  EvenNumbers task = new EvenNumbers(lowerLimit, upperLimit,i);
	          //System.out.println("Created : " + task.getName());
	          lowerLimit = upperLimit+1;
	          upperLimit = upperLimit + 100;
	          customThreadPool.execute(task);
		      tasks.add(task);
	        }
		 customThreadPool.shutdown();
		
	}

}

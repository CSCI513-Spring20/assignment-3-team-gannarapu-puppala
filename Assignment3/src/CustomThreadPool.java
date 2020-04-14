import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

//This class implements Thread pooling and tasks are running
public class CustomThreadPool 
{
    //Thread pool size
    private final int poolSize;
     
    //Internally pool is an array
    private final WorkerThread[] workers;
     
    // FIFO ordering
    private final LinkedBlockingQueue<Runnable> queue;
 
    //Constructor where all threads created
    public CustomThreadPool(int poolSize) 
    {
        this.poolSize = poolSize;
        queue = new LinkedBlockingQueue<Runnable>();
        workers = new WorkerThread[poolSize];
 
        for (int i = 0; i < poolSize; i++) {
            workers[i] = new WorkerThread();
            workers[i].start();
        }
    }
    
    // All tasks added to queue and notify Thread
    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }
 
    // Where all tasks executed and thread are assigned for tasks
    private class WorkerThread extends Thread {
        public void run() {
            Runnable task;
 
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
                        }
                    }
                    task = (Runnable) queue.poll();
                    
                }
 
                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
        
    }
 
    //Shutting down all pools
    public void shutdown() {
    	try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Shut down all pools");
        for (int i = 0; i < poolSize; i++) {
            workers[i] = null ;
        }
        System.exit(0);
    }
}


import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
    private String name;
 
    //Constructor 
    public Task(String name) {
        this.name = name;
    }
    //Returns Name
    public String getName() {
        return name;
    }
 
    //Run Method
    public void run() {
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println(duration);
            System.out.println("Executing : " + name);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
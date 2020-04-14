
public abstract class Task implements Runnable {
    private String name;
 
    //Constructor 
    public Task(String name) {
        this.name = name;
    }
    //Returns Name
    public String getName() {
        return name;
    }
 
}
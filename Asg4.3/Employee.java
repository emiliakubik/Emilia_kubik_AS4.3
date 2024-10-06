import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private List<Job> jobHistory;

    //constructor method sets employees name and instantiates a new array list
    public Employee(String name){
        this.name = name;
        this.jobHistory = new ArrayList<>();
    }

    //adds job to the array list- this is of Job type, so essentially adds all the info added from Job class
    public void addJob(Job job){
        jobHistory.add(job);
    }

    //lists out all the info from every job in this person's history by calling Job's display job info method
    public void displayJobHistory(){
        if (jobHistory.isEmpty()){
            System.out.println("No job history.");
        } else{
            for(Job job : jobHistory){
                job.displayJobDetails();
                System.out.println();
            }
        }
    }

    //getter methods return the 2 properties that are individual to this subclass
    public String getName(){
        return name;
    }

    public List getJobHistory(){
        return jobHistory;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private List<Job> jobHistory;

    public Employee(String name){
        this.name = name;
        this.jobHistory = new ArrayList<>();
    }

    public void addJob(Job job){
        jobHistory.add(job);
    }

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

    public String getName(){
        return name;
    }

    public List getJobHistory(){
        return jobHistory;
    }
}

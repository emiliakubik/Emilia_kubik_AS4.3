import java.util.ArrayList;
import java.lang.Math;

class Task{
    private String name;
    private int duration;
    private boolean complete;
    
    //constructor to initialize task with a name and duration
    public Task(String name, int duration){
        this.name = name;
        this.duration = duration;
        complete = false;
    }
    //getter and setter methods for name and duration
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getDuration(){
        return duration;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    //getter method for completion
    public boolean isCompleted(){
        return complete;
    }

    //setter method for completion if want to mark it completed
    public void completeTask(){
        complete = true;
    }

    //setter method for completion if want to mark it uncompleted
    public void resetTask(){
        complete = false;
    }
}

class TaskTracker {
    //ArrayList of type Task that will hold all the info from the objects of the above class
    private ArrayList<Task> taskList;
    
    //constructor initializes taskTracker object with an empty task list
    public TaskTracker(){
        this.taskList = new ArrayList<>();
    }

    //Method to add a new task to the task list- task is passed in
    public void addTask(Task task){
        taskList.add(task);
    }

    //Method to mark a task as completed based on its index in the list- calls method from Task class
    public void markTaskAsCompleted(int index){
        Task t = taskList.get(index);
        t.completeTask();
    }

    //Method to display all tasks in the task list
    public void displayTasks(){
        if(taskList.isEmpty()){
            System.out.println("No tasks available.");
        } else{
            for(int i = 0; i < taskList.size(); i++){
                Task t = taskList.get(i);
                System.out.println((i + 1) + ". " + t.getName() + " - Duration: " + t.getDuration());
            }
        }
    }

    //Method to calculate the total duration of completed tasks
    public int calculateTotalDuration(){
        int totalDuration = 0;
        for(int i = 0; i < taskList.size(); i++){
            Task t = taskList.get(i);
            if(t.isCompleted()){
                totalDuration = Math.addExact(totalDuration, t.getDuration());
            }
        }

        return totalDuration;
    }

    //Method to calculate the average duration of completed tasks
    public double calculateAverageDuration(){
        int tasksCompleted = 0;
        for(int i = 0; i < taskList.size(); i++){
            Task t = taskList.get(i);
            if(t.isCompleted()){
                tasksCompleted = Math.incrementExact(tasksCompleted);
            }
        }
        return Math.divideExact(calculateTotalDuration(), tasksCompleted);
    }

    //Method to find the maximum duration among completed tasks
    public int findMaxDuration(){
        int maxDuration = (taskList.get(0)).getDuration();
        for(int i = 1; i < taskList.size(); i++){
            int check = (taskList.get(i)).getDuration();
            if (check > maxDuration){
                maxDuration = check;
            }
        }
        return maxDuration;

    }
}

public class TaskMasterApp{
    public static void main(String[] args){
        //Create Task objects
        Task task1 = new Task("Create employee", 15);
        Task task2 = new Task("Edit employee", 20);
        Task task3 = new Task("View employees", 25);
        Task task4 = new Task("Remove employee", 10);
        Task task5 = new Task("List required skills", 30);
        Task task6 = new Task("Calculate employement duration", 30);


        //Create TaskTracker object called "tracker"
        TaskTracker tracker = new TaskTracker();

        //Add tasks to the task list
        tracker.addTask(task1);
        tracker.addTask(task2);
        tracker.addTask(task3);
        tracker.addTask(task4);
        tracker.addTask(task5);
        tracker.addTask(task6);
        
        //Display tasks in the task list
        tracker.displayTasks();

        //Mark tasks as completed
        tracker.markTaskAsCompleted(0);
        tracker.markTaskAsCompleted(1);
        tracker.markTaskAsCompleted(2);

        //Display calculated statistics
        System.out.println("Total Duration of Completed Tasks: " + tracker.calculateTotalDuration() + " minutes");
        System.out.println("Average Duration of Completed Tasks: " + tracker.calculateAverageDuration() + " minutes");
        System.out.println("Maximum Duration among Completed Tasks: " + tracker.findMaxDuration() + " minutes");
    }
}
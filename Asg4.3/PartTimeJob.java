import java.time.LocalDate;
import java.time.Period;
public class PartTimeJob extends Job {
    private int hoursWorked;
    private int hourlyWage;

    //constructor calls Job class's constructor and then sets the porperties that are unique to this subclass
    public PartTimeJob(String companyName, String position, LocalDate startDate, LocalDate endDate, int hoursWorked, int hourlyWage){
        super(companyName, position, startDate, endDate);
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
    }

    //multiplies employee's number of hours worked by their hourly wage and returns this as type int
    public int totalEarnings(){
        return hoursWorked * hourlyWage;
    }

    //if the employee has worked >40 hours, they are eligible for overtime
    public String isEligibleForOvertime(){
        if(hoursWorked > 40){
            return "Eligible.";
        } else {
            return "Not eligible.";
        }
    }

    //overrides Job's abstract class to print all the part time job info 
    @Override
    public void displayJobDetails(){
        System.out.println("Company: " + getCompanyName());
        System.out.println("Position: " + getPosition());
        System.out.println("Start date: " + getStartDate() + "(" + getJobDuration(calculateJobDuration()) + ")");
        System.out.println("Total earnings: " + totalEarnings());
        System.out.println("Eligible for overtime? " + isEligibleForOvertime());
        System.out.println("Job satisfaction (out of 100): " + assessJobSatisfaction());

    }

    //returns the 2 properties that are unique to this subclass
    public int getHoursWorked(){
        return hoursWorked;
    }

    public int getHourlyWage(){
        return hourlyWage;
    }
}

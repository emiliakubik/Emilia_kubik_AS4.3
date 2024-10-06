import java.time.LocalDate;
import java.time.Period;
public class PartTimeJob extends Job {
    private int hoursWorked;
    private int hourlyWage;

    public PartTimeJob(String companyName, String position, LocalDate startDate, LocalDate endDate, int hoursWorked, int hourlyWage){
        super(companyName, position, startDate, endDate);
        this.hoursWorked = hoursWorked;
        this.hourlyWage = hourlyWage;
    }

    public int totalEarnings(){
        return hoursWorked * hourlyWage;
    }

    public String isEligibleForOvertime(){
        if(hoursWorked > 40){
            return "Eligible.";
        } else {
            return "Not eligible.";
        }
    }

    @Override
    public void displayJobDetails(){
        System.out.println("Company: " + getCompanyName());
        System.out.println("Position: " + getPosition());
        System.out.println("Start date: " + getStartDate() + "(" + calculateJobDuration() + ")");
        System.out.println("Total earnings: " + totalEarnings());
        System.out.println("Eligible for overtime? " + isEligibleForOvertime());
        System.out.println("Job satisfaction (out of 100): " + assessJobSatisfaction());

    }
}

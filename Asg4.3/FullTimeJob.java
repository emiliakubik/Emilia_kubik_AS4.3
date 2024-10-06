import java.time.LocalDate; 
public class FullTimeJob extends Job {
    private int biweeklySalary;

    //constructor calls Job class's constructor and then sets the porperties that are unique to this subclass
    public FullTimeJob(String companyName, String position, LocalDate startDate, LocalDate endDate, int biweeklySalary){
        super(companyName, position, startDate, endDate);
        this.biweeklySalary = biweeklySalary;
    }

    //takes the biweekly salary and multiplies it by half of the amount of weeks in a year and then returns that as type int
    public int calculateAnnualSalary(){
        return biweeklySalary * 26;
    }

    //if this person has worked here for >2 years, they are eligible for promotion
    public String isEligibleForPromotion(){
        int length = calculateJobDuration().getMonths();
        if(length >= 24){
            return "Eligible.";
        } else {
            return "Not eligible.";
        }

    }

    //overrides Job's abstract class to print all the full time job info 
    @Override
    public void displayJobDetails(){
        System.out.println("Company: " + getCompanyName());
        System.out.println("Position: " + getPosition());
        System.out.println("Start date: " + getStartDate() + "(" + calculateJobDuration() + ")");
        System.out.println("Annual salary: " + calculateAnnualSalary());
        System.out.println("Eligible for promotion? " + isEligibleForPromotion());
        System.out.println("Job satisfaction (out of 100): " + assessJobSatisfaction());

    }

    //returns the property that is unique to this subclass
    public int getBiweeklySalary(){
        return biweeklySalary;
    }
}

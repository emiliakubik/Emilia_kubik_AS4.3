import java.time.LocalDate;
public class FullTimeJob extends Job {
    private int biweeklySalary;
    public FullTimeJob(String companyName, String position, LocalDate startDate, LocalDate endDate, int biweeklySalary){
        super(companyName, position, startDate, endDate);
        this.biweeklySalary = biweeklySalary;
    }

    public int calculateAnnualSalary(){
        return biweeklySalary * 24;
    }

    public String isEligibleForPromotion(){
        int length = calculateJobDuration().getMonths();
        if(length >= 24){
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
        System.out.println("Annual salary: " + calculateAnnualSalary());
        System.out.println("Eligible for promotion? " + isEligibleForPromotion());
        System.out.println("Job satisfaction (out of 100): " + assessJobSatisfaction());

    }
}

import java.time.LocalDate;
import java.time.Period;
public class ContractJob extends Job{
    private int contractDurationMonths;
    private int totalContractSalary;

    public ContractJob(String companyName, String position, LocalDate startDate, LocalDate endDate, int contractDurationMonths, int totalContractSalary){
        super(companyName, position, startDate, endDate);
        this.contractDurationMonths = contractDurationMonths;
        this.totalContractSalary = totalContractSalary;
    }

    public String getContractDuration(){
        return contractDurationMonths + " months";
    }

    public int calculateBiweeklyPay(){
        return totalContractSalary / contractDurationMonths / 2;
    }

    @Override
    public void displayJobDetails(){
        System.out.println("Company: " + getCompanyName());
        System.out.println("Position: " + getPosition());
        System.out.println("Start date: " + getStartDate() + "(" + calculateJobDuration() + ")");
        System.out.println("Contract duration: " + getContractDuration());
        System.out.println("Biweekly pay: " + calculateBiweeklyPay());
        System.out.println("Job satisfaction (out of 100): " + assessJobSatisfaction());
    }
}

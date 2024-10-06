import java.time.LocalDate;
import java.time.Period;
public class ContractJob extends Job{
    private int contractDurationMonths;
    private int totalContractSalary;

    //constructor calls Job class's constructor and then sets the porperties that are unique to this subclass
    public ContractJob(String companyName, String position, LocalDate startDate, LocalDate endDate, int contractDurationMonths, int totalContractSalary){
        super(companyName, position, startDate, endDate);
        this.contractDurationMonths = contractDurationMonths;
        this.totalContractSalary = totalContractSalary;
    }

    //getter method returns property that is unique to this subclass, and concatenates "months" onto it to clarify the units
    public String getContractDuration(){
        return contractDurationMonths + " months";
    }

    //divides total contract salary pay my how many months the contract is set for and then by 2 to calculate the pay per 2 weeks
    public int calculateBiweeklyPay(){
        return totalContractSalary / contractDurationMonths / 2;
    }

    //overrides Job's abstract class to print all the contract job info 
    @Override
    public void displayJobDetails(){
        System.out.println("Company: " + getCompanyName());
        System.out.println("Position: " + getPosition());
        System.out.println("Start date: " + getStartDate() + "(" + calculateJobDuration() + ")");
        System.out.println("Contract duration: " + getContractDuration());
        System.out.println("Biweekly pay: " + calculateBiweeklyPay());
        System.out.println("Job satisfaction (out of 100): " + assessJobSatisfaction());
    }

    //returns the property that is unique to this subclass
    public int getContractSalary(){
        return totalContractSalary;
    }
}

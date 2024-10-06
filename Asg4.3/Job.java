import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public abstract class Job{
    private String companyName;
    private String position;
    private LocalDate startDate;
    private LocalDate endDate;

    public Job(String companyName, String position, LocalDate startDate, LocalDate endDate){
        this.companyName = companyName;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public abstract void displayJobDetails();

    public Period calculateJobDuration(){
        LocalDate endDateForCalculation;
        if (endDate != null){
            endDateForCalculation = endDate;
        } else {
            endDateForCalculation = LocalDate.now();
        }

        return Period.between(startDate, endDateForCalculation);
    }

    public int assessJobSatisfaction(){
        Scanner scn = new Scanner(System.in);
        int satisfactionScore = 0;

        System.out.println("Do you have a good work-life balance? (answer with y/n) ");
        String answer = scn.nextLine();
        if(answer.equals("y")){
            satisfactionScore += 40; //40% weight
        }

        System.out.println("Are you satisfied with your salary? (answer with y/n) ");
        answer = scn.nextLine();
        if(answer.equals("y")){
            satisfactionScore += 30; //30% weight
        }

        System.out.println("Do you think you've grown in your career? (answer with y/n) ");
        answer = scn.nextLine();
        if(answer.equals("y")){
            satisfactionScore += 30; //30% weight
        }

        return satisfactionScore;
    }

    public String getCompanyName(){
        return companyName;
    }

    public String getPosition(){
        return position;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }
}
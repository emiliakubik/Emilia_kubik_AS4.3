import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public abstract class Job{
    private String companyName;
    private String position;
    private LocalDate startDate;
    private LocalDate endDate;

    //constructor sets company name, work position, start date and end date
    public Job(String companyName, String position, LocalDate startDate, LocalDate endDate){
        this.companyName = companyName;
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    //method to display all job details is abstract because details will be different between job types (subclasses)
    public abstract void displayJobDetails();

    //calculates years, months, and days between start date and end date, if no end date, calculate until today
    public Period calculateJobDuration(){
        LocalDate endDateForCalculation;
        if (endDate != null){
            endDateForCalculation = endDate;
        } else {
            endDateForCalculation = LocalDate.now();
        }

        return Period.between(startDate, endDateForCalculation);
    }

    public String getJobDuration(Period d){
        String str = "";
        if(d.getYears() > 0){
            str += d.getYears() + " year(s) ";
        }
        if(d.getMonths() > 0){
            str += d.getMonths() + " month(s) ";
        }
        if(d.getDays() > 0){
            str += d.getDays() + " day(s)";
        }

        return str;
    }

    //asks questions that each have a different score and then give an overall score of their job satisfactions out of 100 points
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

    //getter methods to return all 4 properties

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
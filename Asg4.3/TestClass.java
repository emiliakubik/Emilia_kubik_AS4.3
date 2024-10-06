import java.time.LocalDate;
public class TestClass {
    public static void main(String[] args){
        Employee employee = new Employee("Mark");

        FullTimeJob fullTimeJob = new FullTimeJob("Meta", "Software engineer", LocalDate.of(2015, 4, 12), LocalDate.of(2022, 8, 25), 5000);

        PartTimeJob partTimeJob = new PartTimeJob("Discover", "Front desk", LocalDate.of(2007, 5, 3), LocalDate.of(2009, 6, 15), 20, 15);

        ContractJob contractJob = new ContractJob("Twitter", "Web developer", LocalDate.of(2020, 1, 1), LocalDate.of(2020, 6, 1), 6, 30000);

        employee.addJob(fullTimeJob);
        employee.addJob(partTimeJob);
        employee.addJob(contractJob);

        employee.displayJobHistory();
    }
}

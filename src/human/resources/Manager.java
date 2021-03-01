package human.resources;

/**
 * Manager Class
 * 
 * @author Luan N Nguyen
 * @since February 07th, 2021
 * @version 1.0
 */
public class Manager extends Staff implements ICalculator {
    /** Variable store job title of manager */
    private String jobTitle;

    public Manager(String id, String name, int age, int coefficients, String dateStart, String department, int daysOff,
            String jobTitle) {
        super(id, name, age, coefficients, dateStart, department, daysOff);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Calculate salary for manager base on his/her job title
     */
    @Override
    public int calculateSalary() {
        // Responsible wage with each specific title
        int responsibleWage;

        switch (jobTitle) {
        case "Business Leader":
            responsibleWage = 8000000;
            break;
        case "Technical Leader":
            responsibleWage = 6000000;
            break;
        case "Project Leader":
        default:
            responsibleWage = 5000000;
            break;
        }
        return super.getCoefficients() * 5000000 + responsibleWage;
    }

    /**
     * Display manager's information
     */
    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s", super.getId(), super.getName(),
                super.getAge(), super.getCoefficients(), super.getDateStart(), super.getDepartment(),
                super.getDaysOff(), jobTitle, "-");
    }
}

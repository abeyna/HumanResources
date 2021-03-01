package human.resources;

/**
 * Employee Class
 * 
 * @author Luan N Nguyen
 * @since February 07th, 2021
 * @version 1.0
 */
public class Employee extends Staff implements ICalculator {
    /** Variable store number of over-time hours */
    private int extraHours;

    /**
     * Employee's Constructor
     * 
     * @param id
     *                         Employee's ID
     * @param name
     *                         Employee's name
     * @param age
     *                         Employee's age
     * @param coefficients
     *                         Employee's coefficients salary
     * @param dateStart
     *                         Date start work
     * @param department
     *                         Department of work
     * @param daysOff
     *                         Number of days off
     * @param extraHours
     *                         Extra working hours
     */
    public Employee(String id, String name, int age, int coefficients, String dateStart, String department, int daysOff,
            int extraHours) {
        super(id, name, age, coefficients, dateStart, department, daysOff);
        this.extraHours = extraHours;
    }

    public int getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(int extraHours) {
        this.extraHours = extraHours;
    }

    /**
     * Calculate salary for employee
     */
    @Override
    public int calculateSalary() {
        return super.getCoefficients() * 3000000 + extraHours * 200000;
    }

    /**
     * Display employee's information
     */
    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s", super.getId(), super.getName(),
                super.getAge(), super.getCoefficients(), super.getDateStart(), super.getDepartment(),
                super.getDaysOff(), "-", extraHours);
    }
}

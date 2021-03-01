package human.resources;

/**
 * Staff Class
 * 
 * @author Luan N Nguyen
 * @since February 07th, 2021
 * @version 1.0
 */
public abstract class Staff {
    /** Staff's ID */
    private String id;

    /** Staff's name */
    private String name;

    /** Staff's age */
    private int age;

    /** Coefficients salary */
    private int coefficients;

    /** Date start work */
    private String dateStart;

    /** Department of work */
    private String department;

    /** Number of days off */
    private int daysOff;

    /**
     * Staff's Constructor
     * 
     * @param id
     *                         Staff's ID
     * @param name
     *                         Staff's name
     * @param coefficients
     *                         Coefficients salary
     * @param dateStart
     *                         Date start work
     * @param department
     *                         Department of work
     * @param daysOff
     *                         Number of days off
     */
    public Staff(String id, String name, int age, int coefficients, String dateStart, String department, int daysOff) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficients = coefficients;
        this.dateStart = dateStart;
        this.department = department;
        this.daysOff = daysOff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCoefficients() {
        return coefficients;
    }

    public void setCoefficients(int coefficients) {
        this.coefficients = coefficients;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDaysOff() {
        return daysOff;
    }

    public void setDaysOff(int daysOff) {
        this.daysOff = daysOff;
    }

    /**
     * Abstract method display staff's information
     */
    public abstract String toString();
}
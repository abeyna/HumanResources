package human.resources;

/**
 * Department Class
 * 
 * @author Luan N Nguyen
 * @since February 07th, 2021
 * @version 1.0
 */
public class Department {
    private int dpmID;
    private String dpmName;
    private int staffsAmount;

    public Department(int dpmID, String dpmName, int staffsAmount) {
        this.dpmID = dpmID;
        this.dpmName = dpmName;
        this.staffsAmount = staffsAmount;
    }

    public int getDpmID() {
        return dpmID;
    }

    public void setDpmID(int dpmID) {
        this.dpmID = dpmID;
    }

    public String getDpmName() {
        return dpmName;
    }

    public void setDpmName(String dpmName) {
        this.dpmName = dpmName;
    }

    public int getStaffsAmount() {
        return staffsAmount++;
    }

    public void setStaffsAmount(int staffsAmount) {
        this.staffsAmount = staffsAmount;
    }

    /**
     * Display department list base on ID, name and amount of staffs in each
     */
    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s", dpmID, dpmName, staffsAmount);
    }
}

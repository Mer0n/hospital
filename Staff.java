package MeresaMeron_Project;

/**
 *
 * @author Meron
 */
public class Staff extends Person {

    private static long sequenceId = 1;
    private long staffId;

    public Staff(String firstName, String lastName) {
        super(firstName, lastName);
        this.staffId = sequenceId++;
    }

    public long getStaffId() {
        return staffId;
    }

    public void setStaffId(long staffId) {
        this.staffId = staffId;
    }
}

package MeresaMeron_Project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mom and Dad
 */
public class Unit {

	private List<Employee> staffMembers;
	private List<Bed> beds;
	private Treatment specialty;
        /**
         * constructor of unit
         * @param members employees in the unit
         * @param specialty doctor specialty in each unit
         */

	public Unit(List<Employee> members, Treatment specialty) {
		this.staffMembers = new ArrayList<Employee>(members);
		beds = new ArrayList<Bed>();
		this.specialty = specialty;
	}
        /**
         * 
         * @param bed assign bed to unit
         */

	public void assignBed(Bed bed) {
		beds.add(bed);
		bed.setAssignedUnit(this);
	}
        /**
         * 
         * @return gets list of beds
         */
	public List<Bed> getBeds() {
		return beds;
	}
        /**
         * 
         * @param staff add to unit
         */
	public void addNewStaffMember(Employee staff) {
		staffMembers.add(staff);
	}
        /**
         * 
         * @return all employees in unit
         */
	public List<Employee> getStaffMembers() {
		return staffMembers;
	}
        /**
         * 
         * @param staffId
         * @return removes employee from unit
         */
	public boolean removeStaff(int staffId) {
		for (Employee staff : staffMembers) {
			if (staff.getId() == staffId) {
				//Means the staff exists!
				staffMembers.remove(staff);
				return true;
			}
		}
		return false;
	}
        /**
         * 
         * @return treatment in unit
         */
	public Treatment getSpecialty() {
	    return specialty;
	}
        /**
         * 
         * @return specialty for unit in string
         */
	public String toString() {
	    return specialty.name();
	}

}
package MeresaMeron_Project;
/**
 *
 * @author Meron
 */

public class Bed {

	private int bedNum;
	private Patient assignedPatient;
	private Unit assignedUnit;
	private boolean isAvailable;
	private double price;
        /**
         * constructor for bed
         * @param bedNum 
         */
	public Bed(int bedNum) {
		this.bedNum = bedNum;
		isAvailable = true;
		price = 20.0;
	}
        /**
         * constructor for bed with price
         * @param bedNum
         * @param price 
         */
	
	public Bed(int bedNum, double price) {
	    this.bedNum = bedNum;
		isAvailable = true;
		this.price = price;
	}
        /**
         * 
         * @param p set the price of bed
         */

	public void setPrice(double p) {
		price = p;
		if (price < 0) {
			price = 0;
		}
	}
        /**
         * 
         * @return the price of bed
         */
	public double getPrice() {
		return price;
	}
	
        /**
         * 
         * @return the bed number
         */
	public int getBedNum() {
		return bedNum;
	}
        /**
         * 
         * @param bedNum sets bed number to bed
         */
	public void setBedNum(int bedNum) {
		this.bedNum = bedNum;
	}
        /**
         * 
         * @return the patient assigned to the bed
         */
	public Patient getAssignedPatient() {
		return assignedPatient;
	}
        /**
         * 
         * @param assignedPatient to bed
         */
	public void setAssignedPatient(Patient assignedPatient) {
		this.assignedPatient = assignedPatient;
		if (assignedPatient == null) {
		    isAvailable = true;
		} else {
		    assignedPatient.setBed(this);
		    isAvailable = false;
		}
	}
        /**
         * 
         * @param unit set bed to unit
         */
	public void setAssignedUnit(Unit unit) {
		this.assignedUnit = unit;
	}
        /**
         * 
         * @return the unit the bed is assigned to
         */
	public Unit getAssignedUnit() {
		return assignedUnit;
	}
        /**
         * 
         * @return checks if bed is available
         */
	public boolean isAvailable() {
		return isAvailable;
	}
        /**
         * 
         * @param isAvailable sets bed  if available
         */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
        /**
         * 
         * @return the bed/bed number/unit bed is assigned and bed price in string
         */
	public String toString() {
		return "Bed #"+bedNum+", unit specialized in "+assignedUnit+". Price: $"+price;
	}

}
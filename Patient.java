package MeresaMeron_Project;


/**
 *
 * @author Meron
 */
//class Patient
public class Patient extends Person implements Comparable<Patient>
{
	private Doctor physician;
	public double owes;
	private static long sequenceId = 1;
	private long patientid;
	private Bed bed;
	private int checkIn;
	private int checkOut;
	private Treatment illness;
	private int daysLeft;
	private Unit unit;

	/**
	 *  Creates a new instance that represents Patient
	 * @param givenName first name of the patient
	 * @param surname last name of the patient
         * @param illness illness of patient
	 */
        
       
	public Patient(String givenName, String surname, Treatment illness) {
		//call parent class constructor  
		super(givenName,surname);
		owes = 0.0;
		patientid = sequenceId++;
		this.illness = illness;
		daysLeft = illness.getTreatmentDays();
	}
        /**
         * 
         * @param physician is assign to patient 
         */
	
	public void assignPhysician(Doctor physician) {
	    this.physician = physician;
	}
	/**
         * 
         * @return said physician
         */
	public Doctor getPhysician() {
	    return physician;
	}
       
	
	public void simulateDay() { 
	    //Simulate once on treatment
	    if(daysLeft > 0) {
            daysLeft--;
            if(daysLeft == 0) {
                owes += illness.getCost();
                illness = null;
            }
	    }
	}
        /**
         * 
         * @return type of illness
         */
	public Treatment getIllness() {
		return illness;
	}

        /**
         * 
         * @param checkIn checks patient in
         */
	public void checkIn(int checkIn) {
		this.checkIn = checkIn;
	}
        /**
         * 
         * @param checkOut checks patient out 
         */
	public void checkOut(int checkOut) {
		this.checkOut = checkOut;
	}
        /**
         * 
         * @return patient check in
         */
	
	public int getCheckIn() {
		return checkIn;
	}
        /**
         * 
         * @return patient check out
         */
	public int getCheckOut() {
		return checkOut;
	}
        /**
         * 
         * @return is bed assigned to patient
         */

	public boolean isAssigned() {
		return bed != null;
	}
        /**
         * 
         * @param bed set bed to patient
         */

	public void setBed(Bed bed) {
		this.bed = bed;
	}
	/**
         * 
         * @return what bed patient has
         */
	public Bed getBed() {
	    return bed;
	}
        /**
         * 
         * @param unit set unit for patient
         */
	
	public void setUnit(Unit unit) {
	    this.unit = unit;
	}
	/**
         * 
         * @return the unit the patient is in
         */
	public Unit getUnit() {
	    return unit;
	}
        /**
         * 
         * @return the patients ID
         */
	public long getPatientId() {
		return patientid;
	}
        /**
         * 
         * @param patientid sets ID for patient
         */
	public void setId(long patientid) {
		this.patientid = patientid;
	}
        /**
         * 
         * @return patient first/last name and Patient ID 
         */
	public String toString() {
		return String.format("%d. %s %s", this.patientid, this.getFirstName(), this.getLastName());
	}
        /**
         * 
         */
	/** Return: this Patient's balance */
	public double getOwes() {
		return owes;
	}

	/** Adds charges to this Patient's bill */
	public void charge(double amount) {
		owes = owes + amount;
	}

	/** Pays off this Patient's bill */
	public void pay(double amount) {
		owes = owes - amount;
	}
	/**
         * compares patient to each other by how much they owe
         * @param other
         * @return 
         */
	public int compareTo(Patient other) {
	    return this.owes < other.owes ? -1 : (this.owes == other.owes ? 0 : 1); 
	}


}
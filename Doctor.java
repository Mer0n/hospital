package MeresaMeron_Project;

/**
 *
 * @author Mom and Dad
 */
//Doctor class
public class Doctor extends Employee {

	private Treatment specialty;
	private Patient patient;

	//constructor
	/**
	 * Creates a new instance that represents Doctor
	 * @param unit where the doctor is working 
	 * @param specialty what type of doctor
	 * @param givenName the doctors first name
	 * @param surname  the doctors last name
	 */
	public Doctor(String unit,Treatment specialty,String givenName,String surname){  

		//call parent class constructor
		super(unit,givenName,surname);
		this.specialty=specialty;
		//set annualSalary
		super.annualSalary=250000;
	}
        /**
         * 
         * @param patient assigned to doctor
         */

	public void assignPatient(Patient patient) {
		this.patient = patient;
	}
        /**
         * 
         * @return get the patient assigned to doctor
         */
	public Patient getPatient() {
		return patient;
	}
        /**
         * 
         * @return the doctors specialty
         */
	public Treatment getSpecialty() {
		return specialty;
	}
	/**
         * 
         * @return is patient available
         */
	public boolean isAvailable() {
	    return patient == null;
	}


	/**
	 * 
	 * @return all give information for the doctor converted to string
	 */
	@Override
	public String toString() {
		super.toString();   
		return String.format("Dr. "+this.getFirstName()+" "+this.getLastName()+"("+this.specialty+")"); 

	} 
}
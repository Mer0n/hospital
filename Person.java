package MeresaMeron_Project;



/**
 *
 * @author Meron
 */
public class Person {


	/**
	 * This generates the unique id
	 */

	private static int val=1;
	/**
	 * Declaring instance variable id
	 */

	public int ID;
	private String firstName;
	private String lastName;

	/**
	 * Creates a new instance that represents Person
	 * @param firstName the first name of person
	 * @param lastName  the last name of person
	 */

	public Person(String firstName, String lastName) {
		super.toString();
		this.ID = val;
		val++;
		this.firstName = firstName;
		this.lastName = lastName;
	}
        /**
         * 
         * @return  first name of person
         */
	public String getFirstName() {
		return firstName;
	}
        /**
         * 
         * @param firstName sets first name of person
         */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
        /**
         * 
         * @return last name of person
         */
	public String getLastName() {
		return lastName;
	}
        /**
         * 
         * @param lastName sets last name of person 
         */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the iD number that was given
	 */
	 public int getId() {
	     return ID;
	 }

	/*
	 * This method will return the Information about the class
	 *
	 */
         /**
          * 
          * @return first name last name and ID of person to string format
          */

	@Override
	public String toString() {
		super.toString(); 
		return firstName + " " + lastName + "(ID# " + ID + ")";
	}

}
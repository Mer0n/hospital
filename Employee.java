package MeresaMeron_Project;



/**
 *
 * @author Mero
 */
//Employee class
public class Employee extends Person{
	public String unit;
	protected int annualSalary;

	//constructor
	/**
	 * Creates a new instance that represents Employee
	 * @param unit where the employee works ex, Unit 1, Unit 2
	 * @param givenName the first name of the employee
	 * @param surname  the last name of the employee
	 */
	public Employee(String unit,String givenName,String surname){ 

		//this will call parent class constructor
		super(givenName,surname);
		this.unit=unit;
	}

	//method getAnnualSalary()
	/**
	 * 
	 * @return annual salary of employee
	 */
	public int getAnnualSalary(){

		return annualSalary;
	}



}

package MeresaMeron_Project;


/**
 *
 * @author Mom and Dad
 */
//class Nurse
public class Nurse extends Employee{
	static int SHIFT_A=1;
	static int SHIFT_B=2;
	static int SHIFT_C=3;
	private int shift;
	//constructor
	/**
	 * Creates a new instance that represents Nurse
	 * @param unit where the nurse is stationed
	 * @param givenName first name of the nurse
	 * @param surname  last name of the nurse
	 */
	public Nurse(String unit,String givenName,String surname){  

		/*this will call parent class constructor, to initialization
         of variable */
		super(unit,givenName,surname);
		shift=SHIFT_A;

		//set default annualSalary
		super.annualSalary=80000;
	}

	//setShift() method
	/**
	 * 
	 * @param shift with shift the nurse is currently working 
	 */
	public void setShift(int shift){

		this.shift=shift;
		if(shift==SHIFT_A)
			super.annualSalary=80000;
		else if(shift==SHIFT_B)
			super.annualSalary=85000;
		else
			super.annualSalary=90000;
	}
	/**
	 * 
	 * @return all give information for the nurse converted to string
	 */
	@Override
	public String toString() {
		super.toString(); 
		return String.format(this.getFirstName()+" "+this.getLastName() + "("+super.unit+" unit,shift "+this.shift +")"); 
	}
	/**
	 * 
	 * @return  get shift for nurse and return
	 */
	public int getShift(){

		return this.shift;
	}
}

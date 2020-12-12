package MeresaMeron_Project;

public enum Treatment {

	PHYSICAL(5, 80.5), MENTAL(8, 105.49), TERMINAL(15, 199.99);

	private int days;
	private double cost;

	private Treatment(int days, double cost) {
		this.days = days;
		this.cost = cost;
	}
        /**
         * 
         * @return cost for treatment 
         */
	
	public double getCost() {
	    return cost;
	}
        /**
         * 
         * @return how long treatment will take in days
         */
	public int getTreatmentDays() {
		return days;
	}

}

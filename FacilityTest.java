package MeresaMeron_Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FacilityTest {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		//Hardcode some patients
		String[] givenNames = {
				"Avery", "Riley", "Jordan", "Angel", "Peyton",
				"Quinn", "Hayden", "Taylor", "Alexis", "Rowan",
				"Charlie", "Emerson", "Finley", "River", "Emery",
				"Morgan", "Elliot", "London", "Eden", "Elliott",
				"Karter", "Dakota", "Reese", "Remington", "Payton",
				"Amari", "Phoenix", "Kendall", "Harley", "Rylan",
				"Marley", "Dallas", "Skyler", "Spencer", "Sage",
				"Kyrie", "Ellis", "Rory", "Remi", "Justice",
				"Ali", "Haven", "Tatum", "Arden", "Linden",
				"Devon", "Rebel", "Rio", "Ripley", "Frankie"
		};

		String[] surnames = {
				"Smith", "Brown", "Tremblay", "Martin", "Roy",
				"Wilson", "Macdonald", "Gagnon", "Johnson", "Taylor",
				"Cote", "Campbell", "Anderson", "Leblanc", "Lee",
				"Jones", "White", "Williams", "Miller", "Thompson",
				"Gauthier", "Young", "Van", "Morin", "Bouchard",
				"Scott", "Stewart", "Belanger", "Reid", "Pelletier",
				"Moore", "Lavoie", "King", "Robinson", "Levesque",
				"Murphy", "Fortin", "Gagne", "Wong", "Clark",
				"Johnston", "Clarke", "Ross", "Walker", "Thomas",
				"Boucher", "Landry", "Kelly", "Bergeron", "Davis"
		};
		List<Patient> patients = new ArrayList<Patient>(); //queue of patients
		Treatment[] illnesses = Treatment.values();
		for(int i = 0; i < givenNames.length; i++) {
			int randIndex = (int)(Math.random()*3);
			patients.add(new Patient(givenNames[i], surnames[i], illnesses[randIndex]));
		}

		//Hardcode for nurses
		Nurse nurses[]=new Nurse[3];
		nurses[0]=new Nurse("Unit1","Greta","Devi");
		nurses[0].setShift(1);
		nurses[1]=new Nurse("Unit2","John","Connor");
		nurses[1].setShift(2);
		nurses[2]=new Nurse("Unit3","Sarah","Dawn");
		nurses[2].setShift(3);

		//Hardcode some doctors
		//Creates three or more Doctor instances.
		Doctor doctors[]=new Doctor[3];
		doctors[0]=new Doctor("Unit1",Treatment.TERMINAL,"Anup","Kumar");
		doctors[1]=new Doctor("Unit2",Treatment.PHYSICAL,"Carla","Esparza");
		doctors[2]=new Doctor("Unit3",Treatment.MENTAL,"Taylor","Wilson");

		//Create units of facility
		Unit[] units = new Unit[3];
		List<Employee> staff = new ArrayList<Employee>();
		staff.add(nurses[0]); //add first nurse to index 0
		staff.add(doctors[0]);//add first doctor to index 1
		units[0] = new Unit(staff, Treatment.TERMINAL);
		staff = new ArrayList<Employee>();
		staff.add(nurses[1]);
		staff.add(doctors[1]);
		units[1] = new Unit(staff, Treatment.PHYSICAL);
		staff = new ArrayList<Employee>();
		staff.add(nurses[2]);
		staff.add(doctors[2]);
		units[2] = new Unit(staff, Treatment.MENTAL);

		//Hardcode some beds
		Bed[] beds = new Bed[6];
		beds[0] = new Bed(1);
		beds[1] = new Bed(2, 15);
		beds[2] = new Bed(3);
		beds[3] = new Bed(4, 25);
		beds[4] = new Bed(5);
		beds[5] = new Bed(6);
		//Assign beds to units
		units[0].assignBed(beds[0]);
		units[0].assignBed(beds[5]);
		units[1].assignBed(beds[1]);
		units[1].assignBed(beds[4]);
		units[2].assignBed(beds[2]);
		units[2].assignBed(beds[3]);

		//Ready to loop and start simulation!
		ArrayList<Patient> patientsTreated = new ArrayList<Patient>();
		int daysLimit = 30;
		boolean stop = false;
		int currDay = 0;
		double totalIncome = 0;
		while(!stop && currDay < daysLimit) {
			currDay++;
			//Loop through pending patients in order they arrived
			for(Patient patient : patients) {
				//Check if patients needs a bed
				if(!patient.isAssigned()) {
					boolean done = false;
					for(Unit unit : units) {
						if(unit.getSpecialty() == patient.getIllness()) {
							//Find available bed
							for(Bed bed : unit.getBeds()) {
								if(bed.isAvailable()) {
									bed.setAssignedPatient(patient);
									patient.setUnit(unit);
									patient.checkIn(currDay);
									done = true;
									break;
								}
							}
							if(done) {
								break;
							}
						}
					}
				}
				//Handle patient if has a bed
				if(patient.isAssigned()) {
					//Check if patient has or can be assigned to a doctor
					if(patient.getPhysician() == null) {
						//Loop through all doctors looking for one available
						for(Employee employee : patient.getUnit().getStaffMembers()) {
							if(employee instanceof Doctor) {
								Doctor doctor = (Doctor)employee;
								if(doctor.isAvailable()) {
									patient.assignPhysician(doctor);
									doctor.assignPatient(patient);
									break;
								}
							}
						}
					}
					if(patient.getPhysician() != null) {
						patient.simulateDay();
						patient.charge(patient.getBed().getPrice());
						//Check if patient is treated completely!
						if(patient.getIllness() == null) {
							patientsTreated.add(patient);
							Doctor doctor = patient.getPhysician();
							patient.assignPhysician(null);
							doctor.assignPatient(null);
							patient.getBed().setAssignedPatient(null);
							patient.checkOut(currDay);
							totalIncome += patient.getOwes();
						}
					}
				}
			}
			//Remove all patients with no illness
			int i = 0;
			while(i < patients.size()) {
				Patient patient = patients.get(i);
				if(patient.getIllness() == null) {
					patients.remove(i);
				} else {
					i++;
				}
			}
			//Finally, ask user if we wants to continue
			System.out.println("Simulation done for day #"+currDay);
			System.out.print(">> Continue with next day? [N to stop, any otherwise]:" );
			String str = scan.nextLine();
			if(str.equals("N")) {
				stop = true;
			}
		}
		//Final report!
		//1. Print list of patients treated sorted by amount owed
		Collections.sort(patientsTreated);
		System.out.printf("%-30s%-30s\n","Patient Name","Amount owed");
		for(Patient patient : patientsTreated) {
			System.out.printf("%-30s$%-29.2f\n",patient.toString(),patient.getOwes());
		}
		//2. List of beds available
		System.out.println("\nBeds available:");
		for(Bed bed : beds) {
			if(bed.isAvailable()) {
				System.out.println(bed);
			}
		}
		//3. Print for total income
		System.out.printf("Total income for patients treated: $%.2f\n",totalIncome);
		//4. Loop to add all salaries
		double totalDoctors = 0;
		double totalNurses = 0;
		for(Doctor doctor : doctors) {
			totalDoctors += doctor.getAnnualSalary();
		}
		for(Nurse nurse : nurses) {
			totalNurses += nurse.getAnnualSalary();
		}
		System.out.printf("Total owed to doctors:\t$%.2f\n",totalDoctors);
		System.out.printf("Total owed to nurses:\t$%.2f\n",totalNurses);
		System.out.printf("Total owed for all employees:\t$%.2f\n",(totalDoctors+totalNurses));
		scan.close();
	}

}

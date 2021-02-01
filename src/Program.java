import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Program {					//This class has input file elements and work function
	private String temp;				//Input file 1. elements
	private String temp2;				//Input file without 1. elements
	
	public Program(String temp) {
		super();
		this.temp = temp;
	}
	
	public Program(String temp, String temp2) {
		super();
		this.temp = temp;
		this.temp2 = temp2;
	}

	public String getTemp2() {
		return temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public static void work(String argument1) throws FileNotFoundException {	//this function run other class function and
																				//print output.txt
		ArrayList <Patient> array = new ArrayList<>();				//arrays
		ArrayList <Admission> array1 = new ArrayList<>();
		ArrayList <Program> array2 = new ArrayList<>();
		ArrayList <Program> array3 = new ArrayList<>();
		ArrayList <Total> array4 = new ArrayList<>();
		
		File f = new File("patient.txt");							//read patient.txt
		Scanner patientxt = new Scanner(f);
		Patient.read(patientxt,array);
		
		File t = new File("admission.txt");							//read admission.txt
		Scanner admissiontxt = new Scanner(t);
		Admission.read(admissiontxt,array1);
		
		File y = new File(argument1);								//read input.txt with argument forms
		Scanner inputxt = new Scanner(y);
		Program.read(inputxt,array2);
		
		PrintStream patientTxt = new PrintStream(f);						//print patient.txt
		PrintStream outputTxt = new PrintStream(new File("output.txt"));	//print output.txt
		PrintStream admissionTxt = new PrintStream(t);						//print admission.txt

		for(Program emk:array2) {											//input file elements adds array2
			if(emk.getTemp().equals("ListPatients")) {
			}
			else {
				String[] arr=emk.getTemp().split(" ",2);
				array3.add(new Program(arr[0],arr[1]));
			}
		}
		String gecici1,gecici2,gecici3,gecici4,gecici5;
		int gecici6,gecici7;
		int total = 0;
		int total1 = 0;
		
		for(Program emk:array3) {								//input file function
			
			if(emk.getTemp().equals("AddPatient")) {			//Add patient function add new patient
				String[] arr = emk.getTemp2().split(" ",5);
				gecici1=arr[0];
				gecici2=arr[1];
				gecici3=arr[2];
				gecici4=arr[3];
				gecici5="Address: "+arr[4];
				array.add(new Patient(Integer.parseInt(gecici1),gecici2,gecici3,gecici4,gecici5));
				System.setOut(outputTxt);
				System.out.println("Patient "+gecici1+" "+gecici2+" added");
			}
			
			if(emk.getTemp().equals("RemovePatient")) {			//remove patient function delete patient
				int index=0;
				for(Patient emj:array) {
					if(emk.getTemp2().equals(Integer.toString(emj.getPatientId()))){
						System.setOut(outputTxt);
						System.out.println("Patient "+emj.getPatientId()+" "+emj.getPatientName()+" removed");
						break;
					}
					index++;;
				}
				array.remove(index);
			}
			
			if(emk.getTemp().equals("CreateAdmission")) {		//Create Admission Function add new admission
				String[] arr = emk.getTemp2().split(" ",2);
				gecici6 = Integer.parseInt(arr[0]);
				gecici7 = Integer.parseInt(arr[1]);
				System.setOut(outputTxt);
				System.out.println("Admission "+gecici6+" created");
				array1.add(new Admission(gecici6,gecici7));
			}
			
			if(emk.getTemp().equals("AddExamination")) {		//AddExaminaton Function add new examination
				String[] arr = emk.getTemp2().split(" ",3);
				gecici1=arr[1];
				gecici2=arr[2];
				System.setOut(outputTxt);
				System.out.println(gecici1+" examination added to admission "+arr[0]);
				array1.add(new Admission(gecici1,gecici2));
				total = Total.calculate(gecici1, gecici2, total);
				array4.add(new Total(Integer.parseInt(arr[0]),gecici1,gecici2,total));
				total=0;
			}
			
			if(emk.getTemp().equals("TotalCost")) {				//Total Cost function print total fee
				System.setOut(outputTxt);
				System.out.println("TotalCost for admission "+emk.getTemp2());
				for(Total emj:array4) {
					if(Integer.parseInt(emk.getTemp2())==emj.getPatientId()) {
						System.setOut(outputTxt);
						System.out.println("	"+emj.getExamination()+" "+emj.getOperation()+" "+emj.getTotal()+"$");
						total1+=emj.getTotal();
					}
				}
				System.out.println("	"+"Total: "+total1+"$");
				total1=0;
			}
		}
		
		Collections.sort(array,Comparator.comparing(Patient::getPatientId));	//sort array by patient ID
		for(Patient emk:array) {												//print list patient in patient.txt
			System.setOut(patientTxt);
			System.out.println(emk.getPatientId()+"	"+emk.getPatientName()+" "+emk.getPatientSurname()+"	"+emk.getPatientPhone()+"	"+emk.getPatientAddress());
		}
		System.setOut(outputTxt);
		
		System.out.println("Patient List:");
		Collections.sort(array,Comparator.comparing(Patient::getPatientName));	//sort array by patient name
		for(Program emk:array2) {
			if(emk.getTemp().equals("ListPatients")) {							//print list patient in output.txt
				for(Patient emj:array) {
					System.setOut(outputTxt);
					System.out.println(emj.getPatientId()+" "+emj.getPatientName()+" "+emj.getPatientSurname()+" "+emj.getPatientPhone()+" "+emj.getPatientAddress());
				}
			}
		}
		
		for(Admission emk:array1) {												//print admission list in admission.txt
			if(emk.getAdmissionID()!=0) {
				System.setOut(admissionTxt);
				System.out.println(emk.getAdmissionID()+"	"+emk.getPatientID());
			}
			else {
				System.setOut(admissionTxt);
				System.out.println(emk.getExaminationType()+"	"+emk.getOperation());
			}
		}
		
	}
	
	public static void read(Scanner path,ArrayList<Program> array) {			//read function
		while(path.hasNextLine()==true) {
			String arr = path.nextLine();
				array.add(new Program(arr));
		}
	}
	

}

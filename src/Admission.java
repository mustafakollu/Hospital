import java.util.ArrayList;
import java.util.Scanner;

public class Admission {											//This class holds admission's elements
	private String examinationType;
	private String operation;
	private int admissionID ;
	private int patientID;
	
	public Admission(int admissionID, int patientID) {				//1. constructor
		super();
		this.admissionID = admissionID;
		this.patientID = patientID;
	}

	public Admission(String examinationType, String operation) {	//2. constructor
		super();
		this.examinationType = examinationType;
		this.operation = operation;
	}

	public int getAdmissionID() {									//getter setter methods
		return admissionID;
	}

	public void setAdmissionID(int admissionID) {
		this.admissionID = admissionID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public String getExaminationType() {
		return examinationType;
	}

	public void setExaminationType(String examinationType) {
		this.examinationType = examinationType;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public static void read(Scanner path,ArrayList<Admission> array1) {				//read function
		while(path.hasNextLine()==true) {
			
			if(path.hasNextInt()==true) {
				String l1 = path.nextLine();
				String[] arr=l1.split("	");
				array1.add(new Admission(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])));
			}
			
			if(path.hasNextInt()==false) {
				String l1 = path.nextLine();
				String[] arr=l1.split("	");
				array1.add(new Admission(arr[0],arr[1]));
			}
		}
	}
}

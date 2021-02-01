import java.util.ArrayList;
import java.util.Scanner;

public class Patient {					//This class holds patient's elements
	private int patientId;
	private String patientName;
	private String patientSurname;
	private String patientAddress;
	private String patientPhone;
	
	public Patient(int patientId, String patientName, String patientSurname,String patientPhone, String patientAddress) {
		super();											// Patient's constructor
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientSurname = patientSurname;
		this.patientPhone = patientPhone;
		this.patientAddress = patientAddress;
	}

	public int getPatientId() {								//Getter Setter methods
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSurname() {
		return patientSurname;
	}
	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public static void read(Scanner path,ArrayList<Patient> array) {		//Read Function
		while(path.hasNextLine()==true) {
			String l1 = path.nextLine();
			String[] arr=l1.split("	");
			String[] arr1=arr[1].split(" ");
				array.add(new Patient(Integer.parseInt(arr[0]),arr1[0],arr1[1],arr[2],arr[3]));
		}
		
	}

}

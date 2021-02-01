
public class Total{								// This class holds Total function's elements

	private int patientId;
	private String examination;
	private String operation;
	private int total;
	
	public Total(int patientId, String examination, String operation, int total) {		//constructor
		super();
		this.patientId = patientId;
		this.examination = examination;
		this.operation = operation;
		this.total = total;
	}
	
	public int getPatientId() {									//getter setter function
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public String getExamination() {
		return examination;
	}
	public void setExamination(String examination) {
		this.examination = examination;
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	public static int calculate(String examinationType,String operation,int total) { //Calculate and return total fee
		
		if(examinationType.equals("Inpatient")) {
			Examination inpatient= new Inpatient();
			total+=inpatient.cost();
		}
		if(examinationType.equals("Outpatient")) {
			Examination outpatient = new Outpatient();
			total+=outpatient.cost();
		}
		if(operation.length()==25) {
			total+=32;
		}
		if(operation.length()==30) {
			total+=27;
		}
		if(operation.length()==32) {
			total+=30;
		}
		if(operation.length()==26) {
			Examination aaa = new Imaging();
			total+=aaa.cost();
		}
		if(operation.length()==17) {
			total+=22;
		}
		if(operation.length()==19) {
			total+=25;
		}
		if(operation.length()==24) {
			total+=20;
		}
		if(operation.length()==13) {
			total+=17;
		}
		if(operation.length()==18) {
			Examination bbb = new Test();
			total+=bbb.cost();
		}
		if(operation.length()==20) {
			total+=15;
		}
		if(operation.length()==11) {
			total+=15;
		}
		if(operation.length()==5) {
			total+=7;
		}
		if(operation.length()==7) {
			total+=10;
		}
		if(operation.length()==12) {
			Examination ccc = new Measurement();
			total+=ccc.cost();
		}
		return total;
	}
}

package model;

public class Employee {
	public static final int SMMLV = 887803;
	public static final int AUX_TRANSPORTE = 102854;
	public static final double PCT_SALUD = 0.04;
	public static final double PCT_PENSION = 0.04;
	private String name;
	private int salary;
	private String id;
	private String charge;
	private String dependency;
	private String dateOfAdmission;
	
	public Employee(String name, int salary, String id, String charge, String dependency, String dateOfAdmission) {
		this.name = name;
		this.salary = salary;
		this.id = id;
		this.charge = charge;
		this.dependency = dependency;
		this.dateOfAdmission = dateOfAdmission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getDependency() {
		return dependency;
	}

	public void setDependency(String dependency) {
		this.dependency = dependency;
	}

	public String getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(String dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public static int getSmmlv() {
		return SMMLV;
	}
	
}

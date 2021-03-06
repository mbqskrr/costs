package model;

public class Employee {
	public static final int SMMLV = 887803;
	public static final int AUX_TRANSPORTE = 102854;
	public static final double PCT_SALUD = 0.04;
	public static final double PCT_PENSION = 0.04;
	public static final double PCT_SUNDAYSM = 2;
	public static final double PCT_SUNDAYSE = 2.50;
	public static final double PCT_MORNING =1.25;
	public static final double PCT_EVENING = 1.75;
	private String name;
	private int salary;
	private String id;
	private String charge;
	private String dependency;
	private String dateOfAdmission;
	private boolean state;
	private int totalextraHours;
	private int morningHours;
	private int eveningHours;
	private int sundayMHours;
	private int sundayEHours;
	private int commissions;
	private int workedDays;
	
	public Employee(String name, int salary, String id, String charge, String dependency, String dateOfAdmission, boolean state) {
		this.name = name;
		this.salary = salary;
		this.id = id;
		this.charge = charge;
		this.dependency = dependency;
		this.dateOfAdmission = dateOfAdmission;
		this.state = state;
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

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getTotalextraHours() {
		return totalextraHours;
	}

	public void setTotalextraHours(int totalextraHours) {
		this.totalextraHours = totalextraHours;
	}

	public int getMorningHours() {
		return morningHours;
	}

	public void setMorningHours(int morningHours) {
		this.morningHours = morningHours;
	}

	public int getEveningHours() {
		return eveningHours;
	}

	public void setEveningHours(int eveningHours) {
		this.eveningHours = eveningHours;
	}

	public int getSundayMHours() {
		return sundayMHours;
	}

	public void setSundayMHours(int sundayMHours) {
		this.sundayMHours = sundayMHours;
	}

	public int getCommissions() {
		return commissions;
	}

	public void setCommissions(int commissions) {
		this.commissions = commissions;
	}

	public int getWorkedDays() {
		return workedDays;
	}

	public void setWorkedDays(int workedDays) {
		this.workedDays = workedDays;
	}

	public int getSundayEHours() {
		return sundayEHours;
	}

	public void setSundayEHours(int sundayEHours) {
		this.sundayEHours = sundayEHours;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", id=" + id + ", charge=" + charge + ", dependency="
				+ dependency + ", dateOfAdmission=" + dateOfAdmission + ", state=" + state + "]";
	}
	
	
	
}

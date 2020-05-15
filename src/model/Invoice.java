package model;

public class Invoice {
	
	private Employee employee;
	private Company company;
	private int salary;
	private int voh;
	
	public Invoice() {
		salary = employee.getSalary();
		voh = salary/240;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public int auxTrans() {
		int aux;
		if (salary > Employee.SMMLV*2) {
			aux = 0;
		} else {
			aux = Employee.AUX_TRANSPORTE;
		}
		return aux;
	}
	
	public int basic() {
		int basic = (salary/30)*employee.getWorkedDays();
		return basic;
	}
	
	/**
	 * Retorna las horas extras diurnas
	 * @return
	 */
	public int daytimeOvertime() {
		int dtot = (int) (voh*Employee.PCT_MORNING*employee.getMorningHours());
		return dtot;
	}
	
	/**
	 * Retorna las horas extras nocturnas
	 * @return
	 */
	public int extraNightTime() {
		int ent = (int) (voh*Employee.PCT_EVENING*employee.getEveningHours());
		return ent;
	}
	
	/**
	 * Calcula las horas extras totales
	 * @return
	 */
	public int overtime() {
		int ot = extraNightTime()+daytimeOvertime();
		return ot;
		
	}



}

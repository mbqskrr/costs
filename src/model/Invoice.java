package model;

public class Invoice {
	
	private Employee employee;
	private Company company;
	/*int salary = employee.getSalary();
	int voh = salary/240;*/

	/*public Invoice(PayrollController  prc) {
		salary = employee.getSalary();
		voh = salary/240;
	}*/
	
	public Invoice(Employee e, Company c) {
		employee = e;
		company = c;
	}
	
	public Invoice() {
		
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
		//if (salary > Employee.SMMLV*2) {
		if(employee.getSalary()>Employee.SMMLV) {
			aux = 0;
		} else {
			aux = Employee.AUX_TRANSPORTE;
		}
		return aux;
	}
	
	public int basic() {
		//int basic = (salary/30)*employee.getWorkedDays();
		int basic = (employee.getSalary()/30)*employee.getWorkedDays();
		return basic;
	}
	
	/**
	 * Retorna las horas extras diurnas
	 * @return
	 */
	public int daytimeOvertime() {
		//int dtot = (int) (voh*Employee.PCT_MORNING*employee.getMorningHours());
		int dtot = (int) ((employee.getSalary()/240)*Employee.PCT_MORNING*employee.getMorningHours());
		return dtot;
	}
	
	/**
	 * Retorna las horas extras nocturnas
	 * @return
	 */
	public int extraNightTime() {
		//int ent = (int) (voh*Employee.PCT_EVENING*employee.getEveningHours());
		int ent = (int) ((employee.getSalary()/240)*Employee.PCT_EVENING*employee.getEveningHours());
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
	
	/**
	 * Calcula las horas extras dominicales diurnas
	 * @return
	 */
	public int sundayExtraDaytime() {
		//int sed = (int) (voh*Employee.PCT_SUNDAYSM*employee.getSundayMHours());
		int sed = (int) ((employee.getSalary()/240)*Employee.PCT_SUNDAYSM*employee.getSundayMHours());
		return sed;
	}
	
	/**
	 * Calcula las horas extras nocuturnas dominicales 
	 * @return
	 */
	public int sundayNightExtraHour() {
		int sneh = (int) ((employee.getSalary()/240)*Employee.PCT_SUNDAYSE*employee.getSundayMHours());
		return sneh;
	}

	/**
	 * Calcula el total devengado
	 * @return
	 */
	public int totalAccrued() {
		int ta = (basic()+auxTrans()+overtime()+sundayExtraDaytime()+sundayNightExtraHour()+employee.getCommissions());
		return ta;
	}

	public int health() {
		//int health=(int) (salary*Employee.PCT_SALUD);
		int health=(int) (employee.getSalary()*Employee.PCT_SALUD);
		return health;
	}
	
	public int pension() {
		//int p=(int) (salary*Employee.PCT_PENSION);
		int p=(int) (employee.getSalary()*Employee.PCT_PENSION);
		return p;
	}
	
	public int totalDeducted() {
		int td = health()+pension();
		return td;
	}
	
	public int payment() {
		int payment = totalAccrued()-totalDeducted();
		return payment;
	}


}

package model;

public class Provisions {
	
	private int eSalary;
	private int accured;
	
	public Provisions(int eSalary, int accured) {
		this.eSalary = eSalary;
		this.accured = accured;
	}
	
	//Prestaciones sociales
	
	public int vacation() {
		int v;
		if (eSalary>Employee.SMMLV*2) {
			v = (int) ((accured-Employee.AUX_TRANSPORTE)*Company.PCT_VACACIONES);
		} else {
			v = (int) (accured*Company.PCT_VACACIONES);
		}
		return v;
	}
	
	public int layoffs() {
		int lo=(int) (accured*Company.PCT_CESANTIAS);
		return lo;
	}
	
	public int interestsLo() {
		int ilo = (int) (layoffs()*Company.PCT_INTERESES_CESANTIAS);
		return ilo;
	}
	
	public int premiumServices() {
		int ps = (int) (accured*Company.PCT_PRIMA_SERVICIOS);
		return ps;
	}
	
	//Seguridad social

}

package model;

public class Provisions {

	private int eSalary;
	private int accured;

	public Provisions(int eSalary, int accured) {
		this.eSalary = eSalary;
		this.accured = accured;
	}

	// Prestaciones sociales

	public int vacation() {
		int v;
		if (eSalary > Employee.SMMLV * 2) {
			v = (int) ((accured - Employee.AUX_TRANSPORTE) * Company.PCT_VACACIONES);
		} else {
			v = (int) (accured * Company.PCT_VACACIONES);
		}
		return v;
	}

	public int layoffs() {
		int lo = (int) (accured * Company.PCT_CESANTIAS);
		return lo;
	}

	public int interestsLo() {
		int ilo = (int) (layoffs() * Company.PCT_INTERESES_CESANTIAS);
		return ilo;
	}

	public int premiumServices() {
		int ps = (int) (accured * Company.PCT_PRIMA_SERVICIOS);
		return ps;
	}

	// Seguridad social

	public int heatlh() {
		int h;
		if (eSalary > Employee.SMMLV * 2) {
			 h = (int) (accured * Company.PCT_SALUD);
		}else {
			 h = (int) ((accured - Employee.AUX_TRANSPORTE) * Company.PCT_SALUD);
		}
		
		return h;
	}

	public int pension() {
		int p;
		if (eSalary > Employee.SMMLV * 2) {
			p = (int) (accured * Company.PCT_PENSION);
		}else {
			p = (int) ((accured - Employee.AUX_TRANSPORTE) * Company.PCT_PENSION);
		}
		return p;
	}

	public int arl() {
		int arl;
		if (eSalary > Employee.SMMLV * 2) {
			arl = (int) (accured * Company.PCT_SEGURIDAD_SOCICAL);
		} else {
			arl = (int) ((accured - Employee.AUX_TRANSPORTE) * Company.PCT_SEGURIDAD_SOCICAL);
		}
		return arl;
	}

	// Parafiscales

	public int sena() {
		int s;
		if (eSalary > Employee.SMMLV * 2) {
			s = (int) (accured*Company.PCT_SENA);
		}else {
			s = (int) ((accured-Employee.AUX_TRANSPORTE)*Company.PCT_SENA);
		}
		return s;
	}
	
	public int icbf() {
		int icbf;
		if (eSalary > Employee.SMMLV * 2) {
			icbf = (int) (accured*Company.PCT_ICBF);
		}else {
			icbf = (int) ((accured-Employee.AUX_TRANSPORTE)*Company.PCT_ICBF);
		}
		return icbf;
	}
	
	public int cc() {
		int cc;
		if (eSalary > Employee.SMMLV * 2) {
			cc = (int) (accured*Company.PCT_CAJA_COMPENSACION);
		}else {
			cc = (int) ((accured-Company.PCT_CAJA_COMPENSACION)*Company.PCT_CAJA_COMPENSACION);
		}
		return cc;
	}
}

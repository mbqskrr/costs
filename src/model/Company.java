package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.HashMap;

public class Company {
	
	public static final double PCT_CAJA_COMPENSACION = 0.04;
	public static final double PCT_ICBF = 0.03;
	public static final double PCT_SENA = 0.02;
	public static final double PCT_PRIMA_SERVICIOS = 0.0833;
	public static final double PCT_CESANTIAS = 0.0833;
	public static final double PCT_INTERESES_CESANTIAS = 0.12;
	public static final double PCT_VACACIONES = 0.0417;
	public static final double PCT_SALUD = 0.085;
	public static final double PCT_PENSION = 0.12;
	public static final double PCT_SEGURIDAD_SOCICAL = 0.00522;
	public final static String PATH = ".\\\\data\\\\employees.txt";
	private String name;
	private String nit;
	//private ArrayList<Employee> employeeArray;
	private HashMap<String, Employee> idMap;
	private HashMap<Employee, Employee> empMap;
	
	public Company(String name, String nit) {
		this.name = name;
		this.nit = nit;
		//employeeArray = new ArrayList<Employee>();
		idMap = new HashMap<String, Employee>();
		empMap = new HashMap<Employee, Employee>();
	}
	
	public Company() {
		//employeeArray = new ArrayList<Employee>();
		idMap = new HashMap<String, Employee>();
		empMap = new HashMap<Employee, Employee>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNit() {
		return nit;
	}
	
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	/*public ArrayList<Employee> getEmployeeArray() {
		return employeeArray;
	}*/
	
	public HashMap<String, Employee> getIdMap() {
		return idMap;
	}

	public HashMap<Employee, Employee> getEmpMap() {
		return empMap;
	}

	public void importReport(String sep) throws IOException {
		File f = new File(PATH);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while ((line = br.readLine())!=null) {
			String[] parts = line.split(sep);
			String name = parts[0];
			int salary = Integer.parseInt(parts[1]);
			String id = parts[2];
			String charge = parts[3];
			String dependency = parts[4];
			String doa = parts[5];
			boolean state = Boolean.parseBoolean(parts[6]);
			Employee e = new Employee(name, salary, id, charge, dependency, doa, state);
			idMap.put(e.getId(), e);
			empMap.put(e, e);
			//employeeArray.add(e);
			//line = br.readLine();
		}
		br.close();
		fr.close();
	}

	public void exportReport() throws FileNotFoundException{
		String msg = "Nombre;Salario;ID;Cargo;Dependencia;Fecha de admision;Estado\n";
		/*for (int i = 0; i < employeeArray.size(); i++) {
			Employee current = employeeArray.get(i);
			msg+=current.getName()+";"+current.getSalary()+";"+current.getId()+";"+current.getCharge()+";"+current.getDependency()+";"+current.getDateOfAdmission()+";"+current.getState()+"\n";
		}*/
		for (Employee e : idMap.values()) {
			msg+=e.getName()+";"+e.getSalary()+";"+e.getId()+";"+e.getCharge()+";"+e.getDependency()+";"+e.getDateOfAdmission()+";"+e.getState()+"\n";
		}
		PrintWriter pw = new PrintWriter(new File(PATH));
		pw.print(msg);
		pw.close();
	}
	
	public void modify(Employee emp) {
		Employee objEmp = search(emp);
		if (objEmp!=null) {
			idMap.remove(emp.getId(), emp);
		}
		
	}
	
	public Employee search(Employee e) {
		Employee emp = null;
		for (Employee employee : idMap.values()) {
			if (employee.getId().equals(e.getId())) {
				emp = employee;
			}
		}
		return emp;
	}
	
}

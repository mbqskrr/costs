package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Company {
	
	public final static String PATH = ".\\\\data\\\\employees.txt";
	private String name;
	private String nit;
	private ArrayList<Employee> employeeArray;
	
	public Company(String name, String nit) {
		this.name = name;
		this.nit = nit;
		employeeArray = new ArrayList<Employee>();
	}
	
	public Company() {
		employeeArray = new ArrayList<Employee>();
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
	
	public ArrayList<Employee> getEmployeeArray() {
		return employeeArray;
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
			Employee e = new Employee(name, salary, id, charge, dependency, doa);
			employeeArray.add(e);
			//line = br.readLine();
		}
		br.close();
		fr.close();
	}
	
	public void exportReport() throws FileNotFoundException{
		String msg = "";
		for (int i = 0; i < employeeArray.size()-1; i++) {
			Employee current = employeeArray.get(i);
			msg+=current.getName()+";"+current.getSalary()+";"+current.getId()+";"+current.getCharge()+";"+current.getDependency()+";"+current.getDateOfAdmission()+"\n";
		}
		PrintWriter pw = new PrintWriter(new File(PATH));
		pw.print(msg);
		pw.close();
	}
	
	
	
}

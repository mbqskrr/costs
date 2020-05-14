package model;

import java.util.ArrayList;

public class Company {
	
	private String name;
	private String nit;
	private ArrayList<Employee> e;
	
	public Company(String name, String nit) {
		this.name = name;
		this.nit = nit;
	}
	
	public Company() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Employee> getE() {
		return e;
	}
	
	public void setE(ArrayList<Employee> e) {
		this.e = e;
	}
	
	public String getNit() {
		return nit;
	}
	
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	
	
}

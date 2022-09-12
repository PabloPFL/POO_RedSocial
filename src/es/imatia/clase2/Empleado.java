package es.imatia.clase2;

import java.util.Date;

public class Empleado {
	
	// Atributos
	public String nombre;
	public int edad;
	public Date fechaIngreso;
	public double salario;
	public Date hoy = new Date();
	
	public static final double BONO=1000;
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
	// Constructor
	public Empleado(String nombre, int edad, Date fechaIngreso, double salario ) {
		this.nombre = nombre;
		this.edad = edad;
		this.fechaIngreso = fechaIngreso;
		this.salario = salario;
	}
	
	
	
	// Métodos
	public void incentivar() {
		System.out.println("Este empleado no tiene ningún tipo de incentivo definido.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

package es.imatia.clase2;

import java.util.Date;

public class Operario extends Empleado {
	
	//Atributos
	public int nivelSeguridad = 0;
	
	
	//Constructor
	public Operario(String nombre, int edad, Date fechaIngreso, double salario, int nivelSeguridad) {
		super(nombre, edad, fechaIngreso, salario);
		if (nivelSeguridad <= 5 && nivelSeguridad > 0) {
			this.nivelSeguridad = nivelSeguridad;
		} else {
			System.out.println("El nivel de seguridad tiene que estar comprendido entre 1 y 5!!");
		}
	}
	
	@Override
	public void incentivar() {
		if (nivelSeguridad > 2 && edad > 30) {
			salario = salario + 2*BONO;
			System.out.println("Nivel de seguridad >2 y mayor de 30 años: Doble bonificación");
		} else if (nivelSeguridad > 2 || edad > 30) {
			System.out.println("Nivel de seguridad >2 o mayor de 30 años: Bonificación simple");
		}
		
		System.out.println("Nuevo salario: " + salario);
	}

	
	

}

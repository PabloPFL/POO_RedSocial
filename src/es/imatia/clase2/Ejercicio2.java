package es.imatia.clase2;

import java.util.Date;

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Date fechaIngreso = new Date(2020,1,6);
		Date hoy = new Date();
		System.out.println("Fecha de ingreso: " + fechaIngreso.getYear() + "-" + fechaIngreso.getMonth() + "-" + fechaIngreso.getDay());		
		System.out.println(hoy.getYear()+1900);
		System.out.println(fechaIngreso.getMonth());
		
		System.out.println(fechaIngreso.getYear());
		
		Empleado miEmpleado = new Empleado("Manu", 31, fechaIngreso, (double) 1000);
		Director miDirector = new Director("Manu", 31, fechaIngreso, (double) 1000, "Magia", 21);
		Operario miOperario = new Operario("Manu", 30, fechaIngreso, (double) 1000, 1);
		
		System.out.println("Empleado: ");
		miEmpleado.incentivar();
		System.out.println("\n ");
		
		System.out.println("Director: ");
		miDirector.incentivar();
		System.out.println("\n ");
		
		System.out.println("Operario: ");
		miOperario.incentivar();
		System.out.println("\n ");
		

	}

}

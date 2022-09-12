package es.imatia.clase2;

import java.util.Date;


public class Director extends Empleado {
	
	// Atributos
	public String departamento;
	public int personal;
	
	
	//Constructor
	public Director(String nombre, int edad, Date fechaIngreso, double salario, String departamento, int personal) {
		super(nombre, edad, fechaIngreso, salario);
		this.departamento = departamento;
		this.personal = personal;
	}
	
	
	//Métodos
	
	@Override
	
	public void incentivar() {
		
		int mesesActivo = (hoy.getYear()+1900) * 12 +  hoy.getMonth() - fechaIngreso.getYear() * 12 - fechaIngreso.getMonth();
		System.out.println(mesesActivo + " meses activo");
		
		if (mesesActivo >= 30 && personal >= 20) {
			salario = salario + 2 * BONO;
			System.out.println(">30 meses y más de 20 empleados: Bono * 2.");
		} else if (mesesActivo >= 30 || personal >= 20) {
			salario = salario + BONO; 
			System.out.println(">30 meses o más de 20 empleados: Bono * 2.");
		}
		System.out.println("Nuevo salario: " + salario);
		
	}


}

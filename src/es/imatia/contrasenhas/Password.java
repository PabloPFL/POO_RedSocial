package es.imatia.contrasenhas;


import java.util.Random;
import java.util.stream.IntStream;

public class Password {
	
	// Atributos
	public int longitud=8;
	public String pass;
	
	
	//Getters & Setters
	public String getPass() {
		return pass;
	}
    void setPass(String pass) {
		this.pass = pass;
	}
    
	public int getLongitud() {
		return longitud;
	}
	
	//Constructores
	
	public Password(String pass, int longitud) { 
		this.pass = pass;
		this.longitud = longitud;
		
	}
	
	public void generarPassword() {
		String [] generador = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
				"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
				"0","1","2","3","4","5","6","7","8","9"};
		Random r = new Random(); 
		int k = r.nextInt(generador.length);
		
		
		System.out.println(k);
		
		/*
		for(int i=0; i<getLongitud()-1;i++) {
			k = r.nextInt(generador.length);
			System.out.println(k);
		}
		*/
		
		
		
		//IntStream arrayRandom = r.ints(getLongitud(),0,generador.length-1);
		
		//for (int i=0; i<getLongitud()-1; i++) {}
		
		//System.out.println(generador[61]);
		//arrayRandom.forEach(value -> System.out.println("Número aleatorio: " + value));
		//System.out.println(arrayRandom);
		
		
		
		
		}
		
		
		
}

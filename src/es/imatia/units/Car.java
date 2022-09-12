package es.imatia.units;

import java.lang.Math;


public class Car {
	
	/* Atributos */
	public String brand;
	public String model;
	public static final int MAX_SPEED = 120;
	public static final int R_MAX_SPEED = 25;
	public String fuel;
	public int speedometer = 0;
	public int tachometer = 0;
	
	public boolean reverse = false;
	int steeringWheelAngle = 0;
	String steerringWheelSide = "Straight";
	public String gear = "N";
	
	/* Getters & Setters */
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getSpeedometer() {
		return speedometer;
	}
	public void setSpeedometer(int speedometer) {
		this.speedometer = speedometer;
	}

	public int getTachometer() {
		return tachometer;
	}
	public void setTachometer(int tachometer) {
		this.tachometer = tachometer;
	}
	
	
	/* Constructor */
	public Car(String brand, String model, String fuel) {
		this.brand = brand;
		this.model = model;
		this.fuel = fuel;
	}
	
	public Car() {
		this.brand = "Seat";
		this.model = "León";
		this.fuel = "Gasolina";
	}
	
	public static void main(String[] args) {
		Car myCar = new Car("Citroën", "Xsara", "Diésel");
		Car myCar2 = new Car();
		
		String option = "";
		System.out.println();
		do {
		System.out.println();
		myCar.showDetails();
		option = Input.string("Selección: \n '+' - Acelerar\n '-' - Frear\n 'n' - Marcha directa\n 'r' - Marcha atrás\n 'd' - Xirar a dereita\n 'i' - Xirar a esquerda\n 'end' - Acaba o programa \n ¿Qué opción desexa facer?: ");
		System.out.println();
		switch (option) {
		case "+":
		myCar.accelerate();
		break;
		case "-":
		myCar.brake();
		break;
		case "r":
		myCar.setReverse(true);
		break;
		case "n":
		myCar.setReverse(false);
		break;
		case "d":
		myCar.turnSteeringWheel(5);
		break;
		case "i":
		myCar.turnSteeringWheel(-5);
		break;
		case "end":
		break;
		default:
		System.out.println("Non existe esa opción");
		break;
		}
		} while (!option.equalsIgnoreCase("end"));
		
		myCar.showDetails();
	}

	/* Métodos */
	
	public void start() {
		if (this.tachometer == 0) {
			this.tachometer = 1000;
			System.out.println("Vehículo encendido.");
		} else {
			System.out.println("El vehículo ya está encendido");
		}
	}
	
	public void stop() {
		if (this.speedometer == 0) {
			this.tachometer = 0;
			System.out.println("Vehículo apagado");
		} else {
			System.out.println("No se puede apagar el vehículo, detener vehículo primero");
		}
	}
	
	public void accelerate() {
		int maxSpeed = MAX_SPEED;
		
		if (this.reverse) {
			maxSpeed = R_MAX_SPEED;
		}
		
		if (this.tachometer == 0) {
			System.out.println("No puedes se puede acelerar. Encender el vehículo primero");
		} else {
			if(this.speedometer + 5 <= maxSpeed) {
				this.speedometer = this.speedometer + 5;
				if (maxSpeed == MAX_SPEED) { calculateTachometer(); }
			} else {
				System.out.println("No se puede superar la velocidad máxima.");
			}
		}
	}
	
	public void brake() {
		if (this.speedometer - 5 >= 0) {
			this.speedometer = this.speedometer - 5;
		} else {
			this.speedometer = 0;
		}
	}
	
	public int turnSteeringWheel(int angle) {
		if (angle <= 45 && angle >= -45) {
			this.steeringWheelAngle = angle;
			if (angle > 0) {
				this.steerringWheelSide = "Right";
			} else if (angle < 0) {
				this.steerringWheelSide = "Left";
			} else {
				this.steerringWheelSide = "Straight";
			}
			
			
			return angle;
		} else {
			System.out.println("El ángulo de giro debe estar comprendido entre -45º y 45º");
			return 0;
		}
	}
	
	
	public void setReverse(boolean reverse) {
		if (speedometer != 0) {
			System.out.println("Es necesario detener el vehículo primero");
		} else {
			if (reverse) {
				this.gear = "R";
			} else {
				this.gear = "N";
			}
		}
	}
	
	private void calculateTachometer() {
		double gearVel = (float) this.speedometer/25;
		double gearVelInt = Math.floor(gearVel);
		
		this.gear = Integer.toString((int) (gearVelInt) +1);
		double fract = gearVel - gearVelInt;
		
		this.tachometer = (int) ((fract*100*1500/100)+1000);
	}
	
	
	public void showDetails() {
		System.out.println("Brand: " + this.brand +  "    Model: " + this.model + "    Fuel: " + this.fuel);
		System.out.println("\nSpeed/Max_Speed: " + this.speedometer  + "/" + MAX_SPEED + "        " + "Rpm: " + this.tachometer);
		System.out.println("Gear: " + this.gear);
	    System.out.println("Steering wheel angle : " + Math.abs(this.steeringWheelAngle) + "   Direction: " + this.steerringWheelSide);

	}
	
	
	
	
	
	
}

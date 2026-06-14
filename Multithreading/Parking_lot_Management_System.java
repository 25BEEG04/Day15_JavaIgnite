package JavaIgniteDay15;

class Parkinglot {
	int availableslots = 3;
	synchronized void parkCar(String carname) {
		if(availableslots > 0) {
			System.out.println("Sucessfully parked : " +carname);
			availableslots--;
			System.out.println("Available slots :" +availableslots);
		}
		else {
			System.out.println("Cant park...slots fulled !!");
		}
	}
}

class Carthread extends Thread {
	Parkinglot parkinglot;
	String carname;
	
	Carthread(Parkinglot parkinglot, String carname) {
		this.parkinglot = parkinglot;
		this.carname = carname;
	}
	public void run() {
		parkinglot.parkCar(carname);
	}
}
public class Parking_lot_Management_System {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parkinglot parkinglot = new Parkinglot();
		Carthread car1 = new Carthread(parkinglot, "Car 1");
		Carthread car2 = new Carthread(parkinglot, "Car 2");
		Carthread car3 = new Carthread(parkinglot, "Car 3");
		Carthread car4 = new Carthread(parkinglot, "Car 4");
		Carthread car5 = new Carthread(parkinglot, "Car 5");
		Carthread car6 = new Carthread(parkinglot, "Car 6");
		car1.start();
		car2.start();
		car3.start();
		car4.start();
		car5.start();
		car6.start();
    }
}

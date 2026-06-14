package JavaIgniteDay15;

class Threater {
	int totalseats = 5;
	synchronized void bookseat(int seats,String threadname) {
		if(totalseats >= seats) {
			System.out.println(threadname + ": Booking Sucessful");
			totalseats = totalseats - seats;
			System.out.println("Remaing seats: "+totalseats);
		}
		else {
			System.out.println(threadname + ": Booking failed");
		}
	}
}
class bookingthread extends Thread {
	Threater threater;
	int seatsreq;
	String threadname;
	bookingthread(Threater threater ,int seatsreq,String threadname) {
		this.seatsreq=seatsreq;
		this.threater=threater;
		this.threadname = threadname;
	}
	public void run() {
		threater.bookseat(seatsreq,threadname);
	}
}
public class TicketBookingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Threater threater = new Threater();
		bookingthread t1 = new bookingthread(threater,2,"Thread1");
		bookingthread t2 = new bookingthread(threater,2,"Thread2");
		bookingthread t3 = new bookingthread(threater,2,"Thread3");

		t1.start();
		t2.start();
		t3.start();
	}

}

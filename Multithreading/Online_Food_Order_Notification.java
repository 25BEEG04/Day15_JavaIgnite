package JavaIgniteDay15;
import java.util.*;
interface Notificationservice {
	public void sendmessage();
}

class Emailnotification implements Notificationservice {
	public void sendmessage() {
		System.out.println("Notification sent through email");
	}	
}
class Smsnotification implements Notificationservice {
	public void sendmessage() {
		System.out.println("Notification sent through sms");
	}	
}
class Orderservice {
	Notificationservice notificationservice;
	Orderservice(Notificationservice notificationservice) {
		this.notificationservice = notificationservice;
	}
	void placeorder() {
		System.out.println("Your order is confirmed !");
		notificationservice.sendmessage();
	}
}
public class Online_Food_Order_Notification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Emailnotification email = new Emailnotification();
		Orderservice ord1 = new Orderservice(email);
		ord1.placeorder();
		
		Smsnotification sms = new Smsnotification();
		Orderservice ord2 = new Orderservice(sms);
		ord2.placeorder();
	}
}

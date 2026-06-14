package JavaIgniteDay15;

class Classroom {
	boolean attendancestarted = false;

	synchronized void waitForAttendance() {
		while(attendancestarted == false) {
			System.out.println("Students are waiting");
			try {
				wait();
			}
			catch (Exception e) {
				System.out.println("Error handeled");
			}
		}
		System.out.println("Students marked present !!");
	}
	synchronized void startAttendance() {
		attendancestarted = true;
		System.out.println("Teacher started attendance ");
		notifyAll();
	}
}
class Teacherthread extends Thread {
	Classroom classroom;
	Teacherthread(Classroom classroom) {
		this.classroom = classroom;
	}
	public void run() {
		classroom.startAttendance();
	}
}
class Studentthread extends Thread {
	Classroom classroom;
	Studentthread(Classroom classroom) {
		this.classroom = classroom;
	}
	 public void run() {
	        classroom.waitForAttendance();
	    }
}
public class Classroom_attendance_system {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Classroom classroom = new Classroom();
		Studentthread s1 = new Studentthread(classroom);
		Studentthread s2 = new Studentthread(classroom);
		Studentthread s3 = new Studentthread(classroom);
		Studentthread s4 = new Studentthread(classroom);
		
		Teacherthread teacher = new Teacherthread(classroom);
		s1.start();
		s2.start();
		s3.start();
		s4.start();
		
		try {
			Thread.sleep(3000);
		} 
		catch (Exception e) {
			System.out.println("Eerror Handled");
		}
		teacher.start();
	}

}

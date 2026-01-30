package MYPACK;
import java.lang.*; // optional
class Y extends Thread { 
	String name="first";
	public Y() {
		System.out.println(name+" thread created");
	}
	public Y(String n) {
		name=n;
		System.out.println(name+" thread created");
	}
	//assigning task to thread
	public void run() {
		try {
		for(int i=1;i<=5;i++) {
			System.out.println(name+" "+i);
			Thread.sleep(2000);
		}
		}catch(Exception e) {}
	}
	
}
public class Demo2 {
	public static void main(String[] args) {
		Y ob1=new Y("first");
		Y ob2=new Y("second");
		Y ob3=new Y("third");
		Y ob4=new Y("fourth");
		ob1.start();ob2.start();ob3.start();ob4.start();

	}

}

package MYPACK;
import java.lang.*;
// creating threads using different constructors
class X extends Thread {
	String name="first";
	public X() {
		// calls Thread()
		System.out.println(name+" thread created");
	}
	public X(String n) {
		// cant call Thread(String)
		name=n;
		System.out.println(name+" thread created");
	}
	//this gives task to thread
	public void run() {
		System.out.println(name+" printing x");
	}
}
public class Demo {
	public static void main(String[] args) {
          X ob1=new X("first");
          X ob2=new X("second");
          X ob3=new X("third");
          ob1.start();ob2.start();ob3.start();
	}

}

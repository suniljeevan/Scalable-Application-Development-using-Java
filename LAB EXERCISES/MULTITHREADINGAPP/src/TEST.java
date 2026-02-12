// Create 4 threads (t1,t2,t3,t4) t1,t2,t3 using Thread class, t4 using Runnable Interface
// t1 - to print 1 to 5
// t2 - to print 5 to 1
// t3 - to read a file (create a folder 4com2 in D drive , create a file notes.txt in d:\4com2, add some content there
// t4 - to check a number is prime or not [ a number is prime, if total factor is 2, (including 1)

package Section4Com2;
import java.io.*;
import java.lang.*;
class MyThread1 extends Thread {
	String name;
	public MyThread1(String name) {
		this.name=name;
	}
	public void run() {
		try {
		for(int i=1;i<=5;i++) {
			System.out.println(name+" "+i);
			Thread.sleep(10000);
		}
		}catch(Exception e) {}
	}
	
}
class MyThread2 extends Thread {
	String name;
	public MyThread2(String name) {
		this.name=name;
	}
	public void run() {
		try {
		for(int i=5;i>=1;i--) {
			System.out.println(name+" "+i);
			Thread.sleep(10000);
		}
		}catch(Exception e) {}
	}
}
class MyThread3 extends Thread {
	String name;
	public MyThread3(String name) {
		this.name=name;
	}
	public void run() {
		try {
		File file=new File("D:\\4com2\\notes.txt");
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		String line=null;
		
		while ((line=br.readLine())!=null) {
			System.out.println(name+" "+line);
			Thread.sleep(10000);
		}
		}catch(Exception e) {}
	}
}
class MyTask implements Runnable {
	int number;
	int count=0;
	MyTask(int number) {
		this.number=number;
	}
	public void run() {
		try {
		for(int i=1;i<=number;i++) {
			if(number%i==0)
				count++;
			Thread.sleep(10000);
		}
		if(count==2)
			System.out.println("prime");
		else
			System.out.println("Not prime");
	}catch(Exception e) {}
	}
}


public class TEST {
	public static void main(String[] args)throws Exception {
        MyThread1 t1=new MyThread1("first"); 
        MyThread2 t2=new MyThread2("second");
        MyThread3 t3=new MyThread3("third");
        MyTask task = new MyTask(24);
        Thread t4=new Thread(task);
        t4.setName("fourth");
        t1.start();t2.start();t3.start();t4.start();
        Thread.sleep(3000000);
        System.out.println("completed");
        
	}

}

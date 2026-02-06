package MYPACK;
class MYTHREAD extends Thread {
	String name;
	MYTHREAD(String name) {
		super(name);
		this.name=name;
		System.out.print(name);
		System.out.println("created");
	}
	public void run() {
		try {
		for(int i=1;i<=10;i++) {
			System.out.println(Thread.currentThread()+" "+i);
			Thread.sleep(10000);
		}
		}catch(Exception e) {}
	}
}
public class TEST5 {
	public static void main(String[] args) throws Exception{
         MYTHREAD t1 = new MYTHREAD("One");
         MYTHREAD t2 = new MYTHREAD("Two");
         MYTHREAD t3 = new MYTHREAD("Threee");
         t1.setPriority(Thread.MIN_PRIORITY);
         t2.setPriority(Thread.NORM_PRIORITY);
         t3.setPriority(Thread.MAX_PRIORITY);
         t1.start();t2.start();t3.start();
         System.out.println("One"+t1.isAlive());
         System.out.println("Two"+t1.isAlive());
         System.out.println("Three"+t1.isAlive());
         t1.join();
         t2.join();
         t3.join();
         System.out.println("One"+t1.isAlive());
         System.out.println("Two"+t1.isAlive());
         System.out.println("Three"+t1.isAlive());
         
	}

}

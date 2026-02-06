import java.util.Random;
//1 producer 1 consumer , Inter Thread Communication
// then with 2 consumer
class Buffer {
	int number;
	boolean signal = false;
	synchronized void produce() {
		try {
			while(signal==true) {
				wait();   
			}
			//signal false, produce
			Random r = new Random();
            number = r.nextInt(10) + 1;
            System.out.println("Producer produced: " + number);
            signal = true;
            notifyAll();
		}catch(Exception e) {}
	}
	synchronized void consume() {
		try {
            while (signal==false) {
                wait();
            }
            //signal true, consume
    System.out.println("Consumer calculated: " + (number * number));
            signal = false;
            notifyAll();
        } catch (Exception e) {}
    }
}
class Producer extends Thread {
	String name;
	Buffer b;
	Producer(String name, Buffer b) {
		this.name=name;
		this.b=b;
	}
	public void run() {
		try {
			while(true) {
				b.produce();
				Thread.sleep(5000);
			}
		}catch(Exception e) {}
	}
}
class Consumer extends Thread {
	String name;
	Buffer b;
	Consumer(String name, Buffer b) {
		this.name=name;
		this.b=b;
	}
	public void run() {
		try {
			while(true) {
				b.consume();
				Thread.sleep(5000);
			}
		}catch(Exception e) {}
	}
}

public class Test11 {
	public static void main(String[] args) throws Exception{
		Buffer b = new Buffer();

        Producer p = new Producer("Producer",b);
        Consumer c = new Consumer("Consumer1",b);
        p.start();
        c.start(); 
        p.join();c.join();
         
	}

}

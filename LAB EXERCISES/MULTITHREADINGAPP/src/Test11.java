import java.util.Random;
//1 producer 1 consumer , Inter Thread Communication
// then with 2 consumer
class Buffer {
	int number;
	boolean isGenerated = false;
	synchronized void produce() {
		try {
			while(isGenerated) {
				wait();
			}
			Random r = new Random();
            number = r.nextInt(10) + 1;
            System.out.println("Producer produced: " + number);
            isGenerated = true;
            notifyAll();
		}catch(Exception e) {}
	}
	synchronized void getSquare() {
		try {
            while (!isGenerated) {
                wait();
            }
            System.out.println("Consumer1 Square: " + (number * number));
            isGenerated = false;
            notifyAll();
        } catch (Exception e) {}
    }
	synchronized void getCube() {
		 try {
	          while (!isGenerated) {
	              wait();
	            }
	           System.out.println("Consumer2 Cube: " + (number * number * number));
	           isGenerated = false;
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
				Thread.sleep(2000);
			}
		}catch(Exception e) {}
	}
}
class Consumer1 extends Thread {
	String name;
	Buffer b;
	Consumer1(String name, Buffer b) {
		this.name=name;
		this.b=b;
	}
	public void run() {
		try {
			while(true) {
				b.getSquare();
				Thread.sleep(2000);
			}
		}catch(Exception e) {}
	}
}
class Consumer2 extends Thread {
	String name;
	Buffer b;
	Consumer2(String name, Buffer b) {
		this.name=name;
		this.b=b;
	}
	public void run() {
		try {
			while(true) {
				b.getCube();
				Thread.sleep(2000);
			}
		}catch(Exception e) {}
	}
}
public class Test11 {
	public static void main(String[] args) throws Exception{
		Buffer b = new Buffer();

        Producer p = new Producer("Producer",b);
        Consumer1 c = new Consumer1("Consumer1",b);
        Consumer2 c2 = new Consumer2("Consumer2",b);
        p.start();
        c.start(); 
        c2.start();
        p.join();c.join();c2.join();
         
	}

}

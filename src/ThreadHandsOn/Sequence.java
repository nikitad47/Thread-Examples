package ThreadHandsOn;

class printSequence extends Thread
{
	static int n=1;
	int rem;
	static Object lock = new Object();
	printSequence(int rem)
	{
		this.rem = rem;
	}
	@Override
	public void run()
	{
		while(n<9){
			synchronized(lock) {
				while(n%3 != rem)
				{
					try {
		                lock.wait();
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
				}
				System.out.println(Thread.currentThread().getName() + n);
				n++;
				lock.notifyAll();
			}
		}
	}
}
public class Sequence {
	public static void main(String[] args){
		printSequence p1 = new printSequence(1);
		printSequence p2 = new printSequence(2);
		printSequence p3 = new printSequence(0);
		
		Thread t1 = new Thread(p1,"Thread 1: ");
		Thread t2 = new Thread(p2,"Thread 2: ");
		Thread t3 = new Thread(p3,"Thread 3: ");

		t1.start();
		t2.start();
		t3.start();
	}

}

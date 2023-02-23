package ThreadHandsOn;
class printEvenOdd extends Thread
{
	static int n=1;
	int rem;
	static Object lock = new Object();
	printEvenOdd(int rem)
	{
		this.rem = rem;
	}
	@Override
	public void run()
	{
		while(n<10){
			synchronized(lock) {
				while(n%2 != rem)
				{
					try {
		                lock.wait();
		            } catch (InterruptedException e) {
		                e.printStackTrace();
		            }
				}
				System.out.println(Thread.currentThread().getName() + " : " + n);
				n++;
				lock.notifyAll();
			}
		}
	}
}
public class ThreadClass {
	public static void main(String[] args){
		printEvenOdd p1 = new printEvenOdd(1);
		printEvenOdd p2 = new printEvenOdd(0);
		Thread t1 = new Thread(p1,"Odd");
		Thread t2 = new Thread(p2,"Even");
		t1.start();
		t2.start();
	}

}

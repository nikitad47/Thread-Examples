package ThreadHandsOn;

class printSequence1 extends Thread
{
	int n=1;
	
	printSequence1()
	{
	}
	@Override
	public void run()
	{
		while(n<6){
			System.out.println(Thread.currentThread().getName() + n);
			n++;
		}
	}
}


public class Sequence2 {

	public static void main(String[] args) throws InterruptedException {
		printSequence1 p1 = new printSequence1();
		printSequence1 p2 = new printSequence1();
		printSequence1 p3 = new printSequence1();
		
		Thread t1 = new Thread(p1,"Thread 1: ");
		Thread t2 = new Thread(p2,"Thread 2: ");
		Thread t3 = new Thread(p3,"Thread 3: ");

		t1.start();
		t1.join();
		t2.start();
		t2.join();
		t3.start();
		t3.join();

	}

}

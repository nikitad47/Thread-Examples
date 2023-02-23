package ThreadsTask;

class printOdd extends Thread
{
	@Override
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			if(i%2==1)
			{
				System.out.println(Thread.currentThread().getName());
				System.out.println(Thread.currentThread().getThreadGroup().getName());
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}
class printEven extends Thread
{
	@Override
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			if(i%2==0)
			{
				System.out.println(Thread.currentThread().getName());
				System.out.println(Thread.currentThread().getThreadGroup().getName());
				System.out.println(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
}


public class EvenOdd {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		ThreadGroup tg1 = new ThreadGroup("TG1");
		ThreadGroup tg2 = new ThreadGroup("TG2");

		printOdd po = new printOdd();
		po.setName("Odd Numbers");
		po.start();
		po.join();
		printEven pe = new printEven();
		pe.setName("Even Number");
		pe.start();
	}

}

package ThreadsTask;

class Table extends Thread
{
	@Override
	public void run()
	{
		int n=10;
		for(int i=2;i<=n;i++)
		{
			System.out.println("\n"+i+"Table");
			for(int j=1;j<=n;j++)
			{
				System.out.print(i*j+"\t");
			}
		}
	}
}

public class ThreadTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Table t = new Table();
		t.start();

	}

}

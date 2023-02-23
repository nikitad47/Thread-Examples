package ThreadsTask;

import java.io.*;
import java.util.*;

class FileTitle implements Runnable{
	
	String input;
	String name;
	FileTitle(String str, String filename)
	{
		this.input=str;
		this.name=filename; 
	}
	void writeToFile(String str,String name)
	{
		try(BufferedWriter wr = new BufferedWriter(new java.io.FileWriter(name)))
		{
			Thread.sleep(1000);
			wr.write(str);
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException(e);
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getContent(String input)
	{
		StringBuilder sb = new StringBuilder(input);
		for(int i=0;i<10000;i++)
		{
			sb.append(input);
			sb.append("\n");
		}
		return sb.toString();
	}
	
	@Override
	public void run()
	{
		writeToFile(input,name);
	}
}

public class StringDynamic{

	public static void main(String[] args) throws IOException 
	{
		// TODO Auto-generated method stub
		FileTitle fw=new FileTitle("Nikita","nikita.txt");
		Thread td=new Thread(fw);
		System.out.println(System.currentTimeMillis());
//		fw.writeFile("text1","Nikita");
		td.start();
		System.out.println(System.currentTimeMillis());
		for(int i=0;i<10;i++) {
			String st="text"+i+".txt";
			fw=new FileTitle(st,"Nikita"+i);
			td=new Thread(fw);		
			td.start();
			System.out.println(System.currentTimeMillis());
		}
	}

}


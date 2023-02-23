package ThreadsTask;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
public class CallableEx {
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		
		FileWrite1 fw=new FileWrite1("text1","Sai");
		FileWrite1 fw2=new FileWrite1("text2","Sai");
//		Thread td=new Thread(fw);
		long start=System.currentTimeMillis();
		ExecutorService executorService=Executors.newFixedThreadPool(2);
		Future<String> ft=executorService.submit(fw);
		Future<String> ft2=executorService.submit(fw2);
		if(ft.get().equals("done")&&ft2.get().equals("done")) {
			System.out.println("Final = "+(System.currentTimeMillis()-start));
		}
		
//		fw.writeFile("text1","Sai");
		
		
		executorService.shutdown();
		
	}
}
class FileWrite1 implements Callable<String>{
	String fileName;
	String str;
	FileWrite1(String fileName,String str){
		this.fileName=fileName;
		this.str=str;
	}
	public void writeFile(String fileName,String str){
		
		try(BufferedWriter br=new BufferedWriter(new FileWriter(new File(fileName)))){
//			Thread.sleep(1000);
			br.write(getContent(str));
			System.out.println(System.currentTimeMillis());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	private static String getContent(String in) {
		StringBuilder sb=new StringBuilder(in);
		for(int i=0;i<10;i++) {
			sb.append(sb);
			sb.append("\n");
		}
		
		return sb.toString();
	
	}
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		writeFile(fileName,str);
		return "done";
	}
	
}
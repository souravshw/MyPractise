package FileHandling_Examples;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		textToFile("Hello Dude.","This is cool","sunday.");
		
	}

	private static void textToFile(String ...argv) {
		// TODO Auto-generated method stub
		
		PrintWriter w=null;
		try {
			w=new PrintWriter(new FileWriter("C:/Users/Sony/Desktop/wordcheckOutput.txt"));
			for(String s:argv)
			{
				System.out.println(s);
			w.println(s);
			
			}
			System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(w!=null)
				w.close();
			
		}
		}
		
		
	}



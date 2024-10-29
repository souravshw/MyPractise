package io.practise.FileHandling_Examples;

import java.io.*;

public class CapitalizeRead {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s = textFromFile();
    System.out.println("The read String is: \n" + s);
  }

  private static String textFromFile() {
    // TODO Auto-generated method stub
    FileReader f = null;
    try {
      f = new FileReader("C:/Users/soushaw/Desktop/wordcheck");
			/* Old way of Reading file
		    int c=0;
		    while(c=f.read()!=-1)
		    {
		    	
		    }
		    */

      BufferedReader b = new BufferedReader(f);
      CapReader c = new CapReader(b);
      String alltext = "";
      String line = "";
      try {
        while ((line = c.readLine()) != null) {
          alltext += line;
        }
        return alltext;
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      if (f != null)
        try {
          f.close();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }

    }
    return null;
  }

}


class CapReader extends BufferedReader {
  public CapReader(Reader arg0) {
    super(arg0);
    // TODO Auto-generated constructor stub
  }

  /* (non-Javadoc)
   * @see java.io.BufferedReader#readLine()
   */
  @Override
  public String readLine() throws IOException {
    // TODO Auto-generated method stub
    String line = super.readLine();
    if (line != null)
      return line.toUpperCase();
    return null;
  }

}

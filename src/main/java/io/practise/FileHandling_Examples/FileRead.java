package io.practise.FileHandling_Examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {

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
            f = new FileReader("C:/Users/Sony/Desktop/wordcheck");
			/* Old way of Reading file
		    int c=0;
		    while(c=f.read()!=-1)
		    {
		    	
		    }
		    */

            BufferedReader b = new BufferedReader(f);
            String alltext = "";
            String line = "";
            try {
                while ((line = b.readLine()) != null) {
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

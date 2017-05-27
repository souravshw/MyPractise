package FileHandling_Examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManip {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Path path = Paths.get("C:/Users/Sony/Desktop/testfile");
//Creating a file

        try {
            Files.createFile(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//Deleting a file
/*
try {
	Files.deleteIfExists(path);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
         */
//Moving a file
        try {
            Files.move(path, Paths.get("C:/Users/Sony/Desktop/hive/testfile"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

package io.practise.myPractice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

    String filePath = "/home/sanu/workspace/VOne/src/FilesOutput/";
    String fileName;
    File file;
    private FileWriter fw;

    public CreateFile(String name) {
        // TODO Auto-generated contructor stub

        this.fileName = name;
        filePath = filePath.concat(name);
        file = new File(filePath);

        if (file.exists())
            System.out.println("Previous file " + name + " is deleted " + file.delete());
        else
            try {
                if (!file.createNewFile())
                    System.out.println("Err in creating file " + name);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    }

    public void WriteIntoFile(String Line) {
        try {
            fw = new FileWriter(filePath, true);
            fw.write(Line);
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block

            e.printStackTrace();
        }
    }

    public void closeFile() {
        try {
            fw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

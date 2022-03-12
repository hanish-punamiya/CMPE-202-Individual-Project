package File;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void create(String fileName) {
        try {
            File myObj = new File(fileName);
            if (myObj.createNewFile()) {
//                System.out.println("File created: " + myObj.getName());
            } else {
//                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error occurred in " + e.getStackTrace()[0].getMethodName() + e.getMessage());
            e.printStackTrace();
        }
    }
}

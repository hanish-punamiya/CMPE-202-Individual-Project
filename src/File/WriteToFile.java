package File;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void write(String data, String fileName) throws IOException {
        FileWriter myWriter = new FileWriter(fileName);
        try {
            myWriter.write(data);
            myWriter.close();
//            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error occurred in " + e.getStackTrace()[0].getMethodName() + e.getMessage());
            e.printStackTrace();
        }
        finally {
            myWriter.close();
        }
    }
}

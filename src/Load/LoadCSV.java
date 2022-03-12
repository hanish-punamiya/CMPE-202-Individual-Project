package Load;

import java.io.File;
import java.util.Scanner;

public class LoadCSV {

    protected Scanner sc;

    public LoadCSV(String fileName) throws Exception {
        this.sc = loadFile(fileName);
    }

    protected Scanner getSc() {
        return this.sc;
    }

    private Scanner loadFile(String fileName) throws Exception {
        this.sc = null;
        try {
            this.sc = new Scanner(new File("./" + fileName));
            this.sc.useDelimiter("\n");
        } catch (Exception exception) {
            System.out.println("Error occurred in loading CSV file: " + exception.getMessage());
        }
        return this.sc;
    }
}

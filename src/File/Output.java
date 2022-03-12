package File;

import java.io.IOException;

public class Output {

    private String fileName;

    public Output(String fileName) {
        this.fileName = fileName;
    }

    public void output(String data) throws IOException {
        CreateFile.create(fileName);
        WriteToFile.write(data, fileName);
    }
}



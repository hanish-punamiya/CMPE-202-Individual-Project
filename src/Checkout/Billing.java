package Checkout;

import Config.Config;
import Data.Database;
import File.Output;

import java.io.IOException;

public class Billing extends Calculation {

    public Billing(Database database) {
        super(database);
    }

    public void checkout() throws IOException {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Amount Paid\n");
            sb.append(calculateTotalAmount());
            addCardsToDatabase();
            Output bill = new Output(Config.getProperty("OUTPUT_FILE"));
            bill.output(sb.toString());
        } catch (Exception exception) {
            System.out.println("Error occurred in " + exception.getStackTrace()[0].getMethodName() + exception.getMessage());
        }
    }
}

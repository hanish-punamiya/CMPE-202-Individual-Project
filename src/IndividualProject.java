import Checkout.Billing;
import Config.Config;
import Data.Database;
import Load.GetDataset;
import Load.LoadCards;
import Load.LoadCart;
import Load.LoadInventory;
import Models.Card;
import Models.Item;
import Validations.Validate;

import java.util.ArrayList;
import java.util.HashMap;

public class IndividualProject {
    public static void main(String args[]) throws Exception {

        Database database = new Database(new GetDataset(Config.getProperty("DATASET_FILE")).getDataset(new HashMap<String, Item>(),
                new LoadInventory()), new GetDataset(Config.getProperty("INPUT_FILE")).getDataset(new HashMap<String, Item>(),
                new LoadCart()), new GetDataset(Config.getProperty("CARDS_FILE")).getDataset(new ArrayList<Card>(), new LoadCards()));

        if (new Validate(database).doValidation()) {
            new Billing(database).checkout();
            System.out.println("The items were correctly billed.");
            System.out.println("Please check the output file for the total amount as well as the card file for the updated cards data.");
        }
    }

}
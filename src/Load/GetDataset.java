package Load;

import Models.Card;
import Models.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class GetDataset extends GetItems {

    public GetDataset(String fileName) throws Exception {
        super(fileName);
    }

    public HashMap<String, Item> getDataset(HashMap<String, Item> items, LoadItems loadItems) throws Exception {
        try {
            if (this.getSc() != null)
                items = this.iterateRows(this.getSc(), items, loadItems);
            else
                return null;
            return items;
        } catch (Exception exception) {
            System.out.println("Error occurred in reading data from Dataset CSV file: " + exception.getMessage());
            return null;
        } finally {
            if (sc != null)
                sc.close();
        }
    }

    public ArrayList<Card> getDataset(ArrayList<Card> items, LoadItems loadItems) throws Exception {
        try {
            if (this.getSc() != null)
                items = this.iterateRows(this.getSc(), items, loadItems);
            else
                return null;
            return items;
        } catch (Exception exception) {
            System.out.println("Error occurred in reading data from Dataset CSV file: " + exception.getMessage());
            return null;
        } finally {
            if (sc != null)
                sc.close();
        }
    }
}

package Load;

import Models.Card;
import Models.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GetItems extends LoadCSV {
    protected GetItems(String fileName) throws Exception {
        super(fileName);
    }

    protected HashMap<String, Item> iterateRows(Scanner sc, HashMap<String, Item> items, LoadItems loadItems) {
        try {
            boolean flag = false;
            while (sc.hasNext()) {
                String[] row = sc.next().split(",");
                if (flag) {
                    Item item = loadItems.getItem(row);
                    if (item != null)
                        items.put(item.getItem(), item);
                    else
                        return null;
                } else
                    flag = true;
            }
            return items;
        } catch (Exception exception) {
            System.out.println("Error occurred in iterating through CSV rows: " + exception.getMessage());
            return null;
        }
    }

    protected ArrayList<Card> iterateRows(Scanner sc, ArrayList<Card> items, LoadItems loadItems) {
        try {
            boolean flag = false;
            while (sc.hasNext()) {
                String[] row = sc.next().split(",");
                if (flag) {
                    Item item = loadItems.getItem(row);
                    if (item != null)
                        items.add(item.getCard());
                    else
                        return null;
                } else
                    flag = true;
            }
            return items;
        } catch (Exception exception) {
            System.out.println("Error occurred in iterating through CSV rows: " + exception.getMessage());
            return null;
        }
    }
}

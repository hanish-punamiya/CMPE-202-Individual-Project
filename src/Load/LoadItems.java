package Load;

import Models.Item;

public interface LoadItems {
    Item getItem(String[] row);
}

//    HashMap<String, Item> getDataset(HashMap<String,Item> items) throws Exception;

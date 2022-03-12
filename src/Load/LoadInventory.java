package Load;

import Models.Item;

public class LoadInventory implements LoadItems {
    @Override
    public Item getItem(String[] row) {
        Item item = new Item();
        try {
            item.setCategory(row[0]);
            item.setItem(row[1]);
            item.setQuantity(Integer.parseInt(row[2]));
            item.setPrice(Double.parseDouble(row[3]));
            return item;
        } catch (Exception exception) {
            System.out.println("Error occurred in setting item details: " + exception.getMessage());
            return null;
        }
    }
}

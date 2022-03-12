package Load;

import Models.Item;

public class LoadCart implements LoadItems {
    @Override
    public Item getItem(String[] row) {
        Item item = new Item();
        try {
            item.setItem(row[0]);
            item.setQuantity(Integer.parseInt(row[1]));
            item.setCard(row[2]);
            return item;
        } catch (Exception exception) {
            System.out.println("Error occurred in setting item details: " + exception.getMessage());
            return null;
        }
    }


}

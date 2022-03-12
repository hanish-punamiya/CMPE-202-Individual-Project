package Load;

import Models.Item;

public class LoadCards implements LoadItems{
    @Override
    public Item getItem(String[] row) {
        Item item = new Item();
        try {
            item.setCard(row[0]);
            return item;
        } catch (Exception exception) {
            System.out.println("Error occurred in setting item details: " + exception.getMessage());
            return null;
        }
    }

}

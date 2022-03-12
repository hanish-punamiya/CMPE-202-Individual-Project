package Validations;

import Data.Database;
import Models.Item;
import Config.Config;

import java.util.ArrayList;
import java.util.HashMap;

public class Validation {

    protected Database database;
    private HashMap<String, Item> inventory;
    private HashMap<String, Item> cart;

    protected Validation(Database database) {
        this.database = database;
        this.inventory = database.getInventory();
        this.cart = database.getCart();
    }

    protected HashMap<Item, Integer> inStock() {
        return getIncorrectQuantities();
    }

    protected HashMap<String, ArrayList<Item>> allowance() {
        return getIncorrectAllowanceItems(getCategoryQuantities());
    }

    private HashMap<Item, Integer> getIncorrectQuantities() {
        HashMap<Item, Integer> incorrectQuantities = new HashMap<Item, Integer>();

        for (String cartItem :
                cart.keySet()) {
            try {
                int cartItemQuantity = cart.get(cartItem).getQuantity();
                int inventoryItemQuantity = 0;
                if (inventory.get(cartItem) != null)
                    inventoryItemQuantity = inventory.get(cartItem).getQuantity();
                if (cartItemQuantity > inventoryItemQuantity)
                    incorrectQuantities.put(cart.get(cartItem), inventoryItemQuantity);
            } catch (Exception exception) {
                System.out.println("Error occurred in " + exception.getStackTrace()[0].getMethodName() + exception.getMessage());
            }
        }
        return incorrectQuantities;
    }

    protected HashMap<String, Integer> getCategoryQuantities() {
        HashMap<String, Integer> categoryQuantities = new HashMap<String, Integer>();

        try {
            String essentials = Config.getProperty("ESSENTIALS");
            String luxury = Config.getProperty("LUXURY");
            String miscellaneous = Config.getProperty("MISCELLANEOUS");

            categoryQuantities.put(essentials, 0);
            categoryQuantities.put(luxury, 0);
            categoryQuantities.put(miscellaneous, 0);

            for (String cartItem :
                    cart.keySet()) {
                if (cart.get(cartItem).getCategory().equals(essentials)) {
                    categoryQuantities.put(essentials, categoryQuantities.get(essentials) + cart.get(cartItem).getQuantity());
                } else if (cart.get(cartItem).getCategory().equals(luxury)) {
                    categoryQuantities.put(luxury, categoryQuantities.get(luxury) + cart.get(cartItem).getQuantity());
                } else if (cart.get(cartItem).getCategory().equals(miscellaneous)) {
                    categoryQuantities.put(miscellaneous, categoryQuantities.get(miscellaneous) + cart.get(cartItem).getQuantity());
                }
            }
        } catch (Exception exception) {
            System.out.println("Error occurred in " + exception.getStackTrace()[0].getMethodName() + exception.getMessage());
        }
        return categoryQuantities;
    }

    private HashMap<String, ArrayList<Item>> getIncorrectAllowanceItems(HashMap<String, Integer> categoryQuantities) {
        HashMap<String, ArrayList<Item>> incorrectAllowance = new HashMap<String, ArrayList<Item>>();

        try {
            int essentialsQuantity = Integer.parseInt(Config.getProperty("ESSENTIALS_QUANTITY"));
            int luxuryQuantity = Integer.parseInt(Config.getProperty("LUXURY_QUANTITY"));
            int miscellaneousQuantity = Integer.parseInt(Config.getProperty("MISCELLANEOUS_QUANTITY"));

            String essentials = Config.getProperty("ESSENTIALS");
            String luxury = Config.getProperty("LUXURY");
            String miscellaneous = Config.getProperty("MISCELLANEOUS");

            ArrayList<Item> essentialItems = new ArrayList<Item>();
            ArrayList<Item> luxuryItems = new ArrayList<Item>();
            ArrayList<Item> miscellaneousItems = new ArrayList<Item>();

            for (String cartItem :
                    cart.keySet()) {
                try {
                    if (cart.get(cartItem).getCategory().equals(essentials) && categoryQuantities.get(essentials) > essentialsQuantity) {
                        essentialItems.add(cart.get(cartItem));
                    } else if (cart.get(cartItem).getCategory().equals(luxury) && categoryQuantities.get(luxury) > luxuryQuantity) {
                        luxuryItems.add(cart.get(cartItem));
                    } else if (cart.get(cartItem).getCategory().equals(miscellaneous) && categoryQuantities.get(miscellaneous) > miscellaneousQuantity) {
                        miscellaneousItems.add(cart.get(cartItem));
                    }
                } catch (Exception exception) {
                    System.out.println("Error occurred in creating incorrectAllowance in " + exception.getStackTrace()[0].getMethodName() + ": " + exception.getMessage());
                }
            }
            incorrectAllowance.put(essentials, essentialItems);
            incorrectAllowance.put(luxury, luxuryItems);
            incorrectAllowance.put(miscellaneous, miscellaneousItems);
        } catch (Exception exception) {
            System.out.println("Error occurred in " + exception.getStackTrace()[0].getMethodName() + exception.getMessage());
        }
        return incorrectAllowance;
    }

}
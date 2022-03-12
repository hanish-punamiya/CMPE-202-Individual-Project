package Validations;

import File.Output;
import Config.Config;
import Data.Database;
import Models.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Validate extends Validation {
    public Validate(Database database) {
        super(database);
    }

    public boolean doValidation() {
        try {
            Output error = new Output(Config.getProperty("ERROR_FILE"));
            String notInStock = validateInStock(inStock());
            if (!notInStock.equals("")) {
                error.output(Config.getProperty("ERROR") + "\n\n" + notInStock);
                System.out.println("Please correct the Quantities");
                System.out.println("Please check the error.txt file for the error and the incorrect items");
                return false;
            }
            String incorrectAllowance = validateAllowance(allowance(),getCategoryQuantities());
            if (!incorrectAllowance.equals("")) {
                error.output(Config.getProperty("ERROR") + "\n\n" + incorrectAllowance);
                System.out.println("Please correct the Quantities");
                System.out.println("Please check the error.txt file for the error and the incorrect items");
                return false;
            }
        } catch (Exception exception) {
            System.out.println("Error occurred in " + exception.getStackTrace()[0].getMethodName() + exception.getMessage());
            return false;
        }
        return true;
    }

    private String validateInStock(HashMap<Item, Integer> incorrectQuantities) {
        StringBuilder str = new StringBuilder();
        try {
            if (incorrectQuantities.size() > 0) {
                for (Item item :
                        incorrectQuantities.keySet()) {
                    str.append(item.getItem()).append(" required by cart: ").append(item.getQuantity()).append(" but present in inventory: ").append(incorrectQuantities.get(item)).append(".\n");
                }
            }
        } catch (Exception exception) {
            System.out.println("Error occurred in " + exception.getStackTrace()[0].getMethodName() + exception.getMessage());
        }
        return str.toString();
    }

    private String validateAllowance(HashMap<String, ArrayList<Item>> incorrectAllowance, HashMap<String, Integer> categoryQuantities) {
        StringBuilder str = new StringBuilder();
        try {
            if (incorrectAllowance.size() > 0) {
                for (String category :
                        incorrectAllowance.keySet()) {
                    if (incorrectAllowance.get(category).size() > 0) {
                        if (category.equals(Config.getProperty("ESSENTIALS"))) {
                            str.append(category).append(" items allowed: ").append(Config.getProperty("ESSENTIALS_QUANTITY")).append(" but present in cart: ").append(categoryQuantities.get(Config.getProperty("ESSENTIALS"))).append(".\n");
                        } else if (category.equals(Config.getProperty("LUXURY"))) {
                            str.append(category).append(" items allowed: ").append(Config.getProperty("LUXURY_QUANTITY")).append(" but present in cart: ").append(categoryQuantities.get(Config.getProperty("LUXURY"))).append(".\n");
                        } else if (category.equals(Config.getProperty("MISCELLANEOUS"))) {
                            str.append(category).append(" items allowed: ").append(Config.getProperty("MISCELLANEOUS_QUANTITY")).append(" but present in cart: ").append(categoryQuantities.get(Config.getProperty("MISCELLANEOUS"))).append(".\n");
                        }
                        str.append(getIncorrectAllowanceItemString(incorrectAllowance, category)).append("\n");
                    }
                }
            }
        } catch (Exception exception) {
            System.out.println("Error occurred in " + exception.getStackTrace()[0].getMethodName() + exception.getMessage());
        }
        return str.toString();
    }

    private String getIncorrectAllowanceItemString(HashMap<String, ArrayList<Item>> incorrectAllowance, String category){
        StringBuilder innerStr = new StringBuilder();
        try {
            for (Item item :
                    incorrectAllowance.get(category)) {
                innerStr.append(item.getItem()).append(" quantity: ").append(item.getQuantity()).append(".\n");
            }
        } catch (Exception exception) {
            System.out.println("Error occurred in " + exception.getStackTrace()[0].getMethodName() + exception.getMessage());
        }
        return innerStr.toString();
    }

}
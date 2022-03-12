package Checkout;

import Config.Config;
import Data.Database;
import File.Output;
import Models.Card;

public class Calculation {

    protected double totalAmount;
    protected Database database;

    public Calculation(Database database) {
        this.database = database;
    }

    protected double calculateTotalAmount(){
        try{
            for (String cartItem :
                    database.getCart().keySet()) {
                totalAmount+=database.getCart().get(cartItem).getPrice();
                database.addCard(database.getCart().get(cartItem).getCard().getCardNumber());
            }
        }catch (Exception exception){
            System.out.println("Error occurred in " + exception.getStackTrace()[0].getMethodName() + exception.getMessage());
        }
        return totalAmount;
    }

    protected void addCardsToDatabase(){
        try{
            StringBuilder sb = new StringBuilder();
            sb.append("CardNumber\n");
            for (Card card :
                    database.getCards()) {
                sb.append(card.getCardNumber()+"\n");
            }
            Output cards = new Output(Config.getProperty("CARDS_FILE"));
            cards.output(sb.toString());
        }catch (Exception exception){
            System.out.println("Error occurred in " + exception.getStackTrace()[0].getMethodName() + exception.getMessage());
        }
    }
}

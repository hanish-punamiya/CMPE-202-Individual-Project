package Data;

import Models.Card;
import Models.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    protected HashMap<String, Item> inventory;
    protected HashMap<String, Item> cart;
    protected ArrayList<Card> cards;

    public Database() {
        this.inventory = new HashMap<String, Item>();
        this.cart = new HashMap<String, Item>();
        this.cards = new ArrayList<Card>();

    }

    public Database(HashMap<String, Item> inventory, HashMap<String, Item> cart, ArrayList<Card> cards) {
        this.inventory = inventory;
        this.cart = setCartCategory(cart);
        this.cards = cards;
    }

    public HashMap<String, Item> getInventory() {
        return inventory;
    }

    public void setInventory(HashMap<String, Item> inventory) {
        this.inventory = inventory;
    }

    public HashMap<String, Item> getCart() {
        return cart;
    }

    public void setCart(HashMap<String, Item> cart) {
        this.cart = setCartCategory(cart);

    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    private HashMap<String, Item> setCartCategory(HashMap<String, Item> cart) {

        for (String cartItem :
                cart.keySet()) {
            try {
                cart.get(cartItem).setCategory(inventory.get(cartItem).getCategory());
                cart.get(cartItem).setPrice(inventory.get(cartItem).getPrice()*cart.get(cartItem).getQuantity());
            } catch (Exception exception) {
                System.out.println("Error occurred in price calculation: " + exception.getMessage());
            }
        }
        return cart;
    }

    public void addCard(String cardNumber){
        boolean check = true;
        for (Card card :
                cards) {
            String cn = card.getCardNumber();
            if (card.getCardNumber().equals(cardNumber))
                check = false;
        }
        if(check)
            cards.add(new Card(cardNumber));
    }

}

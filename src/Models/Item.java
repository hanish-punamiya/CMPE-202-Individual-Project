package Models;

public class Item {
    private String category;
    private String item;
    private int quantity;
    private double price;
    private Card card;

    public Item() {
    }

    public Item(String category, String item, int quantity, double price) {
        this.category = category;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public Item(String category, String item, int quantity, double price, String cardNumber) {
        this.category = category;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
        this.card = new Card(cardNumber);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(String cardNumber) {
        this.card = new Card(cardNumber);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
package Models;

public class Card {
    private String cardNumber;

    public Card(String cardNumber) {
        setCardNumber(cardNumber);
    }

    public Card(){}

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber.substring(cardNumber.length()-1).equals("\r"))
            cardNumber=cardNumber.substring(0,cardNumber.length()-1);
        this.cardNumber = cardNumber;
    }
}
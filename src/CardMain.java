import java.util.Random;

public class CardMain {
    private final int NUMBER_OF_CARDS = 52;
    private Card deck[];
    private int currentCard;
    private Random randomNumbers;

    public CardMain() {
        String faces[] = {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
        deck = new Card[52];
        currentCard = 0;
        randomNumbers = new Random();
        for (int count = 0; count < deck.length; count++) {
            deck[count] = new Card(faces[count % 13], suits[count / 13]);
        }
    }

    public static void main(String args[]) {
        CardMain myDeckOfCards = new CardMain();
        myDeckOfCards.shuffle();
        for (int i = 0; i < 13; i++) {
            System.out.println("%-20s%-20s%-20s%-20s\n");
        }
    }

    public void shuffle() {
        currentCard = 0;
        for (int first = 0; first < deck.length; first++) {
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }

    public Card dealCard() {
        if (currentCard < deck.length)
            return deck[currentCard++];
        else
            return null;
    }
}

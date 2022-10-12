import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner kb = new Scanner(System.in);
    private final int NUMBER_OF_CARDS = 52;
    private Card deck[];
    private int currentCard;
    private Random randomNumbers;

    public Main() {
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
        Main myDeckOfCards = new Main();


        System.out.println("Chose a game");
        System.out.println("1. Poker");
        System.out.println("2. War");
        int s;
        do {
            s = kb.nextInt();

            switch (s) {
                case 1:
                    myDeckOfCards.shuffle();
                    for (int i = 0; i < 4; i++) {
                        System.out.print("Player" + (i + 1) + ":");
                        for (int j = 0; j < 5; j++) {
                            System.out.print(myDeckOfCards.dealCard() + ", ");
                            System.out.println();
                        }
                    }
                    break;
                case 2:
                    myDeckOfCards.shuffle();
                    for (int i = 0; i < 2; i++) {
                        System.out.print("Player" + (i + 1) + ":");
                        for (int j = 0; j < 26; j++) {
                            System.out.print(myDeckOfCards.dealCard() + ", ");
                            System.out.println();
                        }
                    }
                    break;

                default:
            }

        } while (s < 3);

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

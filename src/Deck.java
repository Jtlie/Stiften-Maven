import java.util.ArrayList;
import java.util.Arrays;


/**
 * Een deck met Cards
 * 
 */
public class Deck {
	public static void main(String[] args) {
		// new deck
		Deck d = new Deck();

		// fill deck
		d.fill();

		// insert card
		System.out.println("kaartnummer (0 - 13)");
		//int n = Integer.parseInt(System.console().readLine());
		int n = 2;    //placeholder
		System.out.println("Kaartsoort (0 - 3)");
		//int s = Integer.parseInt(System.console().readLine());
		int s = 2;    // placeholder		
		Card card = new Card(Number.values()[n], Suit.values()[s]);
		int index = 1; // placeholder
		// add card to deck
		d.insertAt(card, index);
		
		// delete card at position
		int i = 20;    // placeholder
		d.delete(i);
		
		d.shuffle();
		
	}

	Card[] cardArray;
	Card[] tempArray;

	/**
	 * Constructor. Maakt een deck met lengte 0.
	 */
	Deck() {
		cardArray = new Card[0];
	}

	/**
	 * Vult de array met 52 kaarten: 2,3 ... ,10,V,B,K,A van klaveren, schoppen,
	 * harten en ruiten.
	 */
	public void fill() {

		/*
		 * int cardnumber = 0; for (int s = 0; s <= 3; s++) { for (int n = 0; n
		 * <= 12; n++) {
		 * 
		 * cardArray.add(cardnumber, new Card(Number.values()[n],
		 * Suit.values()[s])); cardnumber++; } }
		 */
		
		System.out.println("fill");


		cardArray = new Card[52];
		int cardnumber = 0;
		for (int s = 0; s <= 3; s++) {
			for (int n = 0; n <= 12; n++) {
				cardArray[cardnumber] = new Card(Number.values()[n],
						Suit.values()[s]);
				// String temp = cardArray[cardnumber].toString();
				// System.out.println(cardArray[cardnumber]);
				// System.out.println(temp);
				cardnumber++;
			}
		}
		System.out.println(Arrays.toString(cardArray));
	}

	/**
	 * Zoals gezegd is dit spel een beetje vreemd. Bijvoorbeeld: spelers kunnen
	 * kaarten toevoegen aan het deck. Hierdoor kan het aantal kaarten groter
	 * worden dan 52.
	 * 
	 * @param card
	 *            een Kaart
	 * @param index
	 *            Op positie
	 */
	public void insertAt(Card card, int index) {
		System.out.println("insert card");

		
		int length = cardArray.length + 1;
		tempArray = new Card[length];		
		System.arraycopy( cardArray, 0, tempArray, 0, cardArray.length);
		tempArray[length - 1] = card;
		cardArray = new Card[tempArray.length];
		System.arraycopy( tempArray, 0, cardArray, 0, tempArray.length);
		System.out.println(Arrays.toString(cardArray));
	}

	/**
	 * Kaarten kunnen ook verwijderd worden uit het deck. delete Haalt de kaart
	 * met een bepaalde index er uit.
	 * 
	 * Merk op: na delete is de array zo groot als het aantal elementen dat er
	 * in zit.
	 * 
	 * @param index
	 */
	public void delete(int index) {
		
		System.out.println("delete");

		System.out.println(Arrays.toString(cardArray));
		
		tempArray = new Card[index -1];				
		Card[] secondArray = new Card[cardArray.length-index-1];
		Card[] thirdArray = new Card[cardArray.length-1];

		
		tempArray = Arrays.copyOfRange(cardArray, 0, index-1);          
		secondArray = Arrays.copyOfRange(cardArray, index, cardArray.length); 
		cardArray = combine(secondArray,thirdArray);

		System.out.println(Arrays.toString(cardArray));

	}
	
    public static Card[] combine(Card[] a, Card[] b){
        int length = a.length + b.length;
        Card[] result = new Card[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

	/**
	 * Schud alle kaarten zodat de volgorde 'willekeurig' is. Hiervoor is het
	 * toegestaan de Java Random generator te gebruiken.
	 * 
	 */
	public void shuffle() {
		System.out.println("shuffle");

		System.out.println(Arrays.toString(cardArray));
		
		int n = cardArray.length;
	    for (int i = 0; i < n; i++)
	    {
	        // between i and n-1
	        int r = i + (int) (Math.random() * (n-i));
	        Card tmp = cardArray[i];    // swap
	        cardArray[i] = cardArray[r];
	        cardArray[r] = tmp;
	    }
		
		System.out.println(Arrays.toString(cardArray));
	}

	/**
	 * Utillity method for swapping cards in given indices
	 * 
	 * @param indexA
	 * @param indexB
	 */
	private void cardSwap(int indexA, int indexB) {
	}

	/**
	 * Een gegeven kaart moet worden opgezocht in de array, en de index ervan
	 * moet als return worden teruggegeven. Zie [Hubbard p.30]
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int sequentialSearch(Card card) {
		int result = -1;
		return result;
	}

	/**
	 * Legt de kaarten op volgorde. We nemen aan dat een deck op volgorde ligt,
	 * als de volgorde hetzelfde is als na {@link #fillDeck()}
	 */
	public void sort() {
	}

	/**
	 * Vertelt of het deck gesorteerd is.
	 * 
	 * @return
	 */
	public boolean isSorted() {
		boolean sorted = true;
		// ...
		return sorted;
	}

	/**
	 * Een bepaalde kaart moet worden opgezocht in de gesorteerde array op de
	 * binary search manier zoals besproken in [Hubbard p.31].
	 * 
	 * @param card
	 *            de kaart die gezocht wordt
	 * @return De index van de gevonden kaart
	 */
	public int binarySearch(Card card) {
		int result = -1;
		return result;
	}

	/**
	 * Pretty-print het deck.
	 */
	@Override
	public String toString() {
		String str = "";

		return str + "\n";
	}

	public int compareTo(Deck d) {
		return 0;
	}

}

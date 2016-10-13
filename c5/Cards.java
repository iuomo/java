import java.io.*;
import java.util.*;

class Shuffle{
	int shuffledArray[];	//define the array
	String shuffledDeck[];
	
	Shuffle (){	//constructor
		int deck[] = new int[52];
		shuffledArray = new int[52];
		
		shuffledDeck= new String[52];
		String sdeck[] = new String[52];//deck of sorted cards
		
		sdeck[0] = "Ace of Spades";
		sdeck[1] = "Ace of Clubs";
		sdeck[2] = "Ace of Hearts";
		sdeck[3] = "Ace of Diamonds";
		
		sdeck[4] = "King of Spades";
		sdeck[5] = "King of Clubs";
		sdeck[6] = "King of Hearts";
		sdeck[7] = "King of Diamonds";
		
		sdeck[8] = "Queen of Spades";
		sdeck[9] = "Queen of Clubs";
		sdeck[10] =  "Queen of Hearts";
		sdeck[11] = "Queen of Diamonds";
		
		sdeck[12] = "Jack of Spades";
		sdeck[13] = "Jack of Clubs";
		sdeck[14] = "Jack of Hearts";
		sdeck[15] = "Jack of Diamonds";
		
		sdeck[16] = "10 of Spades";
		sdeck[17] = "10 of Clubs";
		sdeck[18] = "10 of Hearts";
		sdeck[19] = "10 of Diamonds";
		
		sdeck[20] = "9 of Spades";
		sdeck[21] = "9 of Clubs";
		sdeck[22] = "9 of Hearts";
		sdeck[23] = "9 of Diamonds";
		
		sdeck[24] = "8 of Spades";
		sdeck[25] = "8 of Clubs";
		sdeck[26] = "8 of Hearts";
		sdeck[27] = "8 of Diamonds";
		
		sdeck[28] = "7 of Spades";
		sdeck[29] = "7 of Clubs";
		sdeck[30] = "7 of Hearts";
		sdeck[31] = "7 of Diamonds";
		
		sdeck[32] = "6 of Spades";
		sdeck[33] = "6 of Clubs";
		sdeck[34] = "6 of Hearts";
		sdeck[35] = "6 of Diamonds";
		
		sdeck[36] = "5 of Spades";
		sdeck[37] = "5 of Clubs";
		sdeck[38] = "5 of Hearts";
		sdeck[39] = "5 of Diamonds";
		
		sdeck[40] = "4 of Spades";
		sdeck[41] = "4 of Clubs";
		sdeck[42] = "4 of Hearts";
		sdeck[43] = "4 of Diamonds";
		
		sdeck[44] = "3 of Spades";
		sdeck[45] = "3 of Clubs";
		sdeck[46] = "3 of Hearts\t";
		sdeck[47] = "3 of Diamonds";
		
		sdeck[48] = "2 of Spades";
		sdeck[49] = "2 of Clubs";
		sdeck[50] = "2 of Hearts";
		sdeck[51] = "2 of Diamonds";
		
	
		int i,ival;
		double val;
		for( i = 0; i < 52;i++){
				deck[i] = i;
		}
		System.out.println("\n\n");
		boolean keep;
		int count = 0;
		for (i = 0; i < 52;i++){
			keep = false;
			while(!keep){
				val = Math.random()*52; 
				ival = (int) val;
				if(deck[ival] == -1)
					keep = false;
				else 
					{//shuffledArray[i] = deck[ival];
					shuffledDeck[i] = sdeck[ival];
					deck[ival] = -1;
					keep = true;
					}
			}
		}
		
	}

}

class Cards{
	public static void main (String args[]) throws java.io.IOException{
	int i,j;
	int hand1[] = new int[5];
	int hand2[] = new int[5];
	String shand1[] = new String[5];
	String shand2[] = new String[5];
		Shuffle deck = new Shuffle();
		//prints the deck just to serve as a debug
		//for( i = 0; i< 52;i++){
		//	System.out.print(deck.shuffledArray[i]+" ");
		//	if ((i % 13 == 0)&&(i> 0))System.out.println();
		//}
		
		hand1[0] = deck.shuffledArray[0];
		hand1[1] = deck.shuffledArray[2];
		hand1[2] = deck.shuffledArray[4];
		hand1[3] = deck.shuffledArray[6];
		hand1[4] = deck.shuffledArray[8];
		
		hand2[0] = deck.shuffledArray[1];
		hand2[1] = deck.shuffledArray[3];
		hand2[2] = deck.shuffledArray[5];
		hand2[3] = deck.shuffledArray[7];
		hand2[4] = deck.shuffledArray[9];
		
		int odd = 0; int even = 1;
		for (i = 0; i <5;i++){
			shand1[i] = deck.shuffledDeck[odd];
			shand2[i] = deck.shuffledDeck[even];
			odd = odd + 2;
			even = even +2;
		}
		
	
		Arrays.sort(shand1); Arrays.sort(shand2);
		
		//display the hands
			System.out.println("\t\t"+"HAND 1\t\t\tHAND 2");
			System.out.println("\t\t"+shand1[0]+"\t\t"+shand2[0]);
			System.out.println("\t\t"+shand1[1]+"\t\t"+shand2[1]);
			System.out.println("\t\t"+shand1[2]+"\t\t"+shand2[2]);
			System.out.println("\t\t"+shand1[3]+"\t\t"+shand2[3]);
			System.out.println("\t\t"+shand1[4]+"\t\t"+shand2[4]);
			System.out.println("\n\n\n");
		
	}
}

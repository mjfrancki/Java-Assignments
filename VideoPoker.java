import java.util.* ;
import java.util.Arrays;


public class VideoPoker{

static int javaDollars;
static int winnings; 
//static int[][] shuffeledDeckArray = new  int[52][2];

static int[][] playerHandArray = new int[5][2];
static int deckPosition = 0;

int[][] deck = new  int[52][2];
int[][] shuffeledDeckArray = new  int[52][2];

/**
constructor for PokerSimulatorV2 
 @param deck sets intial values of a sorted deck 
 
*/


public VideoPoker(int[][] deck){

this.deck = deck ;

}

/**
sets the amount of java dollars player starts with
 @param startMoney sets intial value of you javadollars 
 
*/

public void getStartMoney(int startMoney){
javaDollars = startMoney;
} 


/**
tells player how many java dollars they curently have
 @return how many java dollars you have
*/

public int getMoney(){
return javaDollars; 
} 


/**
creates the suffled array
@param deckArray the orderd deck 
*/

public void shuffel(int[][] deckArray){
deckPosition=0;


int temp0,temp1;
int random;

for(int i = 0 ; i<52 ; i++){

shuffeledDeckArray[i][0] = deckArray[i][0];
shuffeledDeckArray[i][1] = deckArray[i][1];

}


for(int i = 0 ; i<52 ; i++){


random = (int)(Math.random() * 52);

temp0 = shuffeledDeckArray[i][0];
temp1 = shuffeledDeckArray[i][1];

shuffeledDeckArray[i][0]= shuffeledDeckArray[random][0];
shuffeledDeckArray[i][1]= shuffeledDeckArray[random][1];

shuffeledDeckArray[random][0] = temp0;
shuffeledDeckArray[random][1] = temp1;

}




}


/**
deals the player the next 5 cards

*/

public void deal(){
javaDollars--;
winnings--; 

deckPosition++;
playerHandArray[0][0] = shuffeledDeckArray[deckPosition][0];
playerHandArray[0][1] = shuffeledDeckArray[deckPosition][1];
deckPosition++;
playerHandArray[1][0] = shuffeledDeckArray[deckPosition][0];
playerHandArray[1][1] = shuffeledDeckArray[deckPosition][1];
deckPosition++;
playerHandArray[2][0] = shuffeledDeckArray[deckPosition][0];
playerHandArray[2][1] = shuffeledDeckArray[deckPosition][1];
deckPosition++;
playerHandArray[3][0] = shuffeledDeckArray[deckPosition][0];
playerHandArray[3][1] = shuffeledDeckArray[deckPosition][1];
deckPosition++;
playerHandArray[4][0] = shuffeledDeckArray[deckPosition][0];
playerHandArray[4][1] = shuffeledDeckArray[deckPosition][1];



}



/**
check which card the player wants to discard
@param keepCard0 checks if player wants to discard his first card 
@param keepCard1 checks if player wants to discard his second card 
@param keepCard2 checks if player wants to discard his third card 
@param keepCard3 checks if player wants to discard his fourth card 
@param keepCard4 checks if player wants to discard his fith card 

*/


public void discard(char keepCard0, char keepCard1, char keepCard2, char keepCard3, char keepCard4){

if (keepCard0 == '0'){
deckPosition++;
playerHandArray[0][0] = shuffeledDeckArray[deckPosition][0];
playerHandArray[0][1] = shuffeledDeckArray[deckPosition][1];

}

if (keepCard1 == '0'){
deckPosition++;

playerHandArray[1][0] = shuffeledDeckArray[deckPosition][0];
playerHandArray[1][1] = shuffeledDeckArray[deckPosition][1];

}

if (keepCard2 == '0'){
deckPosition++;

playerHandArray[2][0] = shuffeledDeckArray[deckPosition][0];
playerHandArray[2][1] = shuffeledDeckArray[deckPosition][1];


}

if (keepCard3 == '0'){
deckPosition++;

playerHandArray[3][0] = shuffeledDeckArray[deckPosition][0];
playerHandArray[3][1] = shuffeledDeckArray[deckPosition][1];


}

if (keepCard4 == '0'){
deckPosition++;

playerHandArray[4][0] = shuffeledDeckArray[deckPosition][0];
playerHandArray[4][1] = shuffeledDeckArray[deckPosition][1];


}


}


/**
gets the card number or face value from a card array
@parma card the value in the array that represents the cards value
@return card value
*/

public String getCardNumber(int card){

String cardNumber ; 



if(card == 11 )

cardNumber = "Jack" ;


else if(card == 12 )

cardNumber = "Queen ";


else if(card == 13)

cardNumber = "King";


else if(card== 14 )

cardNumber = "Ace" ;

else
cardNumber = card+"";

return cardNumber;

}

/**
gets the card suit value from a card array
@parma card the value in the array that represents the cards suit value
@return cards suit
*/
public String getCardSuit(int card){
String cardSuit ="";



if(card == 0 )

cardSuit = "clubs" ;


else if(card == 1 )

cardSuit = "dimonds" ;



else if(card == 2)

cardSuit = "spades" ;


else if(card == 3 )

cardSuit = "hearts" ;


return cardSuit;

}





/**
Checks if you are runnung low on cards in the deck
@return true if you used 40 or more cards
*/


public boolean checkDeckSive(){

if (deckPosition > 40){
 return true;
}
else
  return false;

}


/**
tells player how much they have won/lost in total.
@return how much you have won, lost or if you have broke even
*/


public String getProfits(){

if (winnings > 0)
  return "You have made a profit of " + winnings + " JavaDollars" ;
else if (winnings < 0)
 return "You are in the hole " + Math.abs(winnings) + " JavaDollars" ;
else
  return "you broke even" ;

}



/**
check what hand the player has, scores it and rewards winnings   
@return sentence telling the player what the hand was and how much they won 
*/


public String scoreHand(){

String hand = "";

int[] cardNumArray  = new int[5];
cardNumArray[0] = playerHandArray[0][1];
cardNumArray[1] = playerHandArray[1][1];
cardNumArray[2] = playerHandArray[2][1];
cardNumArray[3] = playerHandArray[3][1];
cardNumArray[4] = playerHandArray[4][1];

Arrays.sort(cardNumArray);


if( (playerHandArray[0][0] == playerHandArray[1][0])  &&  (playerHandArray[1][0] == playerHandArray[2][0])  &&  (playerHandArray[2][0] == playerHandArray[3][0])  && 
    (playerHandArray[3][0] == playerHandArray[4][0])  && (cardNumArray[0] == 10) && (cardNumArray[1] == 11) && 
    (cardNumArray[2] == 12) && (cardNumArray[3] == 13) && (cardNumArray[4] == 14 )){
hand = "Royal Flush! you won 250 JavaDollars";
javaDollars += 250;
winnings += 250; 
}

else if (  ( (playerHandArray[0][0] == playerHandArray[1][0])  &&  (playerHandArray[1][0] == playerHandArray[2][0])  &&  (playerHandArray[2][0] == playerHandArray[3][0]) && 
            (playerHandArray[3][0] == playerHandArray[4][0]) ) &&
        ( ( (cardNumArray[0] == cardNumArray[1]-1) && (cardNumArray[1] == cardNumArray[2]-1) && (cardNumArray[2] == cardNumArray[3]-1) && (cardNumArray[3] == cardNumArray[4]-1) ) || 
           ( (cardNumArray[0]==2) && (cardNumArray[1]==3) && (cardNumArray[2]==4) && (cardNumArray[3]==5) && (cardNumArray[4]==14) ) ) ){
hand = "Straight Flush! you won 50 JavaDollars";  
javaDollars += 50;
winnings += 50;
}


else if ( ( (cardNumArray[0] == cardNumArray[1]) && (cardNumArray[1] == cardNumArray[2]) && (cardNumArray[2] == cardNumArray[3]) ) 
        || ( (cardNumArray[4] == cardNumArray[3]) && (cardNumArray[3] == cardNumArray[2]) && (cardNumArray[2] == cardNumArray[1]) ) ) {
hand = "Four of a Kind! you won 25 JavaDollars";
javaDollars += 25;
winnings += 25;
}


else if ( ( (cardNumArray[0] == cardNumArray[1]) && (cardNumArray[2] == cardNumArray[3]) && (cardNumArray[3] == cardNumArray[4]) ) 
  || ( (cardNumArray[0] == cardNumArray[1]) && (cardNumArray[1] == cardNumArray[2]) && (cardNumArray[3] == cardNumArray[4]) )  ){
hand = "Full House! you won 6 JavaDollars";
javaDollars += 6;
winnings += 6;
}


else if ( (playerHandArray[0][0] == playerHandArray[1][0])  &&  (playerHandArray[1][0] == playerHandArray[2][0])  &&  (playerHandArray[2][0] == playerHandArray[3][0])  && 
          (playerHandArray[3][0] == playerHandArray[4][0])   ){
hand = "Flush! you won 5 JavaDollars";
javaDollars += 5;  
winnings += 5;
}


else if (   ((cardNumArray[0] == cardNumArray[1]-1) &&(cardNumArray[1] == cardNumArray[2]-1) && (cardNumArray[2] == cardNumArray[3]-1) && (cardNumArray[3] == cardNumArray[4]-1)) || 
            ((cardNumArray[0]==2) && (cardNumArray[1]==3) && (cardNumArray[2]==4) && (cardNumArray[3]==5) && (cardNumArray[4]==14)) ){
hand = "Straight! you won 4 JavaDollars";
javaDollars += 4;
winnings += 4;
}


else if ( ( (cardNumArray[0] == cardNumArray[1]) && (cardNumArray[1] == cardNumArray[2]) ) 
         || ((cardNumArray[1] == cardNumArray[2]) && (cardNumArray[2] == cardNumArray[3])) 
         || ((cardNumArray[2] == cardNumArray[3]) && (cardNumArray[3] == cardNumArray[4])) ){
hand = "3 of a Kind! you won 3 JavaDollars";
javaDollars += 3;
winnings += 3;
}

else if ( ( (cardNumArray[0] == cardNumArray[1]) && (cardNumArray[2] == cardNumArray[3]) ) || 
          ( (cardNumArray[0] == cardNumArray[1]) && (cardNumArray[3] == cardNumArray[4]) ) || 
          ( (cardNumArray[1] == cardNumArray[2]) && (cardNumArray[3] == cardNumArray[4]) ) ) {
hand = "2 Pairs! you won 2 JavaDollars ";
javaDollars += 2;
winnings += 2;
}

else if ( ( (cardNumArray[0] == cardNumArray[1]) && (cardNumArray[0] >= 11) || (cardNumArray[1] == cardNumArray[2]) && (cardNumArray[1] >= 11) || 
           (cardNumArray[2] == cardNumArray[3])  && (cardNumArray[2] >= 11) || (cardNumArray[3] == cardNumArray[4]) && (cardNumArray[3] >= 11) )  ) {
hand = "Pair of Jacks or Better! you won 1 JavaDollars";
javaDollars += 1; 
winnings += 1;
}



else if (  (cardNumArray[0] == cardNumArray[1])  || (cardNumArray[1] == cardNumArray[2])  || (cardNumArray[2] == cardNumArray[3])  || (cardNumArray[3] == cardNumArray[4])   )
hand = "1 Pair but you did not win any javaDollars"; 


else
hand ="Sorry you dont have a winning hand" ;



return hand;


}


}

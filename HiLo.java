/*Vincenzo L
 * High Low program
 * Feb 24,2020 - Feb 25,2020
 * This game generates a random number and user needs to
 * guess if it will be high or low(< or > 7)
*/

import java.util.Scanner;//import scanner for user input
import java.util.Random; //import Random to generate random values

public class HiLo{
  public static Random r = new Random(); //random
  public static Scanner input = new Scanner(System.in); //scanner
 
  public static void main(String[]args){
    int points=1000;//used to store points for user
    char play = 'y';//used to store if user wants to play again or not
    rules();//calls method to print rules
    while(play=='y'){
       if(points==0){//if user is out of points
         System.out.println("You have "+points+" points left");
         System.out.println("Do you want to restart? 'r' for restart:");
         play = input.next().charAt(0);//gets 1st char from user
         if(play=='r'||play=='R'){//if they want to restart
           points=1000;//reset points
         }else{
         System.out.println("Game over! Thanks for playing!");
         play='n';//set play to 'n' to end game
         }
       }else{//if user has points
         points=(game(points));//runs game in the game() method and stores the retuned value which is points left at end of round
         System.out.println("Would you like to play again? 'y' for yes, 'n' for no:");
         play = input.next().charAt(0);//gets 1st char from user
        
       }
    }
    System.out.println("Program Done");//end of program
  }
  
  //rules: pre: none post:none prints rules to console
  public static void rules(){
    System.out.println("-----Rules-----");
    System.out.println("Numbers 1 through 6 are low numbers");
    System.out.println("Numbers 8 through 13 are low numbers");
    System.out.println("Number 7 is not high or low and you automaticlly lose");
    System.out.println("If you are correct, you win double your bet or else you lose the bet value\n\n");
  }
  
  //game: pre: amount of point    post:returns total points at end of round
  public static int game(int points){//takes in num of points
    char choice='0'; //used to store user input(h=high, l=low)
    int bet=0;//stores how much user wants to bet
    int win=0;//store how many points won
    
    System.out.println("-----Game-----");
    System.out.println("You have "+points+" points left");//displays points
    //--------------------------------get bet from user----------------------------//
    System.out.println("Enter how much you want to bet:");
    bet=input.nextInt();//gets bet amount from user
    while(true){//will loop until if condition is met to break
      if(bet>0&&bet<=points){//if bet amount is valid
        points-=bet;//takes bet amount away from total
        break;
      }
      else{//if bet amount is invalid
        System.out.println("Invalid amount. Enter how much you want to bet:");
        bet=input.nextInt();//gets bet amount from user
      }
    }
    System.out.println("You have "+points+" points left");
   //-----------------------------main game area--------------------------------------//
    int num =(r.nextInt(13)+1);//generates a random number between 1 and 13(both included)
    System.out.println("High or Low? h:high l:low?:");
    choice=input.next().charAt(0);//gets guess from user and takes 1st char
    //-------------check conditions------------//
    if((choice=='h'||choice=='H')&& num>7){//if num is high
      win=bet*2;//wins double the bet amount
      points+=win;//add winnings to total points
      System.out.println("You Won! The number was: "+num);
      System.out.println("You Won: "+win+ " points. New point total: "+ points);
    }
    else if((choice=='l'||choice=='L')&& num<7){//if num is low
      win=bet*2;//wins double the bet amount
      points+=win;//add winnings to total points
      System.out.println("You Won! The number was: "+num);
      System.out.println("You Won: "+win+ " points. New point total: "+ points);
    }
    else{//if num is 7
      System.out.println("You lost! The number was: "+num);
      System.out.println("You lost: "+bet+ " points. New point total: "+ points);
    }
      
    return(points);//returns numbe of points
  }
}
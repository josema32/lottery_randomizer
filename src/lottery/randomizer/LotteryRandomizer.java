/*
 *   Name:          Jose Ramirez
 * 
 *   Program:       Lottery Randomizer       
 * 
 *   Description:   This program picks random numbers for a lottery game.   
 *
 *   Date Started:  10/18/18
 *   Last Modified: 10/18/18
 *
 */

package lottery.randomizer;

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class LotteryRandomizer 
{
    public static void main(String[] args) 
    {
        // keyboard input
        Scanner scanner    = new Scanner(System.in);
        // random number object
        Random random      = new Random();
        // holds the choice entered by the user, holds the number of games desired
        String userChoice; 
        int numberOfGames;
        String playMore;
        String yesOrNo;
        
        System.out.println("Welcome to the lottery number Randomizer\n");
       
        do
        {
            System.out.println("Pick your favorite game from the list: \n\n" 
                               + "1 - Power Ball\n"
                               + "2 - Mega Millions\n"
                               + "3 - Cash 5\n"
                               + "0 - Exit Program\n");

            System.out.print("Enter your choice here (1, 2 or 3): ");
            // this is where the user enters the choice
            userChoice = scanner.next();

            System.out.print("How many games would you like to generate: ");
            // this is where the user enters how many games they want
            numberOfGames = scanner.nextInt();
            
            System.out.println("MF: " + userChoice);
            
           // Number generation logic
           if (userChoice.equals("1") || userChoice.equals ("2") || userChoice.equals("3"))
           {
               // holds the power ball or megaplier
               int redBall = 0;
               // controls the loop
               int loopCounter = 1;
               // holds the randomly generated number to be added to the array
               int numPick;
               // holds the game numbers
               int[] gameArray = new int[5];

               while (loopCounter <= numberOfGames){

                   for (int i = 0; i < gameArray.length; i++)
                   {
                       numPick = random.nextInt(70)+1;

                       for (int j = 0; j < gameArray.length; j++)
                       {
                           if (numPick == gameArray[j])
                           {
                               numPick = random.nextInt(70)+1;
                           }
                       }

                       gameArray[i] = numPick;    
                   }

                   Arrays.sort(gameArray);

                   redBall = random.nextInt(25)+1;

                   if (userChoice.equals("3"))
                   {
                       System.out.println(Arrays.toString(gameArray));
                   }
                   else
                   {
                       System.out.println(Arrays.toString(gameArray) + "...[" + redBall + "]\n");
                   }
                   loopCounter++;
               }
           }
           
           else if (userChoice.equals("0"))
           {
               System.out.println("Thanks for using the lottery number randomizer.");
               System.exit(0); 
           }
           else
           {
               System.out.println("That is not a valid choice.");
           }
           
           System.out.println("\nWould you like to get more games? (Y / N): ");
           playMore = scanner.next();
            
        } while(playMore.equals("y") || playMore.equals("Y"));
    }
                
}

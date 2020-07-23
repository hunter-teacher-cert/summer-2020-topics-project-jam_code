import java.util.*;
import java.io.*;

public class Driver
{
  public static void main(String[] args)
  {

    GuessingGame animals = new GuessingGame();
    animals.animalSeed();

    while(true)
    {

      while(!animals.gameOver())
      {
        animals.makeGuess();  //Ask is it  _____ animal?
        if(!animals.gameOver())
          animals.nextQuestion();

      }

      System.out.println("Do you want to play again? Q to quit.  Enter to continue.");
      Scanner input = new Scanner(System.in);
      if(input.nextLine().equals("q"))
        break;

      //Set up for the next round
      animals.restart();
    }// end loop that plays each round of Game

  }//end main
}

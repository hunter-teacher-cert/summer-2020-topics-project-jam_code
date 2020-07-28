import java.util.*;
import java.io.*;

public class Driver
{
  public static void main(String[] args)
  {

    GuessingGame game = pickGame();
    game.restart();

    while(true)
    {
      System.out.println("Think of a noun.  I will try to guess it.");
      while(!game.gameOver())
      {
        game.nextQuestion(); //Ask leading question
        if(!game.gameOver())
          game.makeGuess();  //Ask is it  _____ ?

      }

      System.out.println("Do you want to play again? Q to quit.  Enter to continue.");
      Scanner input = new Scanner(System.in);
      if(input.nextLine().equals("q"))
        break;

      //Set up for the next round
      game.restart();
    }// end loop that plays each round of Game

    saveTree(game);  //serialize
  }//end main

  public static void saveTree(GuessingGame obj)
  {
    try{
        FileOutputStream fos = new FileOutputStream("game_save.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
        oos.close();
        fos.close();
     }catch(IOException ioe){
        System.out.println(ioe);
      }
  }//end saveTree

  public static GuessingGame getSavedTree()
  {
        // read the object from file
        // save the object to file
        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream("game_save.ser");
            in = new ObjectInputStream(fis);
            GuessingGame obj = (GuessingGame) in.readObject();
            in.close();
            return obj;
        } catch (Exception ex) {  //
          GuessingGame game = new GuessingGame();
          game.gameSeed();
          return game;
        }
    }//end getSavedTree


  public static GuessingGame pickGame()
  {
    System.out.println("Enter 1 to start with your last saved game.\nEnter 2 to create your own game from scratch.\nEnter 3 for the pre-seeded animal game.");
    Scanner input = new Scanner(System.in);
    String response = input.nextLine();
    while(!(response.equals("1") || response.equals("2") || response.equals("3")))
    {
      System.out.println("Invalid response.");
      System.out.println("Enter 1 to start with your last saved game.\nEnter 2 to create your own game from scratch.\nEnter 3 for the pre-seeded animal game.");
      response = input.nextLine();
    }
    if(response.equals("1"))
      return getSavedTree();
    else if(response.equals("2"))
    {
      GuessingGame g = new GuessingGame();
      g.gameSeed();
      return g;
    }
    else
    {
      GuessingGame g = new GuessingGame();
      g.animalSeed();
      return g;
    }


  }
}

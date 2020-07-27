import java.util.*;
import java.io.*;

public class Driver
{
  public static void main(String[] args)
  {

    GuessingGame animals = new GuessingGame();
    animals = getSavedTree();  //deserialize
    animals.restart();

    while(true)
    {
      System.out.println("Think of an animal.  I will try to guess it.")
      while(!animals.gameOver())
      {
        animals.nextQuestion(); //Ask leading question
        if(!animals.gameOver())
          animals.makeGuess();  //Ask is it  _____ animal?

      }

      System.out.println("Do you want to play again? Q to quit.  Enter to continue.");
      Scanner input = new Scanner(System.in);
      if(input.nextLine().equals("q"))
        break;

      //Set up for the next round
      animals.restart();
    }// end loop that plays each round of Game

    saveTree(animals);  //serialize
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
          GuessingGame animals = new GuessingGame();
          animals.animalSeed();
          return animals;
          // ex.printStackTrace();
        }
    }//end getSavedTree
}

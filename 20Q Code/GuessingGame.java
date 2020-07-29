import java.util.*;
import java.io.*;

public class GuessingGame implements Serializable
{
  /** instance variables **/
  private GGNode firstQuestion;
  private GGNode current;
  private boolean gameOver;

  /** constructors **/
  public GuessingGame()
  {
    this.firstQuestion = null;
    this.current = this.firstQuestion;
    this.gameOver = false;
  }

  public GuessingGame(GGNode firstQuestion)
  {
    this.firstQuestion = firstQuestion;
    this.current = firstQuestion;
    this.gameOver = false;
  }

  /* Returns true if the game is over.
  ** Game is over if: 1) computer wins OR 2)computer loses
  ** Game over is stored in the instance variable "gameOver"
  */
  public boolean gameOver()
  {
    return gameOver;
  }

  //The game is over.  Start the next round at the top.
  public void restart()
  {
    this.gameOver = false;
    this.current = firstQuestion;  //point to firstQuestion
  }

  /*
  ** Game guesses the noun and asks player if the game guessed correctly.
  ** Updates gameOver to true if computer wins.
  */
  public void makeGuess()
  {
    while(true) //Loop until y or n response
    {
      Scanner input = new Scanner(System.in);
      System.out.println("Are you thinking of " + current.getNoun() + "?");
      String response = input.nextLine();
      if(response.toLowerCase().equals("y") || response.toLowerCase().equals("yes"))
      {
        System.out.println("Huzzah! I guessed it!");
        this.gameOver = true;  //Game is over because computer won.
        return;
      }
      else if(response.toLowerCase().equals("n") || response.toLowerCase().equals("no"))
      {
        return; //Do nothing.
      }
      else
      {
        System.out.println("Invalid Response.");
      }
    }//end valid response while loop
  }//end makeGuess

  /*
  ** Asks the player the question that leads to the next node.
  ** Updates the current pointer based on whether user says yes
  ** or no.
  */
  public void nextQuestion()
  {

    // You can only ask a question if it exists!
    if(current.getLeadingQuestion() != null)
    {
      while(true) //Loop until valid y or n response
      {
        Scanner input = new Scanner(System.in);
        System.out.println(current.getLeadingQuestion());
        String response = input.nextLine();
        /**Follow the "yes" branch**/
        if(response.toLowerCase().equals("y") || response.toLowerCase().equals("yes"))
        {
          if(current.getYesNode() != null)
          {
            current = current.getYesNode();
            return;
          }
          else //end of tree --> computer loses
          {
            this.gameOver = true;
            addYesNode();
            return;
          }
        } //end of "yes" route

        /**Follow the "no" branch**/
        else if(response.toLowerCase().equals("n") || response.toLowerCase().equals("no"))
        {
          if(current.getNoNode() != null)
          {
            current = current.getNoNode();
            return;
          }
          else //end of tree --> computer loses
          {
            this.gameOver = true;
            addNoNode();
            return;
          }
        } //end of "no" route
        else //User did not enter y or n. Print message and loop again.
        {
          System.out.println("Invalid Response.");
        }
      }//end while valid response
    }// End if(question exists)
    else  //Question does not exist so the game is over.
    {
      this.gameOver = true;
      addYesNode();
    }
  }// end nextQuestion()

  public void gameSeed()
  {
    //Prompt user for a category
    System.out.print("Enter a category: ");
    Scanner input = new Scanner(System.in);
    String category = input.nextLine();

    //Establish the category
    GGNode start = new GGNode(category);
    start.setLeadingQuestion("Is it a member of the " + category + " category?");

    //Create one noun within the given category
    System.out.print("Enter a noun that falls under the " + category + " category: ");
    String member = input.nextLine();
    GGNode next = new GGNode(member);
    start.setYesNode(next);

    //Point first question starts to user defined category
    firstQuestion = start;
    current = start;
  }// end gameSeed()


  /*
  ** Populates the Guessing Game with a linked list of animals.
  */
  public void animalSeed()
  {
    GGNode g0 = new GGNode("START");
    GGNode g1 = new GGNode("cow");
    GGNode g2 = new GGNode("chicken");
    GGNode g3 = new GGNode("cat");
    GGNode g4 = new GGNode("sheep");
    GGNode g5 = new GGNode("duck");
    GGNode g6 = new GGNode("dog");
    GGNode g7 = new GGNode("mouse");

    g0.setLeadingQuestion("Is it an animal?");
    g0.setYesNode(g1);

    g1.setLeadingQuestion("Is it a farm animal?");
    g1.setYesNode(g2);
    g1.setNoNode(g3);

    g2.setLeadingQuestion("Does it have 4 legs?");
    g2.setYesNode(g4);
    g2.setNoNode(g5);

    g3.setLeadingQuestion("Does it bark?");
    g3.setYesNode(g6);
    g3.setNoNode(g7);

    firstQuestion = g0;
    current = g0;
  }

  /*
  ** If the guessing game is at a "leaf", the computer loses.
  ** (The computer has not yet lost if it can still move down the tree)
  ** Return true if ending game with loss, else return false.
  */
  public boolean computerLose()
  {
    //The Node is a "leaf" if it does not contain any children
    return current.getYesNode() == null && current.getNoNode() == null;
  }

  /*
  ** This method is called to update a null "yes" pointer.
  ** This occurs when a player says "no" to the associated noun but there is NO leadingQuestion on that node
  ** Adds a leading question that can be answered with "yes", creates a new node, and points
  ** "yes" pointer to it.
  */
  public void addYesNode()
  {
    Scanner input = new Scanner(System.in);
    System.out.println("I give up!\nWhat noun were you thinking of?");
    String noun = input.nextLine();
    System.out.println("Please enter a yes or no question that can be answered with yes for " + noun
    + " and no for " + current.getNoun() + ".");
    String ques = input.nextLine();
    System.out.println("Thanks for teaching me.");

    // Create the new Node and point
    GGNode noob = new GGNode(noun);
    current.setLeadingQuestion(ques);
    current.setYesNode(noob);
  }

  /*
  ** This method is called to update a null "no" pointer.
  ** This occurs when a player says "no" to a leading question and the next Node does not exist.
  ** Add a Node after the game is lost.
  */
  public void addNoNode()
  {
    Scanner input = new Scanner(System.in);
    System.out.println("I give up!\nWhat noun were you thinking of?");
    String noun = input.nextLine();
    System.out.println("Thanks for teaching me.");

    // Create the new GGNode and point the current GGNode to it.
    GGNode noob = new GGNode(noun);
    current.setNoNode(noob);
  }


}//end GuessingGame class

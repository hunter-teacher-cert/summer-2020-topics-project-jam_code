import java.util.*;
import java.io.*;
public class GGNode implements Serializable
{
  private String noun;
  private String leadingQuestion;
  private GGNode yesNode; //pointer to the yes node
  private GGNode noNode; //pointer to the no node

  public GGNode()
  {
    this.noun = "";
    this.leadingQuestion = "";
    this.yesNode = null;
    this.noNode = null;
  }

  public GGNode(String noun)
  {
    this.noun = noun;
    this.leadingQuestion = null;
    this.yesNode = null;
    this.noNode = null;
  }

  public GGNode(String noun, String leadingQuestion, GGNode yesNode, GGNode noNode)
  {
    this.noun = noun;
    this.leadingQuestion = leadingQuestion;
    this.yesNode = yesNode;
    this.noNode = noNode;
  }

  public String getNoun()
  {
    return this.noun;
  }

  public String getLeadingQuestion()
  {
    return this.leadingQuestion;
  }

  public GGNode getYesNode()
  {
    return yesNode;
  }

  public GGNode getNoNode()
  {
    return noNode;
  }

  public void setYesNode(GGNode yesNode)
  {
    this.yesNode = yesNode;
  }

  public void setNoNode(GGNode noNode)
  {
    this.noNode = noNode;
  }

  public void setLeadingQuestion(String leadingQuestion)
  {
    this.leadingQuestion = leadingQuestion;
  }


}

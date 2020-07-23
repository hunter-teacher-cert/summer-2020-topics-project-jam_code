public class GGNode
{
  private String item;
  private String leadingQuestion;
  private GGNode yesNode; //pointer to the yes node
  private GGNode noNode; //pointer to the no node

  public GGNode()
  {
    this.item = "";
    this.leadingQuestion = "";
    this.yesNode = null;
    this.noNode = null;
  }

  public GGNode(String item)
  {
    this.item = item;
    this.leadingQuestion = null;
    this.yesNode = null;
    this.noNode = null;
  }

  public GGNode(String item, String leadingQuestion, GGNode yesNode, GGNode noNode)
  {
    this.item = item;
    this.leadingQuestion = leadingQuestion;
    this.yesNode = yesNode;
    this.noNode = noNode;
  }

  public String getItem()
  {
    return this.item;
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

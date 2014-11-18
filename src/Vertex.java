import java.util.ArrayList;
import java.util.Random;

/**
 * Created by gomezk on 13.11.14.
 */
public class Vertex {

  private int id;
  private int r;
  private int g;
  private int b;
  private ArrayList<Edge> edgeList;

  public Vertex(int id) {
    this.id = id;
    edgeList = new ArrayList<>();
    Random randomGenerator = new Random();
    this.r = randomGenerator.nextInt(255);
    this.g = randomGenerator.nextInt(255);
    this.b = randomGenerator.nextInt(255);
  }


  public int getId() {
    return id;
  }

  public void setRGB(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public String getEdgesAsString() {
    String edgeString = "";
    for (Edge edge : edgeList) {
      if(edgeString.equals("")){
        edgeString += edge.getTarget().getId();
      }else {
        edgeString += " " + edge.getTarget().getId();
      }
    }
    return edgeString;
  }

  public String getRGB() {
    String reString = Integer.toString(r) + "," + Integer.toString(g) + "," +
      Integer.toString(b);
    return reString;

  }

  public Integer getR() {
    return r;
  }

  public Integer getG() {
    return g;
  }

  public Integer getB() {
    return b;
  }

  public ArrayList<Edge> getEdges() {
    return edgeList;
  }

  public void setEdge(Vertex target) {

    edgeList.add(new Edge(this, target));
  }


  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof Vertex)) {
      return false;
    }
    Vertex vex = (Vertex) o;
    return vex.getId() == id;

  }


  @Override
  public int hashCode() {
    return id;
  }

}

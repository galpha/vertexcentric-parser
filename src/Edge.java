/**
 * Created by galpha on 17.11.14.
 */
public class Edge {

  private Vertex source;
  private Vertex target;

  public Edge(Vertex v1, Vertex v2) {
    this.source = v1;
    this.target = v2;
  }

  public Vertex getSource() {
    return source;
  }

  public Vertex getTarget() { return target; }
}

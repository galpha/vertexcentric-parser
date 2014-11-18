import java.util.ArrayList;

/**
 * Created by galpha on 17.11.14.
 */
public class Compare {

  private ArrayList<Vertex> input;
  private ArrayList<Vertex> giraphoutput;

  public Compare(ArrayList<Vertex> input, ArrayList<Vertex> giraphoutput) {

    this.input = input;
    this.giraphoutput = giraphoutput;
  }

  public ArrayList<Vertex> match() {

    for (Vertex outputVertex : giraphoutput) {
      for (Vertex inputVertex : input) {
        if (inputVertex.equals(outputVertex.getEdges().get(0).getTarget())) {
          int r = inputVertex.getR();
          int g = inputVertex.getG();
          int b = inputVertex.getB();
          outputVertex.getEdges().get(0).getTarget().setRGB(r, g, b);
        }
      }
    }

    for (Vertex outputVertex : giraphoutput) {
      for (Vertex inputVertex : input) {
        if(outputVertex.equals(inputVertex)){
          int r = outputVertex.getEdges().get(0).getTarget().getR();
          int g = outputVertex.getEdges().get(0).getTarget().getG();
          int b = outputVertex.getEdges().get(0).getTarget().getB();
          inputVertex.setRGB(r, g, b);
        }
      }
    }

    return input;
  }
}

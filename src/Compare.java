import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by galpha on 17.11.14.
 */
public class Compare {

  private ArrayList<Vertex> input;
  private ArrayList<Vertex> giraphoutput;

  public Compare(ArrayList<Vertex> input, ArrayList<Vertex> giraphoutput){

    this.input=input;
    this.giraphoutput=giraphoutput;
  }

  public ArrayList<Vertex> match(){

    for(Vertex outputVertex: giraphoutput){
      for(Vertex inputVeretx: input){
        if(outputVertex.getId()==inputVeretx.getId()){

          inputVeretx.setRGB(outputVertex.getR(),outputVertex.getG(),
            outputVertex.getB());
        }
      }
    }

    return input;
  }
}

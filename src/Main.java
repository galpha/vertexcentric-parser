import java.io.*;
import java.util.ArrayList;

/**
 * Created by gomezk on 13.11.14.
 */
public class Main {


  public static void main(String[] args)
    throws IOException {


    final String inputpath = "/home/gomezk/testgraph/facebook_combined.txt";
    //final String giraphout = "/home/galpha/testgraphs/facebookoutput";
    final String destpath = "/home/gomezk/testgraph/facebook_combined.dot";

    Reader reader = new Reader();


    ArrayList<Vertex> inputList = reader.read(inputpath, " ");
    //ArrayList<Vertex> giraphoutputList = reader.read(giraphout, "\t");


    //Compare comperator = new Compare(inputList, giraphoutputList);

    Writer writer = new Writer(inputList, destpath);
    writer.writeDot();


  }


}

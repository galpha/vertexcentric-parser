import java.io.*;
import java.util.ArrayList;

/**
 * Created by gomezk on 13.11.14.
 */
public class Main {


  public static void main(String[] args)
    throws IOException {

    //ToDo: Change to ColorMap for random Value output
    final String inputpath = "/home/gomezk/testgraph/smallgraph";
    final String giraphout = "/home/gomezk/testgraph/smallgraph_two_partition";
    final String destpath = "/home/gomezk/testgraph/smallgraph_two_partitions.dot";

    Reader reader = new Reader();


    ArrayList<Vertex> inputList = reader.read(inputpath, " ");
    ArrayList<Vertex> giraphoutputList = reader.read(giraphout, "\t");


    Compare comperator = new Compare(inputList, giraphoutputList);

    Writer writer = new Writer(comperator.match(), destpath);
    writer.writeDot();


  }


}

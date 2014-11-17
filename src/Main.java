import java.io.*;
import java.util.ArrayList;

/**
 * Created by gomezk on 13.11.14.
 */
public class Main {


  public static void main(String[] args)
    throws IOException {


    final String inputpath = "/home/galpha/testgraphs/facebook_combined.txt";
    final String giraphout = "/home/galpha/testgraphs/output";
    final String destpath = "/home/galpha/testgraphs/facebook_mached.dot";

    Reader reader = new Reader();


    ArrayList<Vertex> inputList = reader.read(inputpath, " ");
    ArrayList<Vertex> outputList = reader.read(giraphout, "\t");


    Compare comperator = new Compare(inputList, outputList);

    Writer writer = new Writer(comperator.match(), destpath);
    writer.writeDot();


  }


}

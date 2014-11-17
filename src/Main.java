import java.io.*;
import java.util.ArrayList;

/**
 * Created by gomezk on 13.11.14.
 */
public class Main {


  public static void main(String[] args)
    throws IOException {


    final String inputpath = "/home/galpha/testgraphs/smallgraph.txt";
    final String idwithvaluepath = "/home/galpha/testgraphs/smallgraphoutput";
    final String destpath = "/home/galpha/testgraphs/smallgraph.dot";

    Reader inputReader = new Reader();
    Reader outputReader = new Reader();


    ArrayList<Vertex> inputList = inputReader.read(inputpath, "\t");
    ArrayList<Vertex> outputList = outputReader.read(idwithvaluepath,"       ");


  Compare comperator = new Compare(inputList,outputList);

    Writer writer = new Writer(comperator.match(), destpath);
    writer.writeDotFormat();


  }


}

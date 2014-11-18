import java.io.*;
import java.util.ArrayList;

/**
 * Created by gomezk on 13.11.14.
 */
public class Main {


  public static void main(String[] args)
    throws IOException {


    final String inputpath = "/home/galpha/testgraphs/CA-GrQc.txt";
    //final String giraphout = "/home/galpha/testgraphs/facebookoutput";
    final String destpath = "/home/galpha/testgraphs/CA-GrQc_adl";

    Reader reader = new Reader();


    ArrayList<Vertex> inputList = reader.read(inputpath, "\t");
    //ArrayList<Vertex> giraphoutputList = reader.read(giraphout, "\t");


    //Compare comperator = new Compare(inputList, giraphoutputList);

    Writer writer = new Writer(inputList, destpath);
    writer.writeADL();


  }


}

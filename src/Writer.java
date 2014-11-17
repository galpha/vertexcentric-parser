import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by galpha on 17.11.14.
 */
public class Writer {

  private ArrayList<Vertex> vertexList;
  private String destpath;

  private static final String DOT_DIGRAPH_HEADER = "digraph dg";
  private static final String DOT_BLOCK_OPEN = "{";
  private static final String DOT_BLOCK_CLOSE = "}";
  private static final String DOT_OUT_EDGE = "->";
  private static final String DOT_LABEL_OPEN = "[label=\"";
  private static final String DOT_LABEL_CLOSE = "\"]";
  private static final String DOT_LINE_ENDING = ";";
  private static final String DOT_FILLCOLOR_OPEN = "[fillcolor =\"";

  public Writer(ArrayList<Vertex> vertexList, String destpath) {
    this.vertexList = vertexList;
    this.destpath = destpath;
  }

  public void writeDot()
    throws IOException {
    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(destpath));

    if (vertexList.isEmpty()) {
      System.out.println("Set is empty");
    } else {
      fileWriter
        .write(String.format("%s %s", DOT_DIGRAPH_HEADER, DOT_BLOCK_OPEN));
      fileWriter.newLine();


      for (Vertex vertex : vertexList) {
        fileWriter.write(String.format("\t%s %s%s%s%s",
          vertex.getId(),
          DOT_FILLCOLOR_OPEN,
          vertex.getRGB(),
          DOT_LABEL_CLOSE,
          DOT_LINE_ENDING

        ));
        fileWriter.newLine();
      }

      for (Vertex vertex : vertexList) {
        List<Edge> edgeList = vertex.getEdges();
        for (Edge edge : edgeList) {
          fileWriter.write(String.format("\t%s%s%s%s",
            vertex.getId(),
            DOT_OUT_EDGE,
            edge.getTarget().getId(),
            DOT_LINE_ENDING
          ));
          fileWriter.newLine();

        }
      }
      fileWriter.write(String.format("%s", DOT_BLOCK_CLOSE));

    }
    System.out.println("Schreibe Dot-Format: " + destpath);
    fileWriter.close();

  }

  public void writeADL()
    throws IOException {
    BufferedWriter fileWriter = new BufferedWriter(new FileWriter(destpath));

    if (vertexList.isEmpty()) {
      System.out.println("Set is empty");
    } else {

      for (Vertex vertex : vertexList) {
        fileWriter.write(String.format("%s %s",
          vertex.getId(),
          vertex.getEdgesAsString()));
        fileWriter.newLine();
      }


    }
    System.out.println("Schreibe adl: " + destpath);
    fileWriter.close();

  }
}

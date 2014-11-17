import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by galpha on 17.11.14.
 */
public class Reader {

  private BufferedReader br;

  public Reader() {
  }

  public ArrayList<Vertex> read(String path, String pattern)
    throws IOException {

    ArrayList<Vertex> vertexList = new ArrayList<>();
    br = new BufferedReader(new FileReader((path)));
    Pattern LINE_TOKEN_SEPARATOR = Pattern.compile(pattern);
    System.out.println("Lese: " + path);
    String line;
    while ((line = br.readLine()) != null) {
      String[] lineTokens = LINE_TOKEN_SEPARATOR.split(line);


      if (vertexList.isEmpty()) {
        Vertex vex = new Vertex(Integer.parseInt(lineTokens[0]));
        Vertex target = new Vertex(Integer.parseInt(lineTokens[1]));
        vex.setEdge(target);
        vertexList.add(vex);
      } else {


        Vertex newVex = new Vertex(Integer.parseInt(lineTokens[0]));
        boolean allreadyEdge = false;

        if (vertexList.contains(newVex)) {

          for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).equals(newVex)) {
              if (vertexList.get(i).getEdges()
                .contains(Integer.parseInt(lineTokens[1]))) {
                allreadyEdge = true;
              }
              if (!allreadyEdge) {
                vertexList.get(i).setEdge(new Vertex(Integer.parseInt
                  (lineTokens[1])));
              }
            }
          }

        } else {
          Vertex newTarget = new Vertex(Integer.parseInt(lineTokens[1]));
          newVex.setEdge(newTarget);
          vertexList.add(newVex);

        }


      }


    }
    br.close();

    return vertexList;

  }

}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by galpha on 17.11.14.
 */
public class Reader {

  private ArrayList<Vertex> vertexList;
  private BufferedReader br;

  public Reader()
    throws FileNotFoundException {
    vertexList = new ArrayList<>();
  }

  public ArrayList<Vertex> read(String path, String pattern)
    throws IOException {
    br = new BufferedReader(new FileReader((path)));
    Pattern LINE_TOKEN_SEPARATOR = Pattern.compile(pattern);
    System.out.println("Lese: "+path);
    String line;
    while ((line = br.readLine()) != null) {
      String[] lineTokens = LINE_TOKEN_SEPARATOR.split(line);

      Random randomGenerator = new Random();
      int r = randomGenerator.nextInt(255);
      int g = randomGenerator.nextInt(255);
      int b = randomGenerator.nextInt(255);


      if (vertexList.isEmpty()) {
        Vertex vex = new Vertex(Integer.parseInt(lineTokens[0]));
        vex.setEdge(Integer.parseInt(lineTokens[1]));
        vex.setRGB(r, g, b);
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
                vertexList.get(i).setEdge(Integer.parseInt(lineTokens[1]));
              }
            }
          }

        } else {

          newVex.setEdge(Integer.parseInt(lineTokens[1]));
          newVex.setRGB(r, g, b);
          vertexList.add(newVex);

        }


      }


    }
    br.close();

    return vertexList;
  }

}

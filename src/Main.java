import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by gomezk on 13.11.14.
 */
public class Main {

    private static final String DOT_DIGRAPH_HEADER = "digraph dg";
    private static final String DOT_BLOCK_OPEN = "{";
    private static final String DOT_BLOCK_CLOSE = "}";
    private static final String DOT_OUT_EDGE = "->";
    private static final String DOT_LABEL_OPEN = "[label=\"";
    private static final String DOT_LABEL_CLOSE = "\"]";
    private static final String DOT_LINE_ENDING = ";";
    private static final String DOT_FILLCOLOR_OPEN = "[fillcolor =\"";

    public static void main(String[] args) throws IOException {

        final Pattern LINE_TOKEN_SEPARATOR = Pattern.compile(" ");

        List<Vertex> vertexSet = new ArrayList<>();

        final String path = "/home/gomezk/test/facebook_combined.txt";
        final String destpath = "/home/gomezk/test/facebook_combined.dot";

        System.out.println("Lese: " + path);
        BufferedReader br = new BufferedReader(new FileReader((path)));

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(destpath));

        String line;

        while ((line = br.readLine()) != null) {
            String[] lineTokens = LINE_TOKEN_SEPARATOR.split(line);

            Random randomGenerator = new Random();
            int r = randomGenerator.nextInt(255);
            int g = randomGenerator.nextInt(255);
            int b = randomGenerator.nextInt(255);


            if (vertexSet.isEmpty()) {
                Vertex vex = new Vertex(Integer.parseInt(lineTokens[0]));
                vex.setEdge(Integer.parseInt(lineTokens[1]));
                vex.setRGB(r,g,b);
                vertexSet.add(vex);
            } else {


                Vertex newVex = new Vertex(Integer.parseInt(lineTokens[0]));
                boolean allreadyEdge = false;

                if (vertexSet.contains(newVex)) {

                    for(int i=0;i<vertexSet.size();i++){
                        if(vertexSet.get(i).equals(newVex)){
                            if(vertexSet.get(i).getEdges().contains(Integer.parseInt(lineTokens[1]))){
                                allreadyEdge=true;
                            }
                            if(!allreadyEdge){
                                vertexSet.get(i).setEdge(Integer.parseInt(lineTokens[1]));
                            }
                        }
                    }

                } else {

                    newVex.setEdge(Integer.parseInt(lineTokens[1]));
                    newVex.setRGB(r,g,b);
                    vertexSet.add(newVex);

                }


            }


        }
        br.close();




        if (vertexSet.isEmpty()) {
            System.out.println("Set is empty");
        } else {
            fileWriter.write(String.format("%s %s", DOT_DIGRAPH_HEADER, DOT_BLOCK_OPEN));
            fileWriter.newLine();


            for (Vertex vertex : vertexSet) {
                fileWriter.write(String.format("\t%s %s%s%s%s",
                        vertex.getId(),
                        DOT_FILLCOLOR_OPEN,
                        vertex.getRGB(),
                        DOT_LABEL_CLOSE,
                        DOT_LINE_ENDING

                ));
                fileWriter.newLine();
            }

            for (Vertex vertex : vertexSet) {
                List<Integer> edgeList = vertex.getEdges();
                for (Integer edge : edgeList) {
                    fileWriter.write(String.format("\t%s%s%s%s",
                            vertex.getId(),
                            DOT_OUT_EDGE,
                            edge,
                            DOT_LINE_ENDING
                    ));
                    fileWriter.newLine();

                }
            }
            fileWriter.write(String.format("%s", DOT_BLOCK_CLOSE));

        }
        System.out.println("Schreibe: " + destpath);
        fileWriter.close();


    }



}

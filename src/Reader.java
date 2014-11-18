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
                target.setEdge(vex);
                vertexList.add(vex);
                vertexList.add(target);

            } else {


                Vertex newVex = new Vertex(Integer.parseInt(lineTokens[0]));
                Vertex newTarget = new Vertex(Integer.parseInt(lineTokens[1]));
                boolean allreadyEdge=false;

                if(vertexList.contains(newVex)){
                    if(vertexList.contains(newTarget)){
                        for (int i = 0; i < vertexList.size(); i++) {
                            if (vertexList.get(i).equals(newVex)) {
                                for(Edge edge: vertexList.get(i).getEdges()){
                                    if(edge.getTarget().equals(newTarget)) allreadyEdge=true;
                                }
                                if(!allreadyEdge){
                                    vertexList.get(i).setEdge(newTarget);
                                    allreadyEdge=false;
                                }
                            }
                        }
                        for (int i = 0; i < vertexList.size(); i++) {
                            if (vertexList.get(i).equals(newTarget)) {
                                for(Edge edge: vertexList.get(i).getEdges()){
                                    if(edge.getTarget().equals(newVex)) allreadyEdge=true;
                                }
                                if(!allreadyEdge){
                                    vertexList.get(i).setEdge(newVex);
                                    allreadyEdge=false;
                                }
                            }
                        }
                    }
                }

                if(vertexList.contains(newVex)){
                    if(!vertexList.contains(newTarget)) {
                        for (int i = 0; i < vertexList.size(); i++) {
                            if (vertexList.get(i).equals(newVex)) {
                                vertexList.get(i).setEdge(newTarget);
                                newTarget.setEdge(vertexList.get(i));
                                vertexList.add(newTarget);
                            }

                        }
                    }
                }

                if(!vertexList.contains(newVex)){
                    if(vertexList.contains(newTarget)){
                        for(int i=0;i<vertexList.size();i++) {
                            if (vertexList.get(i).equals(newTarget)) {
                                vertexList.get(i).setEdge(newVex);
                                newVex.setEdge(vertexList.get(i));
                                vertexList.add(newVex);
                            }
                        }
                    }
                }

                if(!vertexList.contains(newVex)){
                    if(!vertexList.contains(newTarget)){
                        newVex.setEdge(newTarget);
                        newTarget.setEdge(newVex);
                        vertexList.add(newVex);
                        vertexList.add(newTarget);
                    }
                }

            }


        }
        br.close();

        return vertexList;

    }

}

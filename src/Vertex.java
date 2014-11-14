import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gomezk on 13.11.14.
 */
public class Vertex {

    private String id;
    private String r;
    private String g;
    private String b;
    private ArrayList<String> edgeList;

    public Vertex(String id){
        this.id=id;
        edgeList= new ArrayList<>();
    }

    public String getId(){
        return id;
    }

    public void setRGB(String r, String g, String b){
        this.r=r;
        this.g=g;
        this.b=b;
    }

    public Vertex getVertexbyID(String id){
        return this;
    }

    public String getRGB(){
        String reString = r+","+g+","+b;
        return reString;

    }

    public ArrayList<String> getEdges(){
        return edgeList;
    }

    public void setEdge(String vertexidto){
        edgeList.add(vertexidto);
    }

}

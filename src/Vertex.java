import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gomezk on 13.11.14.
 */
public class Vertex {

    private int id;
    private int r;
    private int g;
    private int b;
    private ArrayList<Integer> edgeList;

    public Vertex(int id){
        this.id=id;
        edgeList= new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public void setRGB(int r, int g, int b){
        this.r=r;
        this.g=g;
        this.b=b;
    }

    public Vertex getVertexbyID(int id){
        return this;
    }

    public String getRGB(){
        String reString = Integer.toString(r)+","+Integer.toString(g)+","+Integer.toString(b);
        return reString;

    }

    public ArrayList<Integer> getEdges(){
        return edgeList;
    }

    public void setEdge(Integer vertexidto){
        edgeList.add(vertexidto);
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(!(o instanceof Vertex)) return false;
        Vertex vex = (Vertex) o;
        return vex.getId() == id;
    }

    @Override
    public int hashCode() {return id;}

}

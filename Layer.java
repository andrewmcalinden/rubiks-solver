
//Copyright 2020 Andrew McAlinden
import java.util.List;
import java.util.ArrayList;

public class Layer {
    public List<Object> layer;

    public Layer(Corner corner1, Corner corner2, Corner corner3, Corner corner4, Edge edge1, Edge edge2, Edge edge3,
            Edge edge4, Center center) {

        layer = new ArrayList<Object>();

        layer.add(center);
        layer.add(corner1);
        layer.add(edge1);
        layer.add(corner2);
        layer.add(edge2);
        layer.add(corner3);
        layer.add(edge3);
        layer.add(corner4);
        layer.add(edge4);
    }

    public Layer() {
        layer = new ArrayList<Object>();
    }

    public String toString() {
        return "" + layer;
    }
}
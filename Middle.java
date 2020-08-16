//Copyright 2020 Andrew McAlinden
import java.util.ArrayList;

public class Middle extends Layer {

    public Middle(Center center1, Center center2, Center center3, Center center4, Edge edge1, Edge edge2, Edge edge3,
            Edge edge4) {

        layer = new ArrayList<Object>();

        layer.add(center1);
        layer.add(edge1);
        layer.add(center2);
        layer.add(edge2);
        layer.add(center3);
        layer.add(edge3);
        layer.add(center4);
        layer.add(edge4);
    }

    public String toString() {
        return "" + layer;
    }

}
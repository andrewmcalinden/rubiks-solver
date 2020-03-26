import java.util.List;
import java.util.ArrayList;

public class Cube {

    private Center botCenter;

    private Corner cornerBot1;
    private Corner cornerBot2;
    private Corner cornerBot3;
    private Corner cornerBot4;

    private Edge edgeBot1;
    private Edge edgeBot2;
    private Edge edgeBot3;
    private Edge edgeBot4;

    private List<Object> bottom;

    private Center midCenter1;
    private Center midCenter2;
    private Center midCenter3;
    private Center midCenter4;

    private Edge edgeMid1;
    private Edge edgeMid2;
    private Edge edgeMid3;
    private Edge edgeMid4;

    private List<Object> middle;

    private Center topCenter;

    private Corner cornerTop1;
    private Corner cornerTop2;
    private Corner cornerTop3;
    private Corner cornerTop4;

    private Edge edgeTop1;
    private Edge edgeTop2;
    private Edge edgeTop3;
    private Edge edgeTop4;

    private List<Object> top;

    private List<List<Object>> cube;

    public Cube() {
        botCenter = new Center("w");

        cornerBot1 = new Corner("o", "g", "w");
        cornerBot2 = new Corner("g", "r", "y");
        cornerBot3 = new Corner("b", "r", "y");
        cornerBot4 = new Corner("g", "y", "o");

        edgeBot1 = new Edge("g", "r");
        edgeBot2 = new Edge("g", "y");
        edgeBot3 = new Edge("b", "w");
        edgeBot4 = new Edge("r", "y");

        bottom = new ArrayList<Object>();

        bottom.add(botCenter);
        bottom.add(cornerBot1);
        bottom.add(edgeBot1);
        bottom.add(cornerBot2);
        bottom.add(edgeBot2);
        bottom.add(cornerBot3);
        bottom.add(edgeBot3);
        bottom.add(cornerBot4);
        bottom.add(edgeBot4);

        midCenter1 = new Center("b");
        midCenter2 = new Center("r");
        midCenter3 = new Center("g");
        midCenter4 = new Center("o");

        edgeMid1 = new Edge("o", "g");
        edgeMid2 = new Edge("r", "b");
        edgeMid3 = new Edge("r", "w");
        edgeMid4 = new Edge("o", "y");

        middle = new ArrayList<Object>();

        middle.add(midCenter1);
        middle.add(edgeMid1);
        middle.add(midCenter2);
        middle.add(edgeMid2);
        middle.add(midCenter3);
        middle.add(edgeMid3);
        middle.add(midCenter4);
        middle.add(edgeMid4);

        topCenter = new Center("y");

        cornerTop1 = new Corner("w", "g", "r");
        cornerTop2 = new Corner("b", "w", "o");
        cornerTop3 = new Corner("w", "r", "b");
        cornerTop4 = new Corner("y", "b", "o");

        edgeTop1 = new Edge("g", "w");
        edgeTop2 = new Edge("w", "o");
        edgeTop3 = new Edge("y", "b");
        edgeTop4 = new Edge("b", "o");

        top = new ArrayList<Object>();

        top.add(topCenter);
        top.add(cornerTop1);
        top.add(edgeTop1);
        top.add(cornerTop2);
        top.add(edgeTop2);
        top.add(cornerTop3);
        top.add(edgeTop3);
        top.add(cornerTop4);
        top.add(edgeTop4);

        cube = new ArrayList<List<Object>>(3);

        cube.add(bottom);
        cube.add(middle);
        cube.add(top);
    }

    public void D() {

        for (int i = 0; i < bottom.size(); i++) {
            if (bottom.get(i) instanceof Corner) {

                String origSc = ((Corner) bottom.get(i)).getSc();
                String origVc = ((Corner) bottom.get(i)).getVc();

                ((Corner) bottom.get(i)).setSc(origVc);
                ((Corner) bottom.get(i)).setVc(origSc);
            }

        }

        List<Object> temp = new ArrayList<>(bottom);

        for (int i = 1; i < bottom.size(); i++) {

            int index = i + 6;

            if (index > 8) {
                index = (index % 9) + 1;
            }

            temp.set(i, bottom.get(index));

        }

        bottom = temp;
        update();

    }

    public void DPrime() {

        for (int i = 0; i < bottom.size(); i++) {
            if (bottom.get(i) instanceof Corner) {

                String origSc = ((Corner) bottom.get(i)).getSc();
                String origVc = ((Corner) bottom.get(i)).getVc();

                ((Corner) bottom.get(i)).setSc(origVc);
                ((Corner) bottom.get(i)).setVc(origSc);
            }

        }

        List<Object> temp = new ArrayList<>(bottom);

        for (int i = 1; i < bottom.size(); i++) {

            int index = i + 2;

            if (index > 8) {
                index = (index % 9) + 1;
            }

            temp.set(i, bottom.get(index));

        }

        bottom = temp;
        update();

    }

    public void U() {

        for (int i = 0; i < top.size(); i++) {
            if (top.get(i) instanceof Corner) {

                String origSc = ((Corner) top.get(i)).getSc();
                String origVc = ((Corner) top.get(i)).getVc();

                ((Corner) top.get(i)).setSc(origVc);
                ((Corner) top.get(i)).setVc(origSc);
            }

        }

        List<Object> temp = new ArrayList<>(top);

        for (int i = 1; i < top.size(); i++) {

            int index = i + 6;

            if (index > 8) {
                index = (index % 9) + 1;
            }

            temp.set(i, top.get(index));

        }

        top = temp;
        update();

    }

    public void UPrime() {

        for (int i = 0; i < top.size(); i++) {
            if (top.get(i) instanceof Corner) {

                String origSc = ((Corner) top.get(i)).getSc();
                String origVc = ((Corner) top.get(i)).getVc();

                ((Corner) top.get(i)).setSc(origVc);
                ((Corner) top.get(i)).setVc(origSc);
            }

        }

        List<Object> temp = new ArrayList<>(top);

        for (int i = 1; i < top.size(); i++) {

            int index = i + 2;

            if (index > 8) {
                index = (index % 9) + 1;
            }

            temp.set(i, top.get(index));

        }

        top = temp;
        update();

    }

    public void F() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 1 goes to top index 7, fc/sc switched
        String origSc = ((Corner) bottomCopy.get(1)).getSc();
        String origFc = ((Corner) bottomCopy.get(1)).getFc();

        ((Corner) bottomCopy.get(1)).setSc(origFc);
        ((Corner) bottomCopy.get(1)).setFc(origSc);

        top.set(7, bottomCopy.get(1));

        // bottom index 2 goes to middle index 7

        middle.set(7, bottomCopy.get(2));

        // bottom index 3 goes to bottom index 1, fc and sc are switched
        origSc = ((Corner) bottomCopy.get(3)).getSc();
        origFc = ((Corner) bottomCopy.get(3)).getFc();

        ((Corner) bottomCopy.get(3)).setSc(origFc);
        ((Corner) bottomCopy.get(3)).setFc(origSc);

        bottom.set(1, bottomCopy.get(3));

        // top index 5 goes to bottom index 3, fc and sc are switched
        origSc = ((Corner) topCopy.get(5)).getSc();
        origFc = ((Corner) topCopy.get(5)).getFc();

        ((Corner) topCopy.get(5)).setSc(origFc);
        ((Corner) topCopy.get(5)).setFc(origSc);

        bottom.set(3, topCopy.get(5));

        // top index 6 goes to middle index 1, fc and sc are switched
        origSc = ((Edge) topCopy.get(6)).getSc();
        origFc = ((Edge) topCopy.get(6)).getFc();

        ((Edge) topCopy.get(6)).setSc(origFc);
        ((Edge) topCopy.get(6)).setFc(origSc);

        middle.set(1, topCopy.get(6));

        // top index 7 goes to top index 5, fc and sc are switched
        origSc = ((Corner) topCopy.get(7)).getSc();
        origFc = ((Corner) topCopy.get(7)).getFc();

        ((Corner) topCopy.get(7)).setSc(origFc);
        ((Corner) topCopy.get(7)).setFc(origSc);

        top.set(5, topCopy.get(7));

        // middle index 1 goes to bottom index 2, fc and sc are switched
        origSc = ((Edge) middleCopy.get(1)).getSc();
        origFc = ((Edge) middleCopy.get(1)).getFc();

        ((Edge) middleCopy.get(1)).setSc(origFc);
        ((Edge) middleCopy.get(1)).setFc(origSc);

        bottom.set(2, middleCopy.get(1));

        // middle index 7 goes to top index 6

        top.set(6, middleCopy.get(7));

        update();

    }

    public void FPrime() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 1 goes to bottom index 3, fc/sc switched
        String origSc = ((Corner) bottomCopy.get(1)).getSc();
        String origFc = ((Corner) bottomCopy.get(1)).getFc();

        ((Corner) bottomCopy.get(1)).setSc(origFc);
        ((Corner) bottomCopy.get(1)).setFc(origSc);

        bottom.set(3, bottomCopy.get(1));

        // bottom index 2 goes to middle index 1, fc/sc switched
        origSc = ((Edge) bottomCopy.get(2)).getSc();
        origFc = ((Edge) bottomCopy.get(2)).getFc();

        ((Edge) bottomCopy.get(2)).setSc(origFc);
        ((Edge) bottomCopy.get(2)).setFc(origSc);

        middle.set(1, bottomCopy.get(2));

        // bottom index 3 goes to top index 5, fc and sc are switched
        origSc = ((Corner) bottomCopy.get(3)).getSc();
        origFc = ((Corner) bottomCopy.get(3)).getFc();

        ((Corner) bottomCopy.get(3)).setSc(origFc);
        ((Corner) bottomCopy.get(3)).setFc(origSc);

        top.set(5, bottomCopy.get(3));

        // top index 5 goes to top index 7, fc and sc are switched
        origSc = ((Corner) topCopy.get(5)).getSc();
        origFc = ((Corner) topCopy.get(5)).getFc();

        ((Corner) topCopy.get(5)).setSc(origFc);
        ((Corner) topCopy.get(5)).setFc(origSc);

        top.set(7, topCopy.get(5));

        // top index 6 goes to middle index 7
        middle.set(7, topCopy.get(6));

        // top index 7 goes to bottom index 1, fc and sc are switched
        origSc = ((Corner) topCopy.get(7)).getSc();
        origFc = ((Corner) topCopy.get(7)).getFc();

        ((Corner) topCopy.get(7)).setSc(origFc);
        ((Corner) topCopy.get(7)).setFc(origSc);

        bottom.set(1, topCopy.get(7));

        // middle index 1 goes to top index 6, fc and sc are switched
        origSc = ((Edge) middleCopy.get(1)).getSc();
        origFc = ((Edge) middleCopy.get(1)).getFc();

        ((Edge) middleCopy.get(1)).setSc(origFc);
        ((Edge) middleCopy.get(1)).setFc(origSc);

        top.set(6, middleCopy.get(1));

        // middle index 7 goes to bottom index 2

        bottom.set(2, middleCopy.get(7));

        update();

    }

    public void BPrime() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 7 goes to top index 1, fc/sc switched
        String origSc = ((Corner) bottomCopy.get(7)).getSc();
        String origFc = ((Corner) bottomCopy.get(7)).getFc();

        ((Corner) bottomCopy.get(7)).setSc(origFc);
        ((Corner) bottomCopy.get(7)).setFc(origSc);

        top.set(1, bottomCopy.get(7));

        // bottom index 6 goes to middle index 5, fc/sc switched
        origSc = ((Edge) bottomCopy.get(6)).getSc();
        origFc = ((Edge) bottomCopy.get(6)).getFc();

        ((Edge) bottomCopy.get(6)).setSc(origFc);
        ((Edge) bottomCopy.get(6)).setFc(origSc);

        middle.set(7, bottomCopy.get(2));

        // bottom index 3 goes to bottom index 1, fc and sc are switched
        origSc = ((Corner) bottomCopy.get(3)).getSc();
        origFc = ((Corner) bottomCopy.get(3)).getFc();

        ((Corner) bottomCopy.get(3)).setSc(origFc);
        ((Corner) bottomCopy.get(3)).setFc(origSc);

        bottom.set(1, bottomCopy.get(3));

        // top index 5 goes to bottom index 3, fc and sc are switched
        origSc = ((Corner) topCopy.get(5)).getSc();
        origFc = ((Corner) topCopy.get(5)).getFc();

        ((Corner) topCopy.get(5)).setSc(origFc);
        ((Corner) topCopy.get(5)).setFc(origSc);

        bottom.set(3, topCopy.get(5));

        // top index 6 goes to middle index 1, fc and sc are switched
        origSc = ((Edge) topCopy.get(6)).getSc();
        origFc = ((Edge) topCopy.get(6)).getFc();

        ((Edge) topCopy.get(6)).setSc(origFc);
        ((Edge) topCopy.get(6)).setFc(origSc);

        middle.set(1, topCopy.get(6));

        // top index 7 goes to top index 5, fc and sc are switched
        origSc = ((Corner) topCopy.get(7)).getSc();
        origFc = ((Corner) topCopy.get(7)).getFc();

        ((Corner) topCopy.get(7)).setSc(origFc);
        ((Corner) topCopy.get(7)).setFc(origSc);

        top.set(5, topCopy.get(7));

        // middle index 1 goes to bottom index 2, fc and sc are switched
        origSc = ((Edge) middleCopy.get(1)).getSc();
        origFc = ((Edge) middleCopy.get(1)).getFc();

        ((Edge) middleCopy.get(1)).setSc(origFc);
        ((Edge) middleCopy.get(1)).setFc(origSc);

        bottom.set(2, middleCopy.get(1));

        // middle index 7 goes to top index 6

        top.set(6, middleCopy.get(7));

        update();

    }

    public void update() {
        cube.clear();

        cube.add(bottom);
        cube.add(middle);
        cube.add(top);
    }

    public void flipFS()

    public String toString() {
        return "" + cube;
    }
}
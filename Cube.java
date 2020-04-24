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

    private List<String> moves;

    private List<List<Object>> cube;

    public Cube() {
        botCenter = new Center("w");

        cornerBot1 = new Corner("w", "b", "o");
        cornerBot2 = new Corner("w", "b", "r");
        cornerBot3 = new Corner("w", "g", "r");
        cornerBot4 = new Corner("w", "g", "o");

        edgeBot1 = new Edge("w", "b");
        edgeBot2 = new Edge("w", "r");
        edgeBot3 = new Edge("w", "g");
        edgeBot4 = new Edge("w", "o");

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

        edgeMid1 = new Edge("b", "r");
        edgeMid2 = new Edge("r", "g");
        edgeMid3 = new Edge("g", "o");
        edgeMid4 = new Edge("o", "b");

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

        cornerTop1 = new Corner("y", "g", "o");
        cornerTop2 = new Corner("y", "g", "r");
        cornerTop3 = new Corner("y", "b", "r");
        cornerTop4 = new Corner("y", "b", "o");

        edgeTop1 = new Edge("y", "g");
        edgeTop2 = new Edge("y", "r");
        edgeTop3 = new Edge("y", "b");
        edgeTop4 = new Edge("y", "o");

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

        moves = new ArrayList<String>();
    }

    public void D() {

        for (int i = 1; i < bottom.size(); i += 2) {
            ((Corner) (bottom.get(i))).switchScVc();
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

        moves.add("D ");

    }

    public void DPrime() {

        for (int i = 1; i < bottom.size(); i += 2) {
            ((Corner) (bottom.get(i))).switchScVc();
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

        moves.add("D' ");

    }

    public void U() {

        for (int i = 1; i < top.size(); i += 2) {
            ((Corner) (top.get(i))).switchScVc();
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

        moves.add("U ");

    }

    public void UPrime() {

        for (int i = 1; i < top.size(); i += 2) {
            ((Corner) (top.get(i))).switchScVc();
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

        moves.add("U' ");

    }

    public void F() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 1 goes to top index 7, fc/sc switched
        ((Corner) bottomCopy.get(1)).switchScFc();
        top.set(7, bottomCopy.get(1));

        // bottom index 2 goes to middle index 7
        middle.set(7, bottomCopy.get(2));

        // bottom index 3 goes to bottom index 1, fc and sc are switched
        ((Corner) bottomCopy.get(3)).switchScFc();
        bottom.set(1, bottomCopy.get(3));

        // top index 5 goes to bottom index 3, fc and sc are switched
        ((Corner) topCopy.get(5)).switchScFc();
        bottom.set(3, topCopy.get(5));

        // top index 6 goes to middle index 1, fc and sc are switched
        ((Edge) topCopy.get(6)).switchScFc();
        middle.set(1, topCopy.get(6));

        // top index 7 goes to top index 5, fc and sc are switched
        ((Corner) topCopy.get(7)).switchScFc();
        top.set(5, topCopy.get(7));

        // middle index 1 goes to bottom index 2, fc and sc are switched
        ((Edge) middleCopy.get(1)).switchScFc();
        bottom.set(2, middleCopy.get(1));

        // middle index 7 goes to top index 6
        top.set(6, middleCopy.get(7));

        update();
        moves.add("F ");

    }

    public void FPrime() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 1 goes to bottom index 3, fc/sc switched
        ((Corner) bottomCopy.get(1)).switchScFc();
        bottom.set(3, bottomCopy.get(1));

        // bottom index 2 goes to middle index 1, fc/sc switched
        ((Edge) bottomCopy.get(2)).switchScFc();
        middle.set(1, bottomCopy.get(2));

        // bottom index 3 goes to top index 5, fc and sc are switched
        ((Corner) bottomCopy.get(3)).switchScFc();
        top.set(5, bottomCopy.get(3));

        // top index 5 goes to top index 7, fc and sc are switched
        ((Corner) topCopy.get(5)).switchScFc();
        top.set(7, topCopy.get(5));

        // top index 6 goes to middle index 7
        middle.set(7, topCopy.get(6));

        // top index 7 goes to bottom index 1, fc and sc are switched
        ((Corner) topCopy.get(7)).switchScFc();
        bottom.set(1, topCopy.get(7));

        // middle index 1 goes to top index 6, fc and sc are switched
        ((Edge) middleCopy.get(1)).switchScFc();
        top.set(6, middleCopy.get(1));

        // middle index 7 goes to bottom index 2
        bottom.set(2, middleCopy.get(7));

        update();
        moves.add("F' ");

    }

    public void BPrime() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 7 goes to top index 1, fc/sc switched
        ((Corner) bottomCopy.get(7)).switchScFc();
        top.set(1, bottomCopy.get(7));

        // bottom index 6 goes to middle index 5, fc/sc switched
        ((Edge) bottomCopy.get(6)).switchScFc();
        middle.set(5, bottomCopy.get(6));

        // bottom index 5 goes to bottom index 7, fc and sc are switched
        ((Corner) bottomCopy.get(5)).switchScFc();
        bottom.set(7, bottomCopy.get(5));

        // top index 3 goes to bottom index 5, fc and sc are switched
        ((Corner) topCopy.get(3)).switchScFc();
        bottom.set(5, topCopy.get(3));

        // top index 2 goes to middle index 3
        middle.set(3, topCopy.get(2));

        // top index 1 goes to top index 3, fc and sc are switched
        ((Corner) topCopy.get(1)).switchScFc();
        top.set(3, topCopy.get(1));

        // middle index 3 goes to bottom index 6
        bottom.set(6, middleCopy.get(3));

        // middle index 5 goes to top index 2, fc/sc switched
        ((Edge) middleCopy.get(5)).switchScFc();
        top.set(2, middleCopy.get(5));

        update();
        moves.add("B' ");

    }

    public void B() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 5 goes to top index 3, fc/sc switched
        ((Corner) bottomCopy.get(5)).switchScFc();
        top.set(3, bottomCopy.get(5));

        // bottom index 6 goes to middle index 3
        middle.set(3, bottomCopy.get(6));

        // bottom index 7 goes to bottom index 5, fc and sc are switched
        ((Corner) bottomCopy.get(7)).switchScFc();
        bottom.set(5, bottomCopy.get(7));

        // top index 1 goes to bottom index 7, fc and sc are switched
        ((Corner) topCopy.get(1)).switchScFc();
        bottom.set(7, topCopy.get(1));

        // top index 2 goes to middle index 5, fc/sc switched
        ((Edge) topCopy.get(2)).switchScFc();
        middle.set(5, topCopy.get(2));

        // top index 3 goes to top index 1, fc and sc are switched
        ((Corner) topCopy.get(3)).switchScFc();
        top.set(1, topCopy.get(3));

        // middle index 5 goes to bottom index 6, fc/sc switched
        ((Edge) middleCopy.get(5)).switchScFc();
        bottom.set(6, middleCopy.get(5));

        // middle index 3 goes to top index 2
        top.set(2, middleCopy.get(3));

        update();
        moves.add("B ");

    }

    public void R() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 3 goes to top index 5, fc/vc switched
        ((Corner) bottomCopy.get(3)).switchVcFc();
        top.set(5, bottomCopy.get(3));

        // bottom index 4 goes to middle index 1
        middle.set(1, bottomCopy.get(4));

        // bottom index 5 goes to bottom index 3, fc and vc are switched
        ((Corner) bottomCopy.get(5)).switchVcFc();
        bottom.set(3, bottomCopy.get(5));

        // top index 3 goes to bottom index 5, fc and vc are switched
        ((Corner) topCopy.get(3)).switchVcFc();
        bottom.set(5, topCopy.get(3));

        // top index 4 goes to middle index 3, fc/sc switched
        ((Edge) topCopy.get(4)).switchScFc();
        middle.set(3, topCopy.get(4));

        // top index 5 goes to top index 3, fc and vc are switched
        ((Corner) topCopy.get(5)).switchVcFc();
        top.set(3, topCopy.get(5));

        // middle index 3 goes to bottom index 4, fc/sc switched
        ((Edge) middleCopy.get(3)).switchScFc();
        bottom.set(4, middleCopy.get(3));

        // middle index 1 goes to top index 4
        top.set(4, middleCopy.get(1));

        update();
        moves.add("R ");

    }

    public void RPrime() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 5 goes to top index 3, fc/vc switched
        ((Corner) bottomCopy.get(5)).switchVcFc();
        top.set(3, bottomCopy.get(5));

        // middle index 1 goes to bottom index 4
        bottom.set(4, middleCopy.get(1));

        // bottom index 3 goes to bottom index 5, fc and vc are switched
        ((Corner) bottomCopy.get(3)).switchVcFc();
        bottom.set(5, bottomCopy.get(3));

        // top index 5 goes to bottom index 3, fc and vc are switched
        ((Corner) topCopy.get(5)).switchVcFc();
        bottom.set(3, topCopy.get(5));

        // middle index 3 goes to top index 4, fc/sc switched
        ((Edge) middleCopy.get(3)).switchScFc();
        top.set(4, middleCopy.get(3));

        // top index 3 goes to top index 5, fc and vc are switched
        ((Corner) topCopy.get(3)).switchVcFc();
        top.set(5, topCopy.get(3));

        // bottom index 4 goes to middle index 3, fc/sc switched
        ((Edge) bottomCopy.get(4)).switchScFc();
        middle.set(3, bottomCopy.get(4));

        // top index 4 goes to middle index 1
        middle.set(1, topCopy.get(4));

        update();
        moves.add("R' ");
    }

    public void L() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 7 goes to top index 1, fc/vc switched
        ((Corner) bottomCopy.get(7)).switchVcFc();
        top.set(1, bottomCopy.get(7));

        // middle index 7 goes to bottom index 8, fc/sc switched
        ((Edge) middleCopy.get(7)).switchScFc();
        bottom.set(8, middleCopy.get(7));

        // bottom index 1 goes to bottom index 7, fc and vc are switched
        ((Corner) bottomCopy.get(1)).switchVcFc();
        bottom.set(7, bottomCopy.get(1));

        // top index 7 goes to bottom index 1, fc and vc are switched
        ((Corner) topCopy.get(7)).switchVcFc();
        bottom.set(1, topCopy.get(7));

        // middle index 5 goes to top index 8
        top.set(8, middleCopy.get(5));

        // top index 1 goes to top index 7, fc and vc are switched
        ((Corner) topCopy.get(1)).switchVcFc();
        top.set(7, topCopy.get(1));

        // bottom index 8 goes to middle index 5
        middle.set(5, bottomCopy.get(8));

        // top index 8 goes to middle index 7, fc/sc switched
        ((Edge) topCopy.get(8)).switchScFc();
        middle.set(7, topCopy.get(8));

        update();
        moves.add("L ");
    }

    public void LPrime() {
        List<Object> bottomCopy = new ArrayList<>(bottom);
        List<Object> topCopy = new ArrayList<>(top);
        List<Object> middleCopy = new ArrayList<>(middle);

        // bottom index 1 goes to top index 7, fc/vc switched
        ((Corner) bottomCopy.get(1)).switchVcFc();
        top.set(7, bottomCopy.get(1));

        // bottom index 8 goes to middle index 7, fc/sc switched
        ((Edge) bottomCopy.get(8)).switchScFc();
        middle.set(7, bottomCopy.get(8));

        // bottom index 7 goes to bottom index 1, fc and vc are switched
        ((Corner) bottomCopy.get(7)).switchVcFc();
        bottom.set(1, bottomCopy.get(7));

        // top index 1 goes to bottom index 7, fc and vc are switched
        ((Corner) topCopy.get(1)).switchVcFc();
        bottom.set(7, topCopy.get(1));

        // top index 8 goes to middle index 5
        middle.set(5, topCopy.get(8));

        // top index 7 goes to top index 1, fc and vc are switched
        ((Corner) topCopy.get(7)).switchVcFc();
        top.set(1, topCopy.get(7));

        // middle index 5 goes to bottom index 8
        bottom.set(8, middleCopy.get(5));

        // middle index 7 goes to top index 8, fc/sc switched
        ((Edge) middleCopy.get(7)).switchScFc();
        top.set(8, middleCopy.get(7));

        update();
        moves.add("L' ");
    }

    public void scramble(String moves1) {
        String[] ray = moves1.split(" ");

        for (String str : ray) {
            switch (str) {
                case "U":
                    U();
                    break;
                case "U'":
                    UPrime();
                    break;
                case "D":
                    D();
                    break;
                case "D'":
                    DPrime();
                    break;
                case "F":
                    F();
                    break;
                case "F'":
                    FPrime();
                    break;
                case "B":
                    B();
                    break;
                case "B'":
                    BPrime();
                    break;
                case "R":
                    R();
                    break;
                case "R'":
                    RPrime();
                    break;
                case "L":
                    L();
                    break;
                case "L'":
                    LPrime();
                    break;
            }
            moves.remove(0);
        }
    }

    public void startCross() {
        // put all white pieces around yellow, then rotate to correct center and twist
        // 180 degrees

        // first, look for white not rotated correcty in top layer
        for (int i = 2; i < top.size(); i += 2) {

            Edge current = (Edge) top.get(i);

            if (current.getSc().equals("w")) {
                // first move it in front of the blue center
                if (i == 2) {

                    U();
                    U();
                }

                else if (i == 4) {
                    U();
                }

                // if i ==6, it's already in front of blue face

                else if (i == 8) {
                    UPrime();
                }
                // then, make it so white faces up
                F();
                UPrime();
                R();
            }

        }

        moves.add("end top wrong ");

        // then, look for white in the bottom layer rotated correctly for a 180 degree
        // turn

        for (int i = 2; i < bottom.size(); i += 2) {

            Edge current = (Edge) bottom.get(i);

            if (current.getFc().equals("w")) {
                int target = i;

                if (target == 8 || target == 4) {
                    while (((Edge) top.get(target)).getFc().equals("w")) { // while place we want to put edge has white,
                                                                           // keep twisting

                        U();
                    }
                } else {
                    while (((Edge) top.get(target)).getFc().equals("w")) { // while place we want to put edge has white,
                                                                           // keep twisting

                        U();
                    }
                    U(); // because indexes 6 and 2 are actually opposite, do U twice to account for the
                         // offset
                    U();
                }

                // then, depending on where we aligned the edge, rotate it to the top layer
                if (target == 2) {
                    B();
                    B();
                }

                if (target == 4) {
                    R();
                    R();
                }

                if (target == 6) {
                    F();
                    F();
                }

                if (target == 8) {
                    L();
                    L();
                }
            }
        }

        moves.add("end bottom right ");

        // now, check for edges in the bottom rotated incorrectly

        for (int i = 2; i < bottom.size(); i += 2) {

            Edge current = (Edge) bottom.get(i);

            if (current.getSc().equals("w")) {
                int target = i;

                if (target == 8 || target == 4) {
                    while (((Edge) top.get(target)).getFc().equals("w")) { // while place we want to put edge has white,
                                                                           // keep twisting

                        U();
                    }
                } else {

                    while (((Edge) top.get(target)).getFc().equals("w")) { // while place we want to put edge has white,
                                                                           // keep twisting

                        U();
                    }

                    // because indexes 6 and 2 are actually opposite, do D twice to account for the
                    // offset
                    U();
                    U();

                }

                // then, depending on where we aligned the edge, rotate it to the top layer
                if (target == 2) {
                    F();
                    U();
                    LPrime();
                }

                if (target == 4) {
                    R();
                    U();
                    FPrime();
                }

                if (target == 6) {
                    B();
                    U();
                    RPrime();
                }

                if (target == 8) {
                    LPrime();
                    UPrime();
                    F();
                }
            }
        }

        moves.add("end bottom wrong ");

        // look for edges in middle layer to flip up

        // loop through middle layer looking for edges with white
        for (int i = 1; i < middle.size(); i += 2) {

            Edge current = (Edge) middle.get(i);

            if (current.getFc().equals("w") || current.getSc().equals("w")) {

                // cases for each location it could be in
                switch (i) {

                    case 1:
                        // tells us which way to flip it up
                        if (current.getFc().equals("w")) {
                            // rotate top layer until its safe to insert in edge
                            while (((Edge) top.get(4)).getFc().equals("w")) {
                                U();
                            }
                            // rotate it in
                            R();

                        }
                        // sc was white
                        else {
                            while (((Edge) top.get(6)).getFc().equals("w")) {
                                U();
                            }

                            FPrime();
                        }
                        break;

                    case 3:
                        if (current.getFc().equals("w")) {
                            // rotate top layer until its safe to insert in edge
                            while (((Edge) top.get(2)).getFc().equals("w")) {
                                U();
                            }
                            // rotate it in
                            B();

                        }

                        else {
                            while (((Edge) top.get(4)).getFc().equals("w")) {
                                U();
                            }

                            RPrime();
                        }
                        break;

                    case 5:
                        if (current.getFc().equals("w")) {
                            // rotate top layer until its safe to insert in edge
                            while (((Edge) top.get(8)).getFc().equals("w")) {
                                U();
                            }
                            // rotate it in
                            L();

                        }

                        else {
                            while (((Edge) top.get(2)).getFc().equals("w")) {
                                U();
                            }

                            BPrime();
                        }
                        break;

                    case 7:
                        if (current.getFc().equals("w")) {
                            // rotate top layer until its safe to insert in edge
                            while (((Edge) top.get(6)).getFc().equals("w")) {
                                U();
                            }
                            // rotate it in
                            F();

                        }

                        else {
                            while (((Edge) top.get(8)).getFc().equals("w")) {
                                U();
                            }

                            LPrime();
                        }
                        break;

                }
            }

        }

        moves.add("end middle ");

    }

    public void finishCross() {
        int offset = 0; // how far away next white piece

        int[] indexes = { 2, 4, 6, 8 };

        String two = ((Edge) top.get(2)).getSc();

        switch (two) {
            case "g":
                B();
                B();
                break;

            case "r":
                U();
                offset += 1;
                R();
                R();
                break;

            case "b":
                U();
                U();
                offset += 2;
                F();
                F();
                break;

            case "o":
                UPrime();
                offset += 3;
                L();
                L();
                break;
        }

        int start = indexes[(1 + offset) % 4];

        Edge current = ((Edge) top.get(start));

        String four = current.getSc();

        switch (four) {
            case "g":
                int target = 2;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                B();
                B();
                break;

            case "r":

                target = 4;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                R();
                R();
                break;

            case "b":
                target = 6;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                F();
                F();
                break;

            case "o":
                target = 8;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                L();
                L();
                break;
        }

        start = indexes[(2 + offset) % 4];

        current = ((Edge) top.get(start));

        String six = current.getSc();

        switch (six) {
            case "g":
                int target = 2;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                B();
                B();
                break;

            case "r":
                target = 4;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                R();
                R();
                break;

            case "b":
                target = 6;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                F();
                F();
                break;

            case "o":
                target = 8;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                L();
                L();
                break;
        }

        start = indexes[(3 + offset) % 4];

        current = ((Edge) top.get(start));

        String eight = ((Edge) top.get(start)).getSc();

        switch (eight) {
            case "g":
                int target = 2;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                B();
                B();
                break;

            case "r":
                target = 4;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                R();
                R();
                break;

            case "b":
                target = 6;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                F();
                F();
                break;

            case "o":
                target = 8;

                while (top.indexOf(current) != target) { // while location of edge is not at a known safe
                                                         // spot, keep twisting
                    U();
                    offset++;
                }

                L();
                L();
                break;
        }
    }

    public void cross() {
        while (!crossMade()) {
            startCross();
        }
        moves.add("state 1 of cross complete");
        finishCross();
    }

    public boolean crossMade() {
        boolean one = ((Edge) top.get(2)).getFc().equals("w");
        boolean two = ((Edge) top.get(4)).getFc().equals("w");
        boolean three = ((Edge) top.get(6)).getFc().equals("w");
        boolean four = ((Edge) top.get(8)).getFc().equals("w");

        return (one && two && three && four);
    }

    public void update() {
        cube.clear();

        cube.add(bottom);
        cube.add(middle);
        cube.add(top);
    }

    public String toString() {
        return "" + cube + moves;
    }
}
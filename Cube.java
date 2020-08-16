//Copyright 2020 Andrew McAlinden
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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

    public List<String> moves;

    private List<List<Object>> cube;

    private List<Integer> unsolvedBottomCorners;

    public List<List<Object>> solvedState;

    private boolean crossTelem;

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

        solvedState = Collections.unmodifiableList(cube);

        moves = new ArrayList<String>();

        unsolvedBottomCorners = new ArrayList<Integer>();

        crossTelem = false;
    }

    public boolean isSolved() {
        System.out.println("correct: " + solvedState);
        System.out.println("cube: " + cube);
        return (solvedState.equals(cube));
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
        if (crossTelem) {
            moves.add("end top wrong ");
        }

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
                    F();
                    F();
                }

                if (target == 4) {
                    R();
                    R();
                }

                if (target == 6) {
                    B();
                    B();
                }

                if (target == 8) {
                    L();
                    L();
                }
            }
        }

        if (crossTelem) {
            moves.add("end bottom right");
        }
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
        if (crossTelem) {
            moves.add("end bottom wrong ");
        }

        // look for edges in middle layer to flip up

        // loop through middle layer looking for edges with white
        for (int i = 1; i < middle.size(); i += 2) {

            Edge current = (Edge) middle.get(i);

            if (current.has("w")) {

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

        if (crossTelem) {
            moves.add("end middle ");
        }
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
        if (crossTelem) {
            moves.add("stage 1 of cross complete ");
        }
        finishCross();
        moves.add("cross done");
    }

    public boolean crossMade() {
        boolean one = ((Edge) top.get(2)).getFc().equals("w");
        boolean two = ((Edge) top.get(4)).getFc().equals("w");
        boolean three = ((Edge) top.get(6)).getFc().equals("w");
        boolean four = ((Edge) top.get(8)).getFc().equals("w");

        return (one && two && three && four);
    }

    public void bottomCorners() {

        Corner one = new Corner("w", "b", "o");
        Corner two = new Corner("w", "b", "r");
        Corner three = new Corner("w", "g", "r");
        Corner four = new Corner("w", "g", "o");

        Corner real1 = (Corner) bottom.get(1);
        Corner real2 = (Corner) bottom.get(3);
        Corner real3 = (Corner) bottom.get(5);
        Corner real4 = (Corner) bottom.get(7);

        if (!(real1.equals(one))) {
            unsolvedBottomCorners.add(1);
        }

        if (!(real2.equals(two))) {
            unsolvedBottomCorners.add(3);
        }

        if (!(real3.equals(three))) {
            unsolvedBottomCorners.add(5);
        }

        if (!(real4.equals(four))) {
            unsolvedBottomCorners.add(7);
        }

        while (!bottomCornersDone()) {
            while (whiteInTop()) {
                insertCornersInBottom();
            }
            bringCornersIntoTop();
        }
        moves.add("first layer done ");
    }

    public boolean whiteInTop() {
        for (int i = 1; i < top.size(); i += 2) {
            Corner current = (Corner) top.get(i);

            if (current.has("w")) {
                return true;
            }
        }
        return false;
    }

    public boolean nonYellowInTop() {
        for (int i = 2; i < top.size(); i += 2) {
            Edge current = (Edge) top.get(i);

            if (!(current.has("y"))) {
                return true;
            }
        }
        return false;
    }

    public void insertCornersInBottom() {

        // insert corners in top layer
        for (int i = 1; i < top.size(); i += 2) {
            Corner current = ((Corner) top.get(i));
            if (current.has("w")) {

                String c1 = "";
                String c2 = "";

                // figure out what non white colors are to figure out where corner should go
                if (current.getFc().equals("w")) {
                    c1 = current.getSc();
                    c2 = current.getVc();
                } else if (current.getVc().equals("w")) {
                    c1 = current.getSc();
                    c2 = current.getFc();
                } else { // sc was white
                    c1 = current.getFc();
                    c2 = current.getVc();
                }

                if ((c1.equals("b") || c1.equals("r")) && (c2.equals("r") || c2.equals("b"))) {
                    // rotate corner above where it needs to go in
                    while (top.indexOf(current) != 5) {
                        U();
                    }
                    // then insert it in depending on its rotation
                    if (current.getFc().equals("w")) {
                        R();
                        U();
                        U();
                        RPrime();
                        UPrime();
                        R();
                        U();
                        RPrime();
                    } else if (current.getSc().equals("w")) {
                        R();
                        U();
                        RPrime();
                    } else { // Vc was white
                        U();
                        R();
                        UPrime();
                        RPrime();
                    }
                    
                    unsolvedBottomCorners.remove(unsolvedBottomCorners.indexOf(3)); // now index 3 is solved
                }

                else if ((c1.equals("b") || c1.equals("o")) && (c2.equals("o") || c2.equals("b"))) {
                    // rotate corner above where it needs to go in
                    while (top.indexOf(current) != 7) {
                        U();
                    }
                    // then insert it in
                    if (current.getFc().equals("w")) {
                        F();
                        U();
                        U();
                        FPrime();
                        UPrime();
                        F();
                        U();
                        FPrime();
                    } else if (current.getSc().equals("w")) {
                        U();
                        F();
                        UPrime();
                        FPrime();
                    } else { // Vc was white
                        F();
                        U();
                        FPrime();
                    }

                    unsolvedBottomCorners.remove(unsolvedBottomCorners.indexOf(1)); // now index 1 is solved
                }

                else if ((c1.equals("r") || c1.equals("g")) && (c2.equals("g") || c2.equals("r"))) {
                    // rotate corner above where it needs to go in
                    while (top.indexOf(current) != 3) {
                        U();
                    }
                    // then insert it in
                    if (current.getFc().equals("w")) {
                        B();
                        U();
                        U();
                        BPrime();
                        UPrime();
                        B();
                        U();
                        BPrime();
                    } else if (current.getSc().equals("w")) {
                        U();
                        B();
                        UPrime();
                        BPrime();
                    } else { // Vc was white
                        UPrime();
                        RPrime();
                        U();
                        R();
                    }
                    unsolvedBottomCorners.remove(unsolvedBottomCorners.indexOf(5)); // now index 5 is solved
                }

                // colors were green and orange
                else {
                    // rotate corner above where it needs to go in
                    while (top.indexOf(current) != 1) {
                        U();
                    }
                    // then insert it in
                    if (current.getFc().equals("w")) {
                        L();
                        U();
                        U();
                        LPrime();
                        UPrime();
                        L();
                        U();
                        LPrime();
                    } else if (current.getSc().equals("w")) {
                        L();
                        U();
                        LPrime();
                    } else { // Vc was white
                        U();
                        L();
                        UPrime();
                        LPrime();
                    }
                    unsolvedBottomCorners.remove(unsolvedBottomCorners.indexOf(7)); // now index 7 is solved

                }
            }
        }
    }

    public void bringCornersIntoTop() {
        // bring incorrectly rotated corners up to top layer
        for (int i = 1; i < bottom.size(); i += 2) {
            Corner current = (Corner) bottom.get(i);

            if (current.has("w") && (unsolvedBottomCorners.indexOf(i) >= 0)) {
                switch (i) {
                    case 1:
                        LPrime();
                        UPrime();
                        L();
                        U();
                        break;

                    case 3:
                        R();
                        U();
                        RPrime();
                        UPrime();
                        break;

                    case 5:
                        B();
                        U();
                        BPrime();
                        UPrime();
                        break;

                    case 7:
                        L();
                        UPrime();
                        LPrime();
                        U();
                        break;
                }
            }
        }

    }

    public void bringEdgesIntoTop() {
        // bring incorrectly rotated corners up to top layer
        for (int i = 1; i < middle.size(); i += 2) {
            Center center1 = (Center) middle.get(i - 1);
            Edge current = (Edge) middle.get(i);
            Center center2;
            if (i == 7) {
                center2 = (Center) middle.get(0);
            } else {
                center2 = (Center) middle.get(i + 1);
            }

            String c1 = center1.getColor();
            String e1 = current.getFc();
            String e2 = current.getSc();
            String c2 = center2.getColor();

            if ((!(c1.equals(e1))) || (!(c2.equals(e2)))) {
                switch (i) {
                    case 1:
                        R();
                        U();
                        RPrime();
                        UPrime();
                        FPrime();
                        UPrime();
                        F();
                        break;

                    case 3:
                        B();
                        U();
                        BPrime();
                        UPrime();
                        RPrime();
                        UPrime();
                        R();
                        break;

                    case 5:
                        L();
                        U();
                        LPrime();
                        UPrime();
                        BPrime();
                        UPrime();
                        B();
                        break;

                    case 7:
                        F();
                        U();
                        FPrime();
                        UPrime();
                        LPrime();
                        UPrime();
                        L();

                        break;
                }
            }
        }

    }

    public boolean bottomCornersDone() {
        Corner one = new Corner("w", "b", "o");
        Corner two = new Corner("w", "b", "r");
        Corner three = new Corner("w", "g", "r");
        Corner four = new Corner("w", "g", "o");

        Corner real1 = (Corner) bottom.get(1);
        Corner real2 = (Corner) bottom.get(3);
        Corner real3 = (Corner) bottom.get(5);
        Corner real4 = (Corner) bottom.get(7);

        return (one.equals(real1) && two.equals(real2) && three.equals(real3) && four.equals(real4));
    }

    public void insertEdges() {
        for (int i = 2; i < top.size(); i += 2) {
            Edge current = (Edge) (top.get(i));

            if (!(current.has("y"))) {
                String c1 = current.getFc();
                String c2 = current.getSc();

                int target;
                if (c2.equals("b")) {
                    // rotate edge until in correct spot
                    target = 6;
                    while (top.indexOf(current) != target) {
                        U();
                    }

                    if (c1.equals("r")) {
                        U();
                        R();
                        U();
                        RPrime();
                        UPrime();
                        FPrime();
                        UPrime();
                        F();
                    } else { // c1 was orange
                        UPrime();
                        LPrime();
                        UPrime();
                        L();
                        U();
                        F();
                        U();
                        FPrime();
                    }
                }

                else if (c2.equals("r")) {
                    // rotate edge until in correct spot
                    target = 4;
                    while (top.indexOf(current) != target) {
                        U();
                    }

                    if (c1.equals("b")) {
                        UPrime();
                        FPrime();
                        UPrime();
                        F();
                        U();
                        R();
                        U();
                        RPrime();
                    } else { // c1 was green
                        U();
                        B();
                        U();
                        BPrime();
                        UPrime();
                        RPrime();
                        UPrime();
                        R();
                    }
                }

                else if (c2.equals("g")) {
                    // rotate edge until in correct spot
                    target = 2;
                    while (top.indexOf(current) != target) {
                        U();
                    }

                    if (c1.equals("r")) {
                        UPrime();
                        RPrime();
                        UPrime();
                        R();
                        U();
                        B();
                        U();
                        BPrime();
                    } else { // c1 was orange
                        U();
                        L();
                        U();
                        LPrime();
                        UPrime();
                        BPrime();
                        UPrime();
                        B();
                    }
                }

                else { // c2 was orange
                       // rotate edge until in correct spot
                    target = 8;
                    while (top.indexOf(current) != target) {
                        U();
                    }

                    if (c1.equals("g")) {
                        UPrime();
                        BPrime();
                        UPrime();
                        B();
                        U();
                        L();
                        U();
                        LPrime();
                    } else { // c1 was blue
                        U();
                        F();
                        U();
                        FPrime();
                        UPrime();
                        LPrime();
                        UPrime();
                        L();
                    }
                }
            }
        }
    }

    public boolean secondLayerDone() {
        Edge one = new Edge("b", "r");
        Edge two = new Edge("r", "g");
        Edge three = new Edge("g", "o");
        Edge four = new Edge("o", "b");

        Edge real1 = (Edge) middle.get(1);
        Edge real2 = (Edge) middle.get(3);
        Edge real3 = (Edge) middle.get(5);
        Edge real4 = (Edge) middle.get(7);

        return (one.equals(real1) && two.equals(real2) && three.equals(real3) && four.equals(real4));
    }

    public void putEdgesIntoTop() {
        for (int i = 1; i < middle.size(); i += 2) {

        }
    }

    public void secondLayer() {
        while (!secondLayerDone()) {
            while (nonYellowInTop()) {
                insertEdges();
            }
            bringEdgesIntoTop();
        }
        moves.add("second layer done ");
    }

    public void topCross() {
        ArrayList<Integer> yellowUpLocations = new ArrayList<Integer>();

        for (int i = 2; i < top.size(); i += 2) {
            Edge current = (Edge) top.get(i);
            if (current.getFc().equals("y")) {
                yellowUpLocations.add(i);
            }
        }

        if (yellowUpLocations.size() == 4) { // already done
            // do nothing
        }

        else if (yellowUpLocations.size() == 0) { // if no edges were correctly oriented
            F();
            R();
            U();
            RPrime();
            UPrime();
            FPrime();
            B();
            U();
            L();
            UPrime();
            LPrime();
            BPrime();
        }

        else { // 2 were yellow
            int diff = Math.abs(yellowUpLocations.get(0) - yellowUpLocations.get(1));
            if (diff == 2) { // edges were right next to each other
                String four = ((Edge) top.get(4)).getFc();
                String six = ((Edge) top.get(6)).getFc();

                while (!(four.equals("y") && six.equals("y"))) { // while the yellows arent in the right location
                    U();
                    four = ((Edge) top.get(4)).getFc();
                    six = ((Edge) top.get(6)).getFc();
                }

                B();
                U();
                L();
                UPrime();
                LPrime();
                BPrime();
            }

            else { // edges are across from each other
                String eight = ((Edge) top.get(8)).getFc();
                String four = ((Edge) top.get(4)).getFc();

                while (!(four.equals("y") && eight.equals("y"))) { // while the yellows arent in the right
                                                                   // location
                    U();
                    four = ((Edge) top.get(4)).getFc();
                    eight = ((Edge) top.get(8)).getFc();
                }

                F();
                R();
                U();
                RPrime();
                UPrime();
                FPrime();
            }
        }
        moves.add(" top cross done");
    }

    public void topCorners() {
        ArrayList<Integer> yellowUpLocations = new ArrayList<Integer>();

        for (int i = 1; i < top.size(); i += 2) {
            Corner current = (Corner) top.get(i);
            if (current.getFc().equals("y")) {
                yellowUpLocations.add(i);
            }
        }

        if (yellowUpLocations.size() == 0) { // case 21 and 22
            int sc = 0;
            int vc = 0;
            for (int i = 1; i < top.size(); i += 2) {
                Corner current = (Corner) top.get(i);
                if (current.getVc().equals("y")) {
                    vc++;
                } else if (current.getSc().equals("y")) {
                    sc++;
                }
            }

            if (sc == 2 && vc == 2) { // case 22
                while (!(((Corner) top.get(1)).getSc().equals("y") && ((Corner) top.get(7)).getSc().equals("y"))) {
                    U();
                }
                R();
                U();
                U();
                R();
                R();
                UPrime();
                R();
                R();
                UPrime();
                R();
                R();
                U();
                U();
                R();
            }

            else {// vc or sc was 4, case 21
                while (!(((Corner) top.get(1)).getVc().equals("y"))) {
                    U();
                }
                R();
                U();
                U();
                RPrime();
                UPrime();
                R();
                U();
                RPrime();
                UPrime();
                R();
                UPrime();
                RPrime();
            }
        }

        else if (yellowUpLocations.size() == 1) { // sune or antisune
            // see if it is sune or antisune
            while (!(((Corner) top.get(1)).getFc().equals("y"))) {
                U();
            }

            if (((Corner) top.get(3)).getVc().equals("y")) { // antisune
                RPrime();
                UPrime();
                R();
                UPrime();
                RPrime();
                U();
                U();
                R();
            }

            else { // sune
                while (!(((Corner) top.get(7)).getFc().equals("y"))) {
                    U();
                }
                R();
                U();
                RPrime();
                U();
                R();
                U();
                U();
                RPrime();

            }

        }

        else if (yellowUpLocations.size() == 2) { // cases 23, 24, 25
            // see if it is case 25
            boolean twoFive = false;
            int diff = yellowUpLocations.get(0) - yellowUpLocations.get(1);
            if (Math.abs(diff) == 4) {
                twoFive = true;
            }

            if (twoFive) {
                while (!((Corner) top.get(3)).getSc().equals("y")) {
                    U();
                }
                RPrime();
                F();
                R();
                BPrime();
                RPrime();
                FPrime();
                R();
                B();
            }

            else {
                // find if it is case 23 or 24
                while (!((((Corner) top.get(1)).getFc().equals("y")) && (((Corner) top.get(3)).getFc().equals("y")))) {
                    U();
                }

                int sc = 0;
                int vc = 0;
                if (((Corner) top.get(5)).getSc().equals("y")) {
                    sc++;
                } else {
                    vc++;
                }

                if (((Corner) top.get(7)).getSc().equals("y")) {
                    sc++;
                } else {
                    vc++;
                }

                if (sc == 2) {// case 24
                    UPrime(); // make it look like the starting picture

                    RPrime();
                    FPrime();
                    L();
                    F();
                    R();
                    FPrime();
                    LPrime();
                    F();
                }

                else { // vc was 2, case 23
                    R();
                    R();
                    D();
                    RPrime();
                    U();
                    U();
                    R();
                    DPrime();
                    RPrime();
                    U();
                    U();
                    RPrime();
                }
            }
        }
        moves.add(" top corners done");
    }

    public void headlights() {
        
        // check to see if we got headlights skip: if so, we dont need to do any
        // algorithms
        String backLeft = ((Corner) top.get(1)).getVc();
        String backRight = ((Corner) top.get(3)).getVc();

        String rightTop = ((Corner) top.get(3)).getSc();
        String rightBottom = ((Corner) top.get(5)).getSc();      

        String frontLeft = ((Corner) top.get(7)).getVc();
        String frontRight = ((Corner) top.get(5)).getVc();

        String leftBack1 = ((Corner) top.get(1)).getSc();
        String leftFront1 = ((Corner) top.get(7)).getSc();

        if (backLeft.equals(backRight) && rightTop.equals(rightBottom) && frontLeft.equals(frontRight) && leftBack1.equals(leftFront1)){
            return; //if everything is equal, we got a headlights skip, stop the method
        }
        
        boolean ready = false;
        for (int i = 0; i < 3; i++) {
            String leftBack = ((Corner) top.get(1)).getSc();
            String leftFront = ((Corner) top.get(7)).getSc();

            if (!(leftBack.equals(leftFront))) {
                U();
            } else { // we are ready for algo
                ready = true;
                break;
            }
        }

        String leftBack = ((Corner) top.get(1)).getSc();
        String leftFront = ((Corner) top.get(7)).getSc();

        if (leftBack.equals(leftFront)) {
            ready = true;
        }

        if (ready) {
            R();
            U();
            RPrime();
            UPrime();
            RPrime();
            F();
            R();
            R();
            UPrime();
            RPrime();
            UPrime();
            R();
            U();
            RPrime();
            FPrime();
        } else {
            // same algo to create headlights
            R();
            U();
            RPrime();
            UPrime();
            RPrime();
            F();
            R();
            R();
            UPrime();
            RPrime();
            UPrime();
            R();
            U();
            RPrime();
            FPrime();
            // then do it again
            headlights();
            moves.remove(moves.size() - 1); // remove so we dont have "headlights done" twice
        }
        moves.add("headlights done ");
    }

    public void rotateTopEdges() {
        String left1 = ((Corner) top.get(1)).getVc();
        String middle1 = ((Edge) top.get(2)).getSc();
        String right1 = ((Corner) top.get(3)).getVc();
        boolean one = (left1.equals(middle1)) && (middle1.equals(right1));

        String left2 = ((Corner) top.get(3)).getSc();
        String middle2 = ((Edge) top.get(4)).getSc();
        String right2 = ((Corner) top.get(5)).getSc();
        boolean two = (left2.equals(middle2)) && (middle2.equals(right2));

        String left3 = ((Corner) top.get(5)).getVc();
        String middle3 = ((Edge) top.get(6)).getSc();
        String right3 = ((Corner) top.get(7)).getVc();
        boolean three = (left3.equals(middle3)) && (middle3.equals(right3));

        String left4 = ((Corner) top.get(7)).getSc();
        String middle4 = ((Edge) top.get(8)).getSc();
        String right4 = ((Corner) top.get(1)).getSc();
        boolean four = (left4.equals(middle4)) && (middle4.equals(right4));

        if (one && two && three && four){
            return; //if edges are correct, stop the method
        }

        boolean ready = false;
        for (int i = 0; i < 3; i++) {
            String left = ((Corner) top.get(1)).getVc();
            String middle = ((Edge) top.get(2)).getSc();
            String right = ((Corner) top.get(3)).getVc();

            if (!((left.equals(middle)) && (middle.equals(right)))) {
                U();
            } else { // we are ready for algo
                ready = true;
                break;
            }
        }

        String left = ((Corner) top.get(1)).getVc();
        String middle = ((Edge) top.get(2)).getSc();
        String right = ((Corner) top.get(3)).getVc();

        if ((left.equals(middle)) && (middle.equals(right))) {
            ready = true;
        }

        if (ready) {
            boolean goRight = false; // assume algo is to the left

            String c1 = ((Corner) top.get(1)).getSc();
            String c2 = ((Edge) top.get(4)).getSc();

            if (c1.equals(c2)) {
                goRight = true;
            }

            if (goRight) {
                R();
                UPrime();
                R();
                U();
                R();
                U();
                R();
                UPrime();
                RPrime();
                UPrime();
                R();
                R();
            } else {// need to go left
                LPrime();
                U();
                LPrime();
                UPrime();
                LPrime();
                UPrime();
                LPrime();
                U();
                L();
                U();
                L();
                L();
            }
        }
        // no full side yet
        else {
            // do the algo
            R();
            UPrime();
            R();
            U();
            R();
            U();
            R();
            UPrime();
            RPrime();
            UPrime();
            R();
            R();
            rotateTopEdges();
            moves.remove(moves.size() - 1);
        }
        moves.add("top edges done");
    }

    public void twistTop() {
        String left = ((Corner) top.get(1)).getVc();
        String middle = ((Edge) top.get(2)).getSc();
        String right = ((Corner) top.get(3)).getVc();

        while (!(left.equals("g") && middle.equals("g") && right.equals("g"))) {
            U();
            left = ((Corner) top.get(1)).getVc();
            middle = ((Edge) top.get(2)).getSc();
            right = ((Corner) top.get(3)).getVc();
        }

        moves.add("should be done");
    }

    public void update() {
        cube.clear();

        cube.add(bottom);
        cube.add(middle);
        cube.add(top);
    }

    public List<String> trim(){
        List<String> betterMoves = new ArrayList<>(moves);
        for (int i = 0; i < betterMoves.size() - 4; i++){
            //if we find 4 of the same move, remove all of them
            if (betterMoves.get(i).equals(betterMoves.get(i + 1)) && betterMoves.get(i + 1).equals(betterMoves.get(i + 2)) && betterMoves.get(i + 2).equals(betterMoves
                .get(i + 3))){
                    betterMoves.remove(i);
                    betterMoves.remove(i);
                    betterMoves.remove(i);
                    betterMoves.remove(i);
            }
        }

        for (int i = 0; i < betterMoves.size() - 3; i++){
            //if we find 3 of the same move, replace it with a prime
            if(betterMoves.get(i).equals(betterMoves.get(i + 1)) && betterMoves.get(i + 1).equals(betterMoves.get(i + 2))){
                String insert = "";
                if (betterMoves.get(i).indexOf("'") >= 0){ //if it is already a prime
                    insert = betterMoves.get(i).substring(0, 2); //make it not a prime, include space
                }
                else{
                    insert = betterMoves.get(i).substring(0, 1) + "'";
                }
                betterMoves.add(i, insert);
                betterMoves.remove(i + 1);
                betterMoves.remove(i + 1);
                betterMoves.remove(i + 1); 
            }
        }

        for (int i = 0; i < betterMoves.size() - 2; i++) {
            String orig1 = betterMoves.get(i);
            String orig2 = betterMoves.get(i + 1);

            if ((orig1 + "'").equals(orig2) || (orig2 + "'").equals(orig1)){
                betterMoves.remove(i);
                betterMoves.remove(i);
            }
        }
        return betterMoves;
    }

    public String toString() {
        return "" + cube + moves;
    }
}
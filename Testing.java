
public class Testing {

    public static void main(String[] args) {

        Cube cube = new Cube();
        // ("B R R D D F' R R B L L F R R U' F' U L' F F L D D R' U L' F")
        // ("F L L B B D D B U U B R R B B D D F' L' U' R D' B U' B R F'")
        // ("R R F F R R U R R B B D U U L L U' R D D U F R' B B U' F U' R R")
        // ("U U D' F' R L' U B D R B R R D R R B B D D B B U' R R U U B B U'")
        // ("B B U U F' L L B' D D L L R R F' D R R F L D' U' F F L B D D F F")
        // ("B R D F' R R B L L F R F' U L' F F L D D R' U L' F")

        cube.scramble("B R D F' R R B L L F R F' U L' F F L D D R' U L' F");
        System.out.println("Scrambled: " + cube + "\n");

        cube.cross();
        System.out.println("After cross: " + cube + "\n");

        cube.bottomCorners();
        System.out.println("After corners: " + cube + "\n");

        cube.secondLayer();
        System.out.println("After second layer: " + cube + "\n");

        cube.topCross();
        System.out.println("After top cross: " + cube + "\n");

        cube.topCorners();
        System.out.println("After top corners: " + cube + "\n");

        cube.headlights();
        System.out.println("After headlights: " + cube + "\n");

        cube.rotateTopEdges();
        System.out.println("After top edges: " + cube + "\n");

        cube.twistTop();
        System.out.println("Should be done: " + cube + "\n");
    }
}
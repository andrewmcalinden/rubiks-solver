
public class Testing {

    public static void main(String[] args) {

        Cube cube = new Cube();

        // ("B R R D D F' R R B L L F R R U' F' U L' F F L D D R' U L' F")
        // ("F L L B B D D B U U B R R B B D D F' L' U' R D' B U' B R F'")

        cube.scramble("F L L B B D D B U U B R R B B D D F' L' U' R D' B U' B R F'");
        System.out.println("Scrambled: " + cube + "\n");
        
        cube.cross();
        System.out.println("After cross: " + cube + "\n");

        cube.bottomCorners();
        System.out.println("After corners: " + cube + "\n");

        cube.secondLayer();
        System.out.println("After second layer: " + cube + "\n");

    }
}
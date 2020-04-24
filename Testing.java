
public class Testing {
    public static void main(String[] args) {

        Cube cube = new Cube();

        cube.scramble("B R R D D F' R R B L L F R R U' F' U L' F F L D D R' U L' F");
        System.out.println(cube);

        cube.cross();
        System.out.println(cube);

    }
}
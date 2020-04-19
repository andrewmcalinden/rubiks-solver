
public class Testing {
    public static void main(String[] args) {

        Cube cube = new Cube();
        System.out.println(cube);

        while (!cube.crossMade()){ //at the u2 f2
            cube.cross();
        }

        
        System.out.println(cube);

    }
}

public class Testing {
    public static void main(String[] args) {

        Cube cube = new Cube();
        System.out.println(cube);

        while (!cube.crossMade()){
            cube.startCross();
        }

        
        System.out.println(cube);

    }
}
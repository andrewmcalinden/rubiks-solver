
public class Testing {

    public static void main(String[] args) {

        Cube cube = new Cube();

        // ("B R R D D F' R R B L L F R R U' F' U L' F F L D D R' U L' F")
        // ("F L L B B D D B U U B R R B B D D F' L' U' R D' B U' B R F'")

        cube.scramble("B R R D D F' R R B L L F R R U' F' U L' F F L D D R' U L' F");
        System.out.println("Scrambled: " + cube + "\n");
        
        cube.cross();
        System.out.println("After cross: " + cube + "\n");

        cube.bottomCorners(); //works but weirdly, you should delete the array "unsolved" by just looping through bottom layer and looking for unsolved
        System.out.println("After corners: " + cube + "\n");


        //correct: U , U , U , F , U , F' , U , U , L , U , L' , R , U , R' , U' , B , U , B' , U' , U , R , U , U , R' , U' , R , U , R' , U' , R' , U , R 

    }
}
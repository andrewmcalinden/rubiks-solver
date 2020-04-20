import java.util.ArrayList;

public class Run {

    public static void main(String [] args) {

        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        ArrayList<Integer> two = test; //if test is changed, so is two

        System.out.println(test);
        System.out.println(two);

        two.set(2, 5);

        System.out.println(test);
        System.out.println(two);

    }
}
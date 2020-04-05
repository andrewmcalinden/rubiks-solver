import java.util.ArrayList;

public class Run {

    public static void main(String [] args) {

        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(5);
        test.add(2);
        test.add(7);
        test.add(8);

        System.out.println(test);

        for (int i = test.size() - 1; i >= 0; i--) {
            if (test.get(i) == 2) {
                test.remove(i);
            }
        }

        System.out.println(test);
    }
}
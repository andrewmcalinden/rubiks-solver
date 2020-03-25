import java.util.ArrayList;

public class Run {

    public static void main(String args) 
    {
        Misc misc = new Misc();

        ArrayList<Object> test = new ArrayList<Object>();

        test.add(misc);

        for (int i = 0; i < test.size(); i++) {
            if (test.get(i) instanceof Misc) {
                System.out.println("found it");
            }
        }
    }
}
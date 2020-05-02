import java.util.ArrayList;
public class Run {

    public static void main(String [] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(6);
        list.add(4);
        list.add(3);
        list.add(8);
        list.add(5);
        list.add(6);
        System.out.println(list);

        list.add(2, 5);
        System.out.println(list);





    }


}
import java.util.ArrayList;

public class Run {

    public static void main(String [] args) {
        int [] nums = {4, 5, 7, 11, 9, 13, 10, 8, 12};
        int target = 20;

        for (int i = 0; i < nums.length; i++){
            int num1 = nums[i];
            for (int j = 0; j < i; j++){
                int num2 = nums[j];

                if (num1 + num2 == target){
                    if (num1 > num2){
                        System.out.println(num1 + ", " + num2);
                    }

                    else{
                        System.out.println(num2 + ", " + num1);
                    }
                }
            }
        }        

    }


}
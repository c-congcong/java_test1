import javax.swing.*;
import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        byte b = -128;
        int[] arr = {1, 2, 3, 4, 56, 7};
//        long a = 111111111111111111L;
        System.out.println(arr[2]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        for (int a :arr){
            System.out.println(a);
        }

    }

}

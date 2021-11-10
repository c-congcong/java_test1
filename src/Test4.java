import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

import java.sql.SQLOutput;

public class Test4 {

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7};
        int b[] = {11, 22, 33, 44, 55, 66, 77};
        //创建动态数字c
        int c[] = new int[a.length + b.length];
        //将a数组放入c数组
        for (int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }

        //将b数组放入c数组
        for (int j = 0; j < b.length; j++) {
            c[j + a.length] = b[j];
        }
        //查看c数组
        for (int x : c) {
            System.out.print(x + " ");
        }
    }
}

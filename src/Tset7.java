
public class Tset7 {
    public static void main(String[] args) {
        /*
         * 1.控制台输出99乘法表
         * 2.输入一个整数的阶乘
         * 3.返回a的b次方
         * 4.返回一个浮点数，保留两位小数，考虑四舍五入的结果
         * 5.返回整数数组元素和
         * 6.返回数组最大值
         * 7.返回数组最小值
         * 8.返回数组平均值
         * 9.返回一组双色球彩票数
         * */
        //输出九九乘法表的方法
/*
        print99table();
*/
        //输入一个整数的阶乘的方法
/*        int a = factorial(5);
        System.out.println(a);*/
        //返回a的b次方的方法
        int c = square(2,3);
        System.out.println(c);

    }

    public static void print99table() {
        int num = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                num = i * j;
                System.out.print(j + "*" + i + "=" + num + "\t");
            }
            System.out.println();
        }
    }

    public static int factorial(int x) {
        int y = 1;
        for (int i = 1; i <= x; i++) {
            y = i * y;
        }
        return y;
    }

    public static int square(int a, int b) {
        int c = 1;
        for (int i = 0; i < b; i++) {
            c = a * c;
        }
        return c;

    }
}



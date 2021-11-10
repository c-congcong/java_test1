public class Test6 {
    public static void main(String[] args) {
        /*
         * 将奇数和偶数放在俩个不同的数组中
         * */
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 45, 123, 5, 23, 5, 62, 4, 363, 754};
        int o= 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                o++;
//                System.out.println(o);
            }
        }

        //新建俩个动态数组
        int b[] = new int[o];
        int c[] = new int[a.length - o];
        int num1 = 0;
        int num2 = 0;
        for (int x:a){
            if (x % 2 == 0){
                b[num1]=x;
                num1++;
                continue;
            }
            c[num2]=x;
            num2++;
        }


        for (int j :b){
            System.out.print(j+" ");
        }
        System.out.println();
        for (int k :c){
            System.out.print(k+" ");
        }
    }
}

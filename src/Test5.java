public class Test5 {
    public static void main(String[] args) {
        //在数组a索引为3的地方插入一个数字22
        int a[] = {1, 23, 45, 6, 67, 8, 89, 3};
        //创建一个动态数组b
        int b[] = new int[a.length + 1];

        for (int i = 0; i < 4; i++) {
            b[i] = a[i];
        }
        b[4] = 22;
        for (int i = 5; i < a.length+1; i++) {
            b[i] = a[i-1];
        }

        //查看b
        for (int i : b) {
            System.out.println(i);
        }
    }
}

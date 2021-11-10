public class Test1 {
    public static void main(String[] args){
        int num1 = 10;
        int num2 = 20;
        num1 = num2;
        num2 = num2 + 10;
        num2 = num1;
        System.out.println(num1);
        System.out.println(num2);


    }
}

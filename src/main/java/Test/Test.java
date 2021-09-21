package Test;

/**
 * @author cqp
 * @version 1.0.0
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2021年09月10日 08:25:00
 */
public class Test {
    public static void main(String[] args) {
        int a = 1;
        int b = 100;
        while(a <= 10){
            a++;
            System.out.println("a:"+a);
            while (b <= 110){
                b++;
                if( b == 105){
                    System.out.println("continue了");
                    continue;
                }
                System.out.println("b:"+b);

            }

        }
    }
}

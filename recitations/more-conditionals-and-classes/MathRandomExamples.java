/**
* MathRandomExamples.java
* Math.random example exercises
* @author Narcisa Codreanu
*/
public class MathRandomExamples {

    public static void main(String[] args) {

        // a simple random number in [0.0,1.0)
        double a = Math.random();
        System.out.println("Double between 0.0 and 1.0: " + a);

        // double between [0.0, 10.0)
        double b = Math.random()*10.0;
        System.out.println("Double between 0.0 and 10.0: " + b);

        // integer between [3,8]
        int c = (int) (Math.random()*5)+3;
        System.out.println("Integer between 3 and 8: " + c);

        // integer between [-10,10) - maximum 9
        int d = (int) (Math.random()*20)-10;
        System.out.println("Integer between -10 and 10: " + d);

    }
 
}

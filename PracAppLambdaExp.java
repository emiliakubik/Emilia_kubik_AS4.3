import java.util.function.Function;

public class PracAppLambdaExp {
    // Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
    //     @Override
    //     public Integer apply(Integer number) {
    //         return number * number;
    //     }
    //  };

    public static Function <Integer, Integer> squareLambda = (number) -> number * number;
     
    //  Function<String, Integer> stringLengthFunction = new Function<String, Integer>() {
    //     @Override
    //     public Integer apply(String str) {
    //         return str.length();
    //     }
    //  } 

     public static Function <String, Integer> stringLengthLambda = (str) -> str.length();

     public static void main(String[] args) {
        int input = 10;
        String input2 = "Hello world";

        System.out.println("Square: " + squareLambda.apply(input));
        System.out.println("Length: " + stringLengthLambda.apply(input2));
     }
}

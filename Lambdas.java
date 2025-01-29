import java.util.function.Function;
import java.util.function.BiFunction;
import java.lang.Math;

public class Lambdas {
    //No TriFunction interface in the java.util.function library so created one
    //Takes in 3 values, outputs 1 value
    @FunctionalInterface
    interface TriFunction<T, U, V, R>{
        R apply(T t, U u, V v);
    }
    public class QuadraticFormula{
        //takes in 3 Double values, outputs a double array with 2 results: 1 from each quadratic calculation.
        public static TriFunction<Double, Double, Double, double[]> quadraticLambda = (a, b, c) -> new double[]{(-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a), (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a)};
    }

    public class PythagoreanTheorem{
        //takes in 2 Double values, outputs 1 Double value. Sqaures each value, adds them together, then calculates the square root to get result of pythagorean theorem 
        public static BiFunction<Double, Double, Double> pythagoreanLambda = (a, b) -> Math.sqrt(a * a + b * b);
    }

    public class ArithmeticProgression{
        //takes in 3 Double values, outputs 1 Double value. Calculates the sum of arithmetic progression
        public static TriFunction<Double, Double, Double, Double> arithmeticLambda = (n, a1, an) -> n * (a1 * an) / 2;
    }
    
    public class AreaOfCircle{
        //takes in 1 Double value (radius), outputs 1 Doublt value. Calculates the area of the circle using the given radius.
        public static Function<Double, Double> circleLambda = (r) -> (Math.PI * r * r);
    }

    

    public static void main(String[] args){
        //Test runs of each lambda expression
        Double a = 4.0;
        Double b = 11.5;
        Double c = 3.5;

        double[] roots = QuadraticFormula.quadraticLambda.apply(a, b, c);
        System.out.println("Root 1 of Quadratic Formula: " + roots[0]);
        System.out.println("Root 2 of Quadratic Formula: " + roots[1]);

        Double result = PythagoreanTheorem.pythagoreanLambda.apply(a, b);
        System.out.println("Pythagorean Theorem: " + result);

        Double r = ArithmeticProgression.arithmeticLambda.apply(a, b, c);
        System.out.println("Sum of Arithmetic Progression: " + r);

        Double value = AreaOfCircle.circleLambda.apply(c);
        System.out.println("Area of circle: " + value);
    }
}



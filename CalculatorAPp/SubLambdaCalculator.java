package CalculatorAPp;

import java.util.function.Function;
import java.util.Arrays;

public class SubLambdaCalculator {

    public class SubtractionLambdaCalculator{
        public static Function<Integer, Integer> subtractionLambda = (a) -> (a * 4) - (a * 2);
    }

    public class SubLambda{
        public static Function<Integer, Integer> subLambda = (x) -> (x + 100) - (x + 50);
    }

    public class AdditionLambdaCalculator{
        public static Function<Integer, Integer> additionLambda = (a) -> (a * 4) + (a + 2);
    }

    public class AddLambda{
        public static Function<Integer, Integer> addLambda = (x) -> (x * 6) + (x - 2);
    }

    public class AverageLambdaCalculator{
        public static double calculateAverage(int[] numbers){
            return Arrays.stream(numbers)
                .average()
                .orElse(0.0);
        }
    }

    public class MeanLambda{
        public static double calculateMean(int[] numbers){
            return Arrays.stream(numbers)
                .average()
                .orElse(Double.NaN);
        }
    }

    public class SumLambdaCalculator{
        public static double calculateSum(int[] numbers){
            return Arrays.stream(numbers).sum();
        }
    }

    public class CalculatorApp{
        public static void main(String[] args){
            int input = 8;
            int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12};
            int[] arr2 = {34, 254, 333, 12, 95, 12, 345, 22, 252, 1013};

            int subResult = SubtractionLambdaCalculator.subtractionLambda.apply(input);
            int addResult = AdditionLambdaCalculator.additionLambda.apply(input);
            double avgResult = MeanLambda.calculateMean(arr);
            double sumResult = SumLambdaCalculator.calculateSum(arr2);

            System.out.println("Result of SubtractLambda: " + subResult);
            System.out.println("Result of AdditionLambda: " + addResult);
            System.out.println("Result of AverageLambda: " + avgResult);
            System.out.println("Result of SumLambda: " + sumResult);
        }
    }
}

package functionalInterface;

import java.util.function.Function;

public class _Function {
    
    public static void main(String[] args) {
        int increment = increment(0); 
        
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);

        System.out.println(multiply);

        Function<Integer, Integer> add1AndThenMultiplyBy10 =
            incrementByOneFunction.andThen(multiplyBy10Function);

            System.out.println(add1AndThenMultiplyBy10.apply(4));

    }

    

    static Function<Integer, Integer> multiplyBy10Function =
        number -> number * 10;

    static Function<Integer,Integer> 
        incrementByOneFunction = number -> number + 1;

    static int increment(int number){
        return number + 1;
    }


}

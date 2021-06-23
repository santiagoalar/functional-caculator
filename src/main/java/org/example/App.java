package org.example;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class App
{
    public static void main( String[] args )
    {

        IntBinaryOperator sum = Integer::sum;
        IntBinaryOperator sub = (x,y)-> x-y;

        IntBinaryOperator mul = getMulOperator(sum);
        IntBinaryOperator division = getDivOperator(sub);

        System.out.println(mul.applyAsInt(3,5));
        System.out.println(division.applyAsInt(60,10));

    }

    private static IntBinaryOperator getDivOperator(IntBinaryOperator sub) {
        IntBinaryOperator division = (x, y) -> (int) IntStream.iterate(x, e -> sub.applyAsInt(e, y))
                .takeWhile(a -> a >= y).count();
        return division;
    }

    private static IntBinaryOperator getMulOperator(IntBinaryOperator sum) {
        IntBinaryOperator mul = (x1,y1)-> IntStream.rangeClosed(0, y1)
                .reduce((subtotal, element) -> sum.applyAsInt(subtotal, x1))
                .getAsInt();
        return mul;
    }

}

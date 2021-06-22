package org.example;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class App
{
    public static void main( String[] args )
    {

        IntBinaryOperator sum = Integer::sum;
        IntBinaryOperator sub = (x,y)-> x-y;

        IntBinaryOperator mul = (x1,y1)-> IntStream.rangeClosed(0, y1)
                .reduce((subtotal, element) -> sum.applyAsInt(subtotal, x1))
                .getAsInt();

        System.out.println(mul.applyAsInt(3,5));

        /*IntBinaryOperator div = (x1,y1) -> IntStream.range(0, y1)
                .reduce((subtotal, element) -> {
                    System.out.println(element);
                    return sub.applyAsInt(x1, y1);})
                .getAsInt();*/

        System.out.println(div(120, 10));

    }

    public static int div(int a, int b){
        int times = 0;
        while (a >= b){
            a = a-b;
            times++;
        }
        return times;
    }
}

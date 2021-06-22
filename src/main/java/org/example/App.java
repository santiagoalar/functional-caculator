package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class App
{
    public static void main( String[] args )
    {

        IntBinaryOperator sum = Integer::sum;
        IntBinaryOperator sub = (x,y)-> x-y;

        IntBinaryOperator mul = (x1,y1)-> IntStream.range(0, y1 + 1)
                .reduce((subtotal, element) -> sum.applyAsInt(subtotal, x1))
                .getAsInt();

        IntBinaryOperator div = (x1,y1) -> IntStream.range(0, y1)
                .reduce((subtotal, element) -> {
                    System.out.println(element);
                    return sub.applyAsInt(x1, y1);})
                .getAsInt();

        //IntBinaryOperator div1 = (x1,y1) -> IntStream.iterate(y1, i -> i + x1);

        IntStream stream = IntStream.iterate(10, i -> i + 5);
        stream.forEach(System.out::println);

        System.out.println(mul.applyAsInt(3,5));
        //System.out.println(div1.applyAsInt(60, 10));

    }


    /*public static int multiply(int a, int b){
        int result = 0;

        for (int i = 0; i < b; i++) {
            result = sum(a, result);
        }

        return result;
    }

    public static int divide(int a, int b){
        int times = 0;
        while (a >= b){
            a = subtract(a, b);
            times++;
        }

        return times;
        return 0;
    }*/
}

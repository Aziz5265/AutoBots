package com.autobots.java.lambda.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaLesson {
    public static void main(String[] args) {
        iMathOperations addition = (a, b) -> a + b;
        iMathOperations multii = (a,b) -> a * b;
        iMathOperations delenie = (a,b) -> a % b;
        System.out.println("5+3 = " + addition.operation(5,3));
        System.out.println("5 / 3 = " + delenie.operation(5,3));
        System.out.println("5 * 3 = " + multii.operation(5,3));

        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        System.out.println(isNotEmpty.test("false"));

        Function<Integer, String > toStringFun = i -> "chislo: " + i;
        System.out.println(toStringFun.apply(10));

        Consumer<String> print = s -> System.out.println("Writing " + s);
        print.accept("hello");
    }

















}

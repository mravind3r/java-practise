package com.madhusudhan.j8.com.madhusudhan.j8.rav.com.madhusudhan.j8.jose.rav;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;

/**
 * Created by ravi on 31/03/2017.
 */
public class TestingMapFilterReduce {

    BinaryOperator<Integer> biop = (i,j) -> i*i + j*j; // this is non assosiative so extra care

   // red(a,red(b,c)) = red(red(a,b),c)
//    -1,0,2,3,1
//    a,b,c
//    lhs = 0*0 + 2*2 = 4  -->  -1*-1 + 4*4 =  1 + 16 = 17
//    rhs = -1*-1 + 0*0 = 1 -->  1*1 + 2*2 = 1 + 4 = 5





    public static void main(String[] args) {

        // false positive
        // reduction operation on non-assosiative functions

        List<Integer> ints = Arrays.asList(-1,0,2,4,5,6,9,10);
       // List<Integer> ints = Arrays.asList(1,3); // true for all cases as its not work stealing fork join
        // find the avegare of all numbers --> (i+j)/2

        int sum = 0;
        for( int x :ints){
            sum+=x;
        }
        System.out.println("actual avegare="+sum/ints.size());

        Optional<Integer> avg = ints.stream().reduce((i, j) -> i+j/2);
        System.out.println("average using lambdas and parallelism=" + avg.get());

        // solution
        Optional<Integer> sum2 =  ints.stream().reduce((i,j)-> i+j);
        System.out.println("solution average using lambdas and parallelism=" + sum2.get()/ints.size());

        AtomicInteger atomicInteger = new AtomicInteger(1);

        Optional<Integer> avg3 = ints.stream().reduce((i,j) ->{ atomicInteger.getAndIncrement();

            return (i+j); });
        System.out.println(atomicInteger.get());
        System.out.println(avg3.get()/atomicInteger.get());







    }

}

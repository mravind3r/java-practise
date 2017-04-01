package com.madhusudhan.j8.com.madhusudhan.j8.rav;

import com.madhusudhan.j8.domain.Student;
import com.madhusudhan.j8.domain.Trade;
import com.madhusudhan.j8.util.TradeUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by ravi on 30/03/2017.
 */
public class TestReduce {

    public static void main(String[] args) {

        List<Trade> trades = TradeUtil.createTrades();
        // create the trades as a comma seperated values of strings
        // use of reduce function , its an aggregator
        Optional<String> csv = trades.stream().map((t)->t.getInstrument() ).reduce((s1,s2)->s1+","+s2);
        System.out.println(csv);

        // another reduce , sum of all quantities , find the quatitties and then sum them
        Optional<Integer> sum = trades.stream().map(t -> t.getQuantity()).reduce(Integer::sum);
        System.out.println(sum.get());


        // overloaded reduce with an intial value
        List<Integer> students = Arrays.asList(10,20,30);
        Integer total = students.stream().reduce(40,(x,y)->x+y);

    }


}

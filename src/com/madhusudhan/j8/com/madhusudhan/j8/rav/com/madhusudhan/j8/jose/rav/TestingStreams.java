package com.madhusudhan.j8.com.madhusudhan.j8.rav.com.madhusudhan.j8.jose.rav;

import com.madhusudhan.j8.domain.Employee;
import com.madhusudhan.j8.domain.Movie;
import com.madhusudhan.j8.util.MovieUtil;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static com.madhusudhan.j8.util.MovieUtil.createMovies;

/**
 * Created by ravi on 31/03/2017.
 */
public class TestingStreams {

    public static void main(String[] args) {
        Stream<Employee>  sEmp = Stream.empty();
        System.out.println(sEmp.count());

        Stream<Employee> singleEmp = Stream.of(new Employee(1,"rav","finance"));
        System.out.println(singleEmp.count());

        Stream<String> constantElementInfiniteStream = Stream.generate(() -> "one");
       // constantStream.forEach(System.out::println); // this will generate infinite number of "one" strings

        Stream<String> growingStream = Stream.iterate("+",s -> s.concat("+"));
       // growingStream.forEach(System.out::println); againg infinite...


        Stream<String> words = Pattern.compile(" ").splitAsStream("the old brown fox jumped");
        System.out.println("word count=" + words.count());


        // map filter reduce pattern
        // print out all the movie names which are classic( movie names not movies)

        List<Movie> movies = createMovies();
        movies.stream().filter(Movie::isClassic).map(Movie::getName).forEach(System.out::println);


        // anymatch or allmatch, these may not match all the elements , they are shortcicuit opertaors

        boolean b = movies.stream().anyMatch(Movie::isClassic);
        System.out.println(b);

      // find first reduction , find any reduction
        Optional<Movie> first = movies.stream().filter(Movie::isClassic).findAny();
        System.out.println(first.get());



        




    }

}


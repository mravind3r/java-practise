package com.madhusudhan.j8.com.madhusudhan.j8.rav.com.madhusudhan.j8.jose.rav;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by ravi on 01/04/2017.
 */
public class TestingStreams2 {

    public static void main(String[] args) throws IOException {
        Stream<String> file1 = Files.lines(Paths.get("src/test0"));
        Stream<String> file2 = Files.lines(Paths.get("TomSawyer_02.txt"));
        Stream<String> file3 = Files.lines(Paths.get("TomSawyer_03.txt"));
        Stream<String> file4 = Files.lines(Paths.get("TomSawyer_04.txt"));


        System.out.println(file1.count());


    }

}

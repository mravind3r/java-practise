package com.madhusudhan.j8.com.madhusudhan.j8.rav;

import com.madhusudhan.j8.domain.Student;

import java.util.Optional;

/**
 * Created by ravi on 30/03/2017.
 */
public class TestingOptionals {

    public static void main(String[] args) {
        Student def = new Student();
        Student s = new Student();
        Optional<Student> os = Optional.of(s);

        s = null;
        Optional<Student> os2 =Optional.ofNullable(s);
        os2.ifPresent(student -> System.out.println(os2.orElse(def).getName()));
       // System.out.println(os2.get());



    }
}

package _note;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class A {

    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong(10);

        String s = "123456";
        AtomicReference<String> atomicReference = new AtomicReference<>(s);

        System.out.println(atomicReference.get());

        System.out.println(atomicLong);



        Thread thread = new Thread("");
    }

}

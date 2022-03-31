package jpapractice.jpahomeshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Prac {
    public static void main(String[] args) {
        Stream<Integer> ints = Stream.iterate(0, n->n+2);
        Integer[] st = ints.limit(5).toArray(Integer[]::new);
        for(Integer  s : st){
            System.out.println("s = " + s);
        }
    }
}

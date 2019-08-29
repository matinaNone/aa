package lambda.learn;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class EvenNumberCal {

    public static class EvenNumber implements Supplier<Long> {
        long num = 0;

        @Override
        public Long get() {
            num += 2;
            return num;
        }
    }

    public static void main(String[] args) {
        Stream<Long> numbers = Stream.generate(new EvenNumber());
//        numbers.limit(10).forEach(System.out::println);

        Arrays.asList("Hello", "java8", "java7").stream()
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                }).filter(s -> {
                    System.out.println("filter:" + s);
                    return s.startsWith("J");
                })
                .forEach(System.out::println);
        Arrays.asList("Hello", "java8", "java7").parallelStream();
    }
}

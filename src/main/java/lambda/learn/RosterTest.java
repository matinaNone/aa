package lambda.learn;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by wangnan01 on 2017/5/24.
 */
public class RosterTest {

    //1:
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person person : roster) {
            if (person.getAge() > age) {
                person.printPerson();
            }
        }
    }

    //2
    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person person : roster) {
            if (person.getAge() >= low && person.getAge() < high) {
                person.printPerson();
            }
        }
    }

    interface CheckPerson {
        boolean test(Person p);
    }

    //3 4 5
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    //6
    interface Predicate<Person> {
        boolean test(Person t);
    }

    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    //7
    public static void processPersons(
            List<Person> roster,
            Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    //7-2
    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    //8
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }


    public static void main(String[] args) {
        List<Person> roster = Person.createRoster();
        for (Person p : roster) {
            p.printPerson();
        }
        System.out.println("==================");
        //1:
        System.out.println("older than 20:");
        printPersonsOlderThan(roster, 20);
        System.out.println();

        //2
        System.out.println("Persons between the ages of 14 and 30:");
        printPersonsWithinAgeRange(roster, 14, 30);
        System.out.println();

        //3
        System.out.println("Persons who are eligible for Selective Service:");
        class CheckPersonEligibleSelectiveService implements CheckPerson {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        }
        printPersons(roster, new CheckPersonEligibleSelectiveService());
        //4 anonymous class
        printPersons(roster, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });

        //5 lambda expression
        printPersons(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25);
        roster.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25).forEach(Person::printPerson);
        //6
        printPersonsWithPredicate(roster, p -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);
        //7
        processPersons(roster, p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::printPerson);
        //7-2
        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getEmail,
                System.out::println
        );
        //8
        processElements(roster, p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getEmail,
                System.out::println);

        //9
        roster.stream().filter(p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25).map(Person::getEmail).forEach(System.out::println);

        //other stream operation
        String s = roster.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(s);

        int ageSum = roster.stream().mapToInt(Person::getAge).sum();

        Map<Person.Sex, List<Person>> byGroup = roster.stream().collect(Collectors.groupingBy(Person::getGender));
        System.out.println(byGroup);

        Map<Boolean, List<Person>> byAge = roster.stream().collect(Collectors.partitioningBy(p -> p.getAge() >= 26));
        System.out.println(byAge);

        Map<Person.Sex, Set<String>> nameByGender = roster.stream()
                .collect(Collectors.groupingBy
                        (Person::getGender, Collectors.mapping(Person::getName, Collectors.toSet())));
        System.out.println(nameByGender);

        //map.merge
        //        String VolatileTest = "aaabfefkhfjkhhuinekghusidhgiojhgiuehge";
//        Map<Character, Integer> statitic = new HashMap<>();
//        for (int i = 0; i < VolatileTest.length(); i++) {
//            char e = VolatileTest.charAt(i);
//            statitic.merge(e, 1, (oldValue, newValue) -> oldValue + newValue);
//        }
//        System.out.println(statitic);
    }
}

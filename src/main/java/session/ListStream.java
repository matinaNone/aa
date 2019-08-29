package session;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wangnan01 on 2017/6/16.
 */
public class ListStream {
    interface Predicate<Person>{
        boolean test(Person p);
    }

    static void printPersonWithPredicate(List<Person> list, Predicate<Person> tester){
        for(Person person: list){
            if(tester.test(person)){
                person.printPerson();
            }
        }
    }

    interface Function<Person, String>{
        String accept(Person p);
    }

    static void processPersons(List<Person> list, Predicate<Person> tester,  Function<Person, String> mapper){
        for(Person person: list){
            if(tester.test(person)){
               String result = mapper.accept(person);
                System.out.println(result);
            }
        }
    }

    interface Consumer<Person>{
        void apply(Person p);
    }

    static void processPersons(List<Person> list, Predicate<Person> tester, Function<Person, String> mapper, Consumer<Person> block){
        for(Person person: list){
            if(tester.test(person)){
                block.apply(person);
            }
        }
    }


    public static void main(String[] args) {
        List<Person> list = Person.createRoster();
//       list.stream().filter(person -> person.getAge() >= 15 && person.getAge() <= 25)
//                    .map(person -> person.getName())
//                    .peek(p -> System.out.println(p))
//                    .collect(Collectors.toList());

//        printPersonWithPredicate(list, p -> p.getAge()>=15 && p.getAge() <= 25);
//        processPersons(list, p -> p.getAge() >= 15 && p.getAge() <= 25, p -> p.getName());

//        String names = list.stream().map(Person::getName).collect(Collectors.joining(","));
//        System.out.println(names);

        List<String> list2 = list.stream().map(t -> {
            StringBuffer buf = new StringBuffer();
            buf.append("user_id = ").append(t.getAge());
            return buf.toString();})
                .collect(Collectors.toList());
        System.out.println(list2);
    }
}

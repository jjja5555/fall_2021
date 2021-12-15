package edu.northeastern.martin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //functional
        List<Person> list = new ArrayList<>();
        list.add(new Person(25,"xiao"));
        list.add(new Person(22,"jiao"));
        list.add(new Person(23,"bing"));
        //allMatch
        boolean all22 = list.stream().allMatch(p -> p.getAge() == 22);
        System.out.println(all22);
        //anyMatch
        boolean any22 = list.stream().anyMatch(p -> p.getAge() < 22);
        System.out.println(any22);
        //noneMatch
        boolean none22 = list.stream().anyMatch(p -> p.getAge() < 25);
        System.out.println(none22);
        //collect
        List<Integer> ages = list.stream().map(p -> p.getAge()).collect(Collectors.toList());
        System.out.println(ages);
        //collect with comparator name
        List<Integer> nameAsc = list.stream().sorted((Person a, Person b)-> a.getName().compareTo(b.getName())).map(p -> p.getAge()).collect(Collectors.toList());
        System.out.println(nameAsc);

        //collect with comparator name
        List<String> agesAsc = list.stream().sorted(((Person a, Person b)-> a.getAge() -b.getAge())).map(p -> p.getName()).collect(Collectors.toList());
        System.out.println(agesAsc);
        List<String> agesAsc1 = list.stream().sorted(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        }).map(p -> p.getName()).collect(Collectors.toList());
        System.out.println(agesAsc1);

        //count
        long count = list.stream().filter(p -> p.getAge() ==25).count();
        System.out.println(count);

        //forEach
        list.stream().forEach(p -> System.out.println(p));
        System.out.println();
        list.stream().forEach(System.out::println);

        //min
        Optional<Person> min = list.stream().filter(p -> p.getAge() >=23).min((p1,p2) -> p1.getAge() -p2.getAge());
        if(min.isPresent()){
            System.out.println(min.get());
        }
        Optional<Person> max = list.stream().filter(p -> p.getAge() >=23).max((p1,p2) -> p1.getAge() -p2.getAge());
        if(min.isPresent()){
            System.out.println(max.get());
        }

        Optional<String> reduced = list.stream().map(p -> p.getName()).reduce((n1,n2) -> n1 + " " + n2);
        System.out.println(reduced.get());

        list.stream().sorted(new PersonAgeComparator()).forEach(System.out::println);
    }
}

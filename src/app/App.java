package app;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import app.App.Person.Gender;

// Thank's to https://www.youtube.com/watch?v=VRpHdSFWGPs

public class App {
    public static void main(String[] args) throws Exception {
        List <Person> people = List.of(
           new Person("John", Gender.MALE),
           new Person("Maria", Gender.FEMALE),
           new Person("Aisha", Gender.FEMALE),
           new Person("Alex", Gender.MALE),
           new Person("Alice", Gender.FEMALE)
        );

        // Imperative
        System.out.println("// Imperative");
        List <Person> females = new ArrayList<>();

        for (Person person : people) {
            if(Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        System.out.println(females);
       
        
        // Declarative
        System.out.println("// Declarative");
        people.stream()
            .filter(p->p.gender.equals(Gender.FEMALE))
            .forEach(System.out::println);
        
        System.out.println("// Isolated declarative predicate        ");
        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        people.stream()
            .filter(personPredicate)
            .forEach(System.out::println);
        
    }

 
    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, App.Person.Gender gender) {
            this.name = name;
            this.gender = gender;
        }


        @Override
        public String toString() {
            return "Person {gender=" + gender + ", name=" + name + "}";
        }

        enum Gender {
            MALE, FEMALE
        }
    }
}

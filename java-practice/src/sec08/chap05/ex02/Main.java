package sec08.chap05.ex02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeSet[] treeSets = {
                new TreeSet<>(),
                new TreeSet<>(new PersonComp(PersonComp.SortBy.NO, PersonComp.SortDir.DESC)),
                new TreeSet<>(new PersonComp(PersonComp.SortBy.AGE, PersonComp.SortDir.ASC)),
                new TreeSet<>(new PersonComp(PersonComp.SortBy.HEIGHT, PersonComp.SortDir.DESC))
        };

        for (var p : new Person[]{
                new Person("홍길동", 20, 174.5),
                new Person("전우치", 28, 170.2),
                new Person("임꺽정", 24, 183.7),
                new Person("황대장", 32, 168.8),
                new Person("붉은매", 18, 174.1),
        }) {
            for (var ts : treeSets) {
                ts.add(p);
            }
        }

        for (var ts : treeSets) {
            for (var p : ts) {
                System.out.println(p);
            }
            System.out.println("\n- - - - -\n");
        }
    }
}

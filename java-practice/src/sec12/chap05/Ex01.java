package sec12.chap05;

import java.io.*;
import java.util.*;

public class Ex01 {
    public static String PEOPLE_PATH = "java-practice/src/sec12/chap05/people.ser";

    public static void main(String[] args) {
        Person person1 = new Person(
                "홍길동", 20, 175.5, false,
                "AB", 81.2,
                new Career("ABC Market", 2)
        );
        Person person2 = new Person(
                "전우치", 35, 180.3, true,
                "O", 74.3,
                new Career("Macrosoft", 14)
        );

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(new Person(
                "임꺽정", 45, 162.8, true,
                "A", 68.3,
                new Career("Koryeo Inc.", 20)
        ));
        people.add(new Person(
                "붉은매", 24, 185.3, false,
                "B", 79.3,
                new Career("Cocoa", 30)
        ));
        //  💡 ObjectOutputStream : 직렬화 구현한 인스턴스를 스트림으로 출력
        try (
                FileOutputStream fos = new FileOutputStream(PEOPLE_PATH);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);
        ) {
            oos.writeObject(person1);
            oos.writeObject(person2);
            oos.writeObject(people);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

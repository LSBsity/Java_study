package sec12.chap05;

import java.io.*;
import java.util.*;

public class Ex02 {
    public static String PEOPLE_PATH = "java-practice/src/sec12/chap05/people.ser";
    public static void main(String[] args) {
        Person person1Out;
        Person person2Out;
        List<Person> peopleOut;

        //  ⭐️ 다시 인스턴스로 역직렬화
        try (
                FileInputStream fis = new FileInputStream(PEOPLE_PATH);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
        ) {

            //  ⚠️ 직렬화할 때와 순서 동일해야 함
            //  - 순서 바꾸고 재실행 해 볼 것
            person1Out = (Person) ois.readObject();
            person2Out = (Person) ois.readObject();
            peopleOut = (ArrayList) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(person1Out);
        System.out.println(person2Out);
        System.out.println(peopleOut);
    }
}

package sec13.chap01.ex02;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("강백호", 25, 180.8, false);

        //        System.out.println(objToString(person));
        String personXml = objToXML(person);
        System.out.println(personXml);
    }

    public static String objToString(Object obj) {
        Class<?> objClass = obj.getClass();

        StringBuilder sb = new StringBuilder();

        sb.append("ClassName : ").append(objClass.getSimpleName()).append("\n");

        for (var f : objClass.getDeclaredFields()) {

            //  💡 필드가 static인지 여부 확인
            //  - Modifier 클래스의 메서드들 확인해 볼 것
            if (Modifier.isStatic(f.getModifiers())) continue;

            f.setAccessible(true);
            try {
                sb.append(" - %s (%s) : %s%n".formatted(f.getName(), f.getType().getSimpleName(), f.get(obj)));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return sb.toString();
    }

    public static String objToXML(Object obj) {
        Class<?> objClass = obj.getClass();

        StringBuilder sb = new StringBuilder();

        sb.append("<%s>%n".formatted(objClass.getSimpleName()));

        for (var f : objClass.getDeclaredFields()) {
            if (Modifier.isStatic(f.getModifiers())) continue;
            f.setAccessible(true);
            try {
                sb.append("\t<%s>%s</%s>%n".formatted(f.getName(), f.get(obj), f.getName()));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        sb.append("</%s>%n".formatted(objClass.getSimpleName()));

        return sb.toString();
    }
}

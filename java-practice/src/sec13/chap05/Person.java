package sec13.chap05;

/**
 * 한 사람을 나타내는 클래스입니다.
 *
 * @author yalco
 * @version 2.0
 */
public class Person {

    /**
     * 사람의 이름입니다.
     */
    private String name;

    /**
     * 사람의 나이입니다.
     */
    private int age;

    /**
     * 이름과 나이를 받는 생성자입니다.
     *
     * @param name 사람의 이름
     * @param age  사람의 나이
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 스스로를 소개합니다.
     * 만 나이 통일법이 시행되면서 사용되지 않게 되었습니다.
     *
     * @return 소개 문자열
     * @see #introSelf()
     * @deprecated
     */
    public String introduce() {
        return "안녕하세요, 저는 %s이고 %d세입니다"
                .formatted(name, age + 1);
    }

    /**
     * 스스로를 만 나이와 함께 소개합니다.
     *
     * @return 소개 문자열
     * @see <a href="https://ko.wikipedia.org/wiki/%EB%A7%8C_%EB%82%98%EC%9D%B4_%ED%86%B5%EC%9D%BC_%EB%B2%95">만 나이 통일법</a>
     * @since 2.0
     */
    public String introSelf() {
        return "안녕하세요, 저는 %s이고 %d세입니다"
                .formatted(name, age);
    }
}
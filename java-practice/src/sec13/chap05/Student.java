package sec13.chap05;

/**
 * 학생을 나타내는 클래스입니다.
 */
public class Student extends Person {

    /**
     * 학교 이름입니다.
     */
    String schoolName;

    /**
     * 학교 이름을 인자로 받는 생성자입니다.
     *
     * @param schoolName 학교 이름
     */
    public Student(String name, int age, String schoolName) {
        super(name, age);
        this.schoolName = schoolName;
    }

    /**
     * {@inheritDoc} 학교 정보도 추가합니다.
     *
     * @return {@inheritDoc} + 학교명 문자열
     */
    @Override
    public String introSelf() {
        return super.introSelf()
                + "\n저는 %s 학생입니다."
                .formatted(schoolName);
    }

    /**
     * 주어진 시간에 해당하는 과목을 반환합니다.
     *
     * @param period 시간
     * @return 과목명
     * @throws ArrayIndexOutOfBoundsException 주어진 시간이 1~5가 아닐 경우
     */
    @MinMax(min = 1, max = 5)
    public String getClassFromPeriod(int period)
            throws ArrayIndexOutOfBoundsException {
        return new String[]{
                "국어", "수학", "영어", "과학", "사회"
        }[period - 1];
    }
}

package sec04.chap02;

public class Ex04 {
    public static void main(String[] args) {
        byte month = 1;
        byte season;

        switch (month) {
            case 1: case 2: case 3:
                season = 1;
                break;
            case 4: case 5: case 6:
                season = 2;
                break;
            case 7: case 8: case 9:
                season = 3;
                break;
            case 10: case 11: case 12:
                season = 4;
                break;
            default:
                season = 0;
        }

        System.out.println(
                season > 0
                        ? "지금은 %d분기입니다.".formatted(season)
                        : "무효한 월입니다."
        );
    }
}

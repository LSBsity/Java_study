package sec04.chap02;

public class Ex05 {
    public static void main(String[] args) {
        byte startMonth = 1;
        String holidays = "";

        switch (startMonth) {
            case 1:
                holidays += "설날, ";
            case 2:
            case 3:
                holidays += "3·1절, ";
                break;
            case 4:
            case 5:
                holidays += "어린이날, ";
            case 6:
                holidays += "현충일, ";
                break;
            case 7:
            case 8:
                holidays += "광복절, ";
            case 9:
                holidays += "추석, ";
                break;
            case 10:
                holidays += "한글날, ";
            case 11:
            case 12:
                holidays += "크리스마스, ";
                break;
            default:
                holidays = null; // 휴일이 없는 분기와 구분
        }

        String result = holidays == null
                ? "(잘못된 월입니다)"
                : "분기 내 휴일: " + holidays
                .substring(0, holidays.lastIndexOf(", "));
    }
}

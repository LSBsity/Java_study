package sec04.chap05;

public class Ex04 {
    static double getAverage(int... nums) {
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum / nums.length;
    }

    //  자바의 메소드는 하나의 값만 반환 가능
    //  여러 값을 반환하려면 배열 또는 이후 배울 객체를 활용
    static int[] getMaxAndMin(int... nums) {
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return new int[]{max, min};
    }

    public static void main(String[] args) {
        double avg = getAverage(new int[]{3, 5, 4, 13, 7});
        int[] numbers = {3, 5, 9, 2, 8, 1, 4};
        //  변수에 담아 보다 효율적으로 바꿔볼 것
        int maxOfNumbers = getMaxAndMin(numbers)[0];
        int minOfNumbers = getMaxAndMin(numbers)[1];
    }
}

package math;

public class FindKthNumber {
    public static void main(String[] args) {

    }

    public static int findKthNumber(int n, int k) {
        int count = 0;
        int number = 1;
        for (int i = 0; i < n; i++) {
            count++;
            if (count == k){
                return number;
            }
            if (number < Integer.MAX_VALUE / 10 && number * 10 <= n) {
                number *= 10;
            } else {
                while (number % 10 == 9 || number + 1 > n) {
                    number /= 10;
                }
                number++;
            }
        }
        return 0;
    }
}

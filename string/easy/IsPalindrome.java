package string.easy;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        int i = 0 , j = str.length() - 1;
        while (i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

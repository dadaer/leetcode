package string.medium;

public class ReverseWord {
    public static void main(String[] args) {
        reverseEachWord("hello world");
    }

    public static String removeSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int i = 0;
        while (stringBuilder.charAt(i) == ' ') {
            stringBuilder.deleteCharAt(i);
        }
        while (stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        while (i < stringBuilder.length() - 1) {
            if (stringBuilder.charAt(i) == ' ' && stringBuilder.charAt(i + 1) == ' ') {
                stringBuilder.deleteCharAt(i + 1);
            } else {
                i++;
            }
        }
        return new String(stringBuilder);
    }

    public static void reverseString(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static void reverseEachWord(String s) {
        char[] chars = s.toCharArray();
        int end = 0;
        int start = 1;
        while (end < chars.length) {
            while (end < chars.length && chars[end] != ' ') {
                end++;
            }
            reverseString(chars, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}

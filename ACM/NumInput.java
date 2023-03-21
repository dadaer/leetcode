import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            System.out.println(n);
            System.out.println(l);
        }
    }
}

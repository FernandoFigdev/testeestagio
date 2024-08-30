import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe um número: ");
        int num = scanner.nextInt();
        scanner.close();

        int a = 0, b = 1, c = 0;
        boolean found = false;

        while (c <= num) {
            if (c == num) {
                found = true;
                break;
            }
            c = a + b;
            a = b;
            b = c;
        }

        if (found) {
            System.out.println(num + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(num + " não pertence à sequência de Fibonacci.");
        }
    }
}

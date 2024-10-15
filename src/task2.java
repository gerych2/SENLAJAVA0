import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите сумму в BYN: ");
        double byn = scanner.nextDouble();

        double dol = 0.31;
        double dirham = 1.12;
        double eur = 0.28;
        double rub = 29.64;
        double pln = 1.20;

        System.out.println(byn + " белорусских рубля в долларах это: " + String.format("%.4f", (byn * dol)));
        System.out.println(byn + " белорусских рубля в дирхамах это: " + String.format("%.4f", (byn * dirham)));
        System.out.println(byn + " белорусских рубля в евро это: " + String.format("%.4f", (byn * eur)));
        System.out.println(byn + " белорусских рубля в российских рублях это: " + String.format("%.4f", (byn * rub)));
        System.out.println(byn + " белорусских рубля в польских злотых это: " + String.format("%.4f", (byn * pln)));
    }
}

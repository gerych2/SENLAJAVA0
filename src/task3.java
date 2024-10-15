import java.util.Random;
import java.util.Scanner;

public class task3 {

    // Символы для генерации пароля
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*";

    // Все символы, которые могут быть использованы в пароле
    private static final String ALL_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + DIGITS + SPECIAL_CHARACTERS;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Запросить длину пароля у пользователя
        System.out.println("Введите длину пароля (от 8 до 12 символов):");
        int length = scanner.nextInt();

        // Проверка корректности длины
        if (length < 8 || length > 12) {
            System.out.println("Некорректная длина пароля. Пожалуйста, выберите длину от 8 до 12 символов.");
        } else {
            // Генерация пароля
            StringBuilder password = new StringBuilder(length);

            // Гарантируем наличие хотя бы одного символа из каждой категории
            password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
            password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
            password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
            password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

            // Заполнение оставшихся символов случайными символами из всех возможных
            for (int i = 4; i < length; i++) {
                password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
            }

            // Перемешивание символов для более случайного порядка
            String finalPassword = shuffleString(password.toString(), random);

            // Вывод сгенерированного пароля
            System.out.println("Сгенерированный пароль: " + finalPassword);
        }

        scanner.close();
    }

    // Метод для случайного перемешивания символов в строке
    private static String shuffleString(String input, Random random) {
        char[] characters = input.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int j = random.nextInt(characters.length);
            // Перемешивание символов
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
}

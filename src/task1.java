import java.util.Random;
import java.util.Scanner;

public class task1
{
    private static final String[] WORDS = {"programming", "java", "hangman", "computer", "developer", "keyboard"};
    private static final int MAX_LIVES = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String wordToGuess = WORDS[random.nextInt(WORDS.length)];
        char[] guessedWord = new char[wordToGuess.length()];

        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '_';
        }

        int lives = MAX_LIVES;
        boolean wordGuessed = false;

        while (lives > 0 && !wordGuessed) {
            System.out.println("\nУгадайте слово: " + String.valueOf(guessedWord));
            System.out.println("Осталось жизней: " + lives);
            System.out.print("Введите букву: ");
            char guessedLetter = scanner.next().toLowerCase().charAt(0);

            // Проверка, есть ли буква в слове
            boolean letterFound = false;
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == guessedLetter) {
                    guessedWord[i] = guessedLetter;
                    letterFound = true;
                }
            }

            if (!letterFound) {
                lives--;
                System.out.println("Такой буквы нет в слове.");
            }

            wordGuessed = String.valueOf(guessedWord).equals(wordToGuess);
        }

        if (wordGuessed) {
            System.out.println("\nПоздравляем! Вы угадали слово: " + wordToGuess);
        } else {
            System.out.println("\nВы проиграли. Загаданное слово было: " + wordToGuess);
        }

        scanner.close();
    }
}

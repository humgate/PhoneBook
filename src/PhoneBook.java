import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    public static void main(String[] args) {
        //Добавить считывание ввода пользователя в цикле
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean isCorrectInput;

        /* Запрашиваем ввести ФИО */
        isCorrectInput = false;
        while (!isCorrectInput) {
            input = scanner.nextLine(); //Считывает строку из System.in
            isCorrectInput = checkName(input);
            if (!isCorrectInput) System.out.println("Введите корректное имя!");
        }


    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        return true;
    }

    public static boolean checkName(String name) {
        boolean result;
        Pattern pattern = Pattern.compile(
             /*
             Для валидации (проверки формата введенного ФИО) удобно, просто и очень нагялдно использовать
             регулярные выражения.
             Прочитать на русском языке можно, например, здесь.
             https://javarush.ru/groups/posts/regulyarnye-vyrazheniya-v-java

             Фамилия.
             Обязательно одна и только одна заглаваня буква, затем любое кол-во (в т.ч. ноль) прописных букв, затем
             одна (или не одной) комбинация дефиса и одной заглавной буквы, затем любое кол-во (в т.ч. ноль)
             прописных букв, заканчиваться должно обязательно одним пробелом
             */
            "[A-ZА-Я][a-zа-я]*(-[A-ZА-Я])?[a-zа-я]*\\s" +

             /* Имя.
             Обязательно одна и только одна заглаваня буква, затем любое кол-во (в т.ч. ноль) прописных букв, затем
             одна (или не одной) комбинация дефиса и одной заглавной буквы, затем любое кол-во (в т.ч. ноль)
             прописных букв, заканчиваться должно обязательно одним пробелом
             */
            "[A-ZА-Я][a-zа-я]*(-[A-ZА-Я])?[a-zа-я]*\\s" +
             /* Отчество. Для разнообразия сделаем немного по другоме чем для фамилии и имени.
             Обязательно одна и только одна заглаваня буква, затем любое кол-во (в т.ч. ноль) прописных букв, затем
             одна (или не одной) комбинация дефиса и любой буквы, затем любое кол-во (в т.ч. ноль)
             прописных букв
             */
            "[A-ZА-Я][a-zа-я]*(-[A-ZА-Яa-zа-я])?[a-zа-я]*"
        );
        Matcher matcher = pattern.matcher(name);
        result = matcher.matches();
        System.out.println(result);

        /* если проверять только одно условие, что должно быть три подстроки разделенных пробелами то можно так,
        как описано ниже. Очевидно что мощь и наглядность испольщованя регулярных выражений
        гораздо выше чем этого кода. Вопрос только в тои, насколько эьо быстро работает.
        String[] words = name.trim().split(" ");
        result= words.length == 3;
        */
        return result;
        }

    public static String formatName(String name) {
        return "";
    }

    public static String formatPhoneNumber(String number) {
        return "";
    }

    public static void add(String[][] book, String name, String number) {
        //add logic
    }

    public static void list(String[][] book) {
        //print phone book
    }
}

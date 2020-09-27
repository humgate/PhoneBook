import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    static String [][] phoneBook= new String [10][10];
    static int recCount = 0;

    public static void main(String[] args) {

        //Добавить считывание ввода пользователя в цикле
        Scanner scanner = new Scanner(System.in);
        String inputName = "";
        String inputNumber = "";
        boolean isCorrectInput;

        /* Запрашиваем ввести ФИО */
        isCorrectInput = false;
        while (!isCorrectInput) {
            System.out.println("Введите ФИО. Три слова разделенные пробелами:");
            inputName = scanner.nextLine(); //Считывает строку из System.in
            isCorrectInput = checkName(inputName);
            if (!isCorrectInput) System.out.println("ФИО введено некорректно. Введите корректные ФИО!");
        }

        /* Запрашиваем ввести номер */
        isCorrectInput = false;
        while (!isCorrectInput) {
            System.out.println("Введите номер, 11 цифр. ФорматК 8(XXX)-XXX-XX-XX. ");
            inputNumber = scanner.nextLine(); //Считывает строку из System.in
            isCorrectInput = checkPhoneNumber(inputNumber);
            if (!isCorrectInput) System.out.println("Номер введен некорректно. Повторите ввод!");
        }

        add(phoneBook, inputName, inputNumber);

    }

    public static boolean checkPhoneNumber(String phoneNumber) {
        boolean result;
        Pattern pattern = Pattern.compile(
                "\\+?\\d\\(?\\d{3}\\)?" + // +7(903) или +8903 или +7903
                        "[\\s-]?\\d{3}" + // "-000" или " 000"
                        "[\\s-]?\\d{2}" + // "-00" или " 00"
                        "[\\s-]?\\d{2}" //"-00" или " 00"
        );
        Matcher matcher = pattern.matcher(phoneNumber);
        result = matcher.matches();
        return result;
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
        if (recCount < 10) {
            recCount++;
            book[recCount][0] = name;
            book[recCount][1] = number;
            System.out.println("Запись успешно добавлена");
        } else {
            System.out.println("Превышено максмальное количество записей справочника. Новая запись не добавлена!");
        }

    }

    public static void list(String[][] book) {
        //print phone book
    }

}

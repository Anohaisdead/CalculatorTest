import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение:");
        String input;
        try {
            input = scanner.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String result = calc(input);
        System.out.println(result);
        scanner.close();
        }
    public static String calc(String input) throws IOException {
        int result;
        int number1;
        int number2;
        String[] elements = input.split(" ");
        if (elements.length < 3)
            throw new IOException("throws Exception, строка не является математической операцией");
        if (elements.length > 3)
            throw new IOException("throws Exception, должно быть два операнда и 1 оператор");
        try{
            number1 = Integer.parseInt(elements[0]);
        } catch (NumberFormatException e){
            return "Калькулятор работает только с целыми числами";
        }
        try{
            number2 = Integer.parseInt(elements[2]);
        } catch (NumberFormatException e){
            return "Калькулятор работает только с целыми числами";
        }
        if (number1 < 1 || number1 > 10 || number2 < 1 || number2 > 10)
            throw new IOException("throws Exception, числа должны быть от 1 до 10");
        if (!elements[1].equals("+") && !elements[1].equals("-") && !elements[1].equals("*") && !elements[1].equals("/"))
            throw new IOException("throws Exception, введите знак операции +, -, * или /");
        result = switch (elements[1]) {
            case "+" -> number1 + number2;
            case "-" -> number1 - number2;
            case "*" -> number1 * number2;
            case "/" -> number1 / number2;
            default -> throw new IOException("throws Exception: некорректный оператор");
        };
        return String.valueOf(result);
    }

}

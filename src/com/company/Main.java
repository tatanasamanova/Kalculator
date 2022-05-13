package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Татьяна Шаманова
 */
public class Main {
    public static void main(String[] args) {
        String inputString;
        Pattern p = Pattern.compile("([+]|-|[*]|/|^|%)");
/**
 * Метод compile позволяет установить шаблон для регулярного выражения.
 */
        Matcher m;
/**
 * Matchet это поисковик регулярных выражений
 */
        double result = 0;
/**
 * Выводим начальные инструкции для пользователя
 */
        System.out.println("Введите операцию типа(a + n): ");
        try (Scanner scanner = new Scanner(System.in)) {
/**
 * обработка исключений
 */
            while (true) {
/**
 * Цикл while выполняет действие пока истинно условие
 */
                if (scanner.hasNextLine()) {
                    inputString = scanner.nextLine();
/**
 * nextLine считывает всю введённую строку
 */
                    m = p.matcher(inputString);

                    if (m.find()) {
                        result = calculate(inputString.split("\\s+"), result);
                        System.out.println(result);
                    } else {
                        System.out.println("Неверный ввод!");
                    }
                }
            }
        } catch (Exception e) {
/**
 * продожение обработки исключений
 */
            System.out.println("ой, ошибка");
            e.printStackTrace();
        }
    }

    /**
     *метод возвращает результат математического выражения обработанного блоке switch case, в котором находится одно
     * значение, с которым сравнивается значение переменной,и инструкция в виде программного кода
     *
     * @param split делит строку на подстроки с помощью регулярного выражения
     * @param previousResult предыдущий результат
     * @return результат математичеких выражений
     * @throws Exception предупреждяет об исключении
     */
    private static double calculate(String[] split, double previousResult) throws Exception {
        double result;
        String operand;
        double number1;
        double number2;
        if (split.length == 3) {
/**
 * Метод parse используется для извлечения из строки числового значения необходимого типа
 */
            number1 = Double.parseDouble(split[0]);
            operand = split[1];
            number2 = Double.parseDouble(split[2]);

        } else if (split.length == 2) {
/**
 * В случае провала в части if в части else срабатывает новая конструкция if...else
 */
            number1 = previousResult;
            operand = split[0];
            number2 = Double.parseDouble(split[1]);
        } else {
            throw new Exception("Неверный ввод!");
        }
        switch (operand) {
/**
 * switch case-это блок, в котором находится одно значение, с которым сравнивается значение переменной,
 * и инструкция в виде программного кода
 */
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            case "^":
                result = Math.pow(number1, number2);
                break;
            case "%":
                result = number1 % number2;
                break;
            default:
                throw new Exception("Неверный ввод!");
        }
        return result;
    }
}

package sem3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (Фамилия Имя Отчество НомерТелефона):");
        String input = scanner.nextLine();

        String[] data = input.split(" ");
        if (data.length != 4) {
            System.out.println("Ошибка: неверное количество данных.");
            return;
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String phoneNumber = data[3];

        if (!isString(surname) || !isString(name) || !isString(patronymic)) {
            System.out.println("Ошибка: Фамилия, Имя и Отчество должны быть строками.");
            return;
        }

        if (!isNumeric(phoneNumber)) {
            System.out.println("Ошибка: Номер телефона должен быть числом.");
            return;
        }

        String fileName = surname + ".txt";
        String fileContent = surname + name + patronymic + phoneNumber;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(fileContent);
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }

    private static boolean isString(String str) {
        return str.matches("[a-zA-Zа-яА-Я]+");
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
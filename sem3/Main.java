package sem3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные (Фамилия Имя Отчество НомерТелефона):");
        String input = scanner.nextLine();

        String[] data = input.split(" ");
        if (data.length != 4) {
            System.out.println("Ошибка: неверное количество данных");
            return;
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String phoneNumber = data[3];

        if (!surname.matches("[а-яА-Яa-zA-Z]+")) {
            System.out.println("Ошибка: фамилия должна содержать только буквы");
            return;
        }
        if (!name.matches("[а-яА-Яa-zA-Z]+")) {
            System.out.println("Ошибка: имя должна содержать только буквы");
            return;
        }
        if (!patronymic.matches("[а-яА-Яa-zA-Z]+")) {
            System.out.println("Ошибка: отчество должна содержать только буквы");
            return;
        }

        try {
            String filename = surname + ".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
            writer.write("<" + surname + "><" + name + "><" + patronymic + "><" + phoneNumber + ">\n");
            writer.close();
            System.out.println("Данные успешно записаны в файл " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл:");
            e.printStackTrace();
        }
    }
}
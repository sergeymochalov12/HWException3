package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Services {

    public String inputFromUser (String msg){
        System.out.println("Введите данные в следующем формате:");
        System.out.println(msg);
        Scanner in = new Scanner(System.in);
        return in.nextLine();

    }
    // Метод для записи данных в файл

    public void writeToFile(String record, String fileName) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt", true))) {
            writer.write(record);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
        }

        System.out.println("Данные успешно записаны в файл.");
    }

}

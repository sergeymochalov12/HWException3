package org.example;

import jdk.internal.access.JavaIOFileDescriptorAccess;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class CheckData {
    /*
    Класс с методами проверки данных
     */
    public String input;
    public String lastName;


    public CheckData(String input) throws InvalidDataFormatException {
        this.input = input;
        String[] data = input.split(" ");
        this.lastName = data[0];
    }

    public String getLastName()
    {
        return lastName;
    }

    // метод проверки колличества введенных данных


    public static String check(String input) {
        // Разделение введенных данных
        String[] data = input.split(" ");
        // Проверка количества введенных данных
        if (data.length > 6) {
            System.out.println("Ошибка: вы ввели данных больше, чем необходимо");
            return null;
        } else if (data.length < 6) {
            System.out.println("Ошибка: вы ввели данных меньше, чем необходимо");
        }

        // Распарсим данные
        String lastName;
        String firstName = null;
        String middleName = null;
        String birthDate = null;
        long phoneNumber = 0;
        char gender = 0;
        try {
            lastName = data[0];
            firstName = data[1];
            middleName = data[2];
            birthDate = data[3];
            phoneNumber = Long.parseLong(data[4]);
            gender = data[5].charAt(0);

            // Проверка форматов данных
            // Дополнительные проверки формата даты и пола

            if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
                throw new org.example.InvalidDataFormatException("Ошибка: неверный формат даты рождения.");
            }

            if (gender != 'm' && gender != 'f') {
                throw new org.example.InvalidDataFormatException("Ошибка: неверный формат пола.");
            }
            return lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;
        } catch (
                NumberFormatException e) {
            System.out.println("Ошибка: неверный формат номера телефона.");
        } catch (org.example.InvalidDataFormatException e) {
            System.out.println(e.getMessage());
        }
        return null;
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



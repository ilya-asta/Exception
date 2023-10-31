import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Получите данные о человеке от пользователя
        Person person = Person.getUserInput();

        if (person != null) {
            // Определите имя файла
            String originalFileName = person.getLastName() + ".txt";
            String fileName = originalFileName;

            int fileCount = 1;
            while (fileExists(fileName)) {
                fileName = originalFileName.replace(".txt", "_" + fileCount + ".txt");
                fileCount++;
            }

            // Запишите данные о человеке в файл
            writeDataToFile(person, fileName);
        }
    }

    public static void writeDataToFile(Person person, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) { // Используйте конструктор с параметром true для дополнительного записи в файл
            writer.write(person.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Ошибка при записи данных в файл.");
        }
    }
    public static boolean fileExists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }
}


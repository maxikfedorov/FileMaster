/*
    Задание 1
    Есть файл test.txt, содержащий несколько строк текста. 
    С помощью пакета java.nio нужно прочитать содержимое файла и вывести данные в стандартный поток вывода.
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileRider {
    public static void main(String[] args) {

        Path path = Paths.get("src\\test.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

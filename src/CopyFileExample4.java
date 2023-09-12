/*
 * Задание 2.4
 * копирование файла с помощью file.class
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CopyFileExample4 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Path source = Paths.get("media/Test.wav");
        Path dest = Paths.get("media/TestCopy4.wav");
        try {
            Files.copy(source, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл скопирован");
        long endTime = System.currentTimeMillis();
        System.out.println("Время затрачено: " + (endTime - startTime) + " milliseconds");
    }
}

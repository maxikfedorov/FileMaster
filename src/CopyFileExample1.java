/*
 * Задание 2.1
 * копирование файла с помощью java.io FileInputStream / FileOutputStream
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileExample1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream("media/Test.wav");
             FileOutputStream fos = new FileOutputStream("media/TestCopy1.wav")) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл скопирован"); 
        long endTime = System.currentTimeMillis();
        System.out.println("Время затрачено: " + (endTime - startTime) + " milliseconds"); 
    }
}


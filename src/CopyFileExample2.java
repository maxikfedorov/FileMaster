/*
 * Задание 2.2
 * копирование файла с помощью FileChannel
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyFileExample2 {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        try (FileInputStream fis = new FileInputStream("media/Test.wav");
             FileOutputStream fos = new FileOutputStream("media/TestCopy2.wav")) {
            FileChannel sourceChannel = fis.getChannel();
            FileChannel destChannel = fos.getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл скопирован"); 
        long endTime = System.currentTimeMillis();
        System.out.println("Время затрачено: " + (endTime - startTime) + " milliseconds"); 
    }
}

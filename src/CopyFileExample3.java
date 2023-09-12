/*
 * Задание 2.3
 * копирование файла с помощью apache.commons.io.FileUtils
 */

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CopyFileExample3 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        File source = new File("media/Test.wav");
        File dest = new File("media/TestCopy3.wav");

        FileUtils.copyFile(source, dest);
        System.out.println("Файл скопирован"); 
        long endTime = System.currentTimeMillis();
        System.out.println("Время затрачено: " + (endTime - startTime) + " milliseconds");       
    }
}



/*
 * Задание 3
 * поиск контрольной суммы файла
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

public class ControlSum {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("src\\\\test.txt")) {
            byte[] buffer = new byte[1024];
            int length;
            Adler32 adler32 = new Adler32();
            while ((length = fis.read(buffer)) > 0) {
                ByteBuffer bb = ByteBuffer.wrap(buffer, 0, length);
                adler32.update(bb);
            }
            long checksum = adler32.getValue();
            System.out.println("Adler-32 checksum: " + checksum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


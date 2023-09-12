/*
 * Задание 4
 * Сервис по мониторингу директории
 * 
 */


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WatchServiceExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        Path dir = Paths.get("media");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        Map<WatchKey, Path> keyMap = new HashMap<>();
        dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

        while (true) {
            WatchKey key = watchService.take();
            Path dirPath = keyMap.get(key);
            if (dirPath == null) {
                dirPath = (Path) key.watchable();
                keyMap.put(key, dirPath);
            }
            List<WatchEvent<?>> eventList = key.pollEvents();
            for (WatchEvent<?> event : eventList) {
                WatchEvent.Kind<?> kind = event.kind();
                Path filePath = (Path) event.context();
                Path absPath = dirPath.resolve(filePath);
                if (kind == StandardWatchEventKinds.ENTRY_CREATE) {
                    System.out.println("New file created: " + filePath);
                } else if (kind == StandardWatchEventKinds.ENTRY_DELETE) {
                    if (Files.exists(absPath)) {
                        BasicFileAttributes attr = Files.readAttributes(absPath, BasicFileAttributes.class);
                        System.out.println("Size: " + attr.size());
                    } else {
                        System.out.println("File not found: " + filePath);
                    }
                } else if (kind == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println("File modified: " + filePath);
                    // TODO: вывод списка изменений
                }
            }
            key.reset();
        }
    }
}

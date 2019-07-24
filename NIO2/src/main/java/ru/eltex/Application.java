package ru.eltex;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        Path dir = FileSystems.getDefault().getPath("/home/favarish");
        WatchKey key = dir.register(watcher, ENTRY_MODIFY, ENTRY_DELETE, ENTRY_CREATE); // какие события отслеживать
        while(true) {
            key = watcher.take();
            for (WatchEvent<?> event: key.pollEvents()) {
                if (event.kind() == ENTRY_MODIFY){
                    System.out.println("МОДИФИКАЦИЯ: " + event.context());
                }
                if (event.kind() == ENTRY_CREATE ){
                    System.out.println("СОЗДАНИЕ: " + event.context());
                }
                if (event.kind() == ENTRY_DELETE){
                    System.out.println("УДАЛЕНИЕ: " + event.context());
                }
            }
            key.reset();
        }
    }
}

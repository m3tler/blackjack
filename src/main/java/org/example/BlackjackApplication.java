package org.example;

import org.example.app.ApplicationManager;
import org.example.io.IOManager;

public class BlackjackApplication {

    private static final String filePath = "src\\main\\resources\\banner.txt";

    public static void main(String[] args) {
        ApplicationManager applicationManager = new ApplicationManager();
        applicationManager.run();

        IOManager ioManager = new IOManager();
        ioManager.tryReadFile(filePath).ifPresent(ioManager::printLine);
        ioManager.close();
    }
}

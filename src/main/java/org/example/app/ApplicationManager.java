package org.example.app;

import org.example.io.IOManager;
import org.example.ui.AssetManager;

import java.util.Map;

public class ApplicationManager {
    public void run() {
        IOManager ioManager = new IOManager();
        AssetManager assetManager = new AssetManager(ioManager);
        Map<String, String> assets = assetManager.getAssets();
        ioManager.printLine(assets.get("banner.txt"));
    }
}

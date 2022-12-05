package org.example.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.io.IOManager;

import java.util.*;

public class AssetManager {
    private static final String ASSETS_DIRECTORY = "src\\main\\resources\\assets\\";
    private final IOManager ioManager;
    private final Logger logger = LogManager.getLogger(AssetManager.class);
    private final Map<String, String> assets;

    public AssetManager(IOManager ioManager) {
        this.ioManager = ioManager;
        this.assets = loadAll();
    }

    private Map<String, String> loadAll() {
        Map<String, String> loadedAssets = new HashMap<>();
        Set<String> files = ioManager.readAllFileNamesFromDirectory(ASSETS_DIRECTORY);
        files.forEach(file -> loadedAssets.put(file, load(file)));
        logger.info("Finish loading assets from {}", ASSETS_DIRECTORY);
        return loadedAssets;
    }

    private String load(String fileName) {
        return ioManager.readStringFromFile(ASSETS_DIRECTORY + fileName);
    }

    public Map<String, String> getAssets() {
        return assets;
    }
}
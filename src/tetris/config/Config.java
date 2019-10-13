package tetris.config;

import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public final class Config {

    private static final String WINDOW_HEIGHT = "window.height";
    private static final String BACKGROUND_COLOR = "background.color";
    private static final String FIGURES_COLOR = "figures.color";

    public static final int LINE_WIDTH = 2;
    public static int windowHeight;
    public static int windowWidth;
    public static int fieldWidth;
    public static int linePosition;
    public static int blockSize;
    public static Color bgColor;
    public static Color figuresColor;

    private Config() {
    }

    public static void init(String path) throws Exception {
        Map<String, String> properties = readPropertiesFromFile(path);
        initFields(properties);
    }

    private static Map<String, String> readPropertiesFromFile(String path) throws Exception {
        Map<String, String> properties = new HashMap<>();
        File propFile = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(propFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=");
            properties.put(parts[0], parts[1]);
        }
        return properties;
    }

    private static void initFields(Map<String, String> properties) {
        windowHeight = Integer.parseInt(properties.get(WINDOW_HEIGHT));
        windowWidth = windowHeight * 3 / 4;
        fieldWidth = windowWidth * 2 / 3;
        linePosition = fieldWidth + 1;
        blockSize = windowHeight / 20;

        bgColor = Color.web(properties.get(BACKGROUND_COLOR));
        figuresColor = Color.web(properties.get(FIGURES_COLOR));
    }
}

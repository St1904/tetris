package tetris.config;

import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.EnumMap;

public class Context {

    private final EnumMap<Property, String> configuration = new EnumMap<>(Property.class);

    public void init(String path) throws Exception {
        File propFile = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(propFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("=");
            Property property = Property.getProperty(parts[0]);
            if (property != null) {
                configuration.put(property, parts[1]);
            }
        }
    }

    public int getWindowWidth() {
        return getWindowHeight() * 3 / 4;
    }

    public int getWindowHeight() {
        return getIntValue(Property.WINDOW_HEIGHT);
    }

    public int getBlockSize() {
        return getIntValue(Property.WINDOW_HEIGHT) / 20;
    }

    public Color getBgColor() {
        return getColorValue(Property.BACKGROUND_COLOR);
    }

    public Color getFiguresColor() {
        return getColorValue(Property.LINES_COLOR);
    }

    public int getFieldWidth() {
        return getWindowWidth() * 2 / 3;
    }

    public int getLinePosition() {
        return getFieldWidth() + 1;
    }

    private int getIntValue(Property property) {
        return Integer.parseInt(configuration.get(property));
    }

    private String getStringValue(Property property) {
        return configuration.get(property);
    }

    private Color getColorValue(Property property) {
        return Color.web(getStringValue(property));
    }
}

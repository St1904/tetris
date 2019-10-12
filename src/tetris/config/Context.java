package tetris.config;

import javafx.scene.paint.Color;

import java.io.*;
import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Logger;

public class Context {

    private static final Logger LOG = Logger.getLogger(Context.class.getName());

    private final EnumMap<Property, String> configuration = new EnumMap<>(Property.class);

    public void init(String path) {
        try {
            File propFile = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(propFile));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                configuration.put(Property.getProperty(parts[0]), parts[1]);
            }
        } catch (IOException e) {
            // TODO show window with error
        }

        // just to be sure it is OK
        for (Map.Entry<Property, String> propertyStringEntry : configuration.entrySet()) {
            LOG.fine("prop: " + propertyStringEntry.getKey() + ", value: " + propertyStringEntry.getValue());
        }
    }

    public int getWindowWidth() {
        return getIntValue(Property.WINDOW_HEIGHT) * 3 / 4;
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

    public Color getLinesColor() {
        return getColorValue(Property.LINES_COLOR);
    }

    // TODO show error if it is not OK
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

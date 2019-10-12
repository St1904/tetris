package tetris.config;

import java.util.HashMap;
import java.util.Map;

public enum Property {

    WINDOW_HEIGHT("window.height"),
    BACKGROUND_COLOR("background.color"),
    LINES_COLOR("lines.color");

    private static final Map<String, Property> translator = new HashMap<>();
    static {
        for (Property property : Property.values()) {
            translator.put(property.getName(), property);
        }
    }

    private final String name;

    Property(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Property getProperty(String name) {
        return translator.get(name);
    }
}

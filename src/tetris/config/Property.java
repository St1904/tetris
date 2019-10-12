package tetris.config;

import java.util.HashMap;
import java.util.Map;

public enum Property {

    MAIN_WINDOW_WIDTH("main.window.width"),
    MAIN_WINDOW_HEIGHT("main.window.height");

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

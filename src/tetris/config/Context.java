package tetris.config;

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
        return getIntValue(Property.MAIN_WINDOW_WIDTH);
    }

    public int getWindowHeight() {
        return getIntValue(Property.MAIN_WINDOW_HEIGHT);
    }

    // TODO show error if it is not OK
    private int getIntValue(Property property) {
        return Integer.parseInt(configuration.get(property));
    }
}

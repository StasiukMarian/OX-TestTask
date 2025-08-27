package org.ox.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetToken {

    private static final Properties props = new Properties();

    static {
        try (InputStream input = GetToken.class.getClassLoader().getResourceAsStream("application.properties")) {
            props.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Cannot load application.properties", e);
        }
    }

    public static String getApiKey() {
        return props.getProperty("api.key");
    }
}


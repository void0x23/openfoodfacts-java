package org.openfoodfacts.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {

    private static final String CONFIG_FILE = "application.properties";
    private Properties properties;

    public ConfigurationManager() throws IOException {
        this.properties = new Properties();
        loadProperties();
    }

    private void loadProperties() throws IOException {
        try (InputStream input = this.getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            properties.load(input);
        }
    }

    public String getBaseSearchUrl() {
        return properties.getProperty("openfoodfacts.base-search-url");
    }

    public String getProductContextpath() {
        return properties.getProperty("openfoodfacts.url.product.context-path");
    }

    public String getKnowledgePanels() {
        return properties.getProperty("openfoodfacts.url.fields.knowledge-panels");
    }
}

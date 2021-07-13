package co.com.devco.certification.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TravelocityProperties {

    private static final Logger LOGGER = LoggerFactory.getLogger(TravelocityProperties.class);

    private static Properties prop = getProperties();

    public static String getUrl(){
        return prop.getProperty("url");
    }

    private static Properties getProperties() {

        Properties prop = new Properties();

        try {
            prop.load(new FileReader("travelocity.properties"));
        } catch (IOException ex) {
            LOGGER.error("Error al leer el archivo de propiedades travelocity.properties", ex);
        }
        return prop;
    }

}

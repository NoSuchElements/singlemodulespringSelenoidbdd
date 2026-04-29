package com.nosuchelements.utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
@Component
public class DataHelper {
private static final Logger logger = LoggerFactory.getLogger(DataHelper.class);
private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

/**
 * Read JSON file and convert to Map
 */
public Map<String, Object> readJsonFile(String filePath) {
    try (FileReader reader = new FileReader(filePath)) {
        return gson.fromJson(reader, Map.class);
    } catch (IOException e) {
        logger.error("Failed to read JSON file: {}", filePath, e);
        throw new RuntimeException("Failed to read JSON file", e);
    }
}

/**
 * Convert object to JSON string
 */
public String toJson(Object object) {
    return gson.toJson(object);
}

/**
 * Convert JSON string to object
 */
public <T> T fromJson(String json, Class<T> classOfT) {
    return gson.fromJson(json, classOfT);
}

}

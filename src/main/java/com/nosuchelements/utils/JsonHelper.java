package com.nosuchelements.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * JSON Helper for serialization and deserialization
 */
@Component
public class JsonHelper {

    private static final Logger logger = LoggerFactory.getLogger(JsonHelper.class);
    private final ObjectMapper objectMapper;

    public JsonHelper() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Convert object to JSON string
     */
    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("Failed to convert object to JSON", e);
            return "{}";
        }
    }

    /**
     * Convert object to pretty JSON string
     */
    public String toPrettyJson(Object object) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            logger.error("Failed to convert object to pretty JSON", e);
            return "{}";
        }
    }

    /**
     * Parse JSON string to object
     */
    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            logger.error("Failed to parse JSON to object", e);
            return null;
        }
    }

    /**
     * Read JSON from file
     */
    public <T> T readFromFile(String filePath, Class<T> clazz) {
        try {
            return objectMapper.readValue(new File(filePath), clazz);
        } catch (IOException e) {
            logger.error("Failed to read JSON from file: {}", filePath, e);
            return null;
        }
    }

    /**
     * Write object to JSON file
     */
    public void writeToFile(Object object, String filePath) {
        try {
            objectMapper.writeValue(new File(filePath), object);
            logger.info("JSON written to file: {}", filePath);
        } catch (IOException e) {
            logger.error("Failed to write JSON to file: {}", filePath, e);
        }
    }

    /**
     * Validate if string is valid JSON
     */
    public boolean isValidJson(String json) {
        try {
            objectMapper.readTree(json);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }
}

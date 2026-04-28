package com.nosuchelements.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * File Operations Helper
 */
@Component
public class FileHelper {

    private static final Logger logger = LoggerFactory.getLogger(FileHelper.class);

    /**
     * Create directory if it doesn't exist
     */
    public void createDirectory(String directoryPath) {
        try {
            Path path = Paths.get(directoryPath);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
                logger.info("Directory created: {}", directoryPath);
            }
        } catch (IOException e) {
            logger.error("Failed to create directory: {}", directoryPath, e);
        }
    }

    /**
     * Delete file if it exists
     */
    public void deleteFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            if (Files.exists(path)) {
                Files.delete(path);
                logger.info("File deleted: {}", filePath);
            }
        } catch (IOException e) {
            logger.error("Failed to delete file: {}", filePath, e);
        }
    }

    /**
     * Copy file
     */
    public void copyFile(String sourcePath, String destinationPath) {
        try {
            Path source = Paths.get(sourcePath);
            Path destination = Paths.get(destinationPath);
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            logger.info("File copied from {} to {}", sourcePath, destinationPath);
        } catch (IOException e) {
            logger.error("Failed to copy file from {} to {}", sourcePath, destinationPath, e);
        }
    }

    /**
     * Check if file exists
     */
    public boolean fileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    /**
     * Get file extension
     */
    public String getFileExtension(String filePath) {
        int lastIndexOf = filePath.lastIndexOf(".");
        if (lastIndexOf == -1) {
            return "";
        }
        return filePath.substring(lastIndexOf + 1);
    }

    /**
     * Read file content as string
     */
    public String readFileContent(String filePath) {
        try {
            return Files.readString(Paths.get(filePath));
        } catch (IOException e) {
            logger.error("Failed to read file: {}", filePath, e);
            return null;
        }
    }

    /**
     * Write content to file
     */
    public void writeToFile(String content, String filePath) {
        try {
            Files.writeString(Paths.get(filePath), content);
            logger.info("Content written to file: {}", filePath);
        } catch (IOException e) {
            logger.error("Failed to write to file: {}", filePath, e);
        }
    }

    /**
     * Get file size in bytes
     */
    public long getFileSize(String filePath) {
        try {
            return Files.size(Paths.get(filePath));
        } catch (IOException e) {
            logger.error("Failed to get file size: {}", filePath, e);
            return -1;
        }
    }

    /**
     * Clean directory (delete all files)
     */
    public void cleanDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    }
                }
                logger.info("Directory cleaned: {}", directoryPath);
            }
        }
    }
}

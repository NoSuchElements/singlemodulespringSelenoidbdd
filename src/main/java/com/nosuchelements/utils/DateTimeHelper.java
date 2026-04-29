package com.nosuchelements.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Date and Time Helper Utilities
 */
@Component
public class DateTimeHelper {

    private static final DateTimeFormatter DEFAULT_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DEFAULT_DATETIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter TIMESTAMP_FORMAT = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    /**
     * Get current date as string (yyyy-MM-dd)
     */
    public String getCurrentDate() {
        return LocalDate.now().format(DEFAULT_DATE_FORMAT);
    }

    /**
     * Get current date-time as string (yyyy-MM-dd HH:mm:ss)
     */
    public String getCurrentDateTime() {
        return LocalDateTime.now().format(DEFAULT_DATETIME_FORMAT);
    }

    /**
     * Get timestamp for filenames (yyyyMMdd_HHmmss)
     */
    public String getTimestamp() {
        return LocalDateTime.now().format(TIMESTAMP_FORMAT);
    }

    /**
     * Format date with custom pattern
     */
    public String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }

    /**
     * Format date-time with custom pattern
     */
    public String formatDateTime(LocalDateTime dateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    /**
     * Parse date string
     */
    public LocalDate parseDate(String dateString, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return LocalDate.parse(dateString, formatter);
    }

    /**
     * Get date N days from now
     */
    public LocalDate addDays(int days) {
        return LocalDate.now().plusDays(days);
    }

    /**
     * Get date N days ago
     */
    public LocalDate subtractDays(int days) {
        return LocalDate.now().minusDays(days);
    }

    /**
     * Calculate days between two dates
     */
    public long daysBetween(LocalDate startDate, LocalDate endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate);
    }

    /**
     * Check if date is in the past
     */
    public boolean isInPast(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    /**
     * Check if date is in the future
     */
    public boolean isInFuture(LocalDate date) {
        return date.isAfter(LocalDate.now());
    }
}

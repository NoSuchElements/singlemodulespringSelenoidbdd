package com.nosuchelements.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QTestConfig {

    @Value("${qtest.url}")
    private String qtestUrl;

    @Value("${qtest.api.token}")
    private String apiToken;

    @Value("${qtest.project.id}")
    private Long projectId;
    
    @Value("${qtest.cert.path}")
    private String certPath;
    
    @Value("${qtest.cert.password}")
    private String keyPassword;

    @Value("${qtest.enabled:false}")
    private boolean enabled;

    @Value("${qtest.test.cycle.name:Automated Test Cycle}")
    private String testCycleName;

    @Value("${qtest.test.suite.name:Regression Suite}")
    private String testSuiteName;

    @Value("${qtest.attach.screenshots:true}")
    private boolean attachScreenshots;

    @Value("${qtest.retry.attempts:3}")
    private int retryAttempts;

    @Value("${qtest.connection.timeout:30}")
    private int connectionTimeout;
    
    @Value("${qtest.test.cycle.id:6454703}")
    private String testCycleId;

    @Value("${qtest.test.suite.id:}")
    private String testSuiteId;
    
    @Value("${qtest.release.cycle.id:0}")
    private Long releaseCycleId;
    
    @Value("${qtest.platform.cycle.web:0}")
    private Long webCycleId;
    
    @Value("${qtest.platform.cycle.android:0}") 
    private Long androidCycleId;
    
    @Value("${qtest.platform.cycle.ios:0}")
    private Long iosCycleId;
    
    @Value("${platform:WEB}")
	private String platform;

    // Getters
    public String getQtestUrl() { return qtestUrl; }
    public String getApiToken() { return apiToken; }
    public Long getProjectId() { return projectId; }
    public boolean isEnabled() { return enabled; }
    public String getTestCycleName() { return testCycleName; }
    public String getTestSuiteName() { return testSuiteName; }
    public String getTestCycleId() { return testCycleId; }
    public String getTestSuiteId() { return testSuiteId; }
    public String getCertPath() { return certPath; }
    public String getCertPassword() { return keyPassword; }
    public boolean isAttachScreenshots() { 
        return attachScreenshots; 
    }
    public int getRetryAttempts() { return retryAttempts; }
    public int getConnectionTimeout() { 
        return connectionTimeout; 
    }

    public Long getReleaseCycleId() { return releaseCycleId; }
    public Long getPlatformCycleId() {
        return switch (platform.toLowerCase()) {
            case "android" -> androidCycleId;
            case "ios" -> iosCycleId;
            default -> webCycleId;
        };
    }
    public String getPlatform() { return platform; }
    public String getApiUrl() {
        return qtestUrl + "/api/v3/";
    }

    public boolean isConfigurationValid() {
        return qtestUrl != null && !qtestUrl.isEmpty() &&
               apiToken != null && !apiToken.isEmpty() &&
               projectId != null && projectId > 0;
    }
}
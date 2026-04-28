package com.nosuchelements.utils.dsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


/**
 * Consumer application entry point.
 *
 * @Import(DataSourceConfig.class) pulls in the library's DataSource beans,
 * JdbcTemplate beans, and all three Manager @Components into this context.
 *
 * Nothing else is needed — all SQL and business logic lives in the library.
 * This app only provides connection details via application.properties.
 */
@SpringBootApplication(scanBasePackages = "com.nosuchelements")
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}

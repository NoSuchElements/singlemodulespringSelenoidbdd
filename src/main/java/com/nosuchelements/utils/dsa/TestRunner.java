package com.nosuchelements.utils.dsa;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class TestRunner implements CommandLineRunner {
	

    @Override
    public void run(String... args) throws SQLException {
    	System.out.println("Inside Test Runner main");
    	try {
    		Connection connection = null ;
        if (connection.isValid(5)) {
            System.out.println("✅ Database connection SUCCESSFUL");
        }

    } catch (Exception e) {
        System.err.println("❌ Database connection FAILED");
        e.printStackTrace();
    }
   }

}

package com.nosuchelements.constants;

public class Constants {
	public enum Language{
		English,
		French,
		Onboarding
	}
	
	public enum Platform{
		DSA,
		DASH,
		WICI,
		NCAT,
		INTEGRATION
	}
	
	public enum Phone_Type {
		MOBILE,
		HOME
	}
	
	 	public static final long timeoutLong = 30;

	    public static final long pollingLong = 200;

	    public static final long timeoutShort = 10;

	    public static final long pollingShort = 100;

	    public static String DRIVER_DIRECTORY = System.getProperty("user.dir") + "/../common/src/main/resources/drivers";

	    public static String COMMON_RESOURCES = System.getProperty("user.dir") + "/../common/src/main/resources";
}

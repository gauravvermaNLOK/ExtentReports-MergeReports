package com.gaurav.mergereports;

import java.io.File;

public class Util {

	/**
	 * 
	 * @return Path of Directory where Json Report will be Stored
	 */
	public static String createDirectoryForJsonReport()
	{
		 //Creating a Directory for Extent Json Output and create it if doesn't exist
        File file = new File("ExtentJson");
        if (!file.exists()) {
            file.mkdir();
        }
        String opFolder = file.getPath();
        return opFolder;
	}
}

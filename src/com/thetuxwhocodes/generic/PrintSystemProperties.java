package com.thetuxwhocodes.generic;

import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

public class PrintSystemProperties { 

	public static void printAllSystemProperties() {

		Properties systemProperties = System.getProperties();

		Set<Entry<Object, Object>> propertyEntries = systemProperties
				.entrySet();

		for (Entry<Object, Object> propertyEntry : propertyEntries) {
			System.out.println(propertyEntry.getKey() + " : "
					+ propertyEntry.getValue());
		}

	}

	public static void main(String[] args) {
		printAllSystemProperties();
	}

}

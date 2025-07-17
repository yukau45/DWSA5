package org.automation.generic_utilities;

import java.time.LocalDateTime;
import java.util.Random;
/**
 * JavaUtil class provides some static methods which are being used in automation
 * 
 * @author my
 */
public class JavaUtil {
	/**
	 * This method is used to generate a random number and return that number with in the given boundary
	 * @param boundary [int]
	 * @return boundaryNmuber [int]
	 */
	public static int getRandomNumber(int boundary) {
		Random random = new Random();
		return random.nextInt(boundary);
	}
	/**
	 * This method is used to get the timeStamp[Date+time(including millis)]
	 * @return timeStamp[String]
	 */
	public static String timeStamp() {
		LocalDateTime ldt = LocalDateTime.now();
		return ldt.toString().replace(":","-");
	}

}

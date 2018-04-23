package com.xe.b2b.data.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecurityUtil extends Thread {

	private static int max_day_size = 30;
	private static String DATE_STR = null;
	private static final String SHORT_DATE = "yyyyMMdd";

	public static void main(String[] args) throws InterruptedException {
		System.out.println(SecurityUtil.hasExpired());
	}

	public static synchronized boolean hasExpired() {
		String str = new SimpleDateFormat(SHORT_DATE).format(new Date());
		if (DATE_STR == null || !DATE_STR.equals(str)) {
			DATE_STR = str;
			max_day_size--;
		}

		return max_day_size <= 0;
	}

}

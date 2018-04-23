package com.xe.b2b.data.common.util;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * 去除中间的横线
	 * @return
	 */
	public static String getUUID(){
		String uuid= UUID.randomUUID().toString().replaceAll("-","");
		return uuid;
		
	}
	
	public static void main(String[] args) {
		System.out.println(getUUID());
	}

}

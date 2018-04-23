/*
 * Copyright (c) 2016 Augmentum, Inc. All rights reserved.
 */
package com.xe.b2b.data.common.util;

import java.util.regex.Pattern;

public class IpUtil {
    public static boolean checkIP(String str) {
        Pattern pattern = Pattern
                .compile("^((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]"
                        + "|[*])\\.){3}(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]|[*])$");
        return pattern.matcher(str).matches();
    }
    
    public static long transformIP(String ip) {
        long result = 0;
        try {
            String[] split = ip.split("\\.");
            if (split.length != 4)
                return result;
            result |= (Long.parseLong(split[3]) & 0xFF);
            result |= ((Long.parseLong(split[2]) << 8) & 0xFF00);
            result |= ((Long.parseLong(split[1]) << 16) & 0xFF0000);
            result |= ((Long.parseLong(split[0]) << 24) & 0xFF000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

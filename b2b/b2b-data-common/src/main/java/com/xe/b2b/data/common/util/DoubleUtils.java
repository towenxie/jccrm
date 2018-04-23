/**
 * @ProjectName b2b-data-common
 * @FileName DoubleUtils.java
 * @PackageName com.xe.b2b.data.common.util
 * @Date 2017年9月18日上午2:51:30
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.common.util;

import java.math.BigDecimal;

/**
 * @ClassName DoubleUtils 
 * @Description TODO
 * @Date     2017年9月18日 上午2:51:30
 * @author   towen
 * @version  v1.0	 
 */
public class DoubleUtils {

    public static double save2Decimal(double f) {
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }
}


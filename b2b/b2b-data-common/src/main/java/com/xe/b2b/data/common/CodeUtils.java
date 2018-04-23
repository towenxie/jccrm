/**
 * @ProjectName b2b-data-common
 * @FileName CodeUtils.java
 * @PackageName com.xe.b2b.data.common
 * @Date 2017年1月11日上午12:39:11
 * @Copyright (c) 2017, xhra All Rights Reserved.
 *
*/

package com.xe.b2b.data.common;
/**
 * @ClassName CodeUtils 
 * @Description TODO
 * @Date     2017年1月11日 上午12:39:11
 * @author   towen
 * @version  v1.0	 
 */
public class CodeUtils {

    /**
     * 创建指定数量的随机字符串
     * @param numberFlag 是否是数字
     * @param length
     * @return
     */
    public static String createRandom(boolean numberFlag, int length){
     String retStr = "";
     String strTable = numberFlag ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
     int len = strTable.length();
     boolean bDone = true;
     do {
      retStr = "";
      int count = 0;
      for (int i = 0; i < length; i++) {
       double dblR = Math.random() * len;
       int intR = (int) Math.floor(dblR);
       char c = strTable.charAt(intR);
       if (('0' <= c) && (c <= '9')) {
        count++;
       }
       retStr += strTable.charAt(intR);
      }
      if (count >= 2) {
       bDone = false;
      }
     } while (bDone);
    
     return retStr;
    }
}


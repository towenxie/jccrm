package com.xe.b2b.data.common.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestOrder extends Thread{

	 private static long orderNum = 0l;  
	    private static String date ;  
	      
	    public static void main(String[] args) throws InterruptedException {  
	    	TestOrder order = new TestOrder();
//	        for (int i = 0; i < 10000; i++) { 
	        	Thread thread1 = new Thread(order);
	        	thread1.start(); 
	        	Thread thread2 = new Thread(order);
	        	thread2.start();
//	        }  
//	        for (int i = 0; i < 10000; i++) {  
//	        	Thread thread2 = new Thread(order);
//	        	thread2.start();
//	        }
	    }  
	  
	    public void run(){
	    	System.out.println(this.getOrderNo());  
	    }
	    /** 
	     * 生成订单编号 
	     * @return 
	     */  
	    public static synchronized String getOrderNo() {  
	        String str = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());  
	        if(date==null||!date.equals(str)){  
	            date = str;  
	            orderNum  = 0l;  
	        }  
	        orderNum ++;  
	        long orderNo = Long.parseLong((date)) * 100000;  
	        orderNo += orderNum;
	        return orderNo+"";  
	    }  
}

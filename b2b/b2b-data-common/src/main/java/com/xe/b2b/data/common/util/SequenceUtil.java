package com.xe.b2b.data.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.xe.b2b.data.common.contants.SystemConstant;

public class SequenceUtil extends Thread {

	private static int max_work_id_length = 8;
	private static long ORDER_NUMBER = 0l;
	private static String DATE_STR = null;
	private static final String LONG_DATE = "yyyyMMddHHmm";
	private static final String SHORT_DATE = "yyyyMMdd";

	public static void main(String[] args) throws InterruptedException {
		System.out.println(SequenceUtil.getOrderNo());
		System.out.println(SequenceUtil.getOrderNo());
		System.out.println(SequenceUtil.getGoodsNo());
		System.out.println(SequenceUtil.getGoodsNo());
		System.out.println(SequenceUtil.getStockNo());
		System.out.println(SequenceUtil.getGoodsNo());
		System.out.println(SequenceUtil.generateWorkId("123"));
	}

	/**
	 * 生成订单编号
	 * 
	 * @return
	 */
	private static synchronized long generateSequenceId(String dateFormat) {
		String str = new SimpleDateFormat(dateFormat).format(new Date());
		if (DATE_STR == null || !DATE_STR.equals(str)) {
			DATE_STR = str;
			ORDER_NUMBER = 0l;
		}

		ORDER_NUMBER++;
		long orderNo = Long.parseLong((DATE_STR)) * 10000;
		orderNo += ORDER_NUMBER;

		return orderNo;
	}

	public static synchronized String generateWorkId(String id) {
		String workId = SystemConstant.WORK_NUMBER_FLAG;
		while (max_work_id_length > workId.length() + id.length()) {
			workId += "0";
		}
		workId += id;
		return workId;
	}

	public static synchronized String getOrderNo() {
		return SystemConstant.ORDER_NUMBER_FLAG + generateSequenceId(LONG_DATE);
	}

	public static synchronized String getGoodsNo() {
		return SystemConstant.GOODS_NUMBER_FLAG + generateSequenceId(SHORT_DATE);
	}

	public static synchronized String getStockNo() {
		return SystemConstant.STOCK_NUMBER_FLAG + generateSequenceId(LONG_DATE);
	}
	
	public static synchronized String getStockLogNo() {
		return SystemConstant.STOCK_LOG_NUMBER_FLAG + generateSequenceId(LONG_DATE);
	}
}

package com.xe.b2b.data.common.util;

public class ConstantUtils {


	public final static String USERINFO = "userInfo";		// 当前账户
    public final static String ROLES = "cjgly,xgly,ygly,ksgly"; //后台管理员
    public final static String DEFAULTPWD="123456";//初始密码
    public static class RoleType{
		public final static String GLY = "1";	//管理员
		public final static String MY  = "2";	//名医
		public final static String PTYS = "3";	//普通医生
		public final static String PTYH = "4";	//普通用户
		public final static String XSDB = "5";	//销售代表

	}

    /**
     * web用户
	 *   /**用户类型(1、学生会员	2、教师会员	3、机构/学校)
     */
	public interface WEBTYPE {
		public final static String XS="1";//学生会员
		public final static String JS="2";//教师会员
		public final static String JG="3";//机构/学校
	}
    /**
     * web用户
	 *   /**用户类型(1、学生会员	2、教师会员	3、机构/学校)
     */
	public interface TASKTYPE {
		public final static Integer LQ=0;//已领取任务
		public final static Integer WC=1;//完成
	} /**
     * 字典
     */
	public interface Dictionary {
		public final static String hospitallevel="1";//医院级别
		public final static String YEAR="2";//年份
	}
	
	/***
	 * 字典表内分类
	 */
	public interface DIC_CLASSFY {
		public final static String COMPANY="1";//500强企业
		public final static String CMA="2";//cma标记
	}
	
	/**
     * 区域表
     */
	public interface Area {
		public final static String SHENG="0";//省级别的code
	}
	/**
     * 栏目
     */
	public interface Column {
		public final static String JCKC="0";//精彩课程
		public final static String BLFX="1";//病例分析
	}
	
	/**
	 * 用户状态
	 */
	public interface UserStatus{
		public final static Integer MYJS= null;//名医讲师
		public final static Integer ZYJSDSH=0;//专业讲师待审核
		public final static Integer ZYJSSHTG=1;//专业讲师审核通过
		public final static Integer ZYJSSHBH=2;//专业讲师已驳回
		public final static Integer QBZYJS=-1;//全部专业讲师
		public final static Integer IS_days=1;//已推荐天天健康
		public final static Integer NOT_days=0;//未推荐天天健康
		public final static Integer IS_learning=1; //已推荐学术交流
		public final static Integer NOT_learning=0; //未推荐学术交流
		public final static Integer IS_del=1; //已删除用户
		public final static Integer NOT_del=0; //未删除用户
		
	}

}

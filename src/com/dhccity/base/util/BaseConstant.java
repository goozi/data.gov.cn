package com.dhccity.base.util;

public interface BaseConstant {
	// 状态
	final static String STATE_DEL = "-1"; // 删除
	final static String STATE_NORMAL = "1"; // 普通

	// 是否发布
	final static String IS_PUBLIC_PUBLIC = "1"; // 已发布
	final static String IS_PUBLIC_PRIVATE = "0"; // 未发布
	
	// 文章类型
	final static String ARTICLE_TYPE_CAROUSEL = "1"; // 幻灯片
	final static String ARTICLE_TYPE_FORUM = "2"; // 开发者讨论组
	final static String ARTICLE_TYPE_DATASET = "3"; // 数据集
	final static String ARTICLE_TYPE_APP = "4"; // 应用
	final static String ARTICLE_TYPE_API = "5"; // API

	//审核状态
	final static String APPROVAL_STATUS_NORMAL = "0"; // 初始
	final static String APPROVAL_STATUS_REFUSE = "-1"; // 审核不通过
	final static String APPROVAL_STATUS_PASS = "1"; // 审核通过

	//搜索类型
	final static String SEARCH_TYPE_DATA = "data"; //数据
	final static String SEARCH_TYPE_ALL = "all"; //全部

}

package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * 菜单业务类
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company: DHCcity
 * </p>
 * 
 * @author Zerrion
 * @version 1.0
 */

public class MenuApp {
	/**
	 * 通过树型菜单Xml
	 * 
	 * @param user
	 *            User 上传用户对象
	 * @return String
	 */
	public static String createXml(User user) {
		List list = new BaseMenu().findAllNode(1);
		Iterator it = list.iterator();
		String strXml = "<?xml version='1.0' encoding='gb2312' ?><tree>";
		long lastLevel = 0, noneLevel = 9999999;
		while (it.hasNext()) {
			BaseMenu baseTree = (BaseMenu) it.next();

			// 父节点没有权限
			if (baseTree.getLevel() > noneLevel) {
				continue;
			}

			// 权限检测
			boolean isAccess = SecurityApp.checkFunction(user, baseTree
					.getSecurityId());
			if (!isAccess) {
				noneLevel = baseTree.getLevel();
				continue;
			}
			noneLevel = 9999999;

			if (lastLevel > baseTree.getLevel()) {
				for (int i = 0; i < lastLevel - baseTree.getLevel(); i++) {
					strXml += "</item>";
				}
			}

			if (baseTree.isLeaf()) {
				strXml += "<item value='" + baseTree.getId() + "' text='"
						+ baseTree.getName() + "'   NodeId='"
						+ baseTree.getId() + "' Title='" + baseTree.getName()
						+ "' Href='" + baseTree.getValue() + "' Target='"
						+ baseTree.getTarget() + "' Img='"
						+ baseTree.getMeno() + "'/>";
			} else {
				strXml += "<item value='" + baseTree.getId() + "' text='"
						+ baseTree.getName() + "'   NodeId='"
						+ baseTree.getId() + "' Title='" + baseTree.getName()
						+ "' Href='" + baseTree.getValue() + "' Target='"
						+ baseTree.getTarget() + "' Img='"
						+ baseTree.getMeno() + "'>";
			}

			lastLevel = baseTree.getLevel();
		}
		for (int i = 0; i < lastLevel; i++) {
			strXml += "</item>";
		}
		strXml += "</tree>";
		return strXml;
	}

}

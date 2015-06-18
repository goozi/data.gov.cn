package com.dhccity.base.util;

/**
 * Created by Eric on 15/5/22.
 */
public class StringUtil {
    public static String htmlspecialchars(String str) {
        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("\"", "&quot;");
        return str;
    }
}

package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_PARAMETER 系统参数</p>
 * <p>Description:BASE_PARAMETER</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2005-06-16 08:42</p>
 *
 * @author Zerrion_
 * @version 1.0
 *          <servlet><servlet-name>ParameterAction</servlet-name><servlet-class>com.dhccity.xmsl.setup.servlet.ParameterAction</servlet-class></servlet>
 *          <servlet-mapping><servlet-name>ParameterAction</servlet-name><url-pattern>/baseParameterAction</url-pattern></servlet-mapping>
 */

public class ParameterAction extends ServletAction {
    private final String SYSTEM_NAME = "系统维护子系统";
    private final String MODULE_NAME = "参数管理";
    private final int WINDOW_TYPE = 2; //0表示无效、1表示调转、2表示关闭

    /**
     * 增加数据
     */
    public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String name = request.getString("name");
        String code = request.getString("code");
        String unit = request.getString("unit");
        String type = request.getString("type");
        String userNames = request.getString("userNames");
        String userIds = request.getString("userIds");
        String explain = request.getString("explain");

        //锟铰斤拷一锟斤拷锟斤拷锟斤拷
        BaseParameter baseParameter = new BaseParameter();
        baseParameter.setName(name);
        baseParameter.setCode(code);
        baseParameter.setValue("");
        baseParameter.setUnit(unit);
        baseParameter.setType(type);
        baseParameter.setUserNames(userNames);
        baseParameter.setUserIds(userIds);
        baseParameter.setExplain(explain);

        baseParameter.add(); //锟斤拷锟接硷拷录

        user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录[" + name + "]");
        doReturn(response, WINDOW_TYPE);

    }

    /**
     * 修改数据
     */
    public void updateData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        String name = request.getString("name");
        String code = request.getString("code");
        String unit = request.getString("unit");
        String type = request.getString("type");
        String userNames = request.getString("userNames");
        String userIds = request.getString("userIds");
        String explain = request.getString("explain");

        //锟铰斤拷一锟斤拷锟斤拷锟斤拷
        BaseParameter baseParameter = (BaseParameter) new BaseParameter().findById(id);
        baseParameter.setName(name);
        baseParameter.setCode(code);
        baseParameter.setUnit(unit);
        baseParameter.setType(type);
        baseParameter.setUserNames(userNames);
        baseParameter.setUserIds(userIds);
        baseParameter.setExplain(explain);
        baseParameter.update(); //锟睫改硷拷录

        user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录[" + name + "]");
        doReturn(response, WINDOW_TYPE);

    }

    /**
     * 设置值
     */
    public void setupValue(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        String value = request.getString("value");

        //锟铰斤拷一锟斤拷锟斤拷锟斤拷
        BaseParameter baseParameter = (BaseParameter) new BaseParameter().findById(id);
        baseParameter.setValue(value);
        baseParameter.update(); //锟睫改硷拷录

        user.addLog(SYSTEM_NAME, MODULE_NAME, "设置值[" + baseParameter.getName() + "]");
        doReturn(response, WINDOW_TYPE);
    }

}

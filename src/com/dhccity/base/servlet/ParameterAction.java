package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_PARAMETER ϵͳ����</p>
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
    private final String SYSTEM_NAME = "ϵͳά����ϵͳ";
    private final String MODULE_NAME = "��������";
    private final int WINDOW_TYPE = 2; //0��ʾ��Ч��1��ʾ��ת��2��ʾ�ر�

    /**
     * ��������
     */
    public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String name = request.getString("name");
        String code = request.getString("code");
        String unit = request.getString("unit");
        String type = request.getString("type");
        String userNames = request.getString("userNames");
        String userIds = request.getString("userIds");
        String explain = request.getString("explain");

        //�½�һ������
        BaseParameter baseParameter = new BaseParameter();
        baseParameter.setName(name);
        baseParameter.setCode(code);
        baseParameter.setValue("");
        baseParameter.setUnit(unit);
        baseParameter.setType(type);
        baseParameter.setUserNames(userNames);
        baseParameter.setUserIds(userIds);
        baseParameter.setExplain(explain);

        baseParameter.add(); //���Ӽ�¼

        user.addLog(SYSTEM_NAME, MODULE_NAME, "���Ӽ�¼[" + name + "]");
        doReturn(response, WINDOW_TYPE);

    }

    /**
     * �޸�����
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

        //�½�һ������
        BaseParameter baseParameter = (BaseParameter) new BaseParameter().findById(id);
        baseParameter.setName(name);
        baseParameter.setCode(code);
        baseParameter.setUnit(unit);
        baseParameter.setType(type);
        baseParameter.setUserNames(userNames);
        baseParameter.setUserIds(userIds);
        baseParameter.setExplain(explain);
        baseParameter.update(); //�޸ļ�¼

        user.addLog(SYSTEM_NAME, MODULE_NAME, "�޸ļ�¼[" + name + "]");
        doReturn(response, WINDOW_TYPE);

    }

    /**
     * ����ֵ
     */
    public void setupValue(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        String value = request.getString("value");

        //�½�һ������
        BaseParameter baseParameter = (BaseParameter) new BaseParameter().findById(id);
        baseParameter.setValue(value);
        baseParameter.update(); //�޸ļ�¼

        user.addLog(SYSTEM_NAME, MODULE_NAME, "����ֵ[" + baseParameter.getName() + "]");
        doReturn(response, WINDOW_TYPE);
    }

}

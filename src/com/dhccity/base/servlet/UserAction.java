package com.dhccity.base.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dhccity.base.business.DocumentApp;
import com.dhccity.base.util.BaseConstant;
import org.light.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_USER ������Servlet��</p>
 * <p>Description:BASE_USER</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-07-26 14:28</p>
 *
 * @author Zerrion
 * @version 1.0
 *          <servlet><servlet-name>UserAction</servlet-name><servlet-class>com.dhccity.base.servlet.UserAction</servlet-class></servlet>
 *          <servlet-mapping><servlet-name>UserAction</servlet-name><url-pattern>/baseUserAction</url-pattern></servlet-mapping>
 */

public class UserAction extends ServletAction implements BaseConstant {
    private final String SYSTEM_NAME = "ϵͳά����ϵͳ";
    private final String MODULE_NAME = "�û�����";
    private final int WINDOW_TYPE = 1; //0��ʾ��Ч��1��ʾ��ת��2��ʾ�ر�

    /**
     * ��������
     */
    public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String name = request.getString("name");
        String loginName = request.getString("loginName");
        String password = request.getString("password");
        long departmentId = request.getLong("departmentId");
        String sex = request.getString("sex");
        String ename = request.getString("ename");
        String nationality = request.getString("nationality");
        String code = request.getString("code");
        String identityCard = request.getString("identityCard");
        Date birthday = request.getDate("birthday");
        String nativePlace = request.getString("nativePlace");
        long party = request.getLong("party");
        String tel = request.getString("tel");
        String fax = request.getString("fax");
        String mobileTel = request.getString("mobileTel");
        String email = request.getString("email");
        Date joinDate = request.getDate("joinDate");
        long joinType = request.getLong("joinType");
        long boss = request.getLong("boss");
        long assistant = request.getLong("assistant");
        String ip = request.getString("ip");
        int sequ = request.getInt("sequ");
        String type = request.getString("type");
        String sourceCode = request.getString("sourceCode");

        //�½�һ������
        BaseUser baseUser = new BaseUser();
        baseUser.setName(name);
        baseUser.setLoginName(loginName);
        baseUser.setPassword(password);
        baseUser.setDepartmentId(departmentId);
        baseUser.setSex(sex);
        baseUser.setEname(ename);
        baseUser.setNationality(nationality);
        baseUser.setCode(code);
        baseUser.setIdentityCard(identityCard);
        baseUser.setBirthday(birthday);
        baseUser.setNativePlace(nativePlace);
        baseUser.setParty(party);
        baseUser.setTel(tel);
        baseUser.setFax(fax);
        baseUser.setMobileTel(mobileTel);
        baseUser.setEmail(email);
        baseUser.setJoinDate(joinDate);
        baseUser.setJoinType(joinType);
        baseUser.setBoss(boss);
        baseUser.setAssistant(assistant);
        baseUser.setIp(ip);
        baseUser.setSequ(sequ);
        baseUser.setType(type);
        baseUser.setState(1);
        baseUser.add(); //���Ӽ�¼

        DocumentApp.addDocument(request,baseUser.getId(),sourceCode,user);

        //����ְ�����ɫ����
        long[] departmentIds = request.getLongArray("departmentIds");
        long[] groupIds = request.getLongArray("groupIds");
        int[] types = request.getIntArray("types");
        int[] sequs = request.getIntArray("sequs");
        for (int i = 0; i < types.length; i++) {
            if (types[i] != 0) {

                BaseUserGroup baseUserGroup = new BaseUserGroup();
                baseUserGroup.setUserId(baseUser.getId());
                baseUserGroup.setDepartmentId(departmentIds[i]);
                baseUserGroup.setGroupId(groupIds[i]);
                baseUserGroup.setType(types[i]);
                baseUserGroup.setSequ(sequs[i]);
                baseUserGroup.add(); //���Ӽ�¼
            }
        }
        user.addLog(SYSTEM_NAME, MODULE_NAME, "���Ӽ�¼[" + name + "]");
        doReturn(response, WINDOW_TYPE, "user_list.jsp");
    }

    /**
     * �޸�����
     */
    public void updateData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        String name = request.getString("name");
        String loginName = request.getString("loginName");
        String password = request.getString("password");
        long departmentId = request.getLong("departmentId");
        String sex = request.getString("sex");
        String ename = request.getString("ename");
        String nationality = request.getString("nationality");
        String code = request.getString("code");
        String identityCard = request.getString("identityCard");
        Date birthday = request.getDate("birthday");
        String nativePlace = request.getString("nativePlace");
        long party = request.getLong("party");
        String tel = request.getString("tel");
        String fax = request.getString("fax");
        String mobileTel = request.getString("mobileTel");
        String email = request.getString("email");
        Date joinDate = request.getDate("joinDate");
        long joinType = request.getLong("joinType");
        long boss = request.getLong("boss");
        long assistant = request.getLong("assistant");
        String ip = request.getString("ip");
        int sequ = request.getInt("sequ");
        String type = request.getString("type");
        String sourceCode = request.getString("sourceCode");

        //�½�һ������
        BaseUser baseUser = (BaseUser) new BaseUser().findById(id);
        baseUser.setName(name);
        baseUser.setLoginName(loginName);
        baseUser.setPassword(password);
        baseUser.setDepartmentId(departmentId);
        baseUser.setSex(sex);
        baseUser.setEname(ename);
        baseUser.setNationality(nationality);
        baseUser.setCode(code);
        baseUser.setIdentityCard(identityCard);
        baseUser.setBirthday(birthday);
        baseUser.setNativePlace(nativePlace);
        baseUser.setParty(party);
        baseUser.setTel(tel);
        baseUser.setFax(fax);
        baseUser.setMobileTel(mobileTel);
        baseUser.setEmail(email);
        baseUser.setJoinDate(joinDate);
        baseUser.setJoinType(joinType);
        baseUser.setBoss(boss);
        baseUser.setAssistant(assistant);
        baseUser.setIp(ip);
        baseUser.setSequ(sequ);
        baseUser.setType(type);
        baseUser.update(); //�޸ļ�¼

        DocumentApp.updateDocument(request,baseUser.getId(),sourceCode,user);

        //�޸�ְ�����ɫ
        long[] departmentIds = request.getLongArray("departmentIds");
        long[] groupIds = request.getLongArray("groupIds");
        int[] types = request.getIntArray("types");
        int[] sequs = request.getIntArray("sequs");
        long[] ids = request.getLongArray("ids");
        BaseUserGroup.deleteByUserId(baseUser.getId(), ids); //ɾ��ְ�����ɫ
        for (int i = 0; i < types.length; i++) {
            if (types[i] != 0 && ids[i] == 0) {
                BaseUserGroup baseUserGroup = new BaseUserGroup();
                baseUserGroup.setUserId(baseUser.getId());
                baseUserGroup.setDepartmentId(departmentIds[i]);
                baseUserGroup.setGroupId(groupIds[i]);
                baseUserGroup.setType(types[i]);
                baseUserGroup.setSequ(sequs[i]);
                baseUserGroup.add(); //���Ӽ�¼
            }
        }
        user.addLog(SYSTEM_NAME, MODULE_NAME, "�޸ļ�¼[" + name + "]");
        doReturn(response, WINDOW_TYPE);
    }

    /**
     * �ı��û�״̬
     */
    public void updateState(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long[] idArray = request.getLongArray("idArray");
        int state = request.getInt("state");
        String log = "";
        if (idArray != null) {
            for (int i = 0; i < idArray.length; i++) {
                BaseUser baseUser = (BaseUser) new BaseUser().findById(idArray[i]);
                baseUser.setState(state);
                baseUser.update();
                log += baseUser.getName() + ";";
            }
        }
        if (state == 0) {
            user.addLog(SYSTEM_NAME, MODULE_NAME, "ɾ����¼[" + log + "]");
        } else {
            user.addLog(SYSTEM_NAME, MODULE_NAME, "�ָ���¼[" + log + "]");
        }
    }

    /**
     * �����֤��
     */
    public void checkCaptcha(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String captcha = request.getString("captcha");
        String s_captcha = request.getSession().getAttribute("captcha").toString();
        PrintWriter out = response.getWriter();
        if (captcha.equals(s_captcha)) {
            out.print("success");
        } else {
            out.print("false");
        }
    }

    /**
     * ����ע��
     */
    public void regData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String userType = request.getString("userType");
        String loginName = request.getString("loginName");
        String password = request.getString("password");
        String email = request.getString("email");
        String name = "";
        String mobileTel = "";
        if (userType.equals("2")) {
            name = request.getString("name");
            mobileTel = request.getString("mobileTel");
        } else if (userType.equals("1")) {
            name = loginName;
        }


        //�½�һ������
        BaseUser baseUser = new BaseUser();

        baseUser.setLoginName(loginName);
        baseUser.setPassword(password);
        baseUser.setName(name);
        baseUser.setMobileTel(mobileTel);
        baseUser.setEmail(email);
        baseUser.setType(userType);
        baseUser.setState(1);
        baseUser.add(); //���Ӽ�¼

        PrintWriter out = response.getWriter();
        out.print("success");
    }
}
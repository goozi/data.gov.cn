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
 * <p>Title: BASE_USER 表管理Servlet类</p>
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
    private final String SYSTEM_NAME = "系统维护子系统";
    private final String MODULE_NAME = "用户管理";
    private final int WINDOW_TYPE = 1; //0表示无效、1表示调转、2表示关闭

    /**
     * 增加数据
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

        //新建一个对象
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
        baseUser.add(); //增加记录

        DocumentApp.addDocument(request,baseUser.getId(),sourceCode,user);

        //增加职务与角色数据
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
                baseUserGroup.add(); //增加记录
            }
        }
        user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录[" + name + "]");
        doReturn(response, WINDOW_TYPE, "user_list.jsp");
    }

    /**
     * 修改数据
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

        //新建一个对象
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
        baseUser.update(); //修改记录

        DocumentApp.updateDocument(request,baseUser.getId(),sourceCode,user);

        //修改职务与角色
        long[] departmentIds = request.getLongArray("departmentIds");
        long[] groupIds = request.getLongArray("groupIds");
        int[] types = request.getIntArray("types");
        int[] sequs = request.getIntArray("sequs");
        long[] ids = request.getLongArray("ids");
        BaseUserGroup.deleteByUserId(baseUser.getId(), ids); //删除职务与角色
        for (int i = 0; i < types.length; i++) {
            if (types[i] != 0 && ids[i] == 0) {
                BaseUserGroup baseUserGroup = new BaseUserGroup();
                baseUserGroup.setUserId(baseUser.getId());
                baseUserGroup.setDepartmentId(departmentIds[i]);
                baseUserGroup.setGroupId(groupIds[i]);
                baseUserGroup.setType(types[i]);
                baseUserGroup.setSequ(sequs[i]);
                baseUserGroup.add(); //增加记录
            }
        }
        user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录[" + name + "]");
        doReturn(response, WINDOW_TYPE);
    }

    /**
     * 改变用户状态
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
            user.addLog(SYSTEM_NAME, MODULE_NAME, "删除记录[" + log + "]");
        } else {
            user.addLog(SYSTEM_NAME, MODULE_NAME, "恢复记录[" + log + "]");
        }
    }

    /**
     * 检查验证码
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
     * 外网注册
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


        //新建一个对象
        BaseUser baseUser = new BaseUser();

        baseUser.setLoginName(loginName);
        baseUser.setPassword(password);
        baseUser.setName(name);
        baseUser.setMobileTel(mobileTel);
        baseUser.setEmail(email);
        baseUser.setType(userType);
        baseUser.setState(1);
        baseUser.add(); //增加记录

        PrintWriter out = response.getWriter();
        out.print("success");
    }
}

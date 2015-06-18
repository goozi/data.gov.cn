package com.dhccity.interact.servlet;

import com.dhccity.base.util.BaseConstant;
import com.dhccity.interact.entity.Survey;
import org.light.HttpRequest;
import org.light.ServletAction;
import org.light.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * <p>Title: Survey对象管理Servlet类</p>
 * <p>Description:</p>:);
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-12 15:06:08</p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class SurveyAction extends ServletAction implements BaseConstant {
    private final String SYSTEM_NAME = "互动交流";
    private final String MODULE_NAME = "问卷调查";
    private final int WINDOW_TYPE = 1; //0表示无效、1表示调转、2表示关闭

    /**
     * 增加一条数据
     */
    public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String name = request.getString("name");
        String email = request.getString("email");
        String gender = request.getString("gender");
        String age = request.getString("age");
        String work = request.getString("work");
        String address = request.getString("address");
        String accessRate = request.getString("accessRate");
        String designMark = request.getString("designMark");
        String knownMethod = request.getString("knownMethod");
        String useBiz = request.getString("useBiz");
        String suggest = request.getString("suggest");

        Date now = new Date();

        //新建一个对象
        Survey survey = new Survey();
        survey.setName(name);
        survey.setEmail(email);
        survey.setGender(gender);
        survey.setAge(age);
        survey.setWork(work);
        survey.setAddress(address);
        survey.setAccessRate(accessRate);
        survey.setDesignMark(designMark);
        survey.setKnownMethod(knownMethod);
        survey.setUseBiz(useBiz);
        survey.setSuggest(suggest);
        survey.setCreateTime(now);
        survey.add(); //增加记录

//        user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录[" + survey.getId() + "]");
        response.getWriter().print("success");
    }


    /**
     * 删除数据
     */
    public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long[] idArray = request.getLongArray("idArray");
        String log = "";

        //新建一个对象
        Survey survey = new Survey();
        if (idArray != null) {
            for (int i = 0; i < idArray.length; i++) {
                survey.delete(idArray[i]); //删除记录
                log += idArray[i] + ";";
            }
        }

        user.addLog(SYSTEM_NAME, MODULE_NAME, "删除记录[" + log + "]");
    }
}

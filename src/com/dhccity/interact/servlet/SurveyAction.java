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
 * <p>Title: Survey�������Servlet��</p>
 * <p>Description:</p>:);
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-12 15:06:08</p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class SurveyAction extends ServletAction implements BaseConstant {
    private final String SYSTEM_NAME = "��������";
    private final String MODULE_NAME = "�ʾ����";
    private final int WINDOW_TYPE = 1; //0��ʾ��Ч��1��ʾ��ת��2��ʾ�ر�

    /**
     * ����һ������
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

        //�½�һ������
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
        survey.add(); //���Ӽ�¼

//        user.addLog(SYSTEM_NAME, MODULE_NAME, "���Ӽ�¼[" + survey.getId() + "]");
        response.getWriter().print("success");
    }


    /**
     * ɾ������
     */
    public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long[] idArray = request.getLongArray("idArray");
        String log = "";

        //�½�һ������
        Survey survey = new Survey();
        if (idArray != null) {
            for (int i = 0; i < idArray.length; i++) {
                survey.delete(idArray[i]); //ɾ����¼
                log += idArray[i] + ";";
            }
        }

        user.addLog(SYSTEM_NAME, MODULE_NAME, "ɾ����¼[" + log + "]");
    }
}

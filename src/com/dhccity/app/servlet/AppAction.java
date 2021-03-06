package com.dhccity.app.servlet;

import com.dhccity.app.entity.App;
import com.dhccity.app.entity.AppDatasetRelation;
import com.dhccity.base.business.DocumentApp;
import com.dhccity.base.util.BaseConstant;
import com.dhccity.home.entity.Article;
import org.light.HttpRequest;
import org.light.ServletAction;
import org.light.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Title: App对象管理Servlet类</p>
 * <p>Description:</p>:);
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-18 16:46:50</p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class AppAction extends ServletAction implements BaseConstant {
    private final String SYSTEM_NAME = "应用";
    private final String MODULE_NAME = "应用管理";
    private final int WINDOW_TYPE = 1; //0表示无效、1表示调转、2表示关闭

    /**
     * 增加一条数据
     */
    public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String name = request.getString("name");
        String cnName = request.getString("cnName");
        String description = request.getString("description");
        String url = request.getString("url");
        String developer = request.getString("developer");
        String appCharge = request.getString("appCharge");
        String category = request.getString("category");
        long relDatasetId = request.getLong("relDatasetId");
        String[] appOs = request.getStringArray("appOs");
        StringBuilder sb = new StringBuilder(appOs.length * 3);
        int offset = appOs.length - 1;
        for (int i = 0; i < offset; i++) {
            sb.append(appOs[i]).append(";");
        }
        sb.append(appOs[offset]);

        Date now = new Date();

        //新建一个对象
        App app = new App();
        app.setName(name);
        app.setCnName(cnName);
        app.setDescription(description);
        app.setUrl(url);
        app.setDeveloper(developer);
        app.setSubmitterId(user.getId());
        app.setSubmitTime(now);
        app.setModifyUser(user.getId());
        app.setModifyTime(now);
        app.setAppCharge(appCharge);
        app.setCategory(category);
        app.setAppOs(sb.toString());
        app.add(); //增加记录

        Article article = new Article();
        article.setTitle(cnName);
        article.setContent(description);
        article.setIsPublic(IS_PUBLIC_PUBLIC);
        article.setState(STATE_NORMAL);
        article.setType(ARTICLE_TYPE_APP);
        article.setCreator(user.getId());
        article.setCreateTime(now);
        article.setModifyUser(user.getId());
        article.setModifyTime(now);
        article.setIsCommentable(1);
        article.setRelatId(app.getId());
        article.setIp(user.getIp());
        article.add();

        DocumentApp.addDocuments(request, app.getId(), user);

        AppDatasetRelation appDatasetRelation = new AppDatasetRelation();
        appDatasetRelation.setAppId(app.getId());
        appDatasetRelation.setDatasetId(relDatasetId);
        appDatasetRelation.setCreateTime(now);
        appDatasetRelation.add();

        user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录[]");
        doReturn(response, WINDOW_TYPE, "app_list.jsp");
    }

    /**
     * 修改指定数据
     */
    public void updateData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        String name = request.getString("name");
        String cnName = request.getString("cnName");
        String description = request.getString("description");
        String url = request.getString("url");
        String developer = request.getString("developer");
        String appCharge = request.getString("appCharge");
        String category = request.getString("category");
        long relDatasetId = request.getLong("relDatasetId");
        String[] appOs = request.getStringArray("appOs");
        StringBuilder sb = new StringBuilder(appOs.length * 3);
        int offset = appOs.length - 1;
        for (int i = 0; i < offset; i++) {
            sb.append(appOs[i]).append(";");
        }
        sb.append(appOs[offset]);

        Date now = new Date();

        //新建一个对象
        App app = (App) new App().findById(id);
        app.setId(id);
        app.setName(name);
        app.setCnName(cnName);
        app.setDescription(description);
        app.setUrl(url);
        app.setDeveloper(developer);
        app.setModifyUser(user.getId());
        app.setModifyTime(now);
        app.setAppCharge(appCharge);
        app.setCategory(category);
        app.setAppOs(sb.toString());
        app.update(); //修改记录

        Article article = new Article().getByTypeAndRelatId(ARTICLE_TYPE_APP, id);
        article.setTitle(cnName);
        article.setContent(description);
        article.setModifyUser(user.getId());
        article.setModifyTime(now);
        article.update();

        DocumentApp.updateDocuments(request, app.getId(), user);

        AppDatasetRelation appDatasetRelation = new AppDatasetRelation();
        appDatasetRelation.setDatasetId(relDatasetId);
        appDatasetRelation.update();

        user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录[]");
        doReturn(response, WINDOW_TYPE, "app_list.jsp");
    }

    /**
     * 删除数据
     */
    public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long[] idArray = request.getLongArray("idArray");
        String log = "";

        //新建一个对象
        App app = new App();
        if (idArray != null) {
            for (int i = 0; i < idArray.length; i++) {
                //TODO 应同时删除数据集与应用关联关系
                app.delete(idArray[i]); //删除记录
                log += idArray[i] + ";";
            }
        }

        user.addLog(SYSTEM_NAME, MODULE_NAME, "删除记录[" + log + "]");
    }

    /**
     * 更新阅读数
     */
    public void updateReadNum(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        App app = (App) new App().findById(id);
        app.setReadNum(app.getReadNum() + 1);
        app.update();

        PrintWriter out = response.getWriter();
        out.print("success");
    }

    /**
     * 评分
     */
    public void updateStars(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        int star = request.getInt("star");
        App app = (App) new App().findById(id);
        double stars = (app.getStars() * app.getMarkNum() + star) / (app.getMarkNum() + 1);
        BigDecimal b = new BigDecimal(stars);
        app.setStars(b.setScale(3, BigDecimal.ROUND_HALF_UP).floatValue());
        app.setMarkNum(app.getMarkNum() + 1);
        app.update();

        PrintWriter out = response.getWriter();
        out.print("success");
    }
}

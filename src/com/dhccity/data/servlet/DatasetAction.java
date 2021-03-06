package com.dhccity.data.servlet;

import java.io.*;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dhccity.base.util.BaseConstant;
import com.dhccity.base.util.SystemUtil;
import com.dhccity.data.entity.DataGroup;
import com.dhccity.data.entity.Org;
import com.dhccity.home.entity.Article;
import org.light.*;
import com.dhccity.data.entity.Dataset;
import org.light.hibernate.Database;

/**
 * <p>
 * Title: Dataset对象管理Servlet类
 * </p>
 * <p>
 * Description:
 * </p>
 * :);
 * <p>
 * Company: Kingtop
 * </p>
 * <p>
 * CreateDate: 2015-05-14 16:07:19
 * </p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class DatasetAction extends ServletAction implements BaseConstant {
    private final String SYSTEM_NAME = "数据";
    private final String MODULE_NAME = "数据集";
    private final int WINDOW_TYPE = 1; // 0表示无效、1表示调转、2表示关闭

    /**
     * 增加一条数据
     */
    public void addData(HttpRequest request, HttpServletResponse response,
                        User user) throws ServletException, IOException {
        Database.beginTransaction();

        String flow = request.getString("flow");
        String name = request.getString("name");
        String title = request.getString("title");
        String description = request.getString("description");
        String isPublic = request.getString("isPublic");
        String updateRate = request.getString("updateRate");
        long orgId = request.getLong("orgId");
        long groupId = request.getLong("groupId");

        Date now = new Date();
        try {

            // 新建一个对象
            Dataset dataset = new Dataset();
            dataset.setName(name);
            dataset.setTitle(title);
            dataset.setDescription(description);
            dataset.setState(STATE_NORMAL);
            dataset.setIsPublic(isPublic);
            dataset.setCreator(user.getId());
            dataset.setCreateTime(now);
            dataset.setModifyUser(user.getId());
            dataset.setModifyTime(now);
            dataset.setUpdateRate(updateRate);
            dataset.setOrgId(orgId);
            dataset.setGroupId(groupId);
            if (flow.endsWith("api")) {
                dataset.setKind("api");
            }
            dataset.add(); // 增加记录

            //所属机构包含数据集+1
            if (orgId > 0) {
                Org org = (Org) new Org().findById(orgId);
                org.setDatasetNum(org.getDatasetNum() + 1);
                org.update();
            }

            //所属专题包含数据集+1
            if (groupId > 0) {
                DataGroup dataGroup = (DataGroup) new DataGroup().findById(groupId);
                dataGroup.setDatasetNum(dataGroup.getDatasetNum() + 1);
                dataGroup.update();
            }

            String articleType = ARTICLE_TYPE_DATASET;
            if (flow.endsWith("api")) {
                articleType = ARTICLE_TYPE_API;
            }
            //同时创建一条关联文章，方便全文检索
            Article article = new Article();
            article.setTitle(title);
            article.setContent(description);
            article.setType(articleType);
            article.setState(STATE_NORMAL);
            article.setCreator(user.getId());
            article.setCreateTime(now);
            article.setModifyUser(user.getId());
            article.setModifyTime(now);
            article.setIsCommentable(1);
            article.setIsPublic(isPublic);
            article.setIp(user.getIp());
            article.setRelatId(dataset.getId());
            article.add();

            user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录[" + dataset.getId() + "]");
            Database.endTransaction(true);

            if ("single".equals(flow)) {
                doReturn(response, WINDOW_TYPE, "dataset_list.jsp");
            } else if ("multi".equals(flow)) {
                doReturn(response, WINDOW_TYPE,
                        "dataResource_add.jsp?datasetId=" + dataset.getId());
            } else if ("single_api".equals(flow)) {
                doReturn(response, WINDOW_TYPE, "/developer/api_list.jsp");
            } else if ("multi_api".equals(flow)) {
                doReturn(response, WINDOW_TYPE,
                        "/developer/apiResource_add.jsp?apiId=" + dataset.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
            Database.endTransaction(false);
        }
    }

    /**
     * 修改指定数据
     */
    public void updateData(HttpRequest request, HttpServletResponse response,
                           User user) throws ServletException, IOException {
        Database.beginTransaction();
        try {

            String flow = request.getString("flow");
            long id = request.getLong("id");
            String name = request.getString("name");
            String title = request.getString("title");
            String description = request.getString("description");
            String isPublic = request.getString("isPublic");
            String updateRate = request.getString("updateRate");
            long orgId = request.getLong("orgId");
            long groupId = request.getLong("groupId");

            Date now = new Date();
            // 新建一个对象
            Dataset dataset = (Dataset) new Dataset().findById(id);

            //所属机构包含数据集
            if (orgId > 0) {
                if (orgId != dataset.getOrgId()) {
                    //旧机构包含数据集数量-1
                    Org preOrg = (Org) new Org().findById(dataset.getOrgId());
                    preOrg.setDatasetNum(preOrg.getDatasetNum() - 1);
                    preOrg.update();
                    //当前机构包含数据集数量+1
                    Org currOrg = (Org) new Org().findById(orgId);
                    currOrg.setDatasetNum(currOrg.getDatasetNum() + 1);
                    currOrg.update();
                }
            } else {
                //机构包含数据集数量-1
                Org preOrg = (Org) new Org().findById(dataset.getOrgId());
                preOrg.setDatasetNum(preOrg.getDatasetNum() - 1);
                preOrg.update();
            }

            //所属专题包含数据集
            if (groupId > 0) {
                if (groupId != dataset.getGroupId()) {
                    //旧专题包含数据集数量-1
                    DataGroup preDataGroup = (DataGroup) new DataGroup().findById(dataset.getGroupId());
                    preDataGroup.setDatasetNum(preDataGroup.getDatasetNum() - 1);
                    preDataGroup.update();
                    //当前专题包含数据集数量-1
                    DataGroup currDataGroup = (DataGroup) new DataGroup().findById(groupId);
                    currDataGroup.setDatasetNum(currDataGroup.getDatasetNum() + 1);
                    currDataGroup.update();
                }
            } else {
                //专题包含数据集数量-1
                DataGroup preDataGroup = (DataGroup) new DataGroup().findById(dataset.getGroupId());
                preDataGroup.setDatasetNum(preDataGroup.getDatasetNum() - 1);
                preDataGroup.update();
            }

            dataset.setId(id);
            dataset.setName(name);
            dataset.setTitle(title);
            dataset.setDescription(description);
            dataset.setIsPublic(isPublic);
            dataset.setModifyUser(user.getId());
            dataset.setModifyTime(now);
            dataset.setUpdateRate(updateRate);
            dataset.setOrgId(orgId);
            dataset.setGroupId(groupId);
            dataset.update(); // 修改记录


            String articleType = ARTICLE_TYPE_DATASET;
            if (flow.endsWith("api")) {
                articleType = ARTICLE_TYPE_API;
            }
            //同时更新关联的文章
            Article article = new Article().getByTypeAndRelatId(articleType, id);
            article.setTitle(title);
            article.setContent(description);
            article.setModifyUser(user.getId());
            article.setModifyTime(now);
            article.setIsPublic(isPublic);
            article.update();

            user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录[" + title + "]");
            Database.endTransaction(true);
            if ("single".equals(flow)) {
                doReturn(response, WINDOW_TYPE, "dataset_list.jsp");
            } else if ("multi".equals(flow)) {
                doReturn(response, WINDOW_TYPE,
                        "dataResource_list.jsp?datasetId=" + id);
            } else if ("single_api".equals(flow)) {
                doReturn(response, WINDOW_TYPE, "/developer/api_list.jsp");
            } else if ("multi_api".equals(flow)) {
                doReturn(response, WINDOW_TYPE,
                        "/developer/apiResource_list.jsp?apiId=" + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Database.endTransaction(false);
        }
    }

    /**
     * 删除数据
     */
    public void deleteData(HttpRequest request, HttpServletResponse response,
                           User user) throws ServletException, IOException {
        long[] idArray = request.getLongArray("idArray");
        String log = "";

        // 新建一个对象
        Dataset dataset = new Dataset();
        if (idArray != null) {
            for (int i = 0; i < idArray.length; i++) {
                dataset.delete(idArray[i]); // 删除记录
                log += idArray[i] + ";";
            }
        }

        user.addLog(SYSTEM_NAME, MODULE_NAME, "删除记录[" + log + "]");
    }

    /**
     * 更新下载数
     */
    public void updateDownloadNum(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        Dataset dataset = (Dataset) new Dataset().findById(id);
        dataset.setDownloadNum(dataset.getDownloadNum() + 1);
        dataset.update();

        PrintWriter out = response.getWriter();
        out.print("success");
    }

    /**
     * 更新阅读数
     */
    public void updateReadNum(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        Dataset dataset = (Dataset) new Dataset().findById(id);
        dataset.setReadNum(dataset.getReadNum() + 1);
        dataset.update();

        PrintWriter out = response.getWriter();
        out.print("success");
    }

    /**
     * 评分
     * buttonText
     */
    public void updateStars(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        int star = request.getInt("star");
        Dataset dataset = (Dataset) new Dataset().findById(id);
        double stars = (dataset.getStars() * dataset.getMark_num() + star) / (dataset.getMark_num() + 1);
        BigDecimal b = new BigDecimal(stars);
        dataset.setStars(b.setScale(3, BigDecimal.ROUND_HALF_UP).floatValue());
        dataset.setMark_num(dataset.getMark_num() + 1);
        dataset.update();

        PrintWriter out = response.getWriter();
        out.print("success");
    }

    /**
     * 下拉框装载数据
     */
    public void loadJsonData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String json = new Dataset().getJson();

        user.addLog(SYSTEM_NAME, MODULE_NAME, "下拉框装载数据[]");
        PrintWriter out = response.getWriter();
        out.print(json);
    }
}

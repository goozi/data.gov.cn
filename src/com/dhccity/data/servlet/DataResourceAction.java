package com.dhccity.data.servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.dhccity.base.business.DocumentApp;
import com.dhccity.base.util.StringUtil;
import com.dhccity.data.entity.Dataset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.*;

import com.dhccity.data.entity.DataResource;

/**
 * <p>Title: DataResource对象管理Servlet类</p>
 * <p>Description:</p>:);
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-14 16:08:21</p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class DataResourceAction extends ServletAction {
    private final String SYSTEM_NAME = "数据";
    private final String MODULE_NAME = "数据资源";
    private final int WINDOW_TYPE = 1; //0表示无效、1表示调转、2表示关闭

    /**
     * 增加一条数据
     */
    public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String flow = request.getString("flow");
        String name = request.getString("name");
        String title = request.getString("title");
        String description = request.getString("description");
        String resType = request.getString("resType");
        String sourceCode = request.getString("sourceCode");
        String sourceUrl = request.getString("sourceUrl");
        double version = request.getDouble("version");
        //long creator = request.getLong("creator");
        //Date createDate = request.getDate("createDate");
        //long modifyUser = request.getLong("modifyUser");
        //Date modifyDate = request.getDate("modifyDate");
        //long downloadNum = request.getLong("downloadNum");
        //long fileId = request.getLong("fileId");
        long datasetId = request.getLong("datasetId");

        Date now = new Date();

        //新建一个对象
        DataResource dataResource = new DataResource();
        dataResource.setName(name);
        dataResource.setTitle(title);
        dataResource.setDescription(description);
        dataResource.setResType(resType);
        dataResource.setSourceUrl(sourceUrl);
        dataResource.setVersion(version);
		dataResource.setCreator(user.getId());
		dataResource.setCreateDate(now);
		dataResource.setModifyUser(user.getId());
		dataResource.setModifyDate(now);
//		dataResource.setDownloadNum(downloadNum);
        //dataResource.setFileId(fileId);
        dataResource.setDatasetId(datasetId);
        dataResource.add(); //增加记录

        String kind ="";
        if(flow.endsWith("api")){
            kind = "api";
        }else {
            if (resType.equals("file")) {
                kind = DocumentApp.addDocument(request, dataResource.getId(), sourceCode, user);
            }
        }
        dataResource.setKind(kind);
        dataResource.update();

        //同时更新数据集的资源种类字段
        Dataset dataset = (Dataset) new Dataset().findById(datasetId);
        if(!kind.equals("")) {
            if (dataset.getKind() == null || dataset.getKind().equals("")) {
                dataset.setKind(kind);
            } else {
                String[] kinds = dataset.getKind().split("\\|");
                int index = Arrays.binarySearch(kinds,kind);
                //如果种类字段串中不包含该种类则加入
                if(index<0){
                    dataset.setKind(dataset.getKind() + "|" + kind);
                }
            }
        }
        dataset.setModifyUser(user.getId());
        dataset.setModifyTime(now);
        dataset.update();

        user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录[" + title + "]");
        String returnUrl = "";
        if (flow.equals("single")) {
            returnUrl = "dataResource_list.jsp?datasetId=" + datasetId;
        } else if (flow.equals("multi")) {
            returnUrl = "dataResource_add.jsp?datasetId=" + datasetId;
        }else if (flow.equals("single_api")) {
            returnUrl = "/developer/apiResource_list.jsp?apiId="+datasetId;
        } else if (flow.equals("multi_api")) {
            returnUrl = "/developer/apiResource_add.jsp?apiId=" + datasetId;
        }
        doReturn(response, WINDOW_TYPE, returnUrl);
    }

    /**
     * 修改指定数据
     */
    public void updateData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        String flow = request.getString("flow");
        String name = request.getString("name");
        String title = request.getString("title");
        String description = request.getString("description");
        String resType = request.getString("resType");
        String sourceCode = request.getString("sourceCode");
        String sourceUrl = request.getString("sourceUrl");
        double version = request.getDouble("version");
        //long creator = request.getLong("creator");
        //Date createDate = request.getDate("createDate");
        //long modifyUser = request.getLong("modifyUser");
        //Date modifyDate = request.getDate("modifyDate");
        //long downloadNum = request.getLong("downloadNum");
        //long fileId = request.getLong("fileId");
        //long datasetId = request.getLong("datasetId");

        Date now = new Date();

        String kind ="";
        if(flow.endsWith("api")){
            kind = "api";
        }else {
            if (resType.equals("file")) {
                kind = DocumentApp.updateDocument(request, id, sourceCode, user);
            }
        }

        //新建一个对象
        DataResource dataResource = (DataResource) new DataResource().findById(id);
        dataResource.setId(id);
        dataResource.setName(name);
        dataResource.setTitle(title);
        dataResource.setDescription(description);
        dataResource.setResType(resType);
        dataResource.setSourceUrl(sourceUrl);
        dataResource.setVersion(version);
        //dataResource.setCreator(creator);
        //dataResource.setCreateDate(createDate);
        dataResource.setModifyUser(user.getId());
        dataResource.setModifyDate(now);
        //dataResource.setDownloadNum(downloadNum);
        //dataResource.setFileId(fileId);
        //dataResource.setDatasetId(datasetId);
        dataResource.setKind(kind);
        dataResource.update(); //修改记录

        //同时更新数据集的资源种类字段
        Dataset dataset = (Dataset) new Dataset().findById(dataResource.getDatasetId());
        if(!kind.equals("")) {
            if (dataset.getKind() == null || dataset.getKind().equals("")) {
                dataset.setKind(kind);
            } else {
                String[] kinds = dataset.getKind().split("\\|");
                //如果种类字段串中不包含该种类则加入
                if(Arrays.binarySearch(kinds,kind)<0){
                    dataset.setKind(dataset.getKind() + "|" + kind);
                }
            }
        }
        dataset.setModifyUser(user.getId());
        dataset.setModifyTime(now);
        dataset.update();


        user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录["+title+"]");
        PrintWriter out = response.getWriter();
        out.print("success");
        //doReturn(response, WINDOW_TYPE, "dataResource_list.jsp");
    }

    /**
     * 删除数据
     */
    public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long[] idArray = request.getLongArray("idArray");
        String log = "";

        //新建一个对象
        DataResource dataResource = new DataResource();
        if (idArray != null) {
            for (int i = 0; i < idArray.length; i++) {
                dataResource.delete(idArray[i]); //删除记录
                log += idArray[i] + ";";
            }
        }

        user.addLog(SYSTEM_NAME, MODULE_NAME, "删除记录[" + log + "]");
    }

    /**
     * 载入数据
     */
    public void listData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String src = request.getString("src");
        long datasetId = request.getLong("datasetId");
        List<DataResource> dataResources = new ArrayList<DataResource>();
        Map map = new HashMap();
        JSONObject dataResourceJson = new JSONObject(map);
        Long total = 0l;
        if (src.equals("edit")) {
            int rows = request.getInt("rows");
            int page = request.getInt("page");

            DataResource oDataResource = new DataResource();
            total = oDataResource.count();
            dataResources = oDataResource.findPageByDatasetId(datasetId, page, rows);
            JSONArray drsArray = null;
            try {
                drsArray = dataResourceJson.getJSONArray("rows");
                for (int i = 0; i < drsArray.length(); i++) {
                    JSONObject dr = drsArray.getJSONObject(i);
                    dr.put("resourceId", dr.get("id"));
                }
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        map.put("total", total);
        map.put("rows", dataResources);
        PrintWriter out = response.getWriter();
        out.print(dataResourceJson.toString());
        user.addLog(SYSTEM_NAME, MODULE_NAME, "删除记录[载入ID为" + datasetId + "下属数据资源的集合，返回JSON格式数据]");
    }

    /**
     * 更新下载数
     */
    public void updateDownloadNum(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        long id = request.getLong("id");
        DataResource dataResource = (DataResource) new DataResource().findById(id);
        dataResource.setDownloadNum(dataResource.getDownloadNum()+1);
        dataResource.update();

        PrintWriter out = response.getWriter();
        out.print("success");
    }
}

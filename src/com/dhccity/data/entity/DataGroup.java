package com.dhccity.data.entity;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.*;

/**
 * <p>Title: DATA_GROUP表对应实体类</p>
 * <p>Description:专题</p>
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-14 15:52:40</p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class DataGroup extends Ado {
    private long id;                //ID
    private String name;            //名称
    private String title;            //标题
    private String description;            //描述
    private Date createTime;        //创建时间
    private String state;                //状态
    private long creator;            //创建人
    private String approvalStatus;        //审核状态
    private String logo;            //LOGO
    private String type;            //类型
    private long datasetNum;       //包含数据集数量

    {
        defaultOrder = "o.id desc";
    } //默认的排序方式

    public DataGroup() {
    }

    public DataGroup(long id) {
        this.id = id;
    }

    /**
     * 对应字段：[ID]  类型：[NUMBER]  长度：[22]
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 对应字段：[ID]  类型：[NUMBER]  长度：[22]
     */
    public long getId() {
        return this.id;
    }

    /**
     * 对应字段：[名称]  类型：[VARCHAR2]  长度：[200]
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 对应字段：[名称]  类型：[VARCHAR2]  长度：[200]
     */
    public String getName() {
        return this.name == null ? "" : this.name;
    }

    /**
     * 对应字段：[标题]  类型：[VARCHAR2]  长度：[200]
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 对应字段：[标题]  类型：[VARCHAR2]  长度：[200]
     */
    public String getTitle() {
        return this.title == null ? "" : this.title;
    }

    /**
     * 对应字段：[描述]  类型：[VARCHAR2]  长度：[1000]
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 对应字段：[描述]  类型：[VARCHAR2]  长度：[1000]
     */
    public String getDescription() {
        return this.description == null ? "" : this.description;
    }

    /**
     * 对应字段：[创建时间]  类型：[DATE]  长度：[7]
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 对应字段：[创建时间]  类型：[DATE]  长度：[7]
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 对应字段：[状态]  类型：[NUMBER]  长度：[1]
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 对应字段：[状态]  类型：[NUMBER]  长度：[1]
     */
    public String getState() {
        return this.state;
    }

    /**
     * 对应字段：[创建人]  类型：[NUMBER]  长度：[22]
     */
    public void setCreator(long creator) {
        this.creator = creator;
    }

    /**
     * 对应字段：[创建人]  类型：[NUMBER]  长度：[22]
     */
    public long getCreator() {
        return this.creator;
    }

    /**
     * 对应字段：[审核状态]  类型：[NUMBER]  长度：[1]
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    /**
     * 对应字段：[审核状态]  类型：[NUMBER]  长度：[1]
     */
    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    /**
     * 对应字段：[LOGO]  类型：[VARCHAR2]  长度：[200]
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 对应字段：[LOGO]  类型：[VARCHAR2]  长度：[200]
     */
    public String getLogo() {
        return this.logo == null ? "" : this.logo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getDatasetNum() {
        return datasetNum;
    }

    public void setDatasetNum(long datasetNum) {
        this.datasetNum = datasetNum;
    }

    //===============================以下为自编辑代码===================================

    /**
     * 按用户返回专题JSON列表
     *
     * @param userId 用户 ID
     * @return
     */
    public String getJsonByUser(long userId) {
        String presetHql = "from DataGroup o where o.state=1 and o.type='preset'";
        List<DataGroup> presetList = this.findAll(presetHql);
        String customHql = "from DataGroup o where o.state=1 and o.type='custom' and o.creator=" + userId;
        List<DataGroup> customList = this.findAll(customHql);
        JSONArray orgJsonArray = new JSONArray();
        for (int i = 0; i < customList.size(); i++) {
            DataGroup dataGroup = customList.get(i);
            JSONObject dataGroupJson = new JSONObject();
            try {
                dataGroupJson.put("id", dataGroup.getId());
                dataGroupJson.put("text", dataGroup.getTitle());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            orgJsonArray.put(dataGroupJson);
        }
        for (int i = 0; i < presetList.size(); i++) {
            DataGroup dataGroup = presetList.get(i);
            JSONObject dataGroupJson = new JSONObject();
            try {
                dataGroupJson.put("id", dataGroup.getId());
                dataGroupJson.put("text", dataGroup.getTitle());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            orgJsonArray.put(dataGroupJson);
        }
        return orgJsonArray.toString();
    }

}

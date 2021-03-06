package com.dhccity.data.entity;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.*;

/**
 * <p>Title: DATASET表对应实体类</p>
 * <p>Description:数据集</p>
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-16 20:41:30</p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class Dataset extends Ado {
    private long id;                //ID
    private String name;            //名称
    private String title;            //标题
    private String description;        //描述
    private String state;                //状态
    private String isPublic;            //是否公开
    private long creator;            //创建人
    private Date createTime;        //创建时间
    private long modifyUser;        //修改人
    private Date modifyTime;        //修改时间
    private String updateRate;        //更新频率
    private long downloadNum;        //下载数
    private long readNum;            //查看数
    private long orgId;                //所属机构
    private long groupId;            //所属专题
    private float stars;            //星级
    private long mark_num;            //评分数
    private String kind;            //包含资源种类

    {
        defaultOrder = "o.id desc";
    } //默认的排序方式

    public Dataset() {
    }

    public Dataset(long id) {
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
     * 对应字段：[描述]  类型：[VARCHAR2]  长度：[2500]
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 对应字段：[描述]  类型：[VARCHAR2]  长度：[2500]
     */
    public String getDescription() {
        return this.description == null ? "" : this.description;
    }

    /**
     * 对应字段：[状态]  类型：[VARCHAR2]  长度：[10]
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 对应字段：[状态]  类型：[VARCHAR2]  长度：[10]
     */
    public String getState() {
        return this.state;
    }

    /**
     * 对应字段：[是否公开]  类型：[VARCHAR2]  长度：[80]
     */
    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * 对应字段：[是否公开]  类型：[VARCHAR2]  长度：[80]
     */
    public String getIsPublic() {
        return this.isPublic;
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
     * 对应字段：[修改人]  类型：[NUMBER]  长度：[22]
     */
    public void setModifyUser(long modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * 对应字段：[修改人]  类型：[NUMBER]  长度：[22]
     */
    public long getModifyUser() {
        return this.modifyUser;
    }

    /**
     * 对应字段：[修改时间]  类型：[DATE]  长度：[7]
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 对应字段：[修改时间]  类型：[DATE]  长度：[7]
     */
    public Date getModifyTime() {
        return this.modifyTime;
    }

    /**
     * 对应字段：[更新频率]  类型：[VARCHAR2]  长度：[80]
     */
    public void setUpdateRate(String updateRate) {
        this.updateRate = updateRate;
    }

    /**
     * 对应字段：[更新频率]  类型：[VARCHAR2]  长度：[80]
     */
    public String getUpdateRate() {
        return this.updateRate == null ? "" : this.updateRate;
    }

    /**
     * 对应字段：[下载数]  类型：[NUMBER]  长度：[10]
     */
    public void setDownloadNum(long downloadNum) {
        this.downloadNum = downloadNum;
    }

    /**
     * 对应字段：[下载数]  类型：[NUMBER]  长度：[10]
     */
    public long getDownloadNum() {
        return this.downloadNum;
    }

    /**
     * 对应字段：[查看数]  类型：[NUMBER]  长度：[10]
     */
    public void setReadNum(long readNum) {
        this.readNum = readNum;
    }

    /**
     * 对应字段：[查看数]  类型：[NUMBER]  长度：[10]
     */
    public long getReadNum() {
        return this.readNum;
    }

    /**
     * 对应字段：[所属机构]  类型：[NUMBER]  长度：[22]
     */
    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    /**
     * 对应字段：[所属机构]  类型：[NUMBER]  长度：[22]
     */
    public long getOrgId() {
        return this.orgId;
    }

    /**
     * 对应字段：[所属专题]  类型：[NUMBER]  长度：[22]
     */
    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    /**
     * 对应字段：[所属专题]  类型：[NUMBER]  长度：[22]
     */
    public long getGroupId() {
        return this.groupId;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public long getMark_num() {
        return mark_num;
    }

    public void setMark_num(long mark_num) {
        this.mark_num = mark_num;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    //===============================以下为自编辑代码===================================

    /**
     * 按条件搜索数据集，分页返回列表
     *
     * @param orgId    long
     * @param groupId  long
     * @param kind     String
     * @param stars    float
     * @param order    String
     * @param currPage int
     * @param pageSize int
     * @return
     */
    public List<Dataset> search(long orgId, long groupId, String kind, float stars, String order, String searchText, int currPage, int pageSize) {
        String hql = "from Dataset o where 1=1 ";
        if (orgId > 0) {
            hql += " and o.orgId=" + orgId;
        }
        if (groupId > 0) {
            hql += " and o.groupId=" + groupId;
        }
        if (!kind.equals("")) {
            hql += " and o.kind like '%" + kind + "%' ";
        }
        if (stars > 0) {
            hql += " and o.stars >= " + stars;
        }
        if (!searchText.equals("")) {
            hql += " and (o.name like '%" + this.filterSQL(searchText) + "%' or o.title like '%" + this.filterSQL(searchText) + "%' or o.description like '%" + this.filterSQL(searchText) + "%') ";
        }
        if (!order.equals("")) {
            hql += " order by o." + order + " desc";
        } else {
            hql += " order by o.createTime desc";
        }
        List<Dataset> datasetList = this.findPage(hql, currPage, pageSize);
        return datasetList;
    }
    /**
     * 返回数据集JSON列表
     * @return
     */
    public String getJson() {
        String datasetHql = "from Dataset o where o.state='1' and o.isPublic='1'";
        List<Dataset> datasetList = this.findAll(datasetHql);
        JSONArray datasetJsonArray = new JSONArray();
        for (int i = 0; i < datasetList.size(); i++) {
            Dataset dataset = datasetList.get(i);
            JSONObject datasetJson = new JSONObject();
            try {
                datasetJson.put("id", dataset.getId());
                datasetJson.put("text", dataset.getTitle());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            datasetJsonArray.put(datasetJson);
        }
        return datasetJsonArray.toString();
    }
}

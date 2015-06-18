package com.dhccity.data.entity;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.*;

/**
 * <p>Title: DATASET����Ӧʵ����</p>
 * <p>Description:���ݼ�</p>
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-16 20:41:30</p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class Dataset extends Ado {
    private long id;                //ID
    private String name;            //����
    private String title;            //����
    private String description;        //����
    private String state;                //״̬
    private String isPublic;            //�Ƿ񹫿�
    private long creator;            //������
    private Date createTime;        //����ʱ��
    private long modifyUser;        //�޸���
    private Date modifyTime;        //�޸�ʱ��
    private String updateRate;        //����Ƶ��
    private long downloadNum;        //������
    private long readNum;            //�鿴��
    private long orgId;                //��������
    private long groupId;            //����ר��
    private float stars;            //�Ǽ�
    private long mark_num;            //������
    private String kind;            //������Դ����

    {
        defaultOrder = "o.id desc";
    } //Ĭ�ϵ�����ʽ

    public Dataset() {
    }

    public Dataset(long id) {
        this.id = id;
    }

    /**
     * ��Ӧ�ֶΣ�[ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * ��Ӧ�ֶΣ�[ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public long getId() {
        return this.id;
    }

    /**
     * ��Ӧ�ֶΣ�[����]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��Ӧ�ֶΣ�[����]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public String getName() {
        return this.name == null ? "" : this.name;
    }

    /**
     * ��Ӧ�ֶΣ�[����]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ��Ӧ�ֶΣ�[����]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public String getTitle() {
        return this.title == null ? "" : this.title;
    }

    /**
     * ��Ӧ�ֶΣ�[����]  ���ͣ�[VARCHAR2]  ���ȣ�[2500]
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * ��Ӧ�ֶΣ�[����]  ���ͣ�[VARCHAR2]  ���ȣ�[2500]
     */
    public String getDescription() {
        return this.description == null ? "" : this.description;
    }

    /**
     * ��Ӧ�ֶΣ�[״̬]  ���ͣ�[VARCHAR2]  ���ȣ�[10]
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * ��Ӧ�ֶΣ�[״̬]  ���ͣ�[VARCHAR2]  ���ȣ�[10]
     */
    public String getState() {
        return this.state;
    }

    /**
     * ��Ӧ�ֶΣ�[�Ƿ񹫿�]  ���ͣ�[VARCHAR2]  ���ȣ�[80]
     */
    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * ��Ӧ�ֶΣ�[�Ƿ񹫿�]  ���ͣ�[VARCHAR2]  ���ȣ�[80]
     */
    public String getIsPublic() {
        return this.isPublic;
    }

    /**
     * ��Ӧ�ֶΣ�[������]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public void setCreator(long creator) {
        this.creator = creator;
    }

    /**
     * ��Ӧ�ֶΣ�[������]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public long getCreator() {
        return this.creator;
    }

    /**
     * ��Ӧ�ֶΣ�[����ʱ��]  ���ͣ�[DATE]  ���ȣ�[7]
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * ��Ӧ�ֶΣ�[����ʱ��]  ���ͣ�[DATE]  ���ȣ�[7]
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * ��Ӧ�ֶΣ�[�޸���]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public void setModifyUser(long modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * ��Ӧ�ֶΣ�[�޸���]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public long getModifyUser() {
        return this.modifyUser;
    }

    /**
     * ��Ӧ�ֶΣ�[�޸�ʱ��]  ���ͣ�[DATE]  ���ȣ�[7]
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * ��Ӧ�ֶΣ�[�޸�ʱ��]  ���ͣ�[DATE]  ���ȣ�[7]
     */
    public Date getModifyTime() {
        return this.modifyTime;
    }

    /**
     * ��Ӧ�ֶΣ�[����Ƶ��]  ���ͣ�[VARCHAR2]  ���ȣ�[80]
     */
    public void setUpdateRate(String updateRate) {
        this.updateRate = updateRate;
    }

    /**
     * ��Ӧ�ֶΣ�[����Ƶ��]  ���ͣ�[VARCHAR2]  ���ȣ�[80]
     */
    public String getUpdateRate() {
        return this.updateRate == null ? "" : this.updateRate;
    }

    /**
     * ��Ӧ�ֶΣ�[������]  ���ͣ�[NUMBER]  ���ȣ�[10]
     */
    public void setDownloadNum(long downloadNum) {
        this.downloadNum = downloadNum;
    }

    /**
     * ��Ӧ�ֶΣ�[������]  ���ͣ�[NUMBER]  ���ȣ�[10]
     */
    public long getDownloadNum() {
        return this.downloadNum;
    }

    /**
     * ��Ӧ�ֶΣ�[�鿴��]  ���ͣ�[NUMBER]  ���ȣ�[10]
     */
    public void setReadNum(long readNum) {
        this.readNum = readNum;
    }

    /**
     * ��Ӧ�ֶΣ�[�鿴��]  ���ͣ�[NUMBER]  ���ȣ�[10]
     */
    public long getReadNum() {
        return this.readNum;
    }

    /**
     * ��Ӧ�ֶΣ�[��������]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    /**
     * ��Ӧ�ֶΣ�[��������]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public long getOrgId() {
        return this.orgId;
    }

    /**
     * ��Ӧ�ֶΣ�[����ר��]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    /**
     * ��Ӧ�ֶΣ�[����ר��]  ���ͣ�[NUMBER]  ���ȣ�[22]
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

    //===============================����Ϊ�Ա༭����===================================

    /**
     * �������������ݼ�����ҳ�����б�
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
     * �������ݼ�JSON�б�
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
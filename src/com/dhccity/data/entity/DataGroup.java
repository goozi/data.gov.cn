package com.dhccity.data.entity;

import java.util.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.*;

/**
 * <p>Title: DATA_GROUP����Ӧʵ����</p>
 * <p>Description:ר��</p>
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-14 15:52:40</p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class DataGroup extends Ado {
    private long id;                //ID
    private String name;            //����
    private String title;            //����
    private String description;            //����
    private Date createTime;        //����ʱ��
    private String state;                //״̬
    private long creator;            //������
    private String approvalStatus;        //���״̬
    private String logo;            //LOGO
    private String type;            //����
    private long datasetNum;       //�������ݼ�����

    {
        defaultOrder = "o.id desc";
    } //Ĭ�ϵ�����ʽ

    public DataGroup() {
    }

    public DataGroup(long id) {
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
     * ��Ӧ�ֶΣ�[����]  ���ͣ�[VARCHAR2]  ���ȣ�[1000]
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * ��Ӧ�ֶΣ�[����]  ���ͣ�[VARCHAR2]  ���ȣ�[1000]
     */
    public String getDescription() {
        return this.description == null ? "" : this.description;
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
     * ��Ӧ�ֶΣ�[״̬]  ���ͣ�[NUMBER]  ���ȣ�[1]
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * ��Ӧ�ֶΣ�[״̬]  ���ͣ�[NUMBER]  ���ȣ�[1]
     */
    public String getState() {
        return this.state;
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
     * ��Ӧ�ֶΣ�[���״̬]  ���ͣ�[NUMBER]  ���ȣ�[1]
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    /**
     * ��Ӧ�ֶΣ�[���״̬]  ���ͣ�[NUMBER]  ���ȣ�[1]
     */
    public String getApprovalStatus() {
        return this.approvalStatus;
    }

    /**
     * ��Ӧ�ֶΣ�[LOGO]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * ��Ӧ�ֶΣ�[LOGO]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
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

    //===============================����Ϊ�Ա༭����===================================

    /**
     * ���û�����ר��JSON�б�
     *
     * @param userId �û� ID
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
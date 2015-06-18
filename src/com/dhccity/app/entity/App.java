package com.dhccity.app.entity;

import org.light.Ado;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: app���Ӧʵ����</p>
 * <p>Description:Ӧ��</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2015-05-12 12:48:25</p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class App extends Ado {
    private long id;                //ID
    private String name;            //Ӣ����
    private String cnName;            //������
    private String description;            //����
    private String url;                //URL
    private String developer;        //������
    private long submitterId;        //�ύ��ID
    private Date submitTime;        //�ύʱ��
    private long modifyUser;        //�޸���
    private Date modifyTime;        //�޸�ʱ��
    private long appThumbnail;        //Ӧ��ͼ��
    private long appPic;            //Ӧ�ý�ͼ
    private String appCharge;            //Ӧ���շ�����
    private String category;            //���
    private String appOs;                //Ӧ�ò���ϵͳ
    private long markNum;                //������
    private float stars;                //�Ǽ�
    private long readNum;                //�Ķ���

    {
        defaultOrder = "o.id desc";
    } //Ĭ�ϵ�����ʽ

    public App() {
    }

    public App(long id) {
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
     * ��Ӧ�ֶΣ�[Ӣ����]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ��Ӧ�ֶΣ�[Ӣ����]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public String getName() {
        return this.name == null ? "" : this.name;
    }

    /**
     * ��Ӧ�ֶΣ�[������]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    /**
     * ��Ӧ�ֶΣ�[������]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public String getCnName() {
        return this.cnName == null ? "" : this.cnName;
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
     * ��Ӧ�ֶΣ�[URL]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * ��Ӧ�ֶΣ�[URL]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public String getUrl() {
        return this.url == null ? "" : this.url;
    }

    /**
     * ��Ӧ�ֶΣ�[������]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    /**
     * ��Ӧ�ֶΣ�[������]  ���ͣ�[VARCHAR2]  ���ȣ�[200]
     */
    public String getDeveloper() {
        return this.developer == null ? "" : this.developer;
    }

    /**
     * ��Ӧ�ֶΣ�[�ύ��ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public void setSubmitterId(long submitterId) {
        this.submitterId = submitterId;
    }

    /**
     * ��Ӧ�ֶΣ�[�ύ��ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public long getSubmitterId() {
        return this.submitterId;
    }

    /**
     * ��Ӧ�ֶΣ�[Ӧ��ͼ��]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public void setAppThumbnail(long appThumbnail) {
        this.appThumbnail = appThumbnail;
    }

    /**
     * ��Ӧ�ֶΣ�[Ӧ��ͼ��]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public long getAppThumbnail() {
        return this.appThumbnail;
    }

    /**
     * ��Ӧ�ֶΣ�[Ӧ�ý�ͼ]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public void setAppPic(long appPic) {
        this.appPic = appPic;
    }

    /**
     * ��Ӧ�ֶΣ�[Ӧ�ý�ͼ]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public long getAppPic() {
        return this.appPic;
    }

    /**
     * ��Ӧ�ֶΣ�[Ӧ���շ�����]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public void setAppCharge(String appCharge) {
        this.appCharge = appCharge;
    }

    /**
     * ��Ӧ�ֶΣ�[Ӧ���շ�����]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public String getAppCharge() {
        return this.appCharge;
    }

    /**
     * ��Ӧ�ֶΣ�[���]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * ��Ӧ�ֶΣ�[���]  ���ͣ�[NUMBER]  ���ȣ�[22]
     */
    public String getCategory() {
        return this.category;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getAppOs() {
        return appOs;
    }

    public void setAppOs(String appOs) {
        this.appOs = appOs;
    }

    public long getMarkNum() {
        return markNum;
    }

    public void setMarkNum(long markNum) {
        this.markNum = markNum;
    }

    public float getStars() {
        return stars;
    }

    public void setStars(float stars) {
        this.stars = stars;
    }

    public long getReadNum() {
        return readNum;
    }

    public void setReadNum(long readNum) {
        this.readNum = readNum;
    }
    //===============================����Ϊ�Ա༭����===================================

    /**
     * ����������Ӧ�ã�����ҳ���ؽ��
     *
     * @param appCharge
     * @param category
     * @param appOs
     * @param stars
     * @param order
     * @param searchText
     * @param currPage
     * @param pageSize
     * @return
     */
    public List<App> search(String appCharge, String category, String appOs, float stars, String order, String searchText, int currPage, int pageSize) {
        String hql = "from App o where 1=1 ";
        if (!appCharge.equals("")) {
            hql += " and o.appCharge=" + appCharge;
        }
        if (!category.equals("")) {
            hql += " and o.category=" + category;
        }
        if (!appOs.equals("")) {
            hql += " and o.appOs=" + appOs;
        }
        if (stars > 0) {
            hql += " and o.stars >= " + stars;
        }
        if (!searchText.equals("")) {
            hql += " and (o.name like '%" + this.filterSQL(searchText) + "%' or o.cnName like '%"
                    + this.filterSQL(searchText) + "%' or o.description like '%" + this.filterSQL(searchText)
                    + "%' or o.developer like '%" + this.filterSQL(searchText) + "%') ";
        }
        if (!order.equals("")) {
            hql += " order by o." + order + " desc";
        } else {
            hql += " order by o.modifyTime desc";
        }
        List<App> apptList = this.findPage(hql, currPage, pageSize);
        return apptList;
    }

}

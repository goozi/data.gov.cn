package com.dhccity.home.entity;

import java.util.*;

import org.light.*;

import com.dhccity.base.util.BaseConstant;

/**
 * <p>
 * Title: article����Ӧʵ����
 * </p>
 * <p>
 * Description:����
 * </p>
 * <p>
 * Company: dhccity
 * </p>
 * <p>
 * CreateDate: 2015-05-12 12:48:20
 * </p>
 *
 * @author Zerrion
 * @version 1.0
 */
public class Article extends Ado implements BaseConstant {
    private long id; // ID
    private String title; // ����
    private String content; // ����
    private String type; // ��������
    private long creator; // �����û�
    private String state; // ״̬
    private String isPublic; // �Ƿ񷢲�
    private int isCommentable; // �Ƿ������
    private int isTop; // �Ƿ��ö�
    private Date createTime; // ����ʱ��
    private long modifyUser; // �޸��û�
    private Date modifyTime; // �޸�ʱ��
    private long readNum; // �鿴��
    private String ip; // ��ԴIP
    private long commentNum;    //������
    private long forumId;        //������ ID
    private long relatId;    //���� ID

    {
        defaultOrder = "o.id desc";
    } // Ĭ�ϵ�����ʽ

    public Article() {
    }

    public Article(long id) {
        this.id = id;
    }

    /**
     * ��Ӧ�ֶΣ�[ID] ���ͣ�[NUMBER] ���ȣ�[22]
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * ��Ӧ�ֶΣ�[ID] ���ͣ�[NUMBER] ���ȣ�[22]
     */
    public long getId() {
        return this.id;
    }

    /**
     * ��Ӧ�ֶΣ�[����] ���ͣ�[VARCHAR2] ���ȣ�[200]
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ��Ӧ�ֶΣ�[����] ���ͣ�[VARCHAR2] ���ȣ�[200]
     */
    public String getTitle() {
        return this.title == null ? "" : this.title;
    }

    /**
     * ��Ӧ�ֶΣ�[����] ���ͣ�[CLOB] ���ȣ�[4000]
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * ��Ӧ�ֶΣ�[����] ���ͣ�[CLOB] ���ȣ�[4000]
     */
    public String getContent() {
        return this.content == null ? "" : this.content;
    }

    /**
     * ��Ӧ�ֶΣ�[��������] ���ͣ�[VARCHAR2] ���ȣ�[10]
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * ��Ӧ�ֶΣ�[��������] ���ͣ�[VARCHAR2] ���ȣ�[10]
     */
    public String getType() {
        return this.type;
    }

    /**
     * ��Ӧ�ֶΣ�[�����û�] ���ͣ�[NUMBER] ���ȣ�[22]
     */
    public void setCreator(long creator) {
        this.creator = creator;
    }

    /**
     * ��Ӧ�ֶΣ�[�����û�] ���ͣ�[NUMBER] ���ȣ�[22]
     */
    public long getCreator() {
        return this.creator;
    }

    /**
     * ��Ӧ�ֶΣ�[״̬] ���ͣ�[VARCHAR2] ���ȣ�[10]
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * ��Ӧ�ֶΣ�[״̬] ���ͣ�[VARCHAR2] ���ȣ�[10]
     */
    public String getState() {
        return this.state;
    }

    /**
     * ��Ӧ�ֶΣ�[�Ƿ񷢲�] ���ͣ�[VARCHAR2] ���ȣ�[10]
     */
    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * ��Ӧ�ֶΣ�[�Ƿ񷢲�] ���ͣ�[VARCHAR2] ���ȣ�[10]
     */
    public String getIsPublic() {
        return this.isPublic;
    }

    /**
     * ��Ӧ�ֶΣ�[�Ƿ������] ���ͣ�[NUMBER] ���ȣ�[1]
     */
    public void setIsCommentable(int isCommentable) {
        this.isCommentable = isCommentable;
    }

    /**
     * ��Ӧ�ֶΣ�[�Ƿ������] ���ͣ�[NUMBER] ���ȣ�[1]
     */
    public int getIsCommentable() {
        return this.isCommentable;
    }

    /**
     * ��Ӧ�ֶΣ�[�Ƿ��ö�] ���ͣ�[NUMBER] ���ȣ�[1]
     */
    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    /**
     * ��Ӧ�ֶΣ�[�Ƿ��ö�] ���ͣ�[NUMBER] ���ȣ�[1]
     */
    public int getIsTop() {
        return this.isTop;
    }

    /**
     * ��Ӧ�ֶΣ�[����ʱ��] ���ͣ�[DATE] ���ȣ�[7]
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * ��Ӧ�ֶΣ�[����ʱ��] ���ͣ�[DATE] ���ȣ�[7]
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * ��Ӧ�ֶΣ�[�޸��û�] ���ͣ�[NUMBER] ���ȣ�[22]
     */
    public void setModifyUser(long modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * ��Ӧ�ֶΣ�[�޸��û�] ���ͣ�[NUMBER] ���ȣ�[22]
     */
    public long getModifyUser() {
        return this.modifyUser;
    }

    /**
     * ��Ӧ�ֶΣ�[�޸�ʱ��] ���ͣ�[DATE] ���ȣ�[7]
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * ��Ӧ�ֶΣ�[�޸�ʱ��] ���ͣ�[DATE] ���ȣ�[7]
     */
    public Date getModifyTime() {
        return this.modifyTime;
    }

    /**
     * ��Ӧ�ֶΣ�[�鿴��] ���ͣ�[NUMBER] ���ȣ�[10]
     */
    public void setReadNum(long readNum) {
        this.readNum = readNum;
    }

    /**
     * ��Ӧ�ֶΣ�[�鿴��] ���ͣ�[NUMBER] ���ȣ�[10]
     */
    public long getReadNum() {
        return this.readNum;
    }

    /**
     * ��Ӧ�ֶΣ�[��ԴIP] ���ͣ�[VARCHAR2] ���ȣ�[15]
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * ��Ӧ�ֶΣ�[��ԴIP] ���ͣ�[VARCHAR2] ���ȣ�[15]
     */
    public String getIp() {
        return this.ip == null ? "" : this.ip;
    }

    public long getRelatId() {
        return relatId;
    }

    public void setRelatId(long relatId) {
        this.relatId = relatId;
    }

    public long getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(long commentNum) {
        this.commentNum = commentNum;
    }

    public long getForumId() {
        return forumId;
    }

    public void setForumId(long forumId) {
        this.forumId = forumId;
    }
    // ===============================����Ϊ�Ա༭����===================================

    /**
     * ���ط�������ҳ�õ�Ƭ
     *
     * @return
     */
    public List<Article> loadCarousel() {
        String hql = "from Article o where o.type=" + ARTICLE_TYPE_CAROUSEL
                + " and o.isPublic=" + IS_PUBLIC_PUBLIC + " and o.state="
                + STATE_NORMAL;
        hql += " order by o.createTime desc";
        List<Article> list = this.findAll(hql);
        return list;
    }

    /**
     * ͨ������ ID ��������
     *
     * @param relatId
     * @return
     */
    public Article getByTypeAndRelatId(String type, long relatId) {
        String hql = "from Article o where o.type='" + type + "' and o.relatId=" + relatId;
        return (Article) this.findObject(hql);
    }

    /**
     * ȫ����������
     *
     * @param searchText
     * @param type
     * @param order
     * @param currPage
     * @param pageSize
     * @return
     */
    public List<Article> search(String searchText, String type, String order, int currPage, int pageSize) {
        String hql = "from Article o where o.isPublic=" + IS_PUBLIC_PUBLIC + " and o.state=" + STATE_NORMAL;
        if (!searchText.equals("")) {
            hql += " and (o.title like '%" + searchText + "%' or o.content like '%" + searchText
                    + "%' or o.id in (select c.articleId from Comment c where c.content like '%" + searchText
                    + "%' and c.state=" + STATE_NORMAL + ")) ";
        }
        if (!type.equals("")) {
            hql += " and o.type='" + type + "'";
        }
        if (!order.equals("")) {
            hql += " order by o." + order + " desc";
        }
        return this.findPage(hql, currPage, pageSize);
    }
}
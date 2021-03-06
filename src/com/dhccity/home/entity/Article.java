package com.dhccity.home.entity;

import java.util.*;

import org.light.*;

import com.dhccity.base.util.BaseConstant;

/**
 * <p>
 * Title: article表对应实体类
 * </p>
 * <p>
 * Description:文章
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
    private String title; // 标题
    private String content; // 内容
    private String type; // 文章类型
    private long creator; // 发表用户
    private String state; // 状态
    private String isPublic; // 是否发布
    private int isCommentable; // 是否可评论
    private int isTop; // 是否置顶
    private Date createTime; // 创建时间
    private long modifyUser; // 修改用户
    private Date modifyTime; // 修改时间
    private long readNum; // 查看数
    private String ip; // 来源IP
    private long commentNum;    //评论数
    private long forumId;        //讨论组 ID
    private long relatId;    //关联 ID

    {
        defaultOrder = "o.id desc";
    } // 默认的排序方式

    public Article() {
    }

    public Article(long id) {
        this.id = id;
    }

    /**
     * 对应字段：[ID] 类型：[NUMBER] 长度：[22]
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 对应字段：[ID] 类型：[NUMBER] 长度：[22]
     */
    public long getId() {
        return this.id;
    }

    /**
     * 对应字段：[标题] 类型：[VARCHAR2] 长度：[200]
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 对应字段：[标题] 类型：[VARCHAR2] 长度：[200]
     */
    public String getTitle() {
        return this.title == null ? "" : this.title;
    }

    /**
     * 对应字段：[内容] 类型：[CLOB] 长度：[4000]
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 对应字段：[内容] 类型：[CLOB] 长度：[4000]
     */
    public String getContent() {
        return this.content == null ? "" : this.content;
    }

    /**
     * 对应字段：[文章类型] 类型：[VARCHAR2] 长度：[10]
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 对应字段：[文章类型] 类型：[VARCHAR2] 长度：[10]
     */
    public String getType() {
        return this.type;
    }

    /**
     * 对应字段：[发表用户] 类型：[NUMBER] 长度：[22]
     */
    public void setCreator(long creator) {
        this.creator = creator;
    }

    /**
     * 对应字段：[发表用户] 类型：[NUMBER] 长度：[22]
     */
    public long getCreator() {
        return this.creator;
    }

    /**
     * 对应字段：[状态] 类型：[VARCHAR2] 长度：[10]
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * 对应字段：[状态] 类型：[VARCHAR2] 长度：[10]
     */
    public String getState() {
        return this.state;
    }

    /**
     * 对应字段：[是否发布] 类型：[VARCHAR2] 长度：[10]
     */
    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    /**
     * 对应字段：[是否发布] 类型：[VARCHAR2] 长度：[10]
     */
    public String getIsPublic() {
        return this.isPublic;
    }

    /**
     * 对应字段：[是否可评论] 类型：[NUMBER] 长度：[1]
     */
    public void setIsCommentable(int isCommentable) {
        this.isCommentable = isCommentable;
    }

    /**
     * 对应字段：[是否可评论] 类型：[NUMBER] 长度：[1]
     */
    public int getIsCommentable() {
        return this.isCommentable;
    }

    /**
     * 对应字段：[是否置顶] 类型：[NUMBER] 长度：[1]
     */
    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    /**
     * 对应字段：[是否置顶] 类型：[NUMBER] 长度：[1]
     */
    public int getIsTop() {
        return this.isTop;
    }

    /**
     * 对应字段：[创建时间] 类型：[DATE] 长度：[7]
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 对应字段：[创建时间] 类型：[DATE] 长度：[7]
     */
    public Date getCreateTime() {
        return this.createTime;
    }

    /**
     * 对应字段：[修改用户] 类型：[NUMBER] 长度：[22]
     */
    public void setModifyUser(long modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * 对应字段：[修改用户] 类型：[NUMBER] 长度：[22]
     */
    public long getModifyUser() {
        return this.modifyUser;
    }

    /**
     * 对应字段：[修改时间] 类型：[DATE] 长度：[7]
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * 对应字段：[修改时间] 类型：[DATE] 长度：[7]
     */
    public Date getModifyTime() {
        return this.modifyTime;
    }

    /**
     * 对应字段：[查看数] 类型：[NUMBER] 长度：[10]
     */
    public void setReadNum(long readNum) {
        this.readNum = readNum;
    }

    /**
     * 对应字段：[查看数] 类型：[NUMBER] 长度：[10]
     */
    public long getReadNum() {
        return this.readNum;
    }

    /**
     * 对应字段：[来源IP] 类型：[VARCHAR2] 长度：[15]
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 对应字段：[来源IP] 类型：[VARCHAR2] 长度：[15]
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
    // ===============================以下为自编辑代码===================================

    /**
     * 返回发布的首页幻灯片
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
     * 通过关联 ID 查找文章
     *
     * @param relatId
     * @return
     */
    public Article getByTypeAndRelatId(String type, long relatId) {
        String hql = "from Article o where o.type='" + type + "' and o.relatId=" + relatId;
        return (Article) this.findObject(hql);
    }

    /**
     * 全局搜索文章
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

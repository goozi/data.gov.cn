package com.dhccity.data.entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.Ado;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by Eric on 15/5/30.
 */
public class Search extends Ado {
    private long id;
    private String keyword;
    private String type;
    private Date createTime;
    private Date lastTime;
    private long totalCount;
    private long lastWeekCount;
    private long lastMonthCount;
    private long lastYearCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getLastWeekCount() {
        return lastWeekCount;
    }

    public void setLastWeekCount(long lastWeekCount) {
        this.lastWeekCount = lastWeekCount;
    }

    public long getLastMonthCount() {
        return lastMonthCount;
    }

    public void setLastMonthCount(long lastMonthCount) {
        this.lastMonthCount = lastMonthCount;
    }

    public long getLastYearCount() {
        return lastYearCount;
    }

    public void setLastYearCount(long lastYearCount) {
        this.lastYearCount = lastYearCount;
    }



    /**
     * 按搜索关键字查找
     *
     * @param keyword
     * @param type
     * @return
     */
    public Search getByKeyword(String keyword, String type) {
        String hql = "from Search o where o.keyword='" + keyword + "' and o.type='" + type + "'";
        List<Search> searchList = this.findAll(hql);
        if (searchList.size() > 0) {
            return searchList.get(0);
        }
        return null;
    }

    /**
     * 得到最热及最新搜索关键字 JSON 字符串
     *
     * @return
     */
    public String getSearchAssistJson() {
        String hotSearchHql = "from Search o where o.lastWeekCount>20 or o.lastMonthCount>100 or o.lastYearCount>2000 order by o.lastWeekCount*7.5+o.lastMonthCount*2+o.lastYearCount*0.4+o.totalCount*0.1 desc";
        String freshSearchHql = "from Search o order by case when o.lastTime>o.createTime then o.lastTime else o.createTime end desc";
        List<Search> hotSearchList = this.findPage(hotSearchHql, 1, 10);
        List<Search> freshSearchList = this.findPage(freshSearchHql, 1, 10);
        JSONObject assistJson = new JSONObject();
        JSONArray hotSearchArray = new JSONArray();
        JSONArray freshSearchArray = new JSONArray();
        for (int i = 0; i < hotSearchList.size(); i++) {
            Search hotSearch = hotSearchList.get(i);
            JSONObject hotObject = new JSONObject();
            try {
                hotObject.put("keyword", hotSearch.getKeyword());
                hotObject.put("type", hotSearch.getType());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            hotSearchArray.put(hotObject);
        }
        for (int j = 0; j < freshSearchList.size(); j++) {
            Search freshSearch = freshSearchList.get(j);
            JSONObject freshObject = new JSONObject();
            try {
                freshObject.put("keyword", freshSearch.getKeyword());
                freshObject.put("type", freshSearch.getType());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            freshSearchArray.put(freshObject);
        }
        try {
            assistJson.put("hot", hotSearchArray);
            assistJson.put("fresh", freshSearchArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return assistJson.toString();
    }
}

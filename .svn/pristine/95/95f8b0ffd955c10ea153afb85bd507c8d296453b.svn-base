package com.dhccity.data.entity;

import org.light.Ado;

import java.util.Date;

/**
 * Created by Eric on 15/5/30.
 */
public class SearchInstance extends Ado{
    private long id;
    private long searchId;
    private Date searchTime;
    private String ip;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSearchId() {
        return searchId;
    }

    public void setSearchId(long searchId) {
        this.searchId = searchId;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }


    /**
     * 得到过去一周某关键字搜索数量
     * @param searchId
     * @return
     */
    public long getLastWeekCount(long searchId){
        String hql = "select count(*) from SearchInstance o where o.searchId="+searchId+" and (sysdate-o.searchTime)<=7";
        return Long.parseLong(this.findObject(hql).toString());
    }

    /**
     * 得到过去一月某关键字搜索数量
     * @param searchId
     * @return
     */
    public long getLastMonthCount(long searchId){
        String hql = "select count(*) from SearchInstance o where o.searchId="+searchId+" and (sysdate-o.searchTime)<=30";
        return Long.parseLong(this.findObject(hql).toString());
    }

    /**
     * 得到过去一年某关键字搜索数量
     * @param searchId
     * @return
     */
    public long getLastYearCount(long searchId){
        String hql = "select count(*) from SearchInstance o where o.searchId="+searchId+" and (sysdate-o.searchTime)<=365";
        return Long.parseLong(this.findObject(hql).toString());
    }

    /**
     * 得到某关键字搜索数量
     * @param searchId
     * @return
     */
    public long getTotalCount(long searchId){
        String hql = "select count(*) from SearchInstance o where o.searchId="+searchId;
        return Long.parseLong(this.findObject(hql).toString());
    }
}

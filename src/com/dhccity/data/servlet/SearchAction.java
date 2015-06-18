package com.dhccity.data.servlet;

import com.dhccity.base.util.BaseConstant;
import com.dhccity.base.util.SystemUtil;
import com.dhccity.data.entity.Search;
import com.dhccity.data.entity.SearchInstance;
import org.light.HttpRequest;
import org.light.ServletAction;
import org.light.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by Eric on 15/5/31.
 */
public class SearchAction extends ServletAction implements BaseConstant {

    private final String SYSTEM_NAME = "通用";
    private final String MODULE_NAME = "搜索";
    private final int WINDOW_TYPE = 1; //0表示无效、1表示调转、2表示关闭

    /**
     * 全局搜索文章
     */
    public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        String keyword = request.getString("keyword");
        String type = request.getString("type");
        Search search = new Search().getByKeyword(keyword, type);
        Date now = new Date();
        SearchInstance searchInstance = new SearchInstance();
        if (search == null) {
            search = new Search();
            search.setKeyword(keyword);
            search.setType(type);
            search.setCreateTime(now);
            search.setLastTime(now);
            search.setLastWeekCount(1);
            search.setLastMonthCount(1);
            search.setLastYearCount(1);
            search.setTotalCount(1);
            search.add();
        } else {
            search.setLastTime(now);
            search.setLastWeekCount(searchInstance.getLastWeekCount(search.getId()) + 1);
            search.setLastMonthCount(searchInstance.getLastMonthCount(search.getId()) + 1);
            search.setLastYearCount(searchInstance.getLastYearCount(search.getId()) + 1);
            search.setTotalCount(searchInstance.getTotalCount(search.getId()) + 1);
            search.update();
        }
        searchInstance.setSearchId(search.getId());
        searchInstance.setSearchTime(now);
//        searchInstance.setIp(request.getRemoteAddr());
        searchInstance.add();
        PrintWriter out = response.getWriter();
        out.print("success");
    }

    /**
     * 返回最热及最新搜索关键字 JSON 字符串
     */
    public void getAssistJson(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        Search search = new Search();
        PrintWriter out = response.getWriter();
        out.print(search.getSearchAssistJson());
    }
}

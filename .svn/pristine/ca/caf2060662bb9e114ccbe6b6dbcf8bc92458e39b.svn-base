//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.light.system;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.light.Config;
import org.light.Convert;
import org.light.Server;
import org.light.User;
import org.light.hibernate.Database;

public class HttpFilter implements Filter {
    private String encoding;
    private boolean security;

    public HttpFilter() {
    }

    public void init(FilterConfig var1) {
        this.security = Convert.toBoolean(var1.getInitParameter("security"));
        this.encoding = var1.getInitParameter("encoding");
    }

    public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3) {
        HttpServletRequest var4 = (HttpServletRequest)var1;
        HttpServletResponse var5 = (HttpServletResponse)var2;

        try {
            var4.setCharacterEncoding(this.encoding);
            var5.setContentType("text/html;charset=" + this.encoding);
            var5.setHeader("Pragma", "No-cache");
            var5.setHeader("Cache-Control", "no-cache");
            var5.setDateHeader("Expires", 0L);
            if(this.security) {
                User var20 = Server.getCurrUser(var4);
                if(var20 == null) {
                    var5.sendRedirect(Config.Path + "/message.htm?code=LOGIN_NO");
                } else {
                    boolean var21 = this.a(var20, var4, var5);
                    if(var21) {
                        var3.doFilter(var4, var5);
                    } else {
                        var5.sendRedirect(Config.Path + "/message.htm?code=NO_RIGHT");
                    }
                }
            } else {
                var3.doFilter(var4, var5);
            }
        } catch (Exception var18) {
            Exception var6 = var18;

            try {
                PrintWriter var7 = var5.getWriter();
                var7.print(Convert.toString(var6.toString()));
            } catch (Exception var17) {
                ;
            }
        } finally {
            try {
                Database.closeConnection();
            } catch (Exception var16) {
                System.err.println("Error in closing session");
            }

        }

    }

    public void destroy() {
    }

    private boolean a(User var1, HttpServletRequest var2, HttpServletResponse var3) {
        String var4 = var2.getRequestURI();
        String var5 = var2.getQueryString();
        if(var5 != null) {
            int var6 = var5.length();
            byte[] var7 = new byte[var6];
            var5.getBytes(0, var6, var7, 0);

            try {
                var5 = new String(var7, var2.getCharacterEncoding());
            } catch (UnsupportedEncodingException var9) {
                ;
            }
        } else {
            var5 = " ";
        }

        return var1.checkUrl(var4, var5);
    }
}

/*
 * 创建时间：14-4-5 上午9:32
 * 设计人员：dongxl.
 */

package log4j;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import org.apache.log4j.PropertyConfigurator;

public class Log4jServlet extends HttpServlet{
    public void init() throws ServletException {

        //获得配置文件的完整路径
        String path = getServletContext().getRealPath("/");
        String propfile = path + getInitParameter("propfile");

        //配置Log4J环境
        PropertyConfigurator.configure(propfile);
    }
}

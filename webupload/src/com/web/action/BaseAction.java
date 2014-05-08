package com.web.action;

import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;
/**
 * action的基类，封装好了�?��web对象
 * @author D07
 *
 */
public class BaseAction extends ActionSupport
    implements ServletRequestAware, ServletContextAware, ServletResponseAware, SessionAware
{

    public BaseAction()
    {
    }

    public void setServletRequest(HttpServletRequest request)
    {
        this.request = request;
    }

    public void setServletContext(ServletContext application)
    {
        this.application = application;
    }
    public void setServletResponse(HttpServletResponse response)
    {
        this.response = response;
    }
    public void setSession(Map session)
    {
        this.session = session;
    }
    private static final long serialVersionUID = 1L;
    public HttpServletRequest request;
    public HttpServletResponse response;
    public Map session;
    public Map cash;
	public void setCash(Map cash) {
		this.cash = cash;
	}
	public ServletContext application;
}
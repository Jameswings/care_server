package com.cd.careserver.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.cd.careserver.action.BaseAction;
import com.cd.careserver.po.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AuthInterceptor implements Interceptor {

	private static final long serialVersionUID = -7640005163717210819L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String result = "json";
		HttpServletRequest request = ServletActionContext.getRequest();
		User u = (User) request.getSession()
				.getAttribute(User.SESSION_USER_KEY);
		if (u == null) {
			if ("demo".equals(request.getParameter("username"))
					&& "demo".equals(request.getParameter("password"))
					&& "1".equals(request.getParameter("type"))) {
				u = new User();
				u.setUsername(request.getParameter("username"));
				u.setType(Integer.valueOf(request.getParameter("type")));
				u.setStatus(1);
				ServletActionContext.getRequest().getSession()
						.setAttribute(User.SESSION_USER_KEY, u);
				result = invocation.invoke();
			} else {
				BaseAction ba = (BaseAction) invocation.getAction();
				result = ba.invalidUser();
			}
		} else {
			result = invocation.invoke();
		}
		return result;
	}

}

package com.zk.myservlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies=request.getCookies();
		String username="";
		String checked="";
		for(int i=0;i<cookies.length&&cookies!=null;i++)
		{
			if("username".equals(cookies[i].getName()))
			{
				username=cookies[i].getValue();
				checked="checked='checked'";
			}
		}
		out.print("<form action='"+request.getContextPath()+"/doLogin' method='post'>");
		out.print("用户名:<input type='text' name='username' value='"+username+"'/><br/>");
		out.print("密码:<input type='password' name='pwd' /><br/>");
		out.print("记住用户名:<input type='checkbox' name='remember' "+checked+"/><br/>");
		out.print("<input type='submit' value='提交' /><br/>");
		out.print("</form>");
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}

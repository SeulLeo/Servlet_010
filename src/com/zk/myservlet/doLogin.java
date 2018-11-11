package com.zk.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class doLogin extends HttpServlet {

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
		//获取表单数据
		String username=request.getParameter("username");
		String password=request.getParameter("pwd");
		String remember=request.getParameter("remember");
		
		Cookie cookie=new Cookie("username",username);
		//处理业务逻辑
		if("tom".equals(username)&&"123".equals(password))
		{
			if(remember!=null)
			{
				cookie.setPath("/");
				cookie.setMaxAge(Integer.MAX_VALUE);//设置cookie的有效保存时间
			}
			response.addCookie(cookie);//将用户名写回客户端
			out.print("登陆成功");
		}
		else
		{
			out.print("登录失败");
			//设置两秒钟重新登录
			response.setHeader("refresh", "2;url="+request.getContextPath()+"/servlet/LoginServlet");
		}
		//分发转向
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

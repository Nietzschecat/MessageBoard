package com.bmd.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmd.dao.MessageDao;
import com.bmd.model.Message;
import com.bmd.model.User;
import com.bmd.util.PageModel;

/**
 * 留言Servlet类，通过doPost()方法进行请求处理
 * 
 * @author BMD
 */
public class MessageServlet extends HttpServlet {

	private static final long serialVersionUID = 6018004479179335118L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求类型
		String method = request.getParameter("method");
		if (method != null) {
			// 留言
			if ("save".equalsIgnoreCase(method)) {
				// 判断用户是否登录
				this.isLogin(request, response);
				// 标题
				String title = request.getParameter("title");
				// 内容
				String content = request.getParameter("content");
				// 如果留言内容含有换行符，将替换为<br>
				if (content.indexOf("\n") != -1) {
					content = content.replaceAll("\n", "<br>");
				}
				// 用户
				User user = (User) request.getSession().getAttribute("user");
				// 创建Message对象并对其进行赋值
				Message message = new Message();
				message.setTitle(title);
				message.setContent(content);
				message.setCreateTime(new Date());
				message.setUser(user);
				// 实例化MessageDao
				MessageDao dao = new MessageDao();
				dao.saveMessage(message); // 保存留言
				request.getRequestDispatcher("MessageServlet?method=view")
						.forward(request, response);
			}
			// 查看留言
			else if ("view".equalsIgnoreCase(method)) {
				// 获取页码
				String page = request.getParameter("currPage");
				int currPage = 1; // 当前页
				int pageSize = 5; // 每页显示5条记录
				// 如果page变量不为空则对currPage赋值
				if (page != null) {
					currPage = Integer.parseInt(page);
				}
				MessageDao dao = new MessageDao(); // 实例化MessageDao
				// 获取分页组件
				PageModel pageModel = dao.findPaging(currPage, pageSize);
				request.setAttribute("pageModel", pageModel);
				request.getRequestDispatcher("message_list.jsp").forward(
						request, response);
			}

		} else {
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);
		}
	}

	/**
	 * 判断用户是否登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void isLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 判断session中的user值是否为null
		if (request.getSession().getAttribute("user") == null) {
			// 用户没有登录进行错误处理
			request.setAttribute("error", "对不起，您还没有登录！");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		}
	}
}

package com.bmd.service;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bmd.dao.MessageDao;
import com.bmd.model.Message;
import com.bmd.model.Revert;

/**
 * ϵͳ�����Servlet��,
 * ֻ�й���ԱȨ�޿��Բ���
 * @author BMD
 */
public class ManagerServlet extends HttpServlet {

	private static final long serialVersionUID = 47334074575945894L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�жϹ���Ա�Ƿ���й���ԱȨ��
		this.isAdmin(request, response);
		//��ȡ��������
		String method = request.getParameter("method");
		//ɾ��������Ϣ
		if("delete".equalsIgnoreCase(method)){
			String id = request.getParameter("id");
			if(id != null){
				//ʵ����MessageDao
				MessageDao dao = new MessageDao();
				//ɾ��������Ϣ
				dao.deleteMessage(Integer.valueOf(id));
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		//�ظ�����
		else if("revert".equalsIgnoreCase(method)){
			//��ȡ���Ե�ID��
			String msgId = request.getParameter("id");
			//ʵ����MessageDao
			MessageDao dao = new MessageDao();
			//��������
			Message message = dao.getMessage(Integer.valueOf(msgId));
			request.setAttribute("message", message);
			request.getRequestDispatcher("admin_revert.jsp").forward(request, response);
		}
		//����ظ���Ϣ
		else if("saveOrUpdateRevert".equalsIgnoreCase(method)){
			//��ȡ���Ե�ID��
			String msgId = request.getParameter("id");
			//��ȡ�ظ�������
			String content = request.getParameter("content");
			//����ظ������ݺ��л��з������滻Ϊ<br>
			if(content.indexOf("\n") != -1){
				content = content.replaceAll("\n", "<br>");
			}
			//����MessageDao
			MessageDao dao = new MessageDao();
			//��������
			Message message = dao.getMessage(Integer.valueOf(msgId));
			if(message != null){
				//�������м��ػظ���Ϣ
				Revert revert = message.getRevert();
				if(revert == null){
					//�����ظ�
					revert = new Revert();
				}
				revert.setContent(content);
				revert.setRevertTime(new Date());
				//����������ӻظ�
				message.setRevert(revert);
				//��������
				dao.saveMessage(message);
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		//û�д��ݲ���ֵmethod
		else{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	/**
	 * �ж��û��Ƿ���й���ԱȨ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void isAdmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ж��Ƿ��ǹ���Ա���
		if (request.getSession().getAttribute("admin") == null) {
			request.setAttribute("error", "�Բ�����û��Ȩ�޽��в�����");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		}
	}

}

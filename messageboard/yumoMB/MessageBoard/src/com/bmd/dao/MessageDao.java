package com.bmd.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bmd.model.Message;
import com.bmd.util.HibernateUtil;
import com.bmd.util.PageModel;
/**
 * ������Ϣ���ݿ������
 * @author BMD
 */
public class MessageDao {
	/**
	 * ������޸�������Ϣ
	 * @param message Message����
	 */
	public void saveMessage(Message message){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.saveOrUpdate(message);		//�־û�������Ϣ
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	/**
	 * ɾ��������Ϣ
	 * @param id ����id
	 */
	public void deleteMessage(Integer id){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����ָ��id��������Ϣ
			Message message = (Message)session.get(Message.class, id);
			session.delete(message);			//ɾ������
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	/**
	 * ��ѯ����������Ϣ
	 * @return List����
	 */
	public List<Message> findAllMessage(){
		Session session = null;					//Session����
		List<Message> list = null;				//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from Message";		//HQL��ѯ���
			list = session.createQuery(hql)		//����Query����
				          .list();				//��ȡ�����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return list;
	}
	/**
	 * ͨ��id����������Ϣ
	 * @param id ����id
	 * @return Message����
	 */
	public Message getMessage(Integer id){
		Session session = null;					//Session����
		Message message = null;					//Message����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//����Message
			message = (Message)session.get(Message.class, id);
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return message;
	}
	/**
	 * ��ҳ��ѯ������Ϣ
	 * @param currPage	��ǰҳ
	 * @param pageSize	ÿҳ��¼��
	 * @return	PageModel �Զ����ҳ���
	 */
	public PageModel findPaging(int currPage, int pageSize){
		Session session = null;					//Session����
		PageModel pageModel = null;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ��䣬������ʱ�併������
			String hql = "from Message m order by m.createTime desc";
			List<Message> list = session.createQuery(hql)		//����Query����
		  					.setFirstResult((currPage - 1) * pageSize)	//������ʼλ��
		  					.setMaxResults(pageSize)	//���ü�¼��
		  					.list();					//���ؽ����
			pageModel = new PageModel();		//ʵ����pageModel
			pageModel.setCurrPage(currPage);	//���õ�ǰҳ
			pageModel.setList(list);			//���ý����
			pageModel.setPageSize(pageSize);	//����ÿҳ��¼��
			//�����ܼ�¼��
			pageModel.setTotalRecords(getTotalRecords(session));
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return pageModel;
	} 
	/**
	 * ��ѯ���Ե��ܼ�¼��
	 * 
	 * @param session
	 *            Session����
	 * @return �ܼ�¼��
	 */
	public int getTotalRecords(Session session) {
		// HQL��ѯ���
		String hql = "select count(*) from Message";
		// ����Query����
		Query query = session.createQuery(hql);
		// ��ֵ����
		Long totalRecords = (Long) query.uniqueResult();
		// �����ܼ�¼��
		return totalRecords.intValue();
	}
}

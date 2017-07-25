package com.bmd.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.bmd.model.User;
import com.bmd.util.HibernateUtil;

/**
 * �û����ݿ⴦����
 * @author BMD
 */
public class UserDao {
	/**
	 * �����û�
	 * @param user User����
	 */
	public void saveUser(User user){
		Session session = null;					//Session����	
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			session.save(user);					//�־û�user
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
	}
	/**
	 * ��ѯ�����û���Ϣ
	 * @return List����
	 */
	public List<User> findAllUser(){
		Session session = null;					//Session����
		List<User> list = null;					//List����
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			String hql = "from User";
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
	 * ͨ���û����������ѯ�û�
	 * ���ڵ�¼
	 * @param username �û���
	 * @param password ����
	 * @return User����
	 */
	public User findUser(String username, String password){
		Session session = null;					//Session����
		User user = null;						//�û�
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "from User u where u.username=? and u.password=?";
			Query query = session.createQuery(hql)		//����Query����
								.setParameter(0, username)//��̬��ֵ
								.setParameter(1, password);//��̬��ֵ
			user = (User)query.uniqueResult();			//����User����
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return user;
	}
	/**
	 * �ж�ָ���û������û��Ƿ����
	 * @param username �û���
	 * @return
	 */
	public boolean findUserByName(String username){
		Session session = null;					//Session����
		boolean exist = false;
		try {
			//��ȡSession
			session = HibernateUtil.getSession();
			session.beginTransaction();			//��������
			//HQL��ѯ���
			String hql = "from User u where u.username=?";
			Query query = session.createQuery(hql)		//����Query����
								 .setParameter(0, username);//��̬��ֵ
			Object user = query.uniqueResult();			//����User����
			//����û�����existΪtrue
			if(user != null){
				exist = true;
			}
			session.getTransaction().commit(); 	//�ύ����
		} catch (Exception e) {
			e.printStackTrace();				//��ӡ�쳣��Ϣ
			session.getTransaction().rollback();//�ع�����
		}finally{
			HibernateUtil.closeSession();		//�ر�Session
		}
		return exist;
	}
}

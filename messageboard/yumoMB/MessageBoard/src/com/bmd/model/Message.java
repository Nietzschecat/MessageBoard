package com.bmd.model;

import java.util.Date;
/**
 * ������Ϣ�־û���
 * @author BMD
 */
public class Message {
	private Integer id;			//ID���
	private String title;		//����
	private String content;		//����
	private Date createTime;	//����ʱ��
	private Revert revert;		//�ظ�
	private User user;			//�����û�
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Revert getRevert() {
		return revert;
	}
	public void setRevert(Revert revert) {
		this.revert = revert;
	}
}

package com.bmd.model;

import java.util.Date;
/**
 * �ظ��־û���
 * @author BMD
 */
public class Revert {
	private Integer id;		//�ظ�ID
	private String content;	//�ظ�����
	private Date revertTime;//�ظ�ʱ��
	private Message message;//����
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRevertTime() {
		return revertTime;
	}
	public void setRevertTime(Date revertTime) {
		this.revertTime = revertTime;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
}

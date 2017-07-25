package com.bmd.model;

import java.util.Date;
/**
 * 回复持久化类
 * @author BMD
 */
public class Revert {
	private Integer id;		//回复ID
	private String content;	//回复内容
	private Date revertTime;//回复时间
	private Message message;//留言
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

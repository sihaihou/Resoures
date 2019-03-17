package com.reyco.core.domain;

import java.io.Serializable;


public class MailContent implements Serializable{
	  /**
     * 抄送人
     */
    private String carbonCopy;
	 /**
     * 收件人
     */
    private String recipients;
    /**
     * 主题
     */
    private String subject;
    /**
     * 内容
     */
    private String text;
    public MailContent() {
		// TODO Auto-generated constructor stub
	}
	public MailContent(String recipients, String subject, String text) {
		super();
		this.recipients = recipients;
		this.subject = subject;
		this.text = text;
	}
	public MailContent( String carbonCopy,String recipients, String subject, String text) {
		super();
		this.recipients = recipients;
		this.carbonCopy = carbonCopy;
		this.subject = subject;
		this.text = text;
	}
	public String getRecipients() {
		return recipients;
	}
	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}
	public String getCarbonCopy() {
		return carbonCopy;
	}
	public void setCarbonCopy(String carbonCopy) {
		this.carbonCopy = carbonCopy;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "MailContent [recipients=" + recipients + ", carbonCopy=" + carbonCopy + ", subject=" + subject
				+ ", text=" + text + "]";
	}
}

package ru.mera.korsakovkirill.postman;

import java.util.Date;

class Email extends Message {
	
	private String from;
	private String to;
	private String message_body;
	private Date receive_date;
	
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getMessage_body() {
		return message_body;
	}
	public Date getReceive_date() {
		return (Date)receive_date.clone();
	}

}

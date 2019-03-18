package ru.mera.korsakovkirill.postman;

import java.util.Date;

final class Email extends Message {

	private Date receiveDate;

	public Email() {

	}

	public Email(String messageBody) {
		this.messageBody = messageBody;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public Date getReceiveDate() {
		return (Date) receiveDate.clone();
	}

}

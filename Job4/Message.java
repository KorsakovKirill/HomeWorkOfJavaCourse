package ru.mera.korsakovkirill.postman;

public abstract class Message {

	protected Person from;
	protected Person to;
	protected String messageBody;

	public Person getFrom() {
		return from;
	}

	public Person getTo() {
		return to;
	}

	public String getMessageBody() {
		return messageBody;
	}

}

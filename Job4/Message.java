package ru.mera.korsakovkirill.postman;

public class Message {

	protected String from;
	protected String to;
	protected String messageBody;

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getMessageBody() {
		return messageBody;
	}

	@Override
	public String toString() {
		return messageBody;
	}

}

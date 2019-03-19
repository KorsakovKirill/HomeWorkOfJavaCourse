package ru.mera.korsakovkirill.postman;

public abstract class Message {

	protected Person from;
	protected Person to;
	protected String messageBody;

	public Message(Person from, String messageBody, Person to) {
		this.from = from;
		this.to = to;
		this.messageBody = messageBody;
	}
	
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

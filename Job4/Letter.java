package ru.mera.korsakovkirill.postman;

final class Letter extends Message {

	private int fromPostalIndex;
	private int toPostalIndex;
	
	public Letter() {
		
	}

	public Letter(String messageBody) {
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

	public int getFromPostalIndex() {
		return fromPostalIndex;
	}

	public int getToPostalIndex() {
		return toPostalIndex;
	}

}

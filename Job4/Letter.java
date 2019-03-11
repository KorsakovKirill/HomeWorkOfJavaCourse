package ru.mera.korsakovkirill.postman;

class Letter extends Message {
	
	private String from;
	private String to;
	private String message_body;
	private int fromPostalIndex;
	private int toPostalIndex;
	
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getMessage_body() {
		return message_body;
	}
	public int getFromPostalIndex() {
		return fromPostalIndex;
	}
	public int getToPostalIndex() {
		return toPostalIndex;
	}

	
}

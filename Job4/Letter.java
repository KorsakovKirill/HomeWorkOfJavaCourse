package ru.mera.korsakovkirill.postman;

final class Letter extends Message {

	private final int fromPostalIndex;
	private final int toPostalIndex;

	public Letter(Person from, String messageBody, Person to, int fromPostalIndex, int toPostalIndex) {
		super();
		this.from = from;
		this.messageBody = messageBody;
		this.to = to;
		this.fromPostalIndex = fromPostalIndex;
		this.toPostalIndex = toPostalIndex;
	}

	public int getFromPostalIndex() {
		return fromPostalIndex;
	}

	public int getToPostalIndex() {
		return toPostalIndex;
	}

	@Override
	public String toString() {
		return "Отправитель - " + from + ": " + messageBody + " Получатель - " + to + ". Почтовый индекс отправителя - "
				+ fromPostalIndex + ". Почтовый индекс получателя - " + toPostalIndex + ".";
	}

}

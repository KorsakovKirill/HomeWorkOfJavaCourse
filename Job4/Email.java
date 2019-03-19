package ru.mera.korsakovkirill.postman;

import java.util.Date;

final class Email extends Message {

	private final Date receiveDate;

	public Email(Person from, String messageBody, Person to, Date receiveDate) {
		super(to, messageBody, to);
		this.receiveDate = receiveDate;
	}

	public Date getReceiveDate() {
		return (Date) receiveDate.clone();
	}

	@Override
	public String toString() {
		return "Отправитель - " + from + ": " + messageBody + " Получатель - " + to + ". Дата получения сообщения - "
				+ receiveDate;
	}
}

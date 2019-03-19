package ru.mera.korsakovkirill.postman;

import java.util.ArrayList;
import java.util.Date;

public class MailBox {

	ArrayList<Email> elMessage = new ArrayList<Email>();
	
	ArrayList<Letter> letMessage = new ArrayList<Letter>();

	void addElMessage(Person from, String messageBody, Person to, Date receiveDate) {
		elMessage.add(new Email(from, messageBody, to, new Date()));
	}

	public void addLetMessage(Person from, String messageBody, Person to, int fromPostalIndex, int toPostalIndex) {
		letMessage.add(new Letter(from, messageBody, to, fromPostalIndex, toPostalIndex));
	}

	void showAllElMessages() {
		System.out.println("\nAll Email ");
		for (Email email : elMessage) {
			System.out.println(" " + email);
		}
	}

	void showAllLetMessages() {
		System.out.println("\nAll letter ");
		for (Letter letter : letMessage) {
			System.out.println(" " + letter);
		}
	}

}

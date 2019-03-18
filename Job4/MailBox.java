package ru.mera.korsakovkirill.postman;

import java.util.ArrayList;

public class MailBox {

	Message message = new Message();

	Email email = new Email();

	Letter letter = new Letter();

	ArrayList<Email> elMessage = new ArrayList<Email>();

	ArrayList<Letter> letMessage = new ArrayList<Letter>();

	Email addElMessage(Email messageBody) {
		elMessage.add(messageBody);
		return messageBody;
	}

	Letter addLetMessage(Letter messageBody) {
		letMessage.add(messageBody);
		return messageBody;
	}

	void showAllElMessages(Object person) {
		System.out.println("\nAll Email ");
		for (Email email : elMessage) {
			System.out.println(" " + person + email);
		}
	}

	void showAllLetMessages(Object person) {
		System.out.println("\nAll letter ");
		for (Letter letter : letMessage) {
			System.out.println(" " + person + letter);
		}
	}

}

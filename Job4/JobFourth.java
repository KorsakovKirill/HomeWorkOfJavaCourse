package ru.mera.korsakovkirill.postman;

import java.util.Arrays;

public class JobFourth {

	public static void main(String[] args) {

		MailBox mailBox = new MailBox();

		Person person = new Person("Kirill", "Korsakov");

		mailBox.addElMessage(new Email("Привет"));
		mailBox.addElMessage(new Email("Как дела?"));
		mailBox.addElMessage(new Email("Чего молчишь?"));
		mailBox.addElMessage(new Email("Вот и поговорили"));
		mailBox.addElMessage(new Email("парам пам пам"));

		mailBox.addLetMessage(new Letter("В"));
		mailBox.addLetMessage(new Letter("Вот"));
		mailBox.addLetMessage(new Letter("Вот и"));
		mailBox.addLetMessage(new Letter("Вот и п"));
		mailBox.addLetMessage(new Letter("Вот и пог"));
		mailBox.addLetMessage(new Letter("Вот и погов"));
		mailBox.addLetMessage(new Letter("Вот и поговор"));
		mailBox.addLetMessage(new Letter("Вот и поговорил"));
		mailBox.addLetMessage(new Letter("Вот и поговорили!"));

		mailBox.showAllElMessages(person);
		mailBox.showAllLetMessages(person);

	}

}

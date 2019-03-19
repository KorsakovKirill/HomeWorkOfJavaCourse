package ru.mera.korsakovkirill.postman;

import java.util.Date;

public class JobFourth {
	
	public static void main(String[] args) throws InterruptedException {

		MailBox mailBox = new MailBox();
		MailBox mailBox1 = new MailBox();
		Person personFrom = new Person("Kirill", "Korsakov");
		Person personTo = new Person("Павел", "Попов");

		mailBox.addElMessage(personFrom, "Привет.", personTo, new Date());
		mailBox.addElMessage(personTo, "И тебе не хворать...", personFrom, new Date());

		mailBox.addLetMessage(personFrom, "Привет, старый друг. Как поживешь? ЧТо нового?", personTo, 603022, 608300);
		mailBox1.addLetMessage(personTo, "Привет, всё хорошо! Особо ничего. Как твои дела? Что нового? ", personFrom,
								608300, 603022);
		mailBox.addLetMessage(personFrom,"Да и у меня всё хорошо, ничего особо нового с нашей последней переписки не произошло.", 
								personTo, 603022, 608300);

		mailBox.showAllElMessages();
		mailBox.showAllLetMessages();

	}
}

package ru.mera.korsakovkirill.postman;

public class JobFourth {

	public static void main(String[] args) {
	
		final Person Person = new Person();
		
		final Message Message = new Message();
		
		MailBox MailBox = new MailBox();
		
		MailBox.addElMessage("ololo");
		MailBox.addElMessage("ololo1");
		MailBox.addElMessage("ololo2");
		MailBox.addElMessage("ololo3");
		MailBox.addElMessage("ololo4");
		MailBox.addElMessage("ololo2");
		
		MailBox.addLetMessage("Korsakov");
		MailBox.addLetMessage("Korsakov1");
		MailBox.addLetMessage("Korsakov2");
		MailBox.addLetMessage("Korsakov3");
		MailBox.addLetMessage("Korsakov4");
		
		MailBox.showAllElMessages();
		MailBox.showAllLetMessages();
		
		
	
		
		
	}



}

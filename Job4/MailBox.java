package ru.mera.korsakovkirill.postman;

import java.util.ArrayList;

public class MailBox{

	ArrayList<String> elMessage = new ArrayList<String>();
	ArrayList<String> letMessage = new ArrayList<String>();

	//Add Email 
	String addElMessage(String elMes) {
		elMessage.add(elMes);
		return elMes;
	}
	
	//Add letter
	String addLetMessage(String letMes) {
		letMessage.add(letMes);
		return letMes;
	}
	
	//Show all emails
	void showAllElMessages() {
		System.out.println("\nAll Email ");
		for(int i = 0; i < elMessage.size(); i++) {
			int j = 1;
			j += i;
			System.out.println(j + " - " + elMessage.get(i));
		}
	}
	
	//Show all Letter
		void showAllLetMessages() {
			System.out.println("\nAll letter ");
			for(int i = 0; i < letMessage.size(); i++) {
				int j = 1;
				j += i;
				System.out.println(j + " - " + letMessage.get(i));
			}
		}
	
	
}

package ru.mera.korsakovkirill.postman;

public class Notebook extends Computer implements Returnable {
	String timeRunWithBat;
	String diagWind;
	
	Notebook(){
		
	}
	

	public Notebook(String name, int count, int quantity, String diagWind, String timeRunWithBat, int daysForReturn, String documents, int hdd) {
		this.name = name;
		this.count = count;
		this.quantity = quantity;
		this.diagWind = diagWind;
		this.timeRunWithBat = timeRunWithBat;
		this.daysForReturn = daysForReturn;
		this.documents = documents;
		this.hdd = hdd;
	}
	



	
	public String getTimeRunWithBat() {
		return timeRunWithBat;
	}


	public String getDiagWind() {
		return diagWind;
	}
	
	public String toString(){
		 return " Название = " + name + ", Цена = " + count + ", Количество = " + quantity + ", Доп. параметр 1: " + diagWind + ", Доп. параметры 2: " + timeRunWithBat;
		
	}
	@Override
	public int getHDD() {
		return super.getHDD();
	}


	@Override
	public int getDaysForReturn() {	
		return daysForReturn;
	}
	
	@Override
	public String getRequiredDocuments() {
		return documents;
	}


	


}

package ru.mera.korsakovkirill.postman;

public class Monoblok extends Computer {
	Monoblok(){
		
	}
	

	public Monoblok(String name, int count, int quantity, int daysForReturn, int hdd) {
		this.name = name;
		this.count = count;
		this.quantity = quantity;
		this.daysForReturn = daysForReturn;
		this.hdd = hdd;
	}
	
	public String toString(){
		 return " Название = " + name + ", Цена = " + count + ", Количество = " + quantity;
		
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

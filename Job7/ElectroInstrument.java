package ru.mera.korsakovkirill.postman;

public abstract class ElectroInstrument extends AbstractItem{
	int potrmosh;
	
	public int getPotrMosh() {
		return potrmosh;
	}
	public String toString(){
		 return " Название = " + name + ", Цена = " + count + ", Количество = " + quantity + ", Доп. параметры " + doppar;
		
	}
}

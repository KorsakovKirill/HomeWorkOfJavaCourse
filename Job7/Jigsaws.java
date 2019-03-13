package ru.mera.korsakovkirill.postman;

public class Jigsaws extends ElectroInstrument{
	
	String maxTPropil;

	public Jigsaws() {

	}

	public Jigsaws(String name, int count, int quantity, String doppar, int potrmosh, int daysForReturn) {
		this.name = name;
		this.count = count;
		this.quantity = quantity;
		this.doppar = doppar;
		this.potrmosh = potrmosh;
		this.daysForReturn = daysForReturn;
	}

	@Override
	public String getRequiredDocuments() {
		return null;
	}

	@Override
	public int getDaysForReturn() {
		return 0;
	}
}

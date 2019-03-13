package ru.mera.korsakovkirill.postman;

public class Saws extends ElectroInstrument implements Returnable {

	public String radDiska;

	public Saws() {

	}

	public Saws(String name, int count, int quantity, String doppar, int potrmosh, int daysForReturn,
			String documents) {
		this.name = name;
		this.count = count;
		this.quantity = quantity;
		this.doppar = doppar;
		this.potrmosh = potrmosh;
		this.daysForReturn = daysForReturn;
		this.documents = documents;
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

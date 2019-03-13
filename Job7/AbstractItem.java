package ru.mera.korsakovkirill.postman;

public abstract class AbstractItem implements Item, Returnable {

	public int count;
	public String name;
	public int quantity;
	public int daysForReturn;
	public String documents;
	public String doppar;
	public int potrmosh;

	int SumSell() {
		int SumSell = getQuantity() * getCount();
		return SumSell;
	}

	public int getCount() {
		return count;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}
	public int getPotrMosh() {
		return potrmosh;
	}

}

package ru.mera.korsakovkirill.postman;

public class Person {

	private String name;
	private String sername;

	public Person() {

	}

	public Person(String name, String sername) {
		this.name = name;
		this.sername = sername;
	}

	public String getName() {
		return name;
	}

	public String getSername() {
		return sername;
	}

	@Override
	public String toString() {
		return "От " + name + "а" + " " + sername + "а" + ": ";
	}

}

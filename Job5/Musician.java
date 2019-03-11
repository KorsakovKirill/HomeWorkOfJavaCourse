package ru.mera.korsakovkirill.postman;

public class Musician extends Person {

	public Musician() {

	}

	public Musician(String name, String sername) {
		this.name = name;
		this.sername = sername;

	}

	// Перечисление инструментов
	public enum Instrument {
		Dydka, Fleita, Baraban, Gitara
	}

	// Метод рандомного выбора инструментов
	public static final RandomEnum<Instrument> rinstr = new RandomEnum<Instrument>(Instrument.class);

}

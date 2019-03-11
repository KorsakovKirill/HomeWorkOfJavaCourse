package ru.mera.korsakovkirill.postman;

public class Artist extends Person {

	public Artist() {

	}

	public Artist(String name, String sername) {

		this.name = name;
		this.sername = sername;
	}

	// Перечисления стилей
	public enum Style {
		Expressionism, Cubism, Fauvism, Impressionism
	}

	// Метод рандомного выбора стилей
	public static final RandomEnum<Style> rstyle = new RandomEnum<Style>(Style.class);

}

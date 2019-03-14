package ru.mera.korsakovkirill.postman;

public class Gamer {

	String condition;
	String name;

	public Gamer() {

	}

	public Gamer(String name, String condition) {
		this.name = name;
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return " Имя игрока = " + name;

	}

}

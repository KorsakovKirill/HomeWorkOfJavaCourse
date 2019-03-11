package ru.mera.korsakovkirill.postman;

import java.util.ArrayList;

public class JobFifth {
	public static void main(String[] args) throws InterruptedException {

		ArrayList<Person> Personarray = new ArrayList<Person>();

		Personarray.add(new Artist("Kirill", "Pupkin"));
		Personarray.add(new Musician("Ivan", "Ivanyuch"));
		Personarray.add(new Musician("Sasha", "Derevko"));
		Personarray.add(new Artist("Andrei", "Ushkov"));
		Personarray.add(new Artist("Seledka", "Fish"));
		Personarray.add(new Musician("Evgen", "Trapizov"));

		for (int i = 0; i < Personarray.size(); i++) {
			Thread.sleep(100);
			if (Personarray.get(i) instanceof Artist) {
				System.out.println(Personarray.get(i) + " рисует в стиле " + "< " + Artist.rstyle.random() + " >");
			} else if (Personarray.get(i) instanceof Musician) {
				System.err.println(Personarray.get(i) + " Играет на  инструменте " + "< " + Musician.rinstr.random() + " >");
			}
		}

	}
}

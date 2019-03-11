package ru.mera.korsakovkirill.postman;

import java.util.Random;

public class Person {

	public String name;
	public String sername;

	public Person() {
	}

	public static class RandomEnum<E extends Enum> {

		private static final Random RND = new Random();
		private final E[] values;

		public RandomEnum(Class<E> token) {
			values = token.getEnumConstants();
		}

		public E random() {
			return values[RND.nextInt(values.length)];
		}
	}

	@Override
	public String toString() {
		return "Person name = " + name + ", sername = " + sername;
	}

}

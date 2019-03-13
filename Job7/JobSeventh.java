package ru.mera.korsakovkirill.postman;

import java.util.ArrayList;

public class JobSeventh {

	public static void main(String[] args) {

		ArrayList<Object> obj = new ArrayList<Object>();

		AbstractItem sBosch = new Saws("SawBosch", 10000, 3, "Радиус диска 240мм", 330, 21, "Чек и паспорт");
		AbstractItem sDewolt = new Saws("Пила Dewolt", 16000, 1, "Радиус диска 140мм", 120, 21, "Чек и паспорт");
		AbstractItem dMakita = new Drills("Drill Makita", 8000, 1, "Максимальный диаметр сверла 10мм", 250, 14, "Чек");
		AbstractItem dZebr = new Drills("Drill Zebr", 5000, 2, "Максимальный диаметр сверла 25мм", 150, 14, "Чек");
		AbstractItem jsElectro = new Jigsaws("Лобзик Electro", 4000, 1, "Максимальная толщина пропила 15мм", 110, 0);
		AbstractItem jsBosch = new Jigsaws("Лобзик Bosch", 7500, 4, "Максимальная толщина пропила 30мм", 200, 0);

		AbstractItem nAccer = new Notebook("Notebook Acer", 35000, 1, "Диагональ экрана - 17",
				"Время работы без подзарядки 3часа", 14, "чек и паспорт", 512);
		AbstractItem nLenovo = new Notebook("Notebook Lenovo", 33500, 2, "Диагональ экрана - 15",
				"Время работы без подзарядки 2часа", 14, "чек и паспорт", 256);

		AbstractItem mApple = new Monoblok("Monoblok Apple", 50000, 10, 0, 768);
		AbstractItem mHp = new Monoblok("Monoblok HP", 45000, 1, 0, 512);

		AbstractItem sBosch1 = new Saws("SawBosch1", 10000, 3, "Радиус диска 240мм", 430, 21, "Чек и паспорт");

		obj.add(sBosch);
		obj.add(sDewolt);
		obj.add(dMakita);
		obj.add(dZebr);
		obj.add(jsElectro);
		obj.add(jsBosch);
		obj.add(nAccer);
		obj.add(nLenovo);
		obj.add(mApple);
		obj.add(mHp);
		obj.add(sBosch1);

		// Вывод всех товаров
		System.out.println(" • Все имеющиеся товары в магазине: ");
		for (int i = 0; i < obj.size(); i++) {
			System.out.println(obj.get(i));
		}
		
		// Выручка магазина после продажи всех товаров
		int revenue = 0;
		for (int i = 0; i < obj.size(); i++) {
			revenue += ((AbstractItem) obj.get(i)).getCount() * ((AbstractItem) obj.get(i)).getQuantity();
		}
		System.out.println("\n • Выручка магазина при продаже всех товаров составит = " + revenue + "руб");

		// Инструмент с наибольшей можностью потребления
		// Цикл нахождения максимального значения мощности потребления
		int[] mas2 = new int[70];
		int maxValue = mas2[0];
		for (int i = 0; i < obj.size(); i++) {
			mas2[i] = ((AbstractItem) obj.get(i)).getPotrMosh();
			if (mas2[i] >= maxValue) {
				maxValue = mas2[i];
			}
		}

		System.out.println("\n • Максимальная мощность потребления = " + maxValue + " у:");
		
		//Цикл выводящий товар с макс. мощностью потребления, путём сравнения найденного макс показателя с показателями каждого товара
		for (int i = 0; i < obj.size(); i++) {
			if (((AbstractItem) obj.get(i)).getPotrMosh() == 0) {
				continue;
			} else if (maxValue == ((AbstractItem) obj.get(i)).getPotrMosh()) {
				System.out.println(obj.get(i));
			}

		}

		// Общая сумма памяти на жёстких дисках
		int sumHDD = 0;
		for (int i = 0; i < obj.size(); i++) {

			try {
				sumHDD += ((Computer) obj.get(i)).getHDD() * ((Computer) obj.get(i)).getQuantity();
			} catch (Exception e) {
				continue;
			}

		}
		System.out.println("\n • Общая сумма памяти на жёстких дисках  = " + sumHDD + "Гб");

		// Вывод товара который можно вернуть
		System.out.println("\n • Перечень товаров подлежащие возврату:");
		for (int i = 0; i < obj.size(); i++) {
			if (((AbstractItem) obj.get(i)).getDaysForReturn() != 0) {
				System.out.println(((AbstractItem) obj.get(i)).getName() + " можно вернуть в течении: "
						+ ((AbstractItem) obj.get(i)).getDaysForReturn()
						+ "дней со дня покупки, при себе необходимо иметь: "
						+ ((AbstractItem) obj.get(i)).getRequiredDocuments());
			} else {
				continue;
			}
		}

	}

}

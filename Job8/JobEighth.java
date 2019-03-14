package ru.mera.korsakovkirill.postman;

import java.util.ArrayList;
import java.util.Random;

public class JobEighth {

	static String sheltered = "sheltered";
	static String notsheltered = "notsheltered";
	static String goHome = "goHome";

	static ArrayList<Object> win = new ArrayList<Object>();
	static ArrayList<Object> lose = new ArrayList<Object>();
	static ArrayList<Object> gamers = new ArrayList<Object>();
	static ArrayList<Object> cheater = new ArrayList<Object>();

	public static void main(String[] args) throws MiJeDogovarivalisDomaNePryatException, InterruptedException {

		String[] condition = { "sheltered", "notsheltered", "goHome" };

//		getRandom(condition) - для случайного заполнения состояния играков 
		Gamer gamer1 = new Gamer("Вася", getRandom(condition));
		Gamer gamer2 = new Gamer("Игорь", getRandom(condition));
		Gamer gamer3 = new Gamer("Саша", getRandom(condition));
		Gamer gamer4 = new Gamer("Маша", getRandom(condition));
		Gamer gamer5 = new Gamer("Петя", getRandom(condition));

		gamers.add(gamer1);
		gamers.add(gamer2);
		gamers.add(gamer3);
		gamers.add(gamer4);
		gamers.add(gamer5);

		int c = gamers.size();// фиксированная длинна
		int a = gamers.size();// длинна которая по ходу игры уменьшается
		int b; // переменная, которая будет использоваться для рандомного выбора игроков

		for (int j = 0; j < c; j++) {
			// Ведущий говорит "Не Прячешься"
			Thread.sleep(30);
			if (a == 0) {
				break;
			} else {
				b = Math.round((int) (Math.random() * a));// Случайное число в пределах размера списка игроков
				nepryach(((Gamer) gamers.get(b)).condition, b);
				a--;
			}
			// Ведущий говорит "Прячешься"
			if (a == 0) {
				break;
			} else {
				b = Math.round((int) (Math.random() * a));
				try {
					pryach(((Gamer) gamers.get(b)).condition, b);
					a--;
				} catch (MiJeDogovarivalisDomaNePryatException ex) {
					System.err.println("\n" + gamers.get(b) + " - играет не честно");
					a = 0;
				}
			}
		}

		if (win.size() != 0) {
			System.out.println("\nСписок победителей:");
			for (int i = 0; i < win.size(); i++) {
				System.out.println(win.get(i));
			}
		}

		if (lose.size() != 0) {
			System.out.println("\nСписок проигравших:");
			for (int i = 0; i < lose.size(); i++) {
				System.out.println(lose.get(i));
			}
		}

	}
	//Функция «Не прячешься!» 
	public static void nepryach(String condition, int b) {
		if (sheltered.equals(condition) | goHome.equals(condition)) {
			win.add(gamers.get(b));
			gamers.remove(b);
		} else if (notsheltered.equals(condition)) {
			lose.add(gamers.get(b));
			gamers.remove(b);
		}

	}
	//Функция «Прячешься!» 
	public static void pryach(String condition, int b) throws MiJeDogovarivalisDomaNePryatException {
		if (notsheltered.equals(condition)) {
			win.add(gamers.get(b));
			gamers.remove(b);
		} else if (sheltered.equals(condition)) {
			lose.add(gamers.get(b));
			gamers.remove(b);
		} else if (goHome.equals(condition)) {
			lose.removeAll(lose);
			win.removeAll(win);
			throw new MiJeDogovarivalisDomaNePryatException();
		}
	}

	public static String getRandom(String[] condition) {
		int rnd = new Random().nextInt(condition.length);
		return condition[rnd];
	}


}

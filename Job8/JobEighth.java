package ru.mera.korsakovkirill.postman;

import java.util.ArrayList;
import java.util.Random;

public class JobEighth {

	static String sheltered = "sheltered";
	static String notsheltered = "notsheltered";
	static String goHome = "goHome";

	static ArrayList<Gamer> win = new ArrayList<Gamer>();
	static ArrayList<Gamer> lose = new ArrayList<Gamer>();
	static ArrayList<Gamer> gamers = new ArrayList<Gamer>();
	static ArrayList<Gamer> cheater = new ArrayList<Gamer>();

	public static void main(String[] args) throws MiJeDogovarivalisDomaNePryatException, InterruptedException {

		String[] condition = { "sheltered", "notsheltered", "goHome" };

		gamers.add(new Gamer("Вася", getRandom(condition)));
		gamers.add(new Gamer("Игорь", getRandom(condition)));
		gamers.add(new Gamer("Саша", getRandom(condition)));
		gamers.add(new Gamer("Маша", getRandom(condition)));
		gamers.add(new Gamer("Петя", getRandom(condition)));

		final int GAMERS_LENGHT = gamers.size();
		int VariableGamersLength = gamers.size();
		int rndChoiceGamer = 0;
		String gamerCondition = ((Gamer) gamers.get(rndChoiceGamer)).condition;

		for (int j = 0; j < GAMERS_LENGHT; j++) {

			// Ведущий говорит "Не Прячешься"
			if (VariableGamersLength == 0) {
				break;
			} else {
				rndChoiceGamer = Math.round((int) (Math.random() * VariableGamersLength));

				nepryach(gamerCondition, rndChoiceGamer);
				VariableGamersLength--;
			}

			// Ведущий говорит "Прячешься"
			if (VariableGamersLength == 0) {
				break;
			} else {
				rndChoiceGamer = Math.round((int) (Math.random() * VariableGamersLength));
				try {
					pryach(gamerCondition, rndChoiceGamer);
					VariableGamersLength--;
				} catch (MiJeDogovarivalisDomaNePryatException ex) {
					System.err.println("\n" + gamers.get(rndChoiceGamer) + " - играет не честно");
					break;
				}
			}
		}

		if (win.size() != 0) {
			System.out.println("\nСписок победителей:");
			for (Gamer wingamer : win) {
				System.out.println(wingamer);
			}
		}

		if (lose.size() != 0) {
			System.out.println("\nСписок проигравших:");
			for (Gamer losegamer : lose) {
				System.out.println(losegamer);
			}
		}

	}

	public static void nepryach(String condition, int rndChoiceGamer) {
		if (sheltered.equals(condition) || goHome.equals(condition)) {
			win.add(gamers.get(rndChoiceGamer));
			gamers.remove(rndChoiceGamer);
		} else if (notsheltered.equals(condition)) {
			lose.add(gamers.get(rndChoiceGamer));
			gamers.remove(rndChoiceGamer);
		}
	}

	public static void pryach(String condition, int rndChoiceGamer) throws MiJeDogovarivalisDomaNePryatException {
		if (notsheltered.equals(condition)) {
			win.add(gamers.get(rndChoiceGamer));
			gamers.remove(rndChoiceGamer);
		} else if (sheltered.equals(condition)) {
			lose.add(gamers.get(rndChoiceGamer));
			gamers.remove(rndChoiceGamer);
		} else {
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

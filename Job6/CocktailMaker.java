package ru.mera.korsakovkirill.postman;

public abstract class CocktailMaker {

	
	public void mix() {
		getLiquidIngredient();
		getMainIngredient();
		getToppingIngredient();
		System.out.println("Беру " + "<" + getLiquidIngredient() + ">" + " потом добавляю " + "<" + getMainIngredient() + ">" + " сверху добавляю  " + "<" +getToppingIngredient() + ">");
	}

	public abstract String  getLiquidIngredient();

	public abstract String getMainIngredient();

	public abstract String getToppingIngredient();
}

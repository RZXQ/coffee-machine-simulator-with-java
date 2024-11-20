package stage_3;

public class CoffeeMachine {

	private static final int MILK_PER_CUP = 50;

	private static final int WATER_PER_CUP = 200;

	private static final int COFFEE_BEANS_PER_CUP = 15;

	private int maxCupsAvailable;

	private int waterAmount;

	private int milkAmount;

	private int beansAmount;

	public CoffeeMachine(int waterAmount, int milkAmount, int beansAmount) {
		this.waterAmount = waterAmount;
		this.milkAmount = milkAmount;
		this.beansAmount = beansAmount;
		updateMaxCupsAvailable();
	}

	public int getMaxCupAvailable() {
		return this.maxCupsAvailable;
	}

	public void updateMaxCupsAvailable() {
		int maxCupsFromWater = calculateCupsFromIngredient(this.waterAmount, WATER_PER_CUP);
		int maxCupsFromMilk = calculateCupsFromIngredient(this.milkAmount, MILK_PER_CUP);
		int maxCupsFromBeans = calculateCupsFromIngredient(this.beansAmount, COFFEE_BEANS_PER_CUP);

		this.maxCupsAvailable = Math.min(maxCupsFromWater, Math.min(maxCupsFromMilk, maxCupsFromBeans));
	}

	private int calculateCupsFromIngredient(int ingredientAmount, int ingredientPerCup) {
		return ingredientAmount / ingredientPerCup;
	}

}

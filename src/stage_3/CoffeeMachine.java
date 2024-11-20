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
		int cupsOfWater = this.waterAmount / WATER_PER_CUP;
		int cupsOfMilk = this.milkAmount / MILK_PER_CUP;
		int cupsOfBeans = this.beansAmount / COFFEE_BEANS_PER_CUP;

		this.maxCupsAvailable = Math.min(cupsOfWater, Math.min(cupsOfMilk, cupsOfBeans));
	}

}

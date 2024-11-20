package stage_5;

public class CoffeeMachine {

	private int maxCupsAvailable;

	private int moneyCollected;

	private int waterAmount;

	private int milkAmount;

	private int beansAmount;

	private int disposableCups;

	public CoffeeMachine(int waterAmount, int milkAmount, int beansAmount, int disposableCups, int moneyCollected) {
		this.waterAmount = waterAmount;
		this.milkAmount = milkAmount;
		this.beansAmount = beansAmount;
		this.disposableCups = disposableCups;
		this.moneyCollected = moneyCollected;
	}

	public int getMaxCupsAvailable() {
		return maxCupsAvailable;
	}

	public void setMaxCupsAvailable(int maxCupsAvailable) {
		this.maxCupsAvailable = maxCupsAvailable;
	}

	public int getMoneyCollected() {
		return moneyCollected;
	}

	public void setMoneyCollected(int moneyCollected) {
		this.moneyCollected = moneyCollected;
	}

	public int getWaterAmount() {
		return waterAmount;
	}

	public void setWaterAmount(int waterAmount) {
		this.waterAmount = waterAmount;
	}

	public int getMilkAmount() {
		return milkAmount;
	}

	public void setMilkAmount(int milkAmount) {
		this.milkAmount = milkAmount;
	}

	public int getBeansAmount() {
		return beansAmount;
	}

	public void setBeansAmount(int beansAmount) {
		this.beansAmount = beansAmount;
	}

	public int getCupsAmount() {
		return disposableCups;
	}

	public void setCupsAmount(int disposableCups) {
		this.disposableCups = disposableCups;
	}

	public void makeOneCoffee(Coffee coffee) {
		this.waterAmount -= coffee.getWater();
		this.milkAmount -= coffee.getMilk();
		this.beansAmount -= coffee.getBeans();
		this.moneyCollected += coffee.getCost();
		this.disposableCups -= 1;

	}

	// public boolean checkSupplies(Coffee coffee) {
	// if (this.waterAmount < coffee.getWater()) {
	// System.out.println("Sorry, not enough water!");
	// return false;
	// } else if (this.milkAmount < coffee.getMilk()) {
	// System.out.println("Sorry, not enough milk!");
	// return false;
	// } else if (this.beansAmount < coffee.getBeans()) {
	// System.out.println("Sorry, not enough beans!");
	// return false;
	// } else if (this.disposableCups < 1) {
	// System.out.println("Sorry, not enough beans!");
	// return false;
	// }
	// return true;
	// }
	//

	@Override
	public String toString() {
		return String.format(
				"The coffee machine has:\n" + "%d ml of water\n" + "%d ml of milk\n" + "%d g of coffee beans\n"
						+ "%d disposable cups\n" + "$%d of money\n",
				waterAmount, milkAmount, beansAmount, disposableCups, moneyCollected);
	}

	public int getMaxCupAvailable() {
		return this.maxCupsAvailable;
	}

	// public void updateMaxCupsAvailable() {
	// int maxCupsFromWater = calculateCupsFromIngredient(this.waterAmount,
	// WATER_PER_CUP);
	// int maxCupsFromMilk = calculateCupsFromIngredient(this.milkAmount, MILK_PER_CUP);
	// int maxCupsFromBeans = calculateCupsFromIngredient(this.beansAmount,
	// COFFEE_BEANS_PER_CUP);
	//
	// this.maxCupsAvailable = Math.min(maxCupsFromWater, Math.min(maxCupsFromMilk,
	// maxCupsFromBeans));
	// }

	// private int calculateCupsFromIngredient(int ingredientAmount, int ingredientPerCup)
	// {
	// return ingredientAmount / ingredientPerCup;
	// }

}

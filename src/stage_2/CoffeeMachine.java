package stage_2;

public class CoffeeMachine {

	private static final int MILK_PER_CUP = 50;

	private static final int WATER_PER_CUP = 200;

	private static final int COFFEE_BEANS_PER_CUP = 15;

	private int cupsOfCoffeeMachine;

	public void setCupsOfCoffeeMachine(int cupsOfCoffeeMachine) {
		this.cupsOfCoffeeMachine = cupsOfCoffeeMachine;
	}

	public String displayIngredients() {
		return String.format(
				"For %d cups of coffee you will need:\n" + "%d ml of water\n" + "%d ml of milk\n"
						+ "%d g of coffee beans",
				this.cupsOfCoffeeMachine, this.getWaterIngredient(), this.getMilkIngredient(),
				this.getCoffeeBeanIngredient());
	}

	private int getWaterIngredient() {
		return cupsOfCoffeeMachine * WATER_PER_CUP;
	}

	private int getMilkIngredient() {
		return cupsOfCoffeeMachine * MILK_PER_CUP;
	}

	private int getCoffeeBeanIngredient() {
		return cupsOfCoffeeMachine * COFFEE_BEANS_PER_CUP;
	}

}

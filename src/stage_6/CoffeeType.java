package stage_6;

public enum CoffeeType {

	ESPRESSO(250, 0, 16, 4), LATTE(350, 75, 20, 7), CAPPUCCINO(200, 100, 12, 6),BACK(0,0,0,0);

	private final int water;

	private final int milk;

	private final int beans;

	private final int cost;

	CoffeeType(int water, int milk, int beans, int cost) {
		this.water = water;
		this.milk = milk;
		this.beans = beans;
		this.cost = cost;
	}

	public int getWater() {
		return this.water;
	}

	public int getMilk() {
		return milk;
	}

	public int getBeans() {
		return beans;
	}

	public int getCost() {
		return cost;
	}

}

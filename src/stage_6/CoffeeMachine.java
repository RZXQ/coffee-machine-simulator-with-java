package stage_6;

public class CoffeeMachine {

	private static final String CLEAN_COMPLETE_PROMPT = "I have been cleaned!";

	private static final String CLEAN_REQUIRED_PROMPT = "I need cleaning!";

	private static final int CLEAN_THRESHOLD = 10;

	private static int cupsMadeSinceClean = 0;

	private int money;

	private int water;

	private int milk;

	private int beans;

	private int cups;

	public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
		this.water = water;
		this.milk = milk;
		this.beans = beans;
		this.cups = cups;
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getMilk() {
		return milk;
	}

	public void setMilk(int milk) {
		this.milk = milk;
	}

	public int getBeans() {
		return beans;
	}

	public void setBeans(int beans) {
		this.beans = beans;
	}

	public int getCupsAmount() {
		return cups;
	}

	public void setCupsAmount(int disposableCups) {
		this.cups = disposableCups;
	}

	public boolean requireClean() {
		if (CoffeeMachine.cupsMadeSinceClean >= CLEAN_THRESHOLD) {
			System.out.println(CLEAN_REQUIRED_PROMPT);
			return true;
		}
		return false;
	}

	public void brewCoffee(CoffeeType coffeeType) {
		if (requireClean()) {
			return;
		}
		CoffeeMachine.cupsMadeSinceClean++;
		this.water -= coffeeType.getWater();
		this.milk -= coffeeType.getMilk();
		this.beans -= coffeeType.getBeans();
		this.money += coffeeType.getCost();
		this.cups -= 1;
	}

	public void showRemaining() {
		System.out.printf("The coffee machine has:\n" + "%d ml of water\n" + "%d ml of milk\n"
				+ "%d g of coffee beans\n" + "%d disposable cups\n" + "$%d of money\n%n", water, milk, beans, cups,
				money);
	}

	public void executeSelfClean() {
		cupsMadeSinceClean = 0;
		System.out.println(CLEAN_COMPLETE_PROMPT);
	}

}

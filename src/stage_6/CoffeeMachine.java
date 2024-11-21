package stage_6;

public class CoffeeMachine {

	private static final String CLEAN_COMPLETE_PROMPT = "I have been cleaned!";

	public static int cupsMadeSinceClean = 0;

	private int cups;

	private int money;

	private int water;

	private int milk;

	private int beans;

	private Status status;

	private int disposableCups;

	public CoffeeMachine(int water, int milk, int beans, int disposableCups, int money) {
		this.water = water;
		this.milk = milk;
		this.beans = beans;
		this.disposableCups = disposableCups;
		this.money = money;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getCups() {
		return cups;
	}

	public void setCups(int cups) {
		this.cups = cups;
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
		return disposableCups;
	}

	public void setCupsAmount(int disposableCups) {
		this.disposableCups = disposableCups;
	}

	public boolean needClean() {
		if (CoffeeMachine.cupsMadeSinceClean >= 10) {
			this.status = Status.CLEANING;
			System.out.println("I need cleaning!");
			return true;
		}
		return false;
	}

	public void makeOneCoffee(CoffeeType coffeeType) {
		if (!needClean()) {
			CoffeeMachine.cupsMadeSinceClean++;
			this.water -= coffeeType.getWater();
			this.milk -= coffeeType.getMilk();
			this.beans -= coffeeType.getBeans();
			this.money += coffeeType.getCost();
			this.disposableCups -= 1;
		}

	}

	public void showRemaining() {
		System.out.printf(
                "The coffee machine has:\n" + "%d ml of water\n" + "%d ml of milk\n" + "%d g of coffee beans\n"
                + "%d disposable cups\n" + "$%d of money\n%n",
                water, milk, beans, disposableCups, money);
	}

	public void clean() {
		cupsMadeSinceClean = 0;
		System.out.println(CLEAN_COMPLETE_PROMPT);
	}

}

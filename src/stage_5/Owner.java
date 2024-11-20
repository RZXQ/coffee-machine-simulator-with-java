package stage_5;

import java.util.Scanner;

public class Owner {

	private static final Scanner SCANNER = new Scanner(System.in);

	private static final String ACTION_PROMPT = "Write action (buy, fill, take, remaining, exit):";

	private static final String COFFEE_TYPE_PROMPT = "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:";

	private static final String ENOUGH_SUPPLY_PROMPT = "I have enough resources, making you a coffee!\n";

	private CoffeeMachine coffeeMachine;

	private Customer customer;

	private Worker worker;

	private boolean isExit;

	public void makeCoffee() {

		setupCoffeeMachine();

		setupWorker();

		performActions();

	}

	private void performActions() {
		while (!isExit) {
			performSingleAction();
		}
	}

	private void setupWorker() {
		this.worker = new Worker(this.coffeeMachine);
	}

	private void performSingleAction() {
		System.out.println(ACTION_PROMPT);
		Action userAction = Action.valueOf(SCANNER.nextLine().toUpperCase());
		System.out.println();
		switch (userAction) {
			case BUY:
				System.out.println(COFFEE_TYPE_PROMPT);
				int choice = Integer.parseInt(SCANNER.nextLine());
				if (choice == 1) {
					if (checkCoffeeMachineSupplies(Coffee.ESPRESSO)) {
						System.out.println(ENOUGH_SUPPLY_PROMPT);
						coffeeMachine.makeOneCoffee(Coffee.ESPRESSO);
					}
				}
				else if (choice == 2) {
					if (checkCoffeeMachineSupplies(Coffee.LATTE)) {
						System.out.println(ENOUGH_SUPPLY_PROMPT);
						coffeeMachine.makeOneCoffee(Coffee.LATTE);
					}
				}
				else if (choice == 3) {
					if (checkCoffeeMachineSupplies(Coffee.CAPPUCCINO)) {
						System.out.println(ENOUGH_SUPPLY_PROMPT);
						coffeeMachine.makeOneCoffee(Coffee.CAPPUCCINO);
					}
				}
				break;
			case FILL:
				worker.fillIngredients();
				System.out.println();
				break;
			case TAKE:
				worker.takeAllMoney();
				System.out.println();
				break;
			case REMAINING:
				displayRemaining();
				break;
			case EXIT:
				this.isExit = true;
				break;
		}
	}

	public boolean checkCoffeeMachineSupplies(Coffee coffee) {
		if (this.coffeeMachine.getWaterAmount() < coffee.getWater()) {
			System.out.println("Sorry, not enough water!\n");
			return false;
		}
		else if (this.coffeeMachine.getMilkAmount() < coffee.getMilk()) {
			System.out.println("Sorry, not enough milk!\n");
			return false;
		}
		else if (this.coffeeMachine.getBeansAmount() < coffee.getBeans()) {
			System.out.println("Sorry, not enough beans!\n");
			return false;
		}
		else if (this.coffeeMachine.getCupsAmount() < 1) {
			System.out.println("Sorry, not enough beans!\n");
			return false;
		}
		return true;
	}

	private void displayRemaining() {
		System.out.println(this.coffeeMachine);
	}

	private void setupCoffeeMachine() {
		// this.coffeeMachine = getCoffeeMachine();
		// this.coffeeMachine.updateMaxCupsAvailable();
		this.coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
	}

	private void setupCustomer() {
		this.customer = new Customer();
		this.customer.setCupsOfCoffeeNeeded();
	}

	public int readAmount(String prompt) {
		System.out.println(prompt);
		return Integer.parseInt(SCANNER.nextLine());
	}

	// public CoffeeMachine getCoffeeMachine() {
	// return new CoffeeMachine(readAmount(INITIAL_WATER_PROMPT),
	// readAmount(INITIAL_MILK_PROMPT),
	// readAmount(INITIAL_COFFEE_BEANS_PROMPT));
	// }

	private void provideFeedback() {
		int difference = this.coffeeMachine.getMaxCupAvailable() - this.customer.getCupsOfCoffeeNeeded();

		if (difference > 0) {
			System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", difference);
		}
		else if (difference == 0) {
			System.out.println("Yes, I can make that amount of coffee");
		}
		else {
			System.out.printf("No, I can make only %d cups of coffee\n", this.coffeeMachine.getMaxCupAvailable());

		}
	}

	public enum Action {

		BUY, FILL, TAKE, REMAINING, EXIT

	}

}
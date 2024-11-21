package stage_6;

import java.util.Scanner;

public class Seller {

	private static final Scanner SCANNER = new Scanner(System.in);

	private static final String ACTION_PROMPT = "Write action (buy, fill, take, clean, remaining, exit):";

	private static final String COFFEE_TYPE_PROMPT = "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";

	private static final String ENOUGH_SUPPLY_PROMPT = "I have enough resources, making you a coffee!\n";

	private CoffeeMachine coffeeMachine;

	private Staff staff;

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
		this.staff = new Staff(this.coffeeMachine);
	}

	private void cleanCoffeeMachine() {
		this.coffeeMachine.setStatus(Status.ON);
		CoffeeMachine.coffeeSold = 0;
		System.out.println("I have been cleaned!");
	}

	private void performSingleAction() {
		System.out.println(ACTION_PROMPT);
		Action action;

		try {
			action = Action.valueOf(SCANNER.nextLine().toUpperCase());
		}
		catch (IllegalArgumentException e) {
			System.out.println("Invalid action. Please try again.");
			return;
		}

		System.out.println();

		switch (action) {
			case BUY:
				if (this.coffeeMachine.needClean()) {
					break;
				}

				System.out.println(COFFEE_TYPE_PROMPT);
				String choiceStr = SCANNER.nextLine();
				if ("back".equalsIgnoreCase(choiceStr)) {
					break;
				}
				int choice = Integer.parseInt(choiceStr);
				if (choice == 1) {
					if (checkCoffeeMachineSupplies(CoffeeType.ESPRESSO)) {
						System.out.println(ENOUGH_SUPPLY_PROMPT);
						coffeeMachine.makeOneCoffee(CoffeeType.ESPRESSO);
					}
				}
				else if (choice == 2) {
					if (checkCoffeeMachineSupplies(CoffeeType.LATTE)) {
						System.out.println(ENOUGH_SUPPLY_PROMPT);
						coffeeMachine.makeOneCoffee(CoffeeType.LATTE);
					}
				}
				else if (choice == 3) {
					if (checkCoffeeMachineSupplies(CoffeeType.CAPPUCCINO)) {
						System.out.println(ENOUGH_SUPPLY_PROMPT);
						coffeeMachine.makeOneCoffee(CoffeeType.CAPPUCCINO);
					}
				}
				break;
			case FILL:
				staff.fillIngredients();
				System.out.println();
				break;
			case TAKE:
				staff.takeMoney();
				System.out.println();
				break;
			case CLEAN:
				cleanCoffeeMachine();
				break;
			case REMAINING:
				displayRemaining();
				break;
			case EXIT:
				this.isExit = true;
				break;
			default:
				break;
		}
	}

	public boolean checkCoffeeMachineSupplies(CoffeeType coffeeType) {
		if (this.coffeeMachine.getWater() < coffeeType.getWater()) {
			System.out.println("Sorry, not enough water!\n");
			return false;
		}
		else if (this.coffeeMachine.getMilk() < coffeeType.getMilk()) {
			System.out.println("Sorry, not enough milk!\n");
			return false;
		}
		else if (this.coffeeMachine.getBeans() < coffeeType.getBeans()) {
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
		this.coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
	}

	public enum Action {

		BUY, FILL, TAKE, CLEAN, REMAINING, EXIT

	}

}
package stage_6;

import java.util.Scanner;

public class Main {

	private static final Scanner SCANNER = new Scanner(System.in);

	private static final String ACTION_PROMPT = "Write action (buy, fill, take, clean, remaining, exit):";

	private static final String COFFEE_TYPE_PROMPT = "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";

	private static final String ENOUGH_SUPPLY_PROMPT = "I have enough resources, making you a coffee!\n";

	private CoffeeMachine machine;

	private Staff staff;

	private boolean isExit;

	public static void main(String[] args) {
		Main main = new Main();
		main.makeCoffee();
	}

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
		this.staff = new Staff();
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
				if (this.machine.needClean()) {
					break;
				}

				System.out.println(COFFEE_TYPE_PROMPT);
				String choiceStr = SCANNER.nextLine();
				if ("back".equalsIgnoreCase(choiceStr)) {
					break;
				}
				int choice = Integer.parseInt(choiceStr);
				if (choice == 1) {
					if (staff.checkMachineSupplies(machine,CoffeeType.ESPRESSO)) {
						System.out.println(ENOUGH_SUPPLY_PROMPT);
						machine.makeOneCoffee(CoffeeType.ESPRESSO);
					}
				}
				else if (choice == 2) {
					if (staff.checkMachineSupplies(machine,CoffeeType.LATTE)) {
						System.out.println(ENOUGH_SUPPLY_PROMPT);
						machine.makeOneCoffee(CoffeeType.LATTE);
					}
				}
				else if (choice == 3) {
					if (staff.checkMachineSupplies(machine, CoffeeType.CAPPUCCINO)) {
						System.out.println(ENOUGH_SUPPLY_PROMPT);
						machine.makeOneCoffee(CoffeeType.CAPPUCCINO);
					}
				}
				break;
			case FILL:
				staff.fillIngredients(machine);
				System.out.println();
				break;
			case TAKE:
				staff.takeMoney(machine);
				break;
			case CLEAN:
				staff.cleanMachine(machine);
				break;
			case REMAINING:
				machine.showRemaining();
				break;
			case EXIT:
				this.isExit = true;
				break;
			default:
				break;
		}
	}



	private void setupCoffeeMachine() {
		this.machine = new CoffeeMachine(400, 540, 120, 9, 550);
	}

	public enum Action {

		BUY, FILL, TAKE, CLEAN, REMAINING, EXIT

	}

}
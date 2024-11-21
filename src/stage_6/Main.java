package stage_6;

import java.util.Scanner;

public class Main {

	private static final Scanner SCANNER = new Scanner(System.in);

	private static final String ACTION_PROMPT = "Write action (buy, fill, take, clean, remaining, exit):";

	private boolean isExit;

	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}

	public void run() {

		CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
		Staff staff = new Staff();
		Customer customer = new Customer();

		while (!isExit) {
			performSingleAction(machine, staff, customer);
		}

	}

	private void performSingleAction(CoffeeMachine machine, Staff staff, Customer customer) {
		Action action = Action.getAction(SCANNER);
		System.out.println();

		switch (action) {
			case BUY -> {
				if (machine.needClean()) {
					break;
				}
				customer.buyCoffee(staff, machine, SCANNER);
			}
			case FILL -> {
				staff.fillIngredients(machine);
				System.out.println();
			}
			case TAKE -> staff.takeMoney(machine);
			case CLEAN -> staff.cleanMachine(machine);
			case REMAINING -> machine.showRemaining();
			case EXIT -> this.isExit = true;
			case null -> System.out.println("wrong input");
			default -> {
			}
		}
	}

	public enum Action {

		BUY, FILL, TAKE, CLEAN, REMAINING, EXIT;

		public static Action getAction(Scanner scanner) {
			System.out.println(ACTION_PROMPT);
			Action action;
			try {
				action = Action.valueOf(SCANNER.nextLine().toUpperCase());
			}
			catch (IllegalArgumentException e) {
				System.out.println("Invalid action. Please try again.");
				return null;
			}
			return action;
		}

	}

}
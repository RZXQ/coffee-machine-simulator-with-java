package stage_4;

import java.util.Scanner;

public class Controller {

	private static final String INITIAL_WATER_PROMPT = "Write how many ml of water the coffee machine has:";

	private static final String INITIAL_MILK_PROMPT = "Write how many ml of milk the coffee machine has:";

	private static final String INITIAL_COFFEE_BEANS_PROMPT = "Write how many grams of coffee beans the coffee machine has:";

	private static final Scanner SCANNER = new Scanner(System.in);

	private CoffeeMachine coffeeMachine;

	private Customer customer;

	public void makeCoffee() {

		setupCoffeeMachine();
		displayInfo();

		setupCustomer();
		System.out.println(coffeeMachine);

		// provideFeedback();

	}

	private void displayInfo() {
		System.out.println(this.coffeeMachine);
	}

	private void setupCoffeeMachine() {
		// this.coffeeMachine = getCoffeeMachine();
		// this.coffeeMachine.updateMaxCupsAvailable();
		this.coffeeMachine = new CoffeeMachine(400,540,120);
	}

	private void setupCustomer() {
		this.customer =new Customer();
		this.customer.setCupsOfCoffeeNeeded();
	}

	public CoffeeMachine getCoffeeMachine() {
		return new CoffeeMachine(readAmount(INITIAL_WATER_PROMPT), readAmount(INITIAL_MILK_PROMPT),
				readAmount(INITIAL_COFFEE_BEANS_PROMPT));
	}

	public int readAmount(String prompt) {
		System.out.println(prompt);
		return Integer.parseInt(SCANNER.nextLine());
	}

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

}
package stage_3;

import java.util.Scanner;

public class Controller {

	private static final String INITIAL_WATER_PROMPT = "Write how many ml of water the coffee machine has:";

	private static final String INITIAL_MILK_PROMPT = "Write how many ml of milk the coffee machine has:";

	private static final String INITIAL_COFFEE_BEANS_PROMPT = "Write how many grams of coffee beans the coffee machine has:";

	private static final Scanner SCANNER = new Scanner(System.in);

	private CoffeeMachine coffeeMachine;

	private User user;

	public void makeCoffee() {

		setupCoffeeMachine();

		setupUser();

		provideFeedback();

	}

	private void setupCoffeeMachine() {
		this.coffeeMachine = getCoffeeMachine();
		this.coffeeMachine.updateMaxCupsAvailable();
	}

	private void setupUser() {
		this.user =new User();
		this.user.setCupsOfCoffeeNeeded();
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
		int difference = this.coffeeMachine.getMaxCupAvailable() - this.user.getCupsOfCoffeeNeeded();

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
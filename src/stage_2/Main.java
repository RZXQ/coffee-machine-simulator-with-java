package stage_2;

import java.util.Scanner;

public class Main {

	private static final String INITIAL_CUP_PROMPT = "Write how many cups of coffee you will need:";

	private static final Scanner scanner = new Scanner(System.in);

	private static final CoffeeMachine coffeeMachine = new CoffeeMachine();

	public static void main(String[] args) {

		setupCoffeeMachine(coffeeMachine);

		System.out.println(coffeeMachine.displayIngredients());

	}

	public static void setupCoffeeMachine(CoffeeMachine coffeeMachine) {

		System.out.println(INITIAL_CUP_PROMPT);
		int cupsOfCoffeeMachine = Integer.parseInt(scanner.nextLine());
		coffeeMachine.setCupsOfCoffeeMachine(cupsOfCoffeeMachine);
	}

}

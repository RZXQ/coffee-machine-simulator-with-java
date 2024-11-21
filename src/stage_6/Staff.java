package stage_6;

import java.util.Scanner;

public class Staff {

	public static final String ADD_WATER_PROMPT = "Write how many ml of water you want to add:";

	public static final String ADD_MILK_PROMPT = "Write how many ml of milk you want to add: ";

	public static final String ADD_BEANS_PROMPT = "Write how many grams of coffee beans you want to add:";

	public static final String ADD_CUPS_PROMPT = "Write how many disposable cups you want to add: ";

	public static final String TAKE_PROMPT = "I gave you $%d\n";

	private static final Scanner SCANNER = new Scanner(System.in);

	private final CoffeeMachine machine;

	public Staff(CoffeeMachine machine) {
		this.machine = machine;
	}

	public void fillIngredients() {
		this.machine.setWater(this.machine.getWater() + fill(ADD_WATER_PROMPT));
		this.machine.setMilk(this.machine.getMilk() + fill(ADD_MILK_PROMPT));
		this.machine.setBeans(this.machine.getBeans() + fill(ADD_BEANS_PROMPT));
		this.machine.setCupsAmount(this.machine.getCupsAmount() + fill(ADD_CUPS_PROMPT));
	}

	private int fill(String prompt) {
		System.out.println(prompt);
		return Integer.parseInt(SCANNER.nextLine());

	}

	public void takeAllMoney() {
		System.out.printf(TAKE_PROMPT, this.machine.getMoney());
		this.machine.setMoney(0);
	}

}

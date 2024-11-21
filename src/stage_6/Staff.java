package stage_6;

import java.util.Scanner;

public class Staff {

	public static final String COFFEE_TYPE_PROMPT = "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:";

	public static final String ADD_WATER_PROMPT = "Write how many ml of water you want to add:";

	public static final String ADD_MILK_PROMPT = "Write how many ml of milk you want to add: ";

	public static final String ADD_BEANS_PROMPT = "Write how many grams of coffee beans you want to add:";

	public static final String ADD_CUPS_PROMPT = "Write how many disposable cups you want to add: ";

	public static final String ENOUGH_SUPPLY_PROMPT = "I have enough resources, making you a coffee!\n";

	public static final String TAKE_PROMPT = "I gave you $%d\n";

	public void fillIngredients(CoffeeMachine machine, Scanner scanner) {
		machine.setWater(machine.getWater() + fill(ADD_WATER_PROMPT, scanner));
		machine.setMilk(machine.getMilk() + fill(ADD_MILK_PROMPT, scanner));
		machine.setBeans(machine.getBeans() + fill(ADD_BEANS_PROMPT, scanner));
		machine.setCups(machine.getCups() + fill(ADD_CUPS_PROMPT, scanner));
		System.out.println();
	}

	private int fill(String prompt, Scanner scanner) {
		System.out.println(prompt);
		return Integer.parseInt(scanner.nextLine());

	}

	public void cleanMachine(CoffeeMachine machine) {
		machine.performClean();
	}

	public void takeMoney(CoffeeMachine machine) {
		System.out.printf(TAKE_PROMPT, machine.getMoney());
		machine.setMoney(0);
		System.out.println();
	}

	public boolean checkMachineSupplies(CoffeeMachine machine, CoffeeType type) {
		if (machine.getWater() < type.getWater()) {
			System.out.println("Sorry, not enough water!\n");
			return false;
		}
		else if (machine.getMilk() < type.getMilk()) {
			System.out.println("Sorry, not enough milk!\n");
			return false;
		}
		else if (machine.getBeans() < type.getBeans()) {
			System.out.println("Sorry, not enough beans!\n");
			return false;
		}
		else if (machine.getCups() < 1) {
			System.out.println("Sorry, not enough beans!\n");
			return false;
		}
		return true;
	}

}

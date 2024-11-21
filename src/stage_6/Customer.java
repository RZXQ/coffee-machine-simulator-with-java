package stage_6;

import java.util.Scanner;

public class Customer {

	public void buyCoffee(Staff staff, CoffeeMachine machine, Scanner scanner) {
		if (machine.needClean()) {
			return;
		}

		System.out.println(Staff.COFFEE_TYPE_PROMPT);
		String choiceStr = scanner.nextLine();
		if ("back".equalsIgnoreCase(choiceStr)) {
			return;
		}
		int choice = Integer.parseInt(choiceStr);
		CoffeeType type;
		switch (choice) {
			case 1 -> type = CoffeeType.ESPRESSO;
			case 2 -> type = CoffeeType.LATTE;
			case 3 -> type = CoffeeType.CAPPUCCINO;
			default -> {
				System.out.println("Invalid choice. Please try again.");
				return;
			}

		}
		if (staff.checkMachineSupplies(machine, type)) {
			System.out.println(Staff.ENOUGH_SUPPLY_PROMPT);
			machine.brewCoffee(type);
		}

	}

}

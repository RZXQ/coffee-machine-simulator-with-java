package stage_6;

import java.util.Scanner;

public class Main {

	private static final Scanner SCANNER = new Scanner(System.in);

	private static boolean isExit;

	public static void main(String[] args) {
		CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
		Staff staff = new Staff();
		Customer customer = new Customer();

		while (!isExit) {
			run(machine, staff, customer);
		}
	}

	private static void run(CoffeeMachine machine, Staff staff, Customer customer) {
		Action action = Action.getAction(SCANNER);

		switch (action) {
			case BUY -> customer.buyCoffee(staff, machine, SCANNER);
			case FILL -> staff.fillIngredients(machine,SCANNER);
			case TAKE -> staff.takeMoney(machine);
			case CLEAN -> staff.cleanMachine(machine);
			case REMAINING -> machine.showRemaining();
			case EXIT -> isExit = true;
			case null -> System.out.println("wrong input");
			default -> {
			}
		}
	}

}
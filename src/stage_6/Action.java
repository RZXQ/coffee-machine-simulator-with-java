package stage_6;

import java.util.Scanner;

public enum Action {

	BUY, FILL, TAKE, CLEAN, REMAINING, EXIT;

	private static final String ACTION_PROMPT = "Write action (buy, fill, take, clean, remaining, exit):";

	public static Action getAction(Scanner scanner) {
		Action action;

		try {
			System.out.println(ACTION_PROMPT);
			action = Action.valueOf(scanner.nextLine().toUpperCase());
			System.out.println();
		}
		catch (IllegalArgumentException e) {
			System.out.println("Invalid action. Please try again.");
			return null;
		}

		return action;
	}

}
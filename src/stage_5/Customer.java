package stage_5;

import java.util.Scanner;

public class Customer {

	public static final String PROMPT_CUPS_NEEDED = "Write how many cups of coffee you will need:";

	private static final Scanner SCANNER = new Scanner(System.in);

	private int cupsOfCoffeeNeeded;

	public void setCupsOfCoffeeNeeded() {
		System.out.println(PROMPT_CUPS_NEEDED);
		this.cupsOfCoffeeNeeded = Integer.parseInt(SCANNER.nextLine());

	}

	public int getCupsOfCoffeeNeeded() {
		return cupsOfCoffeeNeeded;
	}

}

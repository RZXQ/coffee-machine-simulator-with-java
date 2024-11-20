package stage_3;

import java.util.Scanner;

public class User {

	public static final String REQUIRED_CUPS = "Write how many cups of coffee you will need:";

	private int cupsOfCoffeeNeeded;

	public void setCupsOfCoffeeNeeded() {
		System.out.println(REQUIRED_CUPS);
		this.cupsOfCoffeeNeeded =Integer.parseInt(new Scanner(System.in).nextLine());

	}


	public int getUserRequestQuantities() {
		return cupsOfCoffeeNeeded;
	}
}

package stage_4;

import java.util.Scanner;

public class Worker {
    public static final String ADD_WATER_PROMPT = "Write how many ml of water you want to add:";
    public static final String ADD_MILK_PROMPT = "Write how many ml of milk you want to add: ";
    public static final String ADD_BEANS_PROMPT = "Write how many grams of coffee beans you want to add:";
    public static final String ADD_CUPS_PROMPT = "Write how many disposable cups you want to add: ";
    private static final Scanner SCANNER = new Scanner(System.in);
    private CoffeeMachine machine;

    public Worker(CoffeeMachine machine) {
        this.machine = machine;
    }

    public void fillIngredients() {
        this.machine.setWaterAmount(this.machine.getWaterAmount() + fill(ADD_WATER_PROMPT));
        this.machine.setMilkAmount(this.machine.getMilkAmount() + fill(ADD_MILK_PROMPT));
        this.machine.setBeansAmount(this.machine.getBeansAmount() + fill(ADD_BEANS_PROMPT));
        this.machine.setCupsAmount(this.machine.getCupsAmount() + fill(ADD_CUPS_PROMPT));
    }

    private int fill(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(SCANNER.nextLine());
    }
}

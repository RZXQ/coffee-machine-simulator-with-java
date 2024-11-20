package stage_4;

import java.util.Scanner;

public class Controller {

    private static final String INITIAL_WATER_PROMPT = "Write how many ml of water the coffee machine has:";

    private static final String INITIAL_MILK_PROMPT = "Write how many ml of milk the coffee machine has:";

    private static final String INITIAL_COFFEE_BEANS_PROMPT = "Write how many grams of coffee beans the coffee machine has:";

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String ACTION_PROMPT = "Write action (buy, fill, take):";
    private static final String COFFEE_TYPE_PROMPT = "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:";

    private CoffeeMachine coffeeMachine;

    private Customer customer;

    private Worker worker;

    public void makeCoffee() {

        setupCoffeeMachine();

        setupWorker();

        displayInfo();

        performAction();

        displayInfo();

        // setupCustomer();
        // System.out.println(coffeeMachine);

        // provideFeedback();

    }

    private void setupWorker() {
        this.worker = new Worker(this.coffeeMachine);
    }

    private void performAction() {
        System.out.println(ACTION_PROMPT);
        Action userAction = Action.valueOf(SCANNER.nextLine().toUpperCase());
        switch (userAction) {
            case BUY:
                System.out.println(COFFEE_TYPE_PROMPT);
                int choice = Integer.parseInt(SCANNER.nextLine());
                if (choice == 1) {
                    coffeeMachine.makeOneCoffee(Coffee.ESPRESSO);
                } else if (choice == 2) {
                    coffeeMachine.makeOneCoffee(Coffee.LATTE);
                } else if (choice == 3) {
                    coffeeMachine.makeOneCoffee(Coffee.CAPPUCCINO);
                }
                break;
            case FILL:
                worker.fillIngredients();
                break;


        }

        System.out.println();
    }

    private void displayInfo() {
        System.out.println(this.coffeeMachine);
    }

    private void setupCoffeeMachine() {
        // this.coffeeMachine = getCoffeeMachine();
        // this.coffeeMachine.updateMaxCupsAvailable();
        this.coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
    }

    private void setupCustomer() {
        this.customer = new Customer();
        this.customer.setCupsOfCoffeeNeeded();
    }

    public int readAmount(String prompt) {
        System.out.println(prompt);
        return Integer.parseInt(SCANNER.nextLine());
    }

    // public CoffeeMachine getCoffeeMachine() {
    // return new CoffeeMachine(readAmount(INITIAL_WATER_PROMPT),
    // readAmount(INITIAL_MILK_PROMPT),
    // readAmount(INITIAL_COFFEE_BEANS_PROMPT));
    // }

    private void provideFeedback() {
        int difference = this.coffeeMachine.getMaxCupAvailable() - this.customer.getCupsOfCoffeeNeeded();

        if (difference > 0) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)\n", difference);
        } else if (difference == 0) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("No, I can make only %d cups of coffee\n", this.coffeeMachine.getMaxCupAvailable());

        }
    }

    public enum Action {
        BUY, FILL, TAKE
    }

}
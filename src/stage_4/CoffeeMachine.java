package stage_4;

public class CoffeeMachine {

    private int maxCupsAvailable;

    private int moneyCollected;

    private int waterAmount;

    public void setMaxCupsAvailable(int maxCupsAvailable) {
        this.maxCupsAvailable = maxCupsAvailable;
    }

    public int getMaxCupsAvailable() {
        return maxCupsAvailable;
    }

    public void setMoneyCollected(int moneyCollected) {
        this.moneyCollected = moneyCollected;
    }

    public int getMoneyCollected() {
        return moneyCollected;
    }

    public int getWaterAmount() {
        return waterAmount;
    }

    public int getMilkAmount() {
        return milkAmount;
    }

    public int getBeansAmount() {
        return beansAmount;
    }

    public int getCupsAmount() {
        return disposableCups;
    }

    public void setWaterAmount(int waterAmount) {
        this.waterAmount = waterAmount;
    }

    public void setMilkAmount(int milkAmount) {
        this.milkAmount = milkAmount;
    }

    public void setBeansAmount(int beansAmount) {
        this.beansAmount = beansAmount;
    }

    public void setCupsAmount(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    private int milkAmount;

    private int beansAmount;

    private int disposableCups;

    public CoffeeMachine(int waterAmount, int milkAmount, int beansAmount, int disposableCups, int moneyCollected) {
        this.waterAmount = waterAmount;
        this.milkAmount = milkAmount;
        this.beansAmount = beansAmount;
        this.disposableCups = disposableCups;
        this.moneyCollected = moneyCollected;
    }

    public void makeOneCoffee(Coffee coffee) {
        this.waterAmount -= coffee.getWater();
        this.milkAmount -= coffee.getMilk();
        this.beansAmount -= coffee.getBeans();
        this.moneyCollected += coffee.getCost();
        this.disposableCups-=1;

    }

    @Override
    public String toString() {
        return String.format("The coffee machine has:\n" + "%d ml of water\n" + "%d ml of milk\n" + "%d g of coffee beans\n" + "%d disposable cups\n" + "$%d of money\n", waterAmount, milkAmount, beansAmount, disposableCups, moneyCollected);
    }

    public int getMaxCupAvailable() {
        return this.maxCupsAvailable;
    }

    // public void updateMaxCupsAvailable() {
    // 	int maxCupsFromWater = calculateCupsFromIngredient(this.waterAmount, WATER_PER_CUP);
    // 	int maxCupsFromMilk = calculateCupsFromIngredient(this.milkAmount, MILK_PER_CUP);
    // 	int maxCupsFromBeans = calculateCupsFromIngredient(this.beansAmount, COFFEE_BEANS_PER_CUP);
    //
    // 	this.maxCupsAvailable = Math.min(maxCupsFromWater, Math.min(maxCupsFromMilk, maxCupsFromBeans));
    // }

    // private int calculateCupsFromIngredient(int ingredientAmount, int ingredientPerCup) {
    // 	return ingredientAmount / ingredientPerCup;
    // }

}

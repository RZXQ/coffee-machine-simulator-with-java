## Work on project. Stage 6/6:Brush up your code

Project: [Coffee Machine Simulator with Java](https://hyperskill.org/projects/33)

## Brush up your code

## Description

In this stage, let's improve the design of our program by organizing it into classes that represent different parts of
the coffee machine. For instance, we can create one class for the coffee machine itself and another class to represent
each type of coffee with its ingredients and cost. This approach helps structure the code better, allowing for easier
reuse and extension. Each class should have methods that handle specific tasks, working together to process the user
input and manage the coffee machine's operations.

Your program should handle the user's input through methods in these classes. Every time the user inputs something, it
will be processed by these methods to update the state of the machine. This setup simulates how real-world machines
operate, where each part has a defined role.

As the coffee machine operates, it will keep track of its resources, including water, milk, coffee beans, disposable
cups, and the cash collected. Each action taken by the user should be processed in the context of the machine's current
state, which reflects the available resources.

Additionally, we'll introduce a new action: **cleaning**. The coffee machine will monitor how many coffees have been
made. After producing 10 cups, it will require cleaning. During this action, the machine will not be able to make any
more coffee until it is cleaned by the user typing `"clean"`. After cleaning, the machine resumes its normal operations.

Remember, that:

- For a cup of **espresso**, the coffee machine needs *250 ml* of water and *16 g* of coffee beans. It costs *$4*.
- For a **latte**, the coffee machine needs *350 ml* of water, *75 ml* of milk, and *20 g* of coffee beans. It costs *$
  7*.
- And for a **cappuccino**, the coffee machine needs *200 ml* of water, *100 ml* of milk, and *12 g* of coffee beans. It
  costs *$6*.

## Objective

Your final task is to refactor the program to ensure you can interact with the coffee machine through methods in the
classes you created. Implement the **cleaning** action, where the machine requires cleaning after 10 cups of coffee are
made. Once cleaned, the machine can make coffee again.

**Note:** Your coffee machine should start with the same initial resources: *400 ml* of water, *540 ml*of milk, *120 g*
of coffee beans, *9* disposable cups, *$550* in cash.

## Example

The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

```no-highlight
Write action (buy, fill, take, clean, remaining, exit):
> remaining

The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$550 of money

Write action (buy, fill, take, clean, remaining, exit):
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 2
I have enough resources, making you a coffee!

Write action (buy, fill, take, clean, remaining, exit):
> remaining

The coffee machine has:
50 ml of water
465 ml of milk
100 g of coffee beans
8 disposable cups
$557 of money

Write action (buy, fill, take, clean, remaining, exit):
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 2
Sorry, not enough water!

Write action (buy, fill, take, clean, remaining, exit):
> fill

Write how many ml of water you want to add:
> 1000
Write how many ml of milk you want to add:
> 0
Write how many grams of coffee beans you want to add:
> 0
Write how many disposable cups you want to add:
> 0

Write action (buy, fill, take, clean, remaining, exit):
> remaining

The coffee machine has:
1050 ml of water
465 ml of milk
100 g of coffee beans
8 disposable cups
$557 of money

Write action (buy, fill, take, clean, remaining, exit):
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
> 2
I have enough resources, making you a coffee!

Write action (buy, fill, take, clean, remaining, exit):
> remaining

The coffee machine has:
700 ml of water
390 ml of milk
80 g of coffee beans
7 disposable cups
$564 of money

Write action (buy, fill, take, clean, remaining, exit):
> take

I gave you $564

Write action (buy, fill, take, clean, remaining, exit):
> remaining

The coffee machine has:
700 ml of water
390 ml of milk
80 g of coffee beans
7 disposable cups
$0 of money
```

*(After 10 cups of coffee have been made)*

```no-highlight
Write action (buy, fill, take, clean, remaining, exit):
> buy
I need cleaning!

Write action (buy, fill, take, clean, remaining, exit):
> clean
I have been cleaned!

Write action (buy, fill, take, clean, remaining, exit):
> exit
```
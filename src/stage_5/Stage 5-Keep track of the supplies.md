## Work on project. Stage 5/6:Keep track of the supplies

Project: [Coffee Machine Simulator with Java](https://hyperskill.org/projects/33)

## Keep track of the supplies

## Description

Handling only a single action at a time is quite limited, so let's improve the program to handle multiple actions, one after another. The program should repeatedly ask a user what they want to do. If the user types `"buy"`, `"fill"` or `"take"`, then the program should behave exactly as it did in the previous stage. But unlike the previous stage, where the state of the coffee machine was displayed before and after each action (`"buy"`, `"fill"` or `"take"`), the state of the coffee machine should now be shown only when the user types `"remaining"`. Additionally, if the user wants to switch off the coffee machine, they should type `"exit"` to stop the program. In total, the program should now five actions: `"buy"`, `"fill"`, `"take"`, `"remaining"`, and `"exit"`.

Remember, that:

- For a cup of **espresso**, the coffee machine needs *250 ml* of water and *16 g* of coffee beans. It costs *$4*.
- For a **latte**, the coffee machine needs *350 ml* of water, *75 ml* of milk, and *20 g* of coffee beans. It costs *$7*.
- And for a **cappuccino**, the coffee machine needs *200 ml* of water, *100 ml* of milk, and *12 g* of coffee beans. It costs *$6*.

## Objectives

Write a program that continuously processes user actions until the `"exit"` command is given. Additionally, introduce two new options:

- `"remaining"`: to display the current state of the coffee machine
- `"exit"`: to switch off the coffee machine

Remember, the coffee machine can run out of resources. If it doesn't have enough resources to make coffee, the program should output a message that says it can't make a cup of coffee and indicate which resource is missing.

And the last improvement to the program in this stage — if the user types `"buy"` to buy a cup of coffee but then changes their mind, they should be able to type `"back"` to return into the main menu.



**Note:**

1. Your coffee machine should start with the same initial resources: *400 ml* of water, *540 ml* of milk, *120 g* of coffee beans, *9* disposable cups, *$550* in cash.
2. The program should loop indefinitely, processing actions until the user types `"exit"` to switch off the coffee machine.

## Example

The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

```no-highlight
Write action (buy, fill, take, remaining, exit): 
> remaining

The coffee machine has:
400 ml of water
540 ml of milk
120 g of coffee beans
9 disposable cups
$550 of money

Write action (buy, fill, take, remaining, exit): 
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: 
> 2
I have enough resources, making you a coffee!

Write action (buy, fill, take, remaining, exit): 
> remaining

The coffee machine has:
50 ml of water
465 ml of milk
100 g of coffee beans
8 disposable cups
$557 of money

Write action (buy, fill, take, remaining, exit): 
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: 
> 2
Sorry, not enough water!

Write action (buy, fill, take, remaining, exit): 
> fill

Write how many ml of water you want to add: 
> 1000
Write how many ml of milk you want to add: 
> 0
Write how many grams of coffee beans you want to add: 
> 0
Write how many disposable cups you want to add: 
> 0

Write action (buy, fill, take, remaining, exit): 
> remaining

The coffee machine has:
1050 ml of water
465 ml of milk
100 g of coffee beans
8 disposable cups
$557 of money

Write action (buy, fill, take, remaining, exit): 
> buy

What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: 
> 2
I have enough resources, making you a coffee!

Write action (buy, fill, take, remaining, exit): 
> remaining

The coffee machine has:
700 ml of water
390 ml of milk
80 g of coffee beans
7 disposable cups
$564 of money

Write action (buy, fill, take, remaining, exit): 
> take

I gave you $564

Write action (buy, fill, take, remaining, exit): 
> remaining

The coffee machine has:
700 ml of water
390 ml of milk
80 g of coffee beans
7 disposable cups
$0 of money

Write action (buy, fill, take, remaining, exit): 
> exit
```
## Work on project. Stage 3/6:Estimate the number of servings

Project: [Coffee Machine Simulator with Java](https://hyperskill.org/projects/33)

## Estimate the number of servings

## Description

A real coffee machine doesn't have an infinite supply of water, milk, or coffee beans. If you request too many cups of coffee, it's almost certain that a real coffee machine wouldn't have enough supplies to fulfill the order.

In this stage, you need to improve the previous stage program. Now you will check amounts of water, milk, and coffee beans available in the coffee machine at the moment.

## Objectives

Write a program that does the following:

1. Requests the amounts of water, milk, and coffee beans available at the moment, and then asks for the number of cups of coffee a user needs.
2. If the coffee machine has enough supplies to make the specified amount of coffee, the program should print `"Yes, I can make that amount of coffee"`.
3. If the coffee machine can make more than the requested amount, the program should output `"Yes, I can make that amount of coffee (and even N more than that)"`, where *N* is the number of additional cups of coffee that the coffee machine can make.
4. If the available resources are insufficient to make the requested amount of coffee, the program should output `"No, I can make only N cup(s) of coffee"`.

Like in the previous stage, the coffee machine needs *200 ml* of water, *50 ml* of milk, and *15 g* of coffee beans to make one cup of coffee.



**Note:** As you work through each stage of the project, please ensure to remove any code from previous stages that is no longer needed. Keeping your code clean and focused on the specific objectives of each stage will enhance clarity and improve the overall structure of your project.

As you work through this project, each stage focuses on specific programming concepts, which may create a sense of disconnection. This approach is intentional, allowing you to build your skills gradually without overwhelming complexity. By completing each stage independently, you reinforce individual skills that will be integrated into a cohesive project later.

## Examples

The greater-than symbol followed by a space (`> `) represents the user input. Note that it's not part of the input.

**Example 1:**

```no-highlight
Write how many ml of water the coffee machine has:
> 300
Write how many ml of milk the coffee machine has:
> 65
Write how many grams of coffee beans the coffee machine has:
> 100
Write how many cups of coffee you will need:
> 1
Yes, I can make that amount of coffee
```

**Example 2:**

```no-highlight
Write how many ml of water the coffee machine has:
> 500
Write how many ml of milk the coffee machine has:
> 250
Write how many grams of coffee beans the coffee machine has:
> 200
Write how many cups of coffee you will need:
> 10
No, I can make only 2 cup(s) of coffee
```

**Example 3:**

```no-highlight
Write how many ml of water the coffee machine has:
> 1550
Write how many ml of milk the coffee machine has:
> 299
Write how many grams of coffee beans the coffee machine has:
> 300
Write how many cups of coffee you will need:
> 3
Yes, I can make that amount of coffee (and even 2 more than that)
```

**Example 4:**

```no-highlight
Write how many ml of water the coffee machine has:
> 0
Write how many ml of milk the coffee machine has:
> 0
Write how many grams of coffee beans the coffee machine has:
> 0
Write how many cups of coffee you will need:
> 1
No, I can make only 0 cup(s) of coffee
```

**Example 5:**

```no-highlight
Write how many ml of water the coffee machine has:
> 0
Write how many ml of milk the coffee machine has:
> 0
Write how many grams of coffee beans the coffee machine has:
> 0
Write how many cups of coffee you will need:
> 0
Yes, I can make that amount of coffee 
```
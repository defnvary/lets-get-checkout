
Let's Get Takeout!

Hope you’re hungry! Using the collections framework, generics, and the rest of your knowledge of Java we’ll create a take-out system. We’ll define classes, interfaces, and methods (generic and non-generic) needed to represent our system and perform our take-out logic with the help of Java collections.
Tasks
14/21 complete
Mark the tasks as complete by checking them off
Core Data Types

1.

Let’s start by creating a class that will represent a customer in the take-out system.

In Customer.java, create a Customer class with the following private fields:

    A String called name.
    An int called money.

Be sure to create public getters and setters for all fields and a constructor with name and money parameters that initializes their field counterparts.
2.

Next, let’s create an interface that will represent an item in our take-out system that has a numeric price.

In PricedItem.java, create a PricedItem interface with a T type parameter that is upper bounded by Number. Define the abstract methods:

    getPrice() with a T return type and no parameters.
    setPrice() that returns no value and has a T type parameter called price.

3.

Let’s create another class that will represent a priced food item in our take-out system.

In Food.java, create a Food class that implements an Integer type PricedItem with the following private fields:

    A String called name.
    A String called description.
    An int called price.

Be sure to create a constructor with name, description, and price parameters that initialize their field counterparts.
4.

Let’s complete Food by overriding and implementing a couple of methods.

In Food.java, Override and implement the abstract methods setPrice() and getPrice() of PricedItem. Also, Override toString() to provide a description of a Food object that will be displayed on our menu.

An example Food description would look like:

Enjoy Tacos: Yummy steak tacos    Cost: $15

Copy to Clipboard

Shopping Bag!

5.

To “take” our take-out food home we need a shopping bag.

In ShoppingBag.java, create a generic ShoppingBag class with a T type parameter upper bounded by an Integer type PricedItem.

In ShoppingBag, create a private field called shoppingBag, which is a Map of T to an Integer. Also, create a no-argument constructor that initializes shoppingBag to an empty HashMap.
6.

We’re now able to create ShoppingBag objects, but we need to add items to our bag and keep track of how many of each item we have.

In ShoppingBag, create a method called addItem() that accepts a T type parameter called item, and doesn’t have a return value.

Inside addItem(), if item already exists in shoppingBag, increment its value by 1. If item does not exist in shoppingBag, map item to a value of 1.
7.

When it’s time to pay for our take-out, we need to be able to get the total price of all the items in the shopping bag.

Inside getTotalPrice(), calculate the total price of each item by iterating through the items in shoppingBag and multiplying each item‘s quantity by its price. Sum up all of the total prices to find the grand total of everything in shoppingBag. Return the grand total.

Menu

8.

For us to buy some food, we need to first see a menu. Let’s create one!

In FoodMenu.java, create a FoodMenu class with a private field called menu which is a List of Food. Create a no-argument constructor that initializes menu with some Food objects (try creating 3).
9.

We’ll need to be able to display our menu to customers. Let’s do that by implementing a custom toString() method.

In FoodMenu.java, Override toString() to return a String that contains all Food objects in menu where each Food object has an identifying integer index so customers can easily order food.

An example toString() method would return a String that looks like this:

1. Enjoy Tacos: Yummy steak tacos    Cost: $15
2. Enjoy Dumplings: Delicious steamed dumplings    Cost: 10
3. Ramen: Hot pork ramen    Cost: 12

Copy to Clipboard

10.

When customers use our menu, they’ll need to pick a food item using its item number.

In FoodMenu, create a method called getFood() with an int parameter called index and a Food return type. This method should attempt to get the Food object at index in menu and return it or return null if index is out of bounds.

Note that a List has 0-based indexing but our menu item numbers will start from 1.
11.

When using our menu, we’ll often want to quickly know what the lowest cost food item is to get the best bang for our buck.

In FoodMenu, create a method called getLowestCostFood() with no parameters and a return type of Food. This method should return the Food object in menu with the lowest price.

Simulation Plumbing

12.

We’ll need to be able to take in user input in our take-out system for customers to order food. We’ll be working with an int type user input to drive various prompts in our take-out system. Let’s create a generic user input method to keep our code DRY and reusable.

In UserInputRetriever.java, create a generic interface called UserInputRetriever with a T type parameter. UserInputRetriever should define an abstract method produceOutput() which has a single int type parameter called selection, returns a T type object, and may throw an IllegalArgumentException if selection is not valid.
13.

Let’s create the take-out system that will be able to get user input, allow customers to add food to their bags, and checkout when they are ready (or are out of money).

In TakeOutSimulator.java, create a TakeOutSimulator class with the following private fields:

    Customer type called customer.
    FoodMenu type called menu.
    Scanner type called input.

Create a constructor that initializes customer, menu, and input.
14.

We’ll need to be able to prompt users for their input in various places to use the take-out system. Let’s create a generic method that will prompt users for an int input and perform some operation on it.

In TakeOutSimulator, create a generic private method called getResponse() that has a String parameter called userInputPrompt, a UserInputRetriever parameter called userInputRetriever, and returns a T type reference.

In getResponse(), create an infinite loop that performs the following tasks:

    Display userInputPrompt.
    Get the user input. If an int was provided, retrieve it and attempt to call produceOutput from userInputRetriever with the retrieved int user input as an argument and return the result.
    If an IllegalArgumentException was caught calling produceOutput(), display a message telling the user their int input was not valid.
    If the user did not provide an int type, display a message telling the user that input needs to be an integer and try to obtain the next integer from the input.

Example prompts look like this:

5 is not a valid input. Try Again!

Copy to Clipboard

Input needs to be an `int` type.

Copy to Clipboard

Customer Prompts

15.

Let’s create a way for users to exit the take-out system gracefully.

In TakeOutSimulator, create a method called shouldSimulate() that accepts no parameters and returns a boolean value. In this method:

    Create a String called userPrompt that contains a message to prompt users for an input of 1 (proceed with simulation) or 0 (stop simulation).
    Create an implementation of UserInputRetreiver that returns true if selection is 1 and the customer has enough money to buy the lowest cost food item and false if selection is 0 or the customer does not have enough money. This method should throw an IllegalArgumentException if selection is not 0 or 1.
    Call getResponse() and pass in userPrompt and the created implementation of UserInputRetriever.

Example prompts look like this:

Enter 1 to CONTINUE simulation or 0 to EXIT program: 1
You don't have enough money to continue shopping :( - ending simulation...

Copy to Clipboard

Recall that you can use System.out.printf() or String.format() to create formatted Strings.

Recall that we can use a lambda function to provide an implementation of an interface without needed to create a new class or anonymous class. Example:

// Using an anonymous class to implement SomeInterface
SomeClass someClass = new SomeClass(new SomeInterface(){
  @Override
  public int addFunction (int a, int b){
    return a + b
  }
});

Copy to Clipboard

// Using a lambda function to implement the above functionality
SomeClass someClass = new SomeClass((a,b) -> a + b);

Copy to Clipboard

Recall that we can use getLowestCostFood() in menu to get the Food object with the lowest price in menu.
16.

Let’s create a way for the take-out system to retrieve a user menu selection.

In TakeOutSimulator, create a method called getMenuSelection() that accepts no parameters and returns a Food object. In this method:

    Create a String called userPrompt that contains a message to prompt users for an int input of one of the food items displayed by menu.
    Create an implementation of UserInputRetreiver that gets the food item using selection from menu and returns it if it’s not null. This implementation should throw an IllegalArgumentException if the returned value from menu is null.
    Call getResponse() while passing in userPrompt and the created implementation of UserInputRetriever.

An example prompt looks like this:

Today's Menu Options!

1. Enjoy Tacos: Yummy steak tacos    Cost: $15
2. Enjoy Dumplings: Delicious steamed dumplings    Cost: 10
3. Ramen: Hot pork ramen    Cost: 12
Choose a menu item!: 1

Copy to Clipboard

17.

Let’s create a way to notify the take-out system that a user is ready to checkout.

In TakeOutSimulator, create a method called isStillOrderingFood() that accepts no parameters and returns a boolean value. In this method:

    Create a String called userPrompt that contains a message to prompt users for an input of 1 (continue shopping) or 0 (checkout).
    Create an implementation of UserInputRetreiver that returns true if selection is 1 and false if selection is 0. This method should throw an IllegalArgumentException if selection is not 0 or 1.
    Call getResponse() while passing in userPrompt and the created implementation of UserInputRetriever.

Example prompts look like this:

Enter 1 to CONTINUE shopping or 0 to CHECKOUT: 1

Copy to Clipboard

Ordering Food

18.

Once the customer is finished ordering, we’ll need a way to process their payment.

In TakeOutSimulator, create a method called checkoutCustomer() with a single Food type ShoppingBag parameter called shoppingBag that returns no value. This method should:

    Inform the customer that payment is processing.
    Calculate the customers remaining money after paying for the total cost of Food in shoppingBag.
    Update customer’s money with their remaining money.
    Inform the customer of the updated money they have left.
    Display a friendly message telling our customer to enjoy their meal.

Example messages look like this:

Processing payment...
Your remaining money: $25
Thank you and enjoy your food!

Copy to Clipboard

19.

Let’s create an entry point for the take-out system.

In TakeOutSimulator, create a method called takeOutPrompt() with no parameters and no return value. In this method, create an instance of ShoppingBag of type Food called shoppingBag and a variable to keep track of the customer’s money called customerMoneyLeft. After that, create a loop that performs the following tasks and stops upon user checkout:

    Display a message telling the customer how much money they have left.
    Prompt the user for a menu selection and store the selected Food object.
    Check if the user has enough money left to purchase the selected Food object. If they do, subtract its value from customerMoneyLeft and add it to shoppingBag.
    If the user does not have enough money, display a message telling the user they don’t have enough money and they should pick another item or checkout.
    Ask the user if they are still ordering food.

Once the customer is done ordering food checkout the customer.

Example prompt looks like this:

You have $10 left to spend

Today's Menu Options!

1. Enjoy Tacos: Yummy steak tacos    Cost: $15
2. Enjoy Dumplings: Delicious steamed dumplings    Cost: 10
3. Ramen: Hot pork ramen    Cost: 12
Choose a menu item!: 1

Oops! Looks like you don't have enough for that. Choose another item or checkout.

Copy to Clipboard

20.

Let’s create a way for the take-out system to start it’s dialogue so customers can order food.

In TakeOutSimulator, create a public method called startTakeOutSimulator() that has no parameters and returns no value. This method should display a fun intro message to the customer and loop until the customer wants to exit the simulation.

In each iteration, display the customer greeting and start the take-out prompt.

Example intro and greeting message:

Hello, welcome to my restaurant!

Welcome Mike!

Copy to Clipboard

Let's get some food!

21.

Let’s start up the simulator so we can get some food!

In main() from Main.java, create an instance of scanner called input. Use input to get a String from the user and store it in customerName. Let’s also try and get an integer amount of starting money and store it in an int called money (if a valid integer isn’t provided, display a message).

Let’s instantiate a Customer with customerName and money as arguments and store it in variable called customer. Let’s also create an instance of TakeOutSimulator called takeOutSimulator passing customer and input as arguments.

We can now start our simulation by calling startTakeOutSimulator() from the takeOutSimulator object.

In the terminal, compile and run the code using:

javac Main.java
java Main

Copy to Clipboard

Enjoy the food!

Feedback
How did this project go?
Code Editor
Open file navigation
Close Main.java
Close TakeOutSimulator.java
Close Food.java
Close Customer.java
Close FoodMenu.java
Close ShoppingBag.java
Close UserInputRetriever.java
Close PricedItem.java
Enter Fullscreen Code Editor
1
2
3
4
5
6
7
8
9
Terminal
Add new terminal
Close bash session
Enter Fullscreen Terminal
14/21 complete

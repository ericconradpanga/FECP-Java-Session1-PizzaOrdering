package org.example;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in); // create scanner object for user input

    public static void main(String[] args) {
        ArrayList<String> pizzaTypes = new ArrayList<>(); // create array list to store pizza types
        ArrayList<Integer> pizzaQuantities = new ArrayList<>(); // create array list to store pizza quantities

        String pizzaType;
        int pizzaQuantity;
        int pizzaIndex;

        int userChoice = 0;
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Order");
        System.out.println("5. Exit");

        // repeatedly prompt for user input unless user chooses to exit
        while (userChoice != 5) {
            System.out.print("Choose option: ");
            userChoice = scanner.nextInt();

            switch (userChoice){
                // add order functionality
                case 1:
                    System.out.print("Pizza type: ");
                    pizzaType = scanner.next(); // get type of pizza to add from user
                    System.out.print("Quantity: ");
                    pizzaQuantity = scanner.nextInt(); // get quantity of pizza to add from user
                    System.out.println();

                    pizzaQuantity = validateQuantity(pizzaQuantity); // validate if quantity is positive
                    addOrder(pizzaTypes, pizzaQuantities, pizzaType, pizzaQuantity);
                    break;

                // update order functionality
                case 2:
                    System.out.print("Order number to update: ");
                    pizzaIndex = scanner.nextInt(); // get index of pizza to update from user
                    System.out.print("New quantity: ");
                    pizzaQuantity = scanner.nextInt(); // get new quantity value from user
                    System.out.println();

                    pizzaQuantity = validateQuantity(pizzaQuantity); // validate is quantity is positive
                    updateOrder(pizzaQuantities, pizzaIndex - 1, pizzaQuantity);
                    break;

                // remove order functionality
                case 3:
                    System.out.print("Order number to remove: ");
                    pizzaIndex = scanner.nextInt(); // get index of pizza to remove from user

                    removeOrder(pizzaTypes, pizzaQuantities, pizzaIndex - 1);
                    break;

                // view orders functionality
                case 4:
                    printOrders(pizzaTypes, pizzaQuantities);
                    break;

                default:
                    break;
            }
        }

        System.out.println("---Thank you!---");
    }

    // method to validate if quantity is positive
    public static int validateQuantity(int pizzaQuantity) {
        // if value is negative, will repeatedly prompt user for new quantity
        while(pizzaQuantity <= 0){
            System.out.println("Quantity must be positive.");
            System.out.print("Quantity: ");
            pizzaQuantity = scanner.nextInt();
            System.out.println();
        }

        return pizzaQuantity;
    }

    // method to add pizza order (type and quantity)
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int pizzaQuantity) {
        // will only add order if quantity is positive
        if (pizzaQuantity > 0){
            pizzas.add(pizzaType);
            quantities.add(pizzaQuantity);
        }
    }

    // method to update quantity of specific pizza order
    public static void updateOrder(ArrayList<Integer> quantities, int pizzaIndex, int newQuantity) {
        // will only add order if index of pizza to update exists and quantity is positive
        if (!(pizzaIndex >= quantities.size() || pizzaIndex < 0) && newQuantity > 0) {
            quantities.set(pizzaIndex, newQuantity);
        }
    }

    // method to remove specific pizza order
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int pizzaIndex) {
        // will only remove if index of pizza to remove exists
        if (!(pizzaIndex >= quantities.size() || pizzaIndex < 0)) {
            pizzas.remove(pizzaIndex);
            quantities.remove(pizzaIndex);
        }
    }

    // method to print all pizza orders
    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities) {
        System.out.println("\n--- Current Orders ---");
        for (int i = 0; i < pizzas.size(); i++){
            System.out.printf("%d. " + pizzas.get(i) + " x " + quantities.get(i) + "\n", i + 1);
        }
        System.out.println();
    }
}
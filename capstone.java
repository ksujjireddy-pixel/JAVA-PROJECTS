import java.util.*;

public class capstone {

    static class Item {
        String name;
        int price;
        Item(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner obj1 = new Scanner(System.in);

        Item[] menu = {
            new Item("KitKat", 30),
            new Item("Diet Coke", 40),
            new Item("Chocolate", 40),
            new Item("Chips", 20)
        };

        System.out.println("WELCOME TO THE VENDING MACHINE");
        displayMenu(menu);

        List<Item> cart = new ArrayList<>();
        while (true) {
            System.out.print("\nEnter choice (0-3) or 4 to finish: ");
            int choice = obj1.nextInt();

            if (choice >= 0 && choice < menu.length) {
                cart.add(menu[choice]);
                System.out.println("Added " + menu[choice].name + " to cart");
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
        int total = calculateTotal(cart);
        System.out.println("YOUR BILL IS rs-" + total);

        processPayment(obj1, total);
        System.out.println("THANK YOU FOR SHOPPING!");
        obj1.close();
    }

    static void displayMenu(Item[] menu) {
        System.out.println("\nAVAILABLE MERCHANDISE:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ") " + menu[i].name + " - rs-" + menu[i].price);
        }
        System.out.println("4) Finish");
    }

    static int calculateTotal(List<Item> cart) {
        int total = 0;
        for (Item item : cart) total += item.price;
        if (total >= 100) {
            total -= 10;
            System.out.println("10rs/- discount applied!");
        }
        return total;
    }

    static void processPayment(Scanner obj1, int total) {
        System.out.print("Enter amount paid: ");
        int paid = obj1.nextInt();

        if (paid == total) {
            System.out.println("Payment completed. Collect your merchandise.");
        } else if (paid > total) {
            System.out.println("Payment completed. Balance rs-" + (paid - total) + " credited.");
        } else {
            System.out.println("Invalid payment. Money credited back.");
            System.out.print("Press 0 to exit: ");
            if (obj1.nextInt() == 0) System.out.println("You chose to exit.");
        }
    }
}
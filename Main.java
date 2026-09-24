package Src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Medicine> medicines = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n=== Pharmacy Inventory ===");
            System.out.println("1. Add Medicine");
            System.out.println("2. View Medicines");
            System.out.println("3. Search Medicine");
            System.out.println("4. Update Quantity");
            System.out.println("5. Delete Medicine");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                System.out.print("Enter medicine name: ");
                String name = scanner.nextLine();

                System.out.print("Enter price: ");
                double price = scanner.nextDouble();

                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();

                Medicine medicine =
                        new Medicine(name, price, quantity);

                medicines.add(medicine);

                System.out.println("Medicine added.");

            } else if (choice == 2) {

                if (medicines.isEmpty()) {
                    System.out.println("No medicines in inventory.");
                } else {

                    for (Medicine medicine : medicines) {
                        medicine.displayMedicine();
                    }
                }

            } else if (choice == 3) {

                System.out.print("Enter medicine name: ");
                String searchName = scanner.nextLine();

                boolean found = false;

                for (Medicine medicine : medicines) {

                    if (medicine.name.equalsIgnoreCase(searchName)) {

                        medicine.displayMedicine();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Medicine not found.");
                }

            } else if (choice == 4) {

                System.out.print("Enter medicine name: ");
                String updateName = scanner.nextLine();

                boolean found = false;

                for (Medicine medicine : medicines) {

                    if (medicine.name.equalsIgnoreCase(updateName)) {

                        System.out.print("Enter new quantity: ");
                        medicine.quantity = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Quantity updated.");

                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Medicine not found.");
                }

            } else if (choice == 5) {

                System.out.print("Enter medicine name: ");
                String deleteName = scanner.nextLine();

                Medicine medicineToDelete = null;

                for (Medicine medicine : medicines) {

                    if (medicine.name.equalsIgnoreCase(deleteName)) {

                        medicineToDelete = medicine;
                        break;
                    }
                }

                if (medicineToDelete != null) {

                    medicines.remove(medicineToDelete);

                    System.out.println("Medicine deleted.");

                } else {

                    System.out.println("Medicine not found.");
                }

            } else if (choice == 6) {

                System.out.println("Program closed.");

            } else {

                System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        scanner.close();
    }
}

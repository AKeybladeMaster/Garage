package esGarage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		GarageManager obj = new GarageManager();

		int menu_choice = 0;
		System.out.println("Welcome to the garage! Choose what to do:");
		do {
			try {
				System.out.println("\n0. End the program." + "\n1. Add a vehicle" + "\n2. Print the list of vehicles"
						+ "\n3. Take a vehicle from the garage" + "\n4. Find out which slot is free or occupied");
				menu_choice = sc.nextInt();
				sc.nextLine();

				switch (menu_choice) {
				case 0:
					System.out.println("Program terminated.");
					System.exit(0);
					break;
				case 1:
					if (obj.addIntoSlot())
						System.out.println("Vehicle added successfully!");
					else
						System.out.println("No vehicle added.");
					break;

				case 2:
					obj.showAllVehicles();
					System.out.println("");
					break;

				case 3:
					if (obj.takeFromSlot())
						System.out.println("Vehicle taken successfully!");
					else
						System.out.println("No vehicle taken.");
					break;
				case 4:
					obj.printGarageSlots();
					break;
				default:
					System.out.println("Wrong number. Try again.");
					System.out.println("");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Incorrect input. Shutting down the program.");
			}
		} while (menu_choice != 0);
		sc.close();
	}

}

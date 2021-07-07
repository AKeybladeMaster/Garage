package esGarage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GarageManager {
	String license_plate, brand, type_of_fuel;
	int sub_choice, slot, year_of_matriculation, displacement, number_of_doors, n_stroke_engine, max_capacity;
	static int slots_available = 15;
	Scanner sc = new Scanner(System.in);
	ArrayList<Vehicle> list_of_vehicles;

	public GarageManager() {
		list_of_vehicles = new ArrayList<Vehicle>();
		for (int i = 0; i < 15; i++) {
			list_of_vehicles.add(null);
		}
	}

	public boolean addIntoSlot() {
		try {
			Vehicle v = createVehicle();
			if (v == null) {
				return false;
			} else {
				System.out.print("Do you want to choose where to add your vehicle? (y/n) ");
				if (sc.nextLine().equalsIgnoreCase("y")) {
					printGarageSlots();
					System.out.print("\nType a number from 1 to 15 \nto add a vehicle in the chosen slot: ");
					slot = sc.nextInt();
					sc.nextLine();

					if ((slot >= 1) && (slot <= 15)) {
						if (list_of_vehicles.get(slot - 1) == null) {
							list_of_vehicles.set(slot - 1, v);
							slots_available--;
							return true;
						}
						System.out.println("Slot already taken!");
						return false;
					} else
						throw new InputMismatchException();
				} else {
					for (int i = 0; i < list_of_vehicles.size(); i++) {
						if (list_of_vehicles.get(i) == null) {
							list_of_vehicles.set(i, v);
							slots_available--;
							return true;
						}
					}
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input! Returning to the start...");
		}
		return false;
	}

	private Vehicle createVehicle() {
		try {
			if (slots_available == 0) {
				System.out.println("We're full, you can't add a new vehicle!");
			} else {
				System.out.println("Which vehicle do you want to add?" + "\n1. Car" + "\n2. Motorbike" + "\n3. Van");
				sub_choice = sc.nextInt();
				sc.nextLine();

				if (sub_choice != 1 || sub_choice != 2 || sub_choice != 3)
					// throw new InputMismatchException();
					System.out.print("Type the license plate: ");
				license_plate = sc.nextLine().toUpperCase();
				if (vehicleExists(license_plate)) {
					System.out.println("A vehicle with that license plate exists already!");
					return null;
				}
				System.out.print("Type the brand: ");
				brand = sc.nextLine();
				System.out.print("Type the year of matriculation (number): ");
				year_of_matriculation = sc.nextInt();
				sc.nextLine();
				System.out.print("Type the displacement (number): ");
				displacement = sc.nextInt();
				sc.nextLine();

				if (sub_choice == 1) {
					System.out.print("Type the number of doors: ");
					number_of_doors = sc.nextInt();
					sc.nextLine();
					System.out.print("Write the type of fuel (ex. Diesel): ");
					type_of_fuel = sc.nextLine();
					return new Car(license_plate, brand, year_of_matriculation, displacement, number_of_doors,
							type_of_fuel);
				} else if (sub_choice == 2) {
					System.out.print("Type how many strokes the engine got (ex. 2/4): ");
					n_stroke_engine = sc.nextInt();
					sc.nextLine();
					return new Motorbike(license_plate, brand, year_of_matriculation, displacement, n_stroke_engine);
				} else {
					System.out.print("Type the van capacity in quintals (number): ");
					max_capacity = sc.nextInt();
					sc.nextLine();
					return new Van(license_plate, brand, year_of_matriculation, displacement, max_capacity);
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input! Returning to the start...");
		}
		return null;
	}

	private boolean vehicleExists(String license_plate) {
		for (int i = 0; i < list_of_vehicles.size(); i++) {
			if (list_of_vehicles.get(i) != null && list_of_vehicles.get(i).getLicense_plate().equals(license_plate))
				return true;
		}
		return false;
	}

	public void showAllVehicles() {
		if (slots_available == 15)
			System.out.print("There's no vehicles! Add some first!");
		else {
			System.out.println("Here's the list of vehicles: ");
			for (int i = 0; i < list_of_vehicles.size(); i++) {
				if (list_of_vehicles.get(i) != null) {
					System.out.println(list_of_vehicles.get(i));
				}
			}
		}
	}

	public boolean takeFromSlot() {
		try {
			if (slots_available == 15)
				System.out.print("There's no vehicles! ");
			else {
				printGarageSlots();
				System.out.print("\nType a number from 1 to 15 \nto take a vehicle from the chosen slot: ");
				slot = sc.nextInt();
				sc.nextLine();
				if (list_of_vehicles.get(slot - 1) != null) {
					System.out.println("Here's the vehicle info: \n" + list_of_vehicles.get(slot - 1));
					list_of_vehicles.set(slot - 1, null);
					slots_available++;
					return true;
				}
				System.out.println("The slot is free!");
			}
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input! Returning to the start...");
		}
		return false;
	}

	public void printGarageSlots() {
		for (int i = 0; i < list_of_vehicles.size(); i++) {
			System.out.print("Slot " + (i + 1) + " - ");
			if (list_of_vehicles.get(i) != (null)) {
				System.out.println("Taken by " + list_of_vehicles.get(i));
			} else {
				System.out.println("Free");
			}
		}
	}
}

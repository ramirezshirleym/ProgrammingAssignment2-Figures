/*
 * Programming Fundamentals
 * Summer 2020 - 2
 * Name: Shirley Ramirez
 * PROGRAMMING ASSIGNMENT 2
 */

import java.util.Arrays;
import java.util.Scanner;

public class Figures {

	public static void main(String[] args) {
		// Assignment Header
		System.out.println("Programming Fundamentas");
		System.out.println("NAME: Shirley Ramirez");
		System.out.println("PROGRAMMING ASSIGNMENT 2");
		System.out.println();

		// Create Scanner object to read in user input
		Scanner scan = new Scanner(System.in);

		int size, menuSelect;
		boolean hasNotQuit = true;

		System.out.print("Enter the size of the figure (odd number): ");
		size = scan.nextInt();

		// Confirm input is odd number
		while (size % 2 == 0) {
			System.out.println("Invalid figure size - must be an odd number");
			System.out.println();
			System.out.print("Re-enter the size of the figure: ");
			size = scan.nextInt();

		}

		// Call method based on menu option selection
		while (hasNotQuit == true) {
			printMenu();
			menuSelect = scan.nextInt();
			System.out.println();

			// printBox
			if (menuSelect == 1) {
				printBox(size);
			}

			// printDiamond
			if (menuSelect == 2) {
				printDiamond(size);
			}

			// printX
			if (menuSelect == 3) {
				printX(size);
			}

			// End Program
			if (menuSelect == 4) {
				hasNotQuit = false;
				System.out.println("Good bye!");
			}

		}

		// Close scanner object
		scan.close();

	}

	// Define printMenu method
	private static void printMenu() {
		System.out.println();
		System.out.println("MENU");
		System.out.println("1. Print box");
		System.out.println("2. Print diamond");
		System.out.println("3. Print X");
		System.out.println("4. Quit program");
		System.out.println();
		System.out.print("Please select an option: ");
	}

	// Define printBox method
	public static void printBox(int size) {
		for (int row = 1; row <= size; row++) {
			for (int col = 1; col <= size; col++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}

	// Define printDiamond method
	public static void printDiamond(int size) {
		int arrayLen = (size + 1) / 2;
		int leftIndex, rightIndex;
		String[] leftHalf = new String[arrayLen];
		String[] rightHalf = new String[arrayLen];

		for (int rowCount = 1; rowCount <= size; rowCount++) {
			Arrays.fill(leftHalf, " ");
			Arrays.fill(rightHalf, " ");

			leftIndex = Math.abs(arrayLen - rowCount);
			leftHalf[leftIndex] = "X";

			rightIndex = Math.abs(leftIndex - arrayLen + 1);
			rightHalf[rightIndex] = "X";

			String leftJoined = String.join("", leftHalf);
			String rightJoined = String.join("", rightHalf);

			System.out.println(leftJoined + rightJoined);

		}
	}

	// Define printX method
	public static void printX(int size) {
		String[] line = new String[size];
		int maxIndex = size - 1;

		for (int rowIndex = 0; rowIndex < size; rowIndex++) {
			Arrays.fill(line, " ");
			line[rowIndex] = "X";
			line[maxIndex - rowIndex] = "X";

			String lineJoined = String.join("", line);
			System.out.println(lineJoined);
		}
	}
}

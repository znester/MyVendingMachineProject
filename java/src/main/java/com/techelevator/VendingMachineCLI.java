package com.techelevator;

import com.sun.source.tree.NewArrayTree;
import com.techelevator.view.Menu;

import java.util.Scanner;

public class VendingMachineCLI {


	//Main options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	//Purchase Options
	private static final String PURCHASE_MENU_OPTION_DEPOSIT_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_END_TRANSACTION = "End Transaction";
	private static final String PURCHASE_MENU_OPTION_RETURN_TO_MAIN_MENU = "Main Menu";


	//Menu collections
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_DEPOSIT_MONEY, PURCHASE_MENU_OPTION_END_TRANSACTION, PURCHASE_MENU_OPTION_RETURN_TO_MAIN_MENU };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		VendingMachine vendMachine = new VendingMachine("vendingmachine.csv"); //create the vending machine

		String[] activeMenu = MAIN_MENU_OPTIONS;
		while (true) {
			String userChoice = (String) menu.getChoiceFromOptions(activeMenu);

			if (userChoice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				// display vending machine items
				vendMachine.displayItems();

			} else if (userChoice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// Make active menu purchase menu
				activeMenu = PURCHASE_MENU_OPTIONS;

				if(userChoice.equals(PURCHASE_MENU_OPTION_DEPOSIT_MONEY)) {
					//try(Scanner scanner = new Scanner(menu.in)) {
					System.out.print("Deposit how much? ");

//
					Integer input = Integer.parseInt(menu.getIn().nextLine());
//					vendMachine.feedMoney(input);
				}




			} else if (userChoice.equals(MAIN_MENU_OPTION_EXIT)) {
				//Exit application
				vendMachine.exitDialogue();
				System.exit(1);

			} else if (userChoice.equals(PURCHASE_MENU_OPTION_RETURN_TO_MAIN_MENU)) {
				//Make active menu main menu
				activeMenu = MAIN_MENU_OPTIONS;

			}
			}
		}


	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

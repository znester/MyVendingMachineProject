package com.techelevator;

import com.sun.source.tree.NewArrayTree;
import com.techelevator.view.Menu;

import java.awt.*;
import java.util.Scanner;

public class VendingMachineCLI {


	//Main options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	//Purchase Options
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	//private static final String PURCHASE_MENU_OPTION_RETURN_TO_MAIN_MENU = "Main Menu";***

	//Feed money options
	private static final String FEED_MONEY_MENU_OPTION_ONE = "$1";
	private static final String FEED_MONEY_MENU_OPTION_TWO = "$2";
	private static final String FEED_MONEY_MENU_OPTION_FIVE = "$5";
	private static final String FEED_MONEY_MENU_OPTION_TEN = "$10";
	//private static final String FEED_MONEY_MENU_GO_TO_SELECT_PRODUCT_MENU = "Go To Select Product Menu";***
	private static final String FEED_MONEY_MENU_OPTION_TO_RETURN_TO_PURCHASE_MENU = "Back To Purchase Menu";

	//Select product options
	private static final String SELECT_PRODUCT_MENU_OPTION_1 = "A1";
	private static final String SELECT_PRODUCT_MENU_OPTION_2 = "A2";
	private static final String SELECT_PRODUCT_MENU_OPTION_3 = "A3";
	private static final String SELECT_PRODUCT_MENU_OPTION_4 = "A4";
	private static final String SELECT_PRODUCT_MENU_OPTION_5 = "B1";
	private static final String SELECT_PRODUCT_MENU_OPTION_6 = "B2";
	private static final String SELECT_PRODUCT_MENU_OPTION_7 = "B3";
	private static final String SELECT_PRODUCT_MENU_OPTION_8 = "B4";
	private static final String SELECT_PRODUCT_MENU_OPTION_9 = "C1";
	private static final String SELECT_PRODUCT_MENU_OPTION_10 = "C2";
	private static final String SELECT_PRODUCT_MENU_OPTION_11 = "C3";
	private static final String SELECT_PRODUCT_MENU_OPTION_12 = "C4";
	private static final String SELECT_PRODUCT_MENU_OPTION_13 = "D1";
	private static final String SELECT_PRODUCT_MENU_OPTION_14 = "D2";
	private static final String SELECT_PRODUCT_MENU_OPTION_15 = "D3";
	private static final String SELECT_PRODUCT_MENU_OPTION_16 = "D4";
	private static final String SELECT_PRODUCT_MENU_OPTION_RETURN_PURCHASE_MENU = "Back to Purchase Menu";

	//Menu collections
	//Main menu options
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	//Purchase menu options
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION }; //,PURCHASE_MENU_OPTION_RETURN_TO_MAIN_MENU };
	//Feed money menu options
	private static final String[] FEED_MENU_OPTIONS = { FEED_MONEY_MENU_OPTION_ONE, FEED_MONEY_MENU_OPTION_TWO, FEED_MONEY_MENU_OPTION_FIVE,
			FEED_MONEY_MENU_OPTION_TEN, FEED_MONEY_MENU_OPTION_TO_RETURN_TO_PURCHASE_MENU };
	//Select product menu options
	private static final String[] SELECT_PRODUCT_OPTIONS = { SELECT_PRODUCT_MENU_OPTION_1, SELECT_PRODUCT_MENU_OPTION_2, SELECT_PRODUCT_MENU_OPTION_3,
			SELECT_PRODUCT_MENU_OPTION_4, SELECT_PRODUCT_MENU_OPTION_5, SELECT_PRODUCT_MENU_OPTION_6, SELECT_PRODUCT_MENU_OPTION_7, SELECT_PRODUCT_MENU_OPTION_8, SELECT_PRODUCT_MENU_OPTION_9,
			SELECT_PRODUCT_MENU_OPTION_10, SELECT_PRODUCT_MENU_OPTION_11, SELECT_PRODUCT_MENU_OPTION_12, SELECT_PRODUCT_MENU_OPTION_13, SELECT_PRODUCT_MENU_OPTION_14,
			SELECT_PRODUCT_MENU_OPTION_15, SELECT_PRODUCT_MENU_OPTION_16, SELECT_PRODUCT_MENU_OPTION_RETURN_PURCHASE_MENU };

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
// Feed Money
			} else if(userChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {

					activeMenu = FEED_MENU_OPTIONS;
		//Feed Money Options
			} else if(userChoice.equals(FEED_MONEY_MENU_OPTION_ONE)) {
				vendMachine.feedMoney(100);
				activeMenu = PURCHASE_MENU_OPTIONS;

			} else if(userChoice.equals(FEED_MONEY_MENU_OPTION_TWO)) {
				vendMachine.feedMoney(200);
				activeMenu = PURCHASE_MENU_OPTIONS;

			} else if(userChoice.equals(FEED_MONEY_MENU_OPTION_FIVE)) {
				vendMachine.feedMoney(500);
				activeMenu = PURCHASE_MENU_OPTIONS;

			} else if(userChoice.equals(FEED_MONEY_MENU_OPTION_TEN)) {
				vendMachine.feedMoney(1000);
				activeMenu = PURCHASE_MENU_OPTIONS;

			} else if(userChoice.equals(FEED_MONEY_MENU_OPTION_TO_RETURN_TO_PURCHASE_MENU)) {

				activeMenu = PURCHASE_MENU_OPTIONS;

//Select Product
			} else if(userChoice.equals(PURCHASE_MENU_OPTION_SELECT_PRODUCT)) {

				activeMenu = SELECT_PRODUCT_OPTIONS;

		//Select Product Options _> I.e "A1" - "D4"

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_1)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_2)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_3)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_4)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_5)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_6)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_7)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_8)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_9)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_10)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_11)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_12)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_13)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_14)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_15)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_16)){

			} else if(userChoice.equals(SELECT_PRODUCT_MENU_OPTION_RETURN_PURCHASE_MENU)){

				activeMenu = PURCHASE_MENU_OPTIONS;

// Purchase Menu Finish Transaction -> Makes change, send change back, send user back to main menu

			} else if (userChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {

				activeMenu = MAIN_MENU_OPTIONS;



// MAIN MENU Exit Option
			} else if (userChoice.equals(MAIN_MENU_OPTION_EXIT)) {
				//Exit application
				vendMachine.exitDialogue();
				System.exit(1);
			}

			}
		}



	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}

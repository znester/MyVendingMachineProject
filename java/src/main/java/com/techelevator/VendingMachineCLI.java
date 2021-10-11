package com.techelevator;
import com.techelevator.view.Menu;

public class VendingMachineCLI {

	//Instance variables
	private final Menu MENU;

	//Main menu options
	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";

	//Purchase menu Options
	private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";

	//Feed money menu options
	private static final String FEED_MONEY_MENU_OPTION_ONE = "$1";
	private static final String FEED_MONEY_MENU_OPTION_TWO = "$2";
	private static final String FEED_MONEY_MENU_OPTION_FIVE = "$5";
	private static final String FEED_MONEY_MENU_OPTION_TEN = "$10";
	private static final String FEED_MONEY_MENU_OPTION_TO_RETURN_TO_PURCHASE_MENU = "Back To Purchase Menu";

	//Select product menu options
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

	//Derived instance variables
	//***Menu collections***
	//Main menu
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	//Purchase menu
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY,
			PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION }; //,PURCHASE_MENU_OPTION_RETURN_TO_MAIN_MENU };
	//Feed money menu
	private static final String[] FEED_MENU_OPTIONS = { FEED_MONEY_MENU_OPTION_ONE, FEED_MONEY_MENU_OPTION_TWO, FEED_MONEY_MENU_OPTION_FIVE,
			FEED_MONEY_MENU_OPTION_TEN, FEED_MONEY_MENU_OPTION_TO_RETURN_TO_PURCHASE_MENU };
	//Select product menu
	private static final String[] SELECT_PRODUCT_OPTIONS = { SELECT_PRODUCT_MENU_OPTION_1, SELECT_PRODUCT_MENU_OPTION_2, SELECT_PRODUCT_MENU_OPTION_3,
			SELECT_PRODUCT_MENU_OPTION_4, SELECT_PRODUCT_MENU_OPTION_5, SELECT_PRODUCT_MENU_OPTION_6, SELECT_PRODUCT_MENU_OPTION_7, SELECT_PRODUCT_MENU_OPTION_8, SELECT_PRODUCT_MENU_OPTION_9,
			SELECT_PRODUCT_MENU_OPTION_10, SELECT_PRODUCT_MENU_OPTION_11, SELECT_PRODUCT_MENU_OPTION_12, SELECT_PRODUCT_MENU_OPTION_13, SELECT_PRODUCT_MENU_OPTION_14,
			SELECT_PRODUCT_MENU_OPTION_15, SELECT_PRODUCT_MENU_OPTION_16, SELECT_PRODUCT_MENU_OPTION_RETURN_PURCHASE_MENU };


	//Constructor
	public VendingMachineCLI(Menu menu) {
		this.MENU = menu;
	}

	//Method controls flow of menu options with switch statements
	public void run() {
		VendingMachine vendMachine = new VendingMachine("vendingmachine.csv"); //create the vending machine

		System.out.println("-----------------------------");
		System.out.println("|                           |");
		System.out.println("|      Vendomatic4000       |");
		System.out.println("|                           |");
		System.out.println("-----------------------------");

		String[] activeMenu = MAIN_MENU_OPTIONS;
		while (true) {
			String userChoice = (String) MENU.getChoiceFromOptions(activeMenu);

			switch (userChoice) {
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					// display vending machine items
					vendMachine.displayItems();
					break;

				case MAIN_MENU_OPTION_PURCHASE:
					// Make active menu purchase menu
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case PURCHASE_MENU_OPTION_FEED_MONEY:
					activeMenu = FEED_MENU_OPTIONS;
					System.out.println();
					vendMachine.displayAmountInMachine();
					break;

				case FEED_MONEY_MENU_OPTION_ONE:
					vendMachine.feedMoney(100);
					activeMenu = PURCHASE_MENU_OPTIONS;
					System.out.println();
					vendMachine.displayAmountInMachine();
					break;

				case FEED_MONEY_MENU_OPTION_TWO:
					vendMachine.feedMoney(200);
					activeMenu = PURCHASE_MENU_OPTIONS;
					System.out.println();
					vendMachine.displayAmountInMachine();
					break;

				case FEED_MONEY_MENU_OPTION_FIVE:
					vendMachine.feedMoney(500);
					activeMenu = PURCHASE_MENU_OPTIONS;
					System.out.println();
					vendMachine.displayAmountInMachine();
					break;

				case FEED_MONEY_MENU_OPTION_TEN:
					vendMachine.feedMoney(1000);
					activeMenu = PURCHASE_MENU_OPTIONS;
					System.out.println();
					vendMachine.displayAmountInMachine();
					break;

				case FEED_MONEY_MENU_OPTION_TO_RETURN_TO_PURCHASE_MENU:
				case SELECT_PRODUCT_MENU_OPTION_RETURN_PURCHASE_MENU:
					activeMenu = PURCHASE_MENU_OPTIONS;
					System.out.println();
					vendMachine.displayAmountInMachine();
					break;

				case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
					activeMenu = SELECT_PRODUCT_OPTIONS;

					//Select Product Options _> I.e "A1" - "D4"
					vendMachine.displayItems();
					System.out.println();
					vendMachine.displayAmountInMachine();
					break;

				case SELECT_PRODUCT_MENU_OPTION_1:
					vendMachine.selectProduct("A1");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_2:
					vendMachine.selectProduct("A2");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_3:
					vendMachine.selectProduct("A3");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_4:
					vendMachine.selectProduct("A4");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_5:
					vendMachine.selectProduct("B1");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_6:
					vendMachine.selectProduct("B2");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_7:
					vendMachine.selectProduct("B3");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_8:
					vendMachine.selectProduct("B4");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_9:
					vendMachine.selectProduct("C1");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_10:
					vendMachine.selectProduct("C2");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_11:
					vendMachine.selectProduct("C3");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_12:
					vendMachine.selectProduct("C4");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_13:
					vendMachine.selectProduct("D1");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_14:
					vendMachine.selectProduct("D2");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_15:
					vendMachine.selectProduct("D3");
					activeMenu = PURCHASE_MENU_OPTIONS;
					break;

				case SELECT_PRODUCT_MENU_OPTION_16:
					vendMachine.selectProduct("D4");
					activeMenu = PURCHASE_MENU_OPTIONS;

					break;

//Purchase Menu Finish Transaction -> Makes change, send change back, send user back to main menu
				case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
					vendMachine.finishTransaction();
					activeMenu = MAIN_MENU_OPTIONS;
					break;
//Main menu exit option
				case MAIN_MENU_OPTION_EXIT:
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
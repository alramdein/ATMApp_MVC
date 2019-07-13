package atmapp;
import java.util.*;

public class ATM {
   private boolean userAuthenticated; // whether user is authenticated
   private int currentAccountNumber; // current user's account number
   private Screen screen; // ATM's screen
   private Keypad keypad; // ATM's keypad
   private CashDispenser cashDispenser; // ATM's cash dispenser
   private DepositSlot depositSlot;
   private BankDatabase bankDatabase; // account information database
   
   //tambahan
   private ATM_view atmAppView = new ATM_view();

   // constants corresponding to main menu options
   private static final int BALANCE_INQUIRY = 1;
   private static final int WITHDRAWAL = 2;
   private static final int DEPOSIT = 3;
   private static final int EXIT = 4;

   // no-argument ATM constructor initializes instance variables
   public ATM() {
      userAuthenticated = false; // user is not authenticated to start
      currentAccountNumber = 0; // no current account number to start
      screen = new Screen(); // create screen
      keypad = new Keypad(); // create keypad 
      cashDispenser = new CashDispenser(); // create cash dispenser
      bankDatabase = new BankDatabase(); // create acct info database
      depositSlot = new DepositSlot();
   }

   // start ATM 
   public void run() {
      // welcome and authenticate user; perform transactions
      while (true) {
         // loop while user is not yet authenticated
         while (!userAuthenticated) {
            atmAppView.PrintWelcome();
            authenticateUser(); // authenticate user
         }
         
         performTransactions(); // user is now authenticated
         userAuthenticated = false; // reset before next ATM session
         currentAccountNumber = 0; // reset before next ATM session
         atmAppView.PrintGoodBye();
      }
   }

   // attempts to authenticate user against database
   private void authenticateUser() {
      atmAppView.PrintEnterAccountNumber();
      int accountNumber = keypad.getInput(); // input account number
      atmAppView.PrintEnterPIN();
      int pin = keypad.getInput(); // input PIN
      
      // set userAuthenticated to boolean value returned by database
      userAuthenticated = 
         bankDatabase.authenticateUser(accountNumber, pin);
      
      // check whether authentication succeeded
      if (userAuthenticated) {
         currentAccountNumber = accountNumber; // save user's account #
      } 
      else {
         atmAppView.PrintIncalidAccountNumberOrPIN();
      } 
   } 

   // display the main menu and perform transactions
   private void performTransactions() {
      // local variable to store transaction currently being processed
      Transaction currentTransaction = null;
      
      boolean userExited = false; // user has not chosen to exit

      // loop while user has not chosen option to exit system
      while (!userExited) {
         // show main menu and get user selection
         int mainMenuSelection = displayMainMenu();

         // decide how to proceed based on user's menu selection
         switch (mainMenuSelection) {
            // user chose to perform one of three transaction types
            case BALANCE_INQUIRY:         

               // initialize as new object of chosen type
               currentTransaction = 
                  createTransaction(mainMenuSelection);
               currentTransaction.execute();
                break;
               
            case WITHDRAWAL:
                currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute(); // execute transaction
               break;
            case DEPOSIT:
                currentTransaction = 
                  createTransaction(mainMenuSelection);

               currentTransaction.execute(); // execute transaction
            break;
                
            case EXIT: // user chose to terminate session
               atmAppView.PrintExit();
               userExited = true; // this ATM session should end
               break;
            default: // 
               atmAppView.PrintEntryNotValid();
               break;
         }
      } 
   } 

   // display the main menu and return an input selection
   private int displayMainMenu() {
      atmAppView.PrintMenu();
      return keypad.getInput(); // return user's selection
   } 
         
   private Transaction createTransaction(int type) {
      Transaction temp = null; 
          
      switch (type) {
         case BALANCE_INQUIRY: 
            temp = new BalanceInquiry(
               currentAccountNumber, screen, bankDatabase);
            break;
         // -- NAMBAH INI
         case WITHDRAWAL:
             temp = new Withdrawal(currentAccountNumber, screen, bankDatabase, 
                     keypad, cashDispenser);
             break;
         case DEPOSIT:
             temp = new Deposit(currentAccountNumber,screen,bankDatabase,keypad,depositSlot);
             break;
             
          
      }

      return temp;
   } 
}
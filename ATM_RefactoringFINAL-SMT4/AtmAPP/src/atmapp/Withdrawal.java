package atmapp;
import java.util.*;
// Withdrawal.java
// Represents a withdrawal ATM transaction

public class Withdrawal extends Transaction {
   private int amount; // amount to withdraw
   private Keypad keypad; // reference to keypad
   private CashDispenser cashDispenser; // reference to cash dispenser

   // constant corresponding to menu option to cancel
   private final static int CANCELED = 6;
   
   //tambahan
   private Withdrawal_view withdrawalView = new Withdrawal_view();

   // Withdrawal constructor
   public Withdrawal(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      CashDispenser atmCashDispenser) {

      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      
      // -- NAMBAH INI
      amount = 0;
      keypad = atmKeypad;
      cashDispenser = atmCashDispenser;
      
   }

   // perform transaction
   @Override
   public void execute() {
       double availableBalance;
       amount = displayMenuOfAmounts();
       if(amount != 0){
            if(cashDispenser.isSufficientCashAvailable(amount)){
                BankDatabase atmBankDatabase = super.getBankDatabase();
                availableBalance =
                        atmBankDatabase.getAvailableBalance(
                                super.getAccountNumber());
                if(amount <= availableBalance){
                    cashDispenser.dispenseCash(amount);
                    atmBankDatabase.getAccount(super.getAccountNumber()).
                            credit(amount);
                    withdrawalView.IfWithdrawalSuccess();
                }
                else {
                    withdrawalView.IfWithdrawalFailed(amount, availableBalance);
                }
            }
            else {
                withdrawalView.IfWithdrawalInsufficient();
            }
       }
       else {
           withdrawalView.IfWithdrawalCancel();
       }
   } 

   // display a menu of withdrawal amounts and the option to cancel;
   // return the chosen amount or 0 if the user chooses to cancel
   private int displayMenuOfAmounts() {
      int userChoice = 0; // local variable to store return value

      Screen screen = getScreen(); // get screen reference
      
      // array of amounts to correspond to menu numbers
      int[] amounts = {0, 20, 40, 60, 100, 200};

      // loop while no valid choice has been made
      while (userChoice == 0) {
         // display the withdrawal menu
         withdrawalView.WithdrawalMenu();

         int input = keypad.getInput(); // get user input through keypad
 
         // determine how to proceed based on the input value
         switch (input) {
            // if the user chose a withdrawal amount
            // (i.e., chose option 1, 2, 3, 4 or 5), return the
            // corresponding amount from amounts array
            
            // -- NAMBAH INI
            case 1: 
               userChoice = amounts[input]; // save user's choice
               break; 
            case 2: 
               userChoice = amounts[input]; // save user's choice
               break; 
            case 3: 
               userChoice = amounts[input]; // save user's choice
               break; 
            case 4:
               userChoice = amounts[input]; // save user's choice
               break;  
            case 5:
               userChoice = amounts[input]; // save user's choice
               break;       
            case CANCELED: // the user chose to cancel
               userChoice = amounts[input - CANCELED]; // save user's choice
               break;
            default: // the user did not enter a value from 1-6
               withdrawalView.IfInvalidSelection();
         } 
      } 

      return userChoice; // return withdrawal amount or CANCELED
   }
} 
package atmapp;
import java.util.*;
public class Deposit extends Transaction {
   private double amount; // amount to deposit
   private Keypad keypad; // reference to keypad
   private DepositSlot depositSlot; // reference to deposit slot
   private final static int CANCELED = 0; // constant for cancel option
   
   //tambahan
   private Deposit_view depositView;

   // Deposit constructor
   public Deposit(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase, Keypad atmKeypad, 
      DepositSlot atmDepositSlot) {
      
      // initialize superclass variables
      super(userAccountNumber, atmScreen, atmBankDatabase);
      // -- NAMBAH INI
      depositSlot = atmDepositSlot;
      keypad = atmKeypad;
      amount = 0;

   } 

   // perform transaction
   @Override
   public void execute() {
       amount = promptForDepositAmount();
       if(amount != 0){
           BankDatabase atmBankDatabase = super.getBankDatabase();
           depositView.PrintInsertDeposit(amount);
           if(depositSlot.isEnvelopeReceived()){
               depositView.PrintEnvelopeReceived();
               atmBankDatabase
                       .getAccount(super.getAccountNumber()).debit(amount);
           }
       }
       else {
          depositView.PrintCancelingTransaction();
       }
   }

   // prompt user to enter a deposit amount in cents 
   private double promptForDepositAmount() {

      // display the prompt
     depositView.PrintAmountInCent();
      int input = keypad.getInput(); // receive input of deposit amount
      
      // check whether the user canceled or entered a valid amount
      if (input == CANCELED) {
         return CANCELED;
      }
      else {
         return (double) input / 100; // return dollar amount
      }
   }
} 

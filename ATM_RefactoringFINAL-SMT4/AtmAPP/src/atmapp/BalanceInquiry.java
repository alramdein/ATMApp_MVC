package atmapp;
import java.util.*;
public class BalanceInquiry extends Transaction {
   // BalanceInquiry constructor
   public BalanceInquiry(int userAccountNumber, Screen atmScreen, 
      BankDatabase atmBankDatabase) {
      super(userAccountNumber, atmScreen, atmBankDatabase);
   } 
   
   //tambahan
   private BalanceInquiry_view balanceinquiryView = new BalanceInquiry_view();

   // performs the transaction
   @Override
   public void execute() {
      // get references to bank database and screen
      BankDatabase bankDatabase = getBankDatabase();
      Screen screen = getScreen();
      // get the available balance for the account involved
      double availableBalance = 
         bankDatabase.getAvailableBalance(getAccountNumber());

      // get the total balance for the account involved
      double totalBalance = 
         bankDatabase.getTotalBalance(getAccountNumber());
      
      // display the balance information on the screen
      balanceinquiryView.DisplayBalanceInformation(availableBalance, totalBalance);
   }
} 
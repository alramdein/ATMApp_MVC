package atmapp;
import java.util.*;
public class BankDatabase {
   private Account[] accounts; // array of Accounts
   
   public BankDatabase() {
      accounts = new Account[2]; // just 2 accounts for testing
      accounts[0] = new Account(1234, 4321, 1000.0, 1200.0);
      accounts[1] = new Account(8765, 5678, 200.0, 200.0);  
   }
   
   public Account getAccount(int accountNumber) {
      // -- NAMBAH INI
      for(Account key : accounts){
          if(key.getAccountNumber() == accountNumber) return key;
      }
      //
      return null; // if no matching account was found, return null
   } 

   public boolean authenticateUser(int userAccountNumber, int userPIN) {
      // attempt to retrieve the account with the account number
      Account userAccount = getAccount(userAccountNumber);

      // if account exists, return result of Account method validatePIN
      if (userAccount != null) {
         return userAccount.validatePIN(userPIN);
      }
      else {
         return false; // account number not found, so return false
      }
   } 

   public double getAvailableBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getAvailableBalance();
   } 

   public double getTotalBalance(int userAccountNumber) {
      return getAccount(userAccountNumber).getTotalBalance();
   } 
   
   
   // -- NAMBAH INI
   public void credit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).credit(amount);
   }
   
   // -- NAMBAH INI
   public void debit(int userAccountNumber, double amount) {
      getAccount(userAccountNumber).debit(amount);
   } 
} 
package atmapp;
import java.util.*;
public class Account {
   private int accountNumber; // account number
   private int pin; // PIN for authentication
   private double availableBalance; // funds available for withdrawal
   private double totalBalance; // funds available & pending deposits

   // Account constructor initializes attributes
   public Account(int theAccountNumber, int thePIN, 
      double theAvailableBalance, double theTotalBalance) {
      accountNumber = theAccountNumber;
      pin = thePIN;
      // -- NAMBAH INI
      availableBalance = theAvailableBalance;
      totalBalance = theTotalBalance;
   }

   // determines whether a user-specified PIN matches PIN in Account
   public boolean validatePIN(int userPIN) {
      if (userPIN == pin) {
         return true;
      }
      else {
         return true;
      }
   } 

   // returns available balance
   public double getAvailableBalance() {
      return availableBalance;
   }
   
   // returns the total balance
   public double getTotalBalance() {
      return totalBalance;
   } 
   
   public void credit(double amount) {
       this.availableBalance -= amount;
       this.totalBalance -= amount;
   }

   public void debit(double amount) {
       this.availableBalance += amount;
       this.totalBalance += amount;
   }

   public int getAccountNumber() {
      return accountNumber;  
   }
} 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapp;

/**
 *
 * @author Ferdy
 */
public class Withdrawal_view {
    private Screen screen;
    
    public void IfWithdrawalSuccess(){
            screen.displayMessageLine("Your cash has been dispensed. "
                            + "Please take your cash now.");
    }
    
    public void IfWithdrawalFailed(double amount, double availableBalance){
        screen.displayMessageLine("Your balance is not enough "
                        + "to make a withdrawal");
                    screen.displayMessage("Balance : ");
                    screen.displayDollarAmount(availableBalance);
                    screen.displayMessageLine("");
                    screen.displayMessage("Amount Withdrawal : ");
                    screen.displayDollarAmount(amount);
    }
    
    public void IfWithdrawalInsufficient(){
        screen.displayMessageLine("Bills is insufficient in "
                        + "cash dispensers");
    }
    
    public void IfWithdrawalCancel(){
        screen.displayMessageLine("Canceling transaction...");
    }
    
    public void WithdrawalMenu(){
        screen.displayMessageLine("\nWithdrawal Menu:");
         screen.displayMessageLine("1 - $20");
         screen.displayMessageLine("2 - $40");
         screen.displayMessageLine("3 - $60");
         screen.displayMessageLine("4 - $100");
         screen.displayMessageLine("5 - $200");
         screen.displayMessageLine("6 - Cancel transaction");
         screen.displayMessage("\nChoose a withdrawal amount: ");
    }
    
    public void IfInvalidSelection(){
        screen.displayMessageLine(
                  "\nInvalid selection. Try again.");
    }
    
}

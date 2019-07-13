/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmapp;

/**
 *
 * @author USER
 */
public class Deposit_view {
    private Screen screen; 
    
    public void PrintInsertDeposit (double amount) {
         screen.displayMessage("Please insert a deposit "
                   + "envelope containing ");
           screen.displayDollarAmount(amount);
           screen.displayMessageLine("");
    }
    
    public void PrintEnvelopeReceived () {
        screen.displayMessageLine("Your envelope has been received.\n" 
                       + "NOTE: The money just deposited will not be available "
                       + "until we verify "
                       + "the amount of any enclosed cash and "
                       + "your checks clear.");
    }
    
    public void PrintCancelingTransaction () {
         screen.displayMessageLine("Canceling transaction...");
    }
    
    public void PrintAmountInCent () {
         screen.displayMessage("\nPlease enter a deposit amount in " + 
         "CENTS (or 0 to cancel): ");
    }
}

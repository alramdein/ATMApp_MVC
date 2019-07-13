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
public class ATM_view {
    private Screen screen = new Screen();
    
    public void PrintWelcome () {
        screen.displayMessageLine("\nWelcome!");  
    }
    
    public void PrintGoodBye () {
         screen.displayMessageLine("\nThank you! Goodbye!");
    }
    
    public void PrintEnterAccountNumber () {
        screen.displayMessage("\nPlease enter your account number: ");
    }
    
    public void PrintEnterPIN () {
        screen.displayMessage("\nEnter your PIN: "); // prompt for PIN
    }
    
    public void PrintIncalidAccountNumberOrPIN () {
        screen.displayMessageLine(
            "Invalid account number or PIN. Please try again.");
    }
    
    public void PrintExit () {
        screen.displayMessageLine("\nExiting the system...");
    }
    
    public void PrintEntryNotValid () {
        screen.displayMessageLine(
                  "\nYou did not enter a valid selection. Try again.");
             
    }
    
    public void PrintMenu () {
      screen.displayMessageLine("\nMain menu:");
      screen.displayMessageLine("1 - View my balance");
      screen.displayMessageLine("2 - Withdraw cash");
      screen.displayMessageLine("3 - Deposit funds");
      screen.displayMessageLine("4 - Exit\n");
      screen.displayMessage("Enter a choice: ");
    }
}

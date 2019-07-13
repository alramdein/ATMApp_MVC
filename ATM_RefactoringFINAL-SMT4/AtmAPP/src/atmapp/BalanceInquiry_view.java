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
public class BalanceInquiry_view {
    private Screen screen = new Screen();
    
    public void DisplayBalanceInformation(double availableBalance, double totalBalance){
        screen.displayMessageLine("\nBalance Information:");
        screen.displayMessage(" - Available balance: "); 
        screen.displayDollarAmount(availableBalance);
        screen.displayMessage("\n - Total balance:     ");
        screen.displayDollarAmount(totalBalance);
        screen.displayMessageLine("");
    }
}

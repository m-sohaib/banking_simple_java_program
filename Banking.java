
//Mohammad Sohaib 

import javax.swing.JOptionPane;
public class Banking {
	public static void main(String[] args) {
		
		final int pin = 123; 
		int inPin = 0, choice = 0;
		double balance = 500.00;
		
		inPin = Integer.parseInt(JOptionPane.showInputDialog("Enter Pin to sign-in or enter 0 to cancel: "));
		
		/*if statement checks if pin is entered correctly or 0 is entered to cancel.
		if not, then do-while loop keeps prompting to enter the correct pin or 0 to end*/
		if(inPin!=pin && inPin!=0) {
			do{
				inPin = Integer.parseInt(JOptionPane.showInputDialog("Invalid Pin!! Enter again or 0 to cancel: "));
			}while(inPin!=pin && inPin!=0);
		}	
		
		if(inPin == pin) {
			//do while loop created to show the menu continuously until selecting the exit option 
			do{
				choice = Integer.parseInt(JOptionPane.showInputDialog("1. See Balance\n 2. Withdraw\n 3. Deposit\n 4. Exit"));
				//Able to see the total balance accurately each time choice equals to 1 
				if(choice == 1) {
					JOptionPane.showMessageDialog(null,"Total Balance: $" + balance);
				}
				/*Calls the withdraw method to enter the withdraw amount. Subtracts the withdraw amount from the balance.
				The message dialog then shows the previous balance and the new balance */
				else if(choice == 2) {
					if(withdraw > balance){
						JOptionPane.showMessageDialog(null, "Insufficient funds.");
					}
					else {
						double prev = balance; 
						balance = balance - withdraw;
						JOptionPane.showMessageDialog(null,"Prev Balance: $" + prev + "\nNew Balance: $" + balance);
					}
				}
				/*Calls the deposit method to enter the deposit amount. Adds the deposit amount to the balance.
				The message dialog then shows the previous balance and the new balance */
				else if(choice == 3){
					double deposit = depositMethod(balance);
					double prev = balance; 
					balance = balance + deposit;
					JOptionPane.showMessageDialog(null,"Prev Balance: $" + prev + "\nNew Balance: $" + balance);
				}
				// ends the loop when entering 4 to exit or a number higher than 4. Displays message dialog and program ends.  
				else{
					JOptionPane.showMessageDialog(null,"Transaction complete. Have a nice day!");
				}
			}while(choice > 0 && choice < 4);
		}
		//if value is entered 0, then the following message is displayed and the program ends. 
		else if(inPin == 0){
			JOptionPane.showMessageDialog(null,"Thank you. Have a nice day.");
		}

	} //end of main
	
	//This method asks for entering an amount you would like to withdraw and then will return that value
	public static double withdrawMethod(double inBalance) {
		double withdraw = 0;
		withdraw = Double.parseDouble(JOptionPane.showInputDialog("Current Balance: $" + inBalance + "\nEnter withdraw amount: "));
		return withdraw;
	}
	//This method asks for entering an amount you would like to deposit and then will return that value
	public static double depositMethod(double inBalance) {
		double deposit = 0;
		deposit = Double.parseDouble(JOptionPane.showInputDialog("Current Balance: $" + inBalance + "\nEnter deposit amount: "));
		return deposit;
	}
} // end of class

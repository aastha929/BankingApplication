package com.capgemini.ui;
import com.capgemini.service.Bank;
import com.capgemini.service.ICICIBank;
import com.capgemini.exception.InvalidAccountNumberException;
import com.capgemini.exception.InsufficientBalanceException;
import com.capgemini.exception.InsufficientOpeningAmountException;
import java.util.Scanner;


public class Client {

	public static void main(String[] args) {
		Bank bank = new ICICIBank();
		try
		{
			System.out.println(bank.createAccount(101, 3000));
			System.out.println(bank.createAccount(102, 3000));
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your choice/n 1. Withdrawal/n 2.Deposit/n 3.Fund Tranfer ");
			int x= sc.nextInt();
			switch(x)
			{
			case 1:System.out.println("Enter account number from which you want to withdraw");
			int b=sc.nextInt();
		    System.out.println("how much you want to withdraw");
			int c=sc.nextInt();
			System.out.println("Balance after withdrawal = "+bank.withdrawAmount(b,c));
			break;
			case 2:System.out.println("Enter account number in which you want to deposit");
			int y=sc.nextInt();
		    System.out.println("how much you want to withdraw");
			int z=sc.nextInt();
			System.out.println("Account balance after deposit = "+bank.depositAmount(y,z));
			break;
			case 3:System.out.println("Enter sender account number");
			int m=sc.nextInt();
		    System.out.println("Enter receiver account number");
			int n=sc.nextInt();
			 System.out.println("Enter fund transfer amount");
				int o=sc.nextInt();
				int a[]=bank.fundTransfer(m,n,o);
				System.out.println("Sender balance after fund transfer = "+a[0]);
				System.out.println("Reciever balance after fund transfer = "+a[1]);
				break;
			case 4:	 System.out.println("Minimum amount for creating account is 500. ");
			int p=sc.nextInt();
			
			System.out.println(bank.createAccount(103, p));
			System.out.println("Checking for minimum balance while creating account...");
			}	
		}
		catch(InsufficientOpeningAmountException ioa) {
			System.out.println("Minimum Balance must be 500");
		}
		catch(InvalidAccountNumberException ian)
		{
			System.out.println("Invalid account number ");
		}
		catch(InsufficientBalanceException ibe){
			System.out.println("insufficient balance");
		}
	}

}